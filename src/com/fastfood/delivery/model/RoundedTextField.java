package com.fastfood.delivery.model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedTextField extends JTextField
{
    private int radius; // Radius for rounded corners
    private final int borderThickness = 2; // Thickness of the border

    public RoundedTextField(int radius)
    {
        super();
        this.radius = radius; // Set radius
        setOpaque(false); // Make transparent
        setForeground(Color.DARK_GRAY); // Text color
        setBackground(Color.WHITE); // Background color
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g.create(); // Create graphics context
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Enable anti-aliasing

        // Create rounded rectangle for background
        RoundRectangle2D.Float roundedRectangle = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius);
        g2d.setColor(getBackground()); // Set background color
        g2d.fill(roundedRectangle); // Fill rounded rectangle

        super.paintComponent(g); // Paint text field contents
        g2d.dispose(); // Dispose graphics context
    }

    @Override
    protected void paintBorder(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g.create(); // Create graphics context
        g2d.setColor(Color.BLUE); // Border color
        g2d.setStroke(new BasicStroke(borderThickness)); // Set border thickness

        // Create a rounded rectangle for the border with an adjusted size
        RoundRectangle2D.Float roundedBorder = new RoundRectangle2D.Float(
                borderThickness / 2f, // Offset by half the border thickness
                borderThickness / 2f, // Offset by half the border thickness
                getWidth() - borderThickness, // Adjust width for border thickness
                getHeight() - borderThickness, // Adjust height for border thickness
                radius, radius // Set corner radius
        );

        g2d.draw(roundedBorder); // Draw the rounded border
        g2d.dispose(); // Dispose the graphics context
    }
}
