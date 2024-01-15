package org.daergaoth.swing.elements;


import javax.swing.*;
import java.awt.*;

public class MyTextArea extends JTextArea {
    public void setupDefaultPanel() {
        this.setEditable(true);
        this.setAutoscrolls(true);
        this.setBackground(new Color(0x00FF00));
        this.setForeground(new Color(0x0F3153));
        this.setFont(new Font("MV Boli", Font.PLAIN, 19));
    }
}