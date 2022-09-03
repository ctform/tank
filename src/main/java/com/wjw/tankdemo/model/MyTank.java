package com.wjw.tankdemo.model;

import com.wjw.tankdemo.enums.DirectTypeNum;

import java.awt.*;

public class MyTank {
    private int x;
    private int y;
    private static final int speedLevel = 1;
    private static final int moveUnit = 2;
    private DirectTypeNum tankDirect;
    //坦克是否移动的状态表示
    private boolean isMoving = false;
    Bullet bullet = new Bullet(300, 300, DirectTypeNum.RIGHT);

    public MyTank(int x, int y, DirectTypeNum directTypeNum) {
        this.x = x;
        this.y = y;
        this.tankDirect = directTypeNum;
    }

    public void paint(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 80, 80);
        g.setColor(color);
        bullet.paint(g);
        move();
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    private void move() {
        if(isMoving) {
            switch (tankDirect) {
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

    public void setTankDirect(DirectTypeNum tankDirect) {
        this.tankDirect = tankDirect;
    }
}
