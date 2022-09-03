package com.wjw.tankdemo;

import java.awt.*;

public class MyTank {
    private int x;
    private int y;
    int speed = 1;
    final int moveUnit = 2;
    private DirectTypeNum tankDirect = DirectTypeNum.NONE;

    public MyTank(int x, int y, DirectTypeNum directTypeNum) {
        this.x = x;
        this.y = y;
        this.tankDirect = directTypeNum;
    }

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
