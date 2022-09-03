package com.wjw.tankdemo.model;

import com.wjw.tankdemo.enums.DirectTypeNum;

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
    //框架引用 用于获取子弹集合 删除子弹
    private MyFrame frame;
    //子弹存活状态
    private boolean live = true;

    public Bullet(int x, int y, DirectTypeNum direct, MyFrame frame) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.frame = frame;
    }

    public void paint(Graphics g) {
        if(!live) {
            //删除子弹
            frame.bullets.remove(this);
        }

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

        //移动后检验子弹更新子弹存活状态
        updateLive();
    }

    private void updateLive() {
        if (x < 0 || y < 0 || x > frame.GAME_WIDTH || y > frame.GAME_HEIGHT) {
            live = false;
        }
    }

}
