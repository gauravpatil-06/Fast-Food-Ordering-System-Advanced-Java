package com.fastfood.delivery.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.IOException;

public class ImagePreview extends JComponent implements ChangeListener
{
    private JFileChooser fileChooser; // File chooser reference
    private ImageIcon thumbnail; // Thumbnail image
    private File file; // Selected file

    public ImagePreview(JFileChooser fileChooser)
    {
        this.fileChooser = fileChooser;
        this.fileChooser.addPropertyChangeListener(evt -> // Listener for file chooser changes
        {
            boolean update = false;

            if (JFileChooser.DIRECTORY_CHANGED_PROPERTY.equals(evt.getPropertyName())) // Directory changed
            {
                file = null; // Clear file
                update = true;
            }
            else if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(evt.getPropertyName())) // File selected
            {
                file = (File) evt.getNewValue();
                update = true;
            }
            if (update)
            {
                if (isShowing()) // If visible
                {
                    loadImage(); // Load image
                    repaint(); // Refresh
                }
            }
        });
        setPreferredSize(new Dimension(300, 300)); // Set preview size
    }

    private void loadImage()
    {
        if (file == null) // No file selected
        {
            thumbnail = null; // Clear thumbnail
            return;
        }

        // Try to read and scale the image
        try
        {
            BufferedImage img = ImageIO.read(file);
            if (img != null)
            {
                thumbnail = new ImageIcon(img.getScaledInstance(200, 200, Image.SCALE_SMOOTH)); // Scale image
            }
        }
        catch (IOException e) // Handle errors
        {
            thumbnail = null; // Clear thumbnail on error
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        if (thumbnail == null) // Load if not already loaded
        {
            loadImage();
        }
        if (thumbnail != null) // Draw thumbnail
        {
            int x = getWidth() / 2 - thumbnail.getIconWidth() / 2; // Center X
            int y = getHeight() / 2 - thumbnail.getIconHeight() / 2; // Center Y

            if (y < 0) // Adjust Y if needed
            {
                y = 0;
            }

            thumbnail.paintIcon(this, g, x, y); // Paint icon
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) // Update on state change
    {
        file = fileChooser.getSelectedFile(); // Get selected file
        if (isShowing()) // If visible
        {
            loadImage(); // Load image
            repaint(); // Refresh
        }
    }
}
