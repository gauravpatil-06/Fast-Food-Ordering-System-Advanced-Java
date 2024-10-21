package com.fastfood.delivery.model;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RoundedButton extends JButton
{
    private int radius; // Radius for rounded corners

    public RoundedButton(String text, int radius)
    {
        super(text);
        this.radius = radius; // Set radius
        setOpaque(false); // Make transparent
        setContentAreaFilled(false); // No fill
        setForeground(Color.WHITE); // Text color
        setBackground(Color.blue); // Blue background
        setBorderPainted(false); // No border

        // Create rounded border
        Border roundedBorder = BorderFactory.createLineBorder(Color.blue, 2);
        setBorder(BorderFactory.createCompoundBorder(roundedBorder, BorderFactory.createEmptyBorder(4, 4, 4, 4)));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g.create(); // Create graphics context
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Enable anti-aliasing

        g2d.setColor(getBackground()); // Set background color
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius); // Draw rounded rectangle

        super.paintComponent(g); // Paint button contents
        g2d.dispose(); // Dispose graphics context
    }

    @Override
    protected void paintBorder(Graphics g)
    {
        super.paintBorder(g); // Paint border if needed
    }
}
