package com.wjw.tankdemo;

import org.springframework.core.annotation.Order;

import java.awt.*;
import java.awt.event.*;

public class MyFrame extends Frame {
    private int x = 200;
    private int y = 200;
    final int moveUnit = 2;
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
        MyKeyListener keyListener = (MyKeyListener) getKeyListeners()[0];
        keyListener.reLocate();
        g.fillRect(x, y, 80, 80);
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
        }

        public void reLocate() {
            if(bL) x -= speed * moveUnit;
            if(bU) y -= speed * moveUnit;
            if(bD) y += speed * moveUnit;
            if(bR) x += speed * moveUnit;
        }
    }
}
