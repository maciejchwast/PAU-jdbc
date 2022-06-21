package com.company;

import javax.swing.*;

public class Label {
    String text;
    JFrame frame;
    public Label(String text, JFrame frame) {
        this.text = text;
        this.frame = frame;
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setBounds(50,50,1000,30);
        frame.add(label);
    }
    public void reload(){
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setBounds(50,50,1000,30);
        frame.add(label);
    }
}
