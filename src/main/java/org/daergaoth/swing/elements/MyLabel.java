package org.daergaoth.swing.elements;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {
    public void setupTextField(int x, int y, int width, int height) {
        this.setHorizontalTextPosition(JLabel.LEFT);//Useless if parent layout manager is null
        this.setVerticalTextPosition(JLabel.CENTER);//Useless if parent layout manager is null
        this.setForeground(new Color(0x00FF00));
        this.setFont(new Font("MV Boli", Font.PLAIN, 20));
        this.setBackground(new Color(0x123456));
        this.setOpaque(true);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.LEFT);
        this.setBounds(x, y, width, height); //this needed if the parent layout manager is null
    }
}
