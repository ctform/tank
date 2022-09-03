package com.wjw.tankdemo;

import java.awt.*;

public class MyTank {
    private int x = 200;
    private int y = 200;
    int speed = 1;
    final int moveUnit = 2;
    private DirectTypeNum tankDirect = DirectTypeNum.NONE;

    public void paint(Graphics g){
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
    }

    public void setTankDirect(DirectTypeNum tankDirect) {
        this.tankDirect = tankDirect;
    }
}
