package com.wjw.tankdemo;

import org.springframework.core.annotation.Order;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
    private int x = 200;
    private int y = 200;

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

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                x += 10;
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                y += 10;
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(x,y,80,80);
        System.out.println("paint");
    }
}
