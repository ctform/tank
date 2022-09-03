package com.wjw.tankdemo;

import org.springframework.core.annotation.Order;

import java.awt.*;
import java.awt.event.*;

public class MyFrame extends Frame {
    private int x = 200;
    private int y = 200;
    final int moveUnit = 2;
    private DirectTypeNum tankDirect = DirectTypeNum.NONE;
    int speed = 1;

    public MyFrame() {
        setSize(800, 600);
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
        g.fillRect(x, y, 80, 80);
        switch (tankDirect) {
            case UP:
                y -= speed * moveUnit;
                break;
            case DOWN:
                y += speed * moveUnit;
                break;
            case LEFT:
                x -= speed * moveUnit;
                break;
            case RIGHT:
                x += speed * moveUnit;
                break;
            default:
                break;
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

            setTankDirect();
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
                default:
                    break;
            }
            setTankDirect();
        }

        private void setTankDirect() {
            if (bL) {
                tankDirect = DirectTypeNum.LEFT;
                return;
            }
            if (bU) {
                tankDirect = DirectTypeNum.UP;
                return;
            }
            if (bD) {
                tankDirect = DirectTypeNum.DOWN;
                return;
            }
            if (bR) {
                tankDirect = DirectTypeNum.RIGHT;
                return;
            }
            tankDirect = DirectTypeNum.NONE;
        }
    }
}
