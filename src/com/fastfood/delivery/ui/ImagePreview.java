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
    private JFileChooser fileChooser;
    private ImageIcon thumbnail;
    private File file;

    public ImagePreview(JFileChooser fileChooser) {
        this.fileChooser = fileChooser;
        this.fileChooser.addPropertyChangeListener(evt ->
        {
            boolean update = false;

            if (JFileChooser.DIRECTORY_CHANGED_PROPERTY.equals(evt.getPropertyName()))
            {
                file = null;
                update = true;
            }
            else if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(evt.getPropertyName()))
            {
                file = (File) evt.getNewValue();
                update = true;
            }
            if (update)
            {
                if (isShowing())
                {
                    loadImage();
                    repaint();
                }
            }
        });
        setPreferredSize(new Dimension(300, 300)); // Set preview size
    }

    private void loadImage()
    {
        if (file == null) {
            thumbnail = null;
            return;
        }

        // Try to read and scale the image
        try
        {
            BufferedImage img = ImageIO.read(file);
            if (img != null)
            {
                thumbnail = new ImageIcon(img.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
            }
        }
        catch (IOException e)
        {
            thumbnail = null;
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        if (thumbnail == null)
        {
            loadImage();
        }
        if (thumbnail != null)
        {
            int x = getWidth() / 2 - thumbnail.getIconWidth() / 2;
            int y = getHeight() / 2 - thumbnail.getIconHeight() / 2;

            if (y < 0)
            {
                y = 0;
            }

            thumbnail.paintIcon(this, g, x, y);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        file = fileChooser.getSelectedFile();
        if (isShowing())
        {
            loadImage();
            repaint();
        }
    }
}
