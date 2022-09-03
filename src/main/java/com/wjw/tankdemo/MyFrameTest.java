package com.wjw.tankdemo;

public class MyFrameTest {
    public static void main(String[] args) throws InterruptedException {
        MyFrame myFrame = new MyFrame();
        do {
            Thread.sleep(10);
            myFrame.repaint();
        } while (true);
    }
}
