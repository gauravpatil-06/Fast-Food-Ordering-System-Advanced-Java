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
import java.sql.*;

public class MyProfile extends JPanel
{
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USER = "system";
    private static final String DB_PASSWORD = "gaurav";

    JLabel L1, L2, L3, L4, L5, L6;
    RoundedTextField tf1, tf2, tf3, tf4, tf5;
    RoundedButton b1, b2, b3;
    ImageIcon profile;

    private String currentUsername;  // Stores the current username for database update

    // Constructor takes user details as parameters
   public MyProfile(String name, String mobileNo, String emailId, String username, String password)
    {
        this.currentUsername = username;  // Store the username

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
                // Capture the updated information from the text fields
                String updatedName = tf1.getText();
                String updatedMobile = tf2.getText();
                String updatedEmail = tf3.getText();
                String updatedPassword = tf5.getText();

                // Call method to update the user data in the database
                boolean isUpdated = updateUserData(updatedName, updatedMobile, updatedEmail, updatedPassword);

                if (isUpdated)
                {
                    JOptionPane.showMessageDialog(null, "Profile Updated Successfully!");
                } else
                {
                    JOptionPane.showMessageDialog(null, "Failed to Update Profile!", "Error", JOptionPane.ERROR_MESSAGE);
                }
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
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current MyProfile JPanel
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MyProfile.this);
                topFrame.dispose(); // Close the current frame

                // Open the login page
                LoginPage loginPage = new LoginPage(); // Assuming you have a LoginPage class
                loginPage.setVisible(true);
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

        ActionListener actionListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Object source = e.getSource(); // Get the source of the event

                if (source == tf1)
                {
                    tf2.requestFocus(); // Move to Mobile No. field
                } else if (source == tf2)
                {
                    tf3.requestFocus(); // Move to Email ID field
                } else if (source == tf3)
                {
                    tf4.requestFocus(); // Move to Username field
                } else if (source == tf4)
                {
                    tf5.requestFocus(); // Move to Password field
                } else if (source == tf5)
                {
                    b1.doClick(); // Simulate clicking the Register button
                }
            }
        };

        tf1.addActionListener(actionListener);
        tf2.addActionListener(actionListener);
        tf3.addActionListener(actionListener);
        tf4.addActionListener(actionListener);
        tf5.addActionListener(actionListener);

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

    // Method to update the user data in the database
    private boolean updateUserData(String name, String mobileNo, String emailId, String password)
    {
        boolean isUpdated = false;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD))
        {
            String query = "UPDATE users SET name = ?, mobile_no = ?, email_id = ?, password = ? WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, mobileNo);
            stmt.setString(3, emailId);
            stmt.setString(4, password);
            stmt.setString(5, currentUsername);  // Use the stored username for WHERE clause

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0)
            {
                isUpdated = true;  // Update was successful
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return isUpdated;
    }
}
