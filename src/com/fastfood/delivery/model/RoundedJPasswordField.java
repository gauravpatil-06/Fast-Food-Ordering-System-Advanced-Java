package com.fastfood.delivery.model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedJPasswordField extends JPasswordField
{
    private int radius;
    private final int borderThickness = 2;

    public RoundedJPasswordField(int radius)
    {
        super();
        this.radius = radius;
        setOpaque(false);
        setForeground(Color.DARK_GRAY);
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D.Float roundedRectangle = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius);
        g2d.setColor(getBackground());
        g2d.fill(roundedRectangle);

        super.paintComponent(g);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(borderThickness));

        // Create a rounded rectangle for the border with an adjusted size
        RoundRectangle2D.Float roundedBorder = new RoundRectangle2D.Float(
                borderThickness / 2f, // Offset by half the border thickness
                borderThickness / 2f, // Offset by half the border thickness
                getWidth() - borderThickness, // Adjust width for border thickness
                getHeight() - borderThickness, // Adjust height for border thickness
                radius, radius
        );

        g2d.draw(roundedBorder); // Draw the rounded border
        g2d.dispose(); // Dispose the graphics context
    }
}
