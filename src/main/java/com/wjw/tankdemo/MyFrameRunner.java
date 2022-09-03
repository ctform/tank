package com.wjw.tankdemo;

import com.wjw.tankdemo.model.MyFrame;

public class MyFrameRunner {
    public static void main(String[] args) throws InterruptedException {
        MyFrame myFrame = new MyFrame();
        do {
            Thread.sleep(10);
            myFrame.repaint();
        } while (true);
    }
}
