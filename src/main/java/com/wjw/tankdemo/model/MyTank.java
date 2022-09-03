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
    //tank持有MyFrame的引用以赋值子弹
    private MyFrame frame;

    public MyTank(int x, int y, DirectTypeNum directTypeNum,MyFrame frame) {
        this.x = x;
        this.y = y;
        this.tankDirect = directTypeNum;
        this.frame = frame;
    }

    public void paint(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 80, 80);
        g.setColor(color);
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

    /**
     * 开火方法,使用引用赋值子弹给frame,为什么不直接return子弹给frame接收
     * 在未来扩展时候可以使用策略模式,根据不同情况给出一个不同的开火结果,而不是现在直接给定子弹结果
     * 直接给定子弹结果限定了方法只能在返回值上做文章,而现在有很多可能
     */
    public void fire() {
        frame.bullet = new Bullet(x,y,tankDirect);
    }
}
