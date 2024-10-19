package com.fastfood.delivery.ui;

import com.fastfood.delivery.model.RoundedButton;
import com.fastfood.delivery.model.RoundedTextField;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;

public class MyProfile extends JPanel
{
    JLabel L1, L2, L3, L4, L5, L6;
    RoundedTextField tf1, tf2, tf3, tf4, tf5;
    RoundedButton b1, b2, b3;
    ImageIcon profile;

    // Constructor now takes user details as parameters
   public MyProfile(String name, String mobileNo, String emailId, String username, String password)
    {
        setLayout(null);
        setBackground(new Color(224, 255, 255));

        Font f1 = new Font("Arial Black", Font.BOLD, 45);
        Font f2 = new Font("adamina", Font.BOLD, 25);
        Font f3 = new Font("Arial Black", Font.BOLD, 25);

        // Title
        L1 = new JLabel("My Profile", JLabel.CENTER);
        L1.setFont(f1);
        L1.setForeground(Color.blue);

        // Name
        ImageIcon name_icon = new ImageIcon("src/resources/logo_name.png");
        JLabel imageLabel_name = new JLabel(new ImageIcon(name_icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        L2 = new JLabel("Name:", JLabel.CENTER);
        L2.setFont(f2);
        L2.setForeground(Color.black);
        tf1 = new RoundedTextField(16);
        tf1.setFont(f2);
        Border tf1_round = BorderFactory.createLineBorder(Color.blue, 1);
        tf1.setBorder(BorderFactory.createCompoundBorder(tf1_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        // Mobile Number
        ImageIcon mobile_no = new ImageIcon("src/resources/logo_phone.png");
        JLabel imageLabel_mobile_no = new JLabel(new ImageIcon(mobile_no.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        L3 = new JLabel("Mobile No:", JLabel.CENTER);
        L3.setFont(f2);
        L3.setForeground(Color.black);
        tf2 = new RoundedTextField(16);
        tf2.setFont(f2);
        Border tf2_round = BorderFactory.createLineBorder(Color.blue, 1);
        tf2.setBorder(BorderFactory.createCompoundBorder(tf2_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        // Email ID
        ImageIcon email_id = new ImageIcon("src/resources/logo_email.png");
        JLabel imageLabel_email_id = new JLabel(new ImageIcon(email_id.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        L4 = new JLabel("Email ID:", JLabel.CENTER);
        L4.setFont(f2);
        L4.setForeground(Color.black);
        tf3 = new RoundedTextField(16);
        tf3.setFont(f2);
        Border tf3_round = BorderFactory.createLineBorder(Color.blue, 1);
        tf3.setBorder(BorderFactory.createCompoundBorder(tf3_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        // Username
        ImageIcon user = new ImageIcon("src/resources/logo_username.png");
        JLabel imageLabel_user = new JLabel(new ImageIcon(user.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        L5 = new JLabel("Username:", JLabel.CENTER);
        L5.setFont(f2);
        L5.setForeground(Color.black);
        tf4 = new RoundedTextField(16);
        tf4.setFont(f2);
        Border tf4_round = BorderFactory.createLineBorder(Color.blue, 1);
        tf4.setBorder(BorderFactory.createCompoundBorder(tf4_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        // Password
        ImageIcon pwd = new ImageIcon("src/resources/logo_password.png");
        JLabel imageLabel_pwd = new JLabel(new ImageIcon(pwd.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        L6 = new JLabel("Password:", JLabel.CENTER);
        L6.setFont(f2);
        L6.setForeground(Color.black);
        tf5 = new RoundedTextField(16);
        tf5.setFont(f2);
        Border tf5_round = BorderFactory.createLineBorder(Color.blue, 1);
        tf5.setBorder(BorderFactory.createCompoundBorder(tf5_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        b1 = new RoundedButton("Save", 20);
        b1.setFont(f3);
        b1.setForeground(Color.white);
        b1.setBackground(Color.blue);

        profile = new ImageIcon("src/resources/logo_login_page.png");
        JLabel imageLabel_profile = new JLabel(new ImageIcon(profile.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH)));

        b2 = new RoundedButton("Choose Photo", 20);
        b2.setFont(f3);
        b2.setForeground(Color.white);
        b2.setBackground(Color.blue);

        b3 = new RoundedButton("Log Out", 20);
        b3.setFont(f3);
        b3.setForeground(Color.white);
        b3.setBackground(Color.blue);

        // Set bounds for the components
        L1.setBounds(450, 30, 500, 60);

        imageLabel_profile.setBounds(900, 150, 350, 350); // Keep this dimension as requested

        imageLabel_name.setBounds(135, 220, 40, 40);
        L2.setBounds(115, 220, 300, 40);
        tf1.setBounds(380, 220, 300, 40);

        imageLabel_mobile_no.setBounds(135, 300, 40, 40);
        L3.setBounds(120, 300, 300, 40);
        tf2.setBounds(380, 300, 300, 40);

        imageLabel_email_id.setBounds(135, 380, 40, 40);
        L4.setBounds(115, 380, 300, 40);
        tf3.setBounds(380, 380, 300, 40);

        imageLabel_user.setBounds(135, 460, 40, 40);
        L5.setBounds(120, 460, 300, 40);
        tf4.setBounds(380, 460, 300, 40);

        imageLabel_pwd.setBounds(135, 540, 40, 40);
        L6.setBounds(120, 540, 300, 40);
        tf5.setBounds(380, 540, 300, 40);

        b1.setBounds(270, 650, 300, 50);
        b2.setBounds(940, 570, 300, 50);
        b3.setBounds(940, 660, 300, 50);

        // Add submit action
        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = tf1.getText();
                String mobile = tf2.getText();
                String email = tf3.getText();
                String username = tf4.getText();
                String password = tf5.getText();

                // Show message dialog on submission
                JOptionPane.showMessageDialog(null, "Profile Save successfully!!!");
            }
        });

        // Populate the text fields with provided user details
        tf1.setText(name);
        tf2.setText(mobileNo);
        tf3.setText(emailId);
        tf4.setText(username);
        tf5.setText(password);

        b2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setPreferredSize(new Dimension(1000, 700)); // Update the dialog size to 10000x700
                FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG,JPEG & PNG Images", "jpg", "png","jpeg");
                fileChooser.setFileFilter(filter);
                fileChooser.setAccessory(new ImagePreview(fileChooser)); // Preview added for better visibility
                int returnVal = fileChooser.showOpenDialog(null);

                if (returnVal == JFileChooser.APPROVE_OPTION)
                {
                    File file = fileChooser.getSelectedFile();
                    try
                    {
                        BufferedImage bufferedImage = ImageIO.read(file);
                        profile = new ImageIcon(bufferedImage);
                        // Set the profile picture with rounded shape
                        imageLabel_profile.setIcon(getRoundedProfilePic(profile, 350, 350));  // Update profile pic to 350x350
                        b2.setText("Change Photo");
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error loading image!");
                    }
                }
            }
        });

        add(L1);
        add(imageLabel_profile);
        add(imageLabel_name);
        add(L2);
        add(tf1);
        add(imageLabel_mobile_no);
        add(L3);
        add(tf2);
        add(imageLabel_email_id);
        add(L4);
        add(tf3);
        add(imageLabel_user);
        add(L5);
        add(tf4);
        add(imageLabel_pwd);
        add(L6);
        add(tf5);
        add(b1);
        add(b2);
        add(b3);

    }

    // Method to create a rounded profile picture
    public ImageIcon getRoundedProfilePic(ImageIcon icon, int width, int height)
    {
        if (icon == null)
        {
            return new ImageIcon(new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB));  // Return empty if no image
        }

        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bufferedImage.createGraphics();

        g2.setClip(new Ellipse2D.Double(0, 0, width, height));
        g2.drawImage(scaledImage, 0, 0, width, height, null);
        g2.dispose();

        return new ImageIcon(bufferedImage);
    }
}
