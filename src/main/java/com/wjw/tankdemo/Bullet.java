package com.wjw.tankdemo;

import java.awt.*;

/**
 * 子弹类
 */
public class Bullet {
    private int x;
    private int y;
    private static final int moveUnit = 5;
    private static final int speedLevel = 1;
    private static final int WIDTH = 10, HEIGHT = 10;
    private DirectTypeNum direct;

    public Bullet(int x, int y, DirectTypeNum direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.BLACK);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(color);
        move();
    }

    private void move() {
        switch (direct) {
            case UP:
                y -= speedLevel * moveUnit;
                break;
            case DOWN:
                y += speedLevel * moveUnit;
                break;
            case LEFT:
                x -= speedLevel * moveUnit;
                break;
            case RIGHT:
                x += speedLevel * moveUnit;
                break;
            default:
                break;
        }
    }

}
