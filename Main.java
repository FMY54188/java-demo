package com.zuoye;

import  javax.swing.*;
import  java.awt.*;
import  java.awt.Toolkit;
import  java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public  class Main {
    public static final String[] TIPS = {
            "多喝水哦~","保持微笑啊","每天都要元气满满",
            "记得吃水果","保持好心情","好好爱自己",
            "梦想成真","期待下一次见面","金榜题名",
            "顺顺利利","早点休息哦","愿所有烦恼都消失",
            "别熬夜","今天要开心哦","天冷了，要多穿衣服",
            "今天要努力哦","今天要加油啊","相信自己"
    };
    public static final Color[] BG_COLORS ={
            new Color(255,182,193), //lightpink
            new Color(135,206,235), //skyblue
            new Color(144,238,144), //lightgreen
            new Color(230,230,250), //lavender
            new Color(255,255,224), //plum
            new Color(255,127,80), //coral
            new Color(255,228,196), //bisque
            new Color(127,255,212), //aquamarine
            new Color(255,228,225), //mistyrose
            new Color(240,255,240), //honeydew
            new Color(255,240,245),
            new Color(253,245,230),
    };

    public static void createTipWindow() {
        Random random = new Random();
        JFrame frame = new JFrame("温馨提示");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300,100);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = random.nextInt(screenSize.width - 300);
        int y = random.nextInt(screenSize.height - 150);
        frame.setLocation(x,y);
        Color bgColor = BG_COLORS[random.nextInt(BG_COLORS.length)];
        JLabel label = new JLabel(
                TIPS[random.nextInt(TIPS.length)],
                SwingConstants.CENTER
        );
        label.setFont(new Font("微软雅黑",Font.PLAIN,22));
        label.setOpaque(true);
        label.setBackground(bgColor);
        label.setPreferredSize(new Dimension(300,150));
        frame.add(label);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i= 0; i < 100; i++){
            executor.submit(() -> {
                try{
                    Thread.sleep(150);
                    SwingUtilities.invokeLater((Main::createTipWindow));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
    }

}
