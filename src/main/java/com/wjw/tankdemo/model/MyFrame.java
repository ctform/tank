package com.wjw.tankdemo.model;

import com.wjw.tankdemo.enums.DirectTypeNum;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
    public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;
    private MyTank tank = new MyTank(200, 200, DirectTypeNum.UP, this);
    public Bullet bullet;

    public MyFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        tank.paint(g);
        //当子弹发射时 才进行子弹的绘制
        if(bullet != null){
            bullet.paint(g);
        }
        System.out.println("paint");
    }


    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                default:
                    break;
            }
            setTankDirect(tank);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    tank.fire();
                default:
                    break;
            }
            setTankDirect(tank);
        }

        private void setTankDirect(MyTank tank) {
            if (!bL && !bU && !bD && !bR) {
                tank.setMoving(false);
            } else {
                tank.setMoving(true);
                if (bL) {
                    tank.setTankDirect(DirectTypeNum.LEFT);
                    return;
                }
                if (bU) {
                    tank.setTankDirect(DirectTypeNum.UP);
                    return;
                }
                if (bD) {
                    tank.setTankDirect(DirectTypeNum.DOWN);
                    return;
                }
                if (bR) {
                    tank.setTankDirect(DirectTypeNum.RIGHT);
                    return;
                }
            }
        }
    }

    //利用双缓冲技术解决屏幕闪烁问题
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics graphicsOff = offScreenImage.getGraphics();
        Color color = graphicsOff.getColor();
        graphicsOff.setColor(Color.WHITE);
        graphicsOff.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        graphicsOff.setColor(color);
        paint(graphicsOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}
