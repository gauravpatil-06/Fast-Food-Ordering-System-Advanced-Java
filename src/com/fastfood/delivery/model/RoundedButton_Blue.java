package com.fastfood.delivery.model;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RoundedButton_Blue extends JButton
{
    private int radius;

    public RoundedButton_Blue(String text, int radius)
    {
        super(text);
        this.radius = radius;
        setOpaque(false);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setBackground(new Color(20, 90, 180)); // Further darker faint blue
        setBorderPainted(false);

        Border roundedBorder = BorderFactory.createLineBorder(Color.blue, 2);
        setBorder(BorderFactory.createCompoundBorder(roundedBorder, BorderFactory.createEmptyBorder(4, 4, 4, 4)));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        super.paintComponent(g);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g)
    {
        super.paintBorder(g);
    }
}
