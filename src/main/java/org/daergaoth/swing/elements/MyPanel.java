package org.daergaoth.swing.elements;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public void setupTextField(int x, int y, int width, int height) {
        this.setForeground(new Color(0x00FF00));
        this.setFont(new Font("MV Boli", Font.PLAIN, 20));
        this.setBackground(new Color(0x123456));
        this.setOpaque(true);
        this.setBounds(x, y, width, height); //this needed if the parent layout manager is null
    }
}
