package org.daergaoth.swing.elements;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    public void setupDefaultButton(int x, int y, int width, int height, String text) {
        this.setBounds(x, y, width, height);
        this.setText(text);
        this.setFocusable(false);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.BOTTOM);
        this.setFont(new Font("MV Boli", Font.PLAIN, 20));
        this.setForeground(new Color(0x00FF00));
        this.setBackground(new Color(0x123456));
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setEnabled(true);
    }
}
