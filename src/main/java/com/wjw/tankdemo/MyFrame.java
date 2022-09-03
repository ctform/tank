package com.wjw.tankdemo;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
    private MyTank tank = new MyTank(200,200,DirectTypeNum.NONE);

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
        tank.paint(g);
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
                default:
                    break;
            }
            setTankDirect(tank);
        }

        private void setTankDirect(MyTank tank) {
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
            tank.setTankDirect(DirectTypeNum.NONE);
        }
    }
}
