package com.fastfood.delivery.ui;

import com.fastfood.delivery.model.RoundedButton;
import com.fastfood.delivery.model.RoundedJPasswordField;
import com.fastfood.delivery.model.RoundedTextField;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame
{
    JLabel L1, L2, L3;
    RoundedTextField tf1;
    RoundedJPasswordField tf2;
    RoundedButton b1, b2;
    JCheckBox showPasswordCheckbox;

    // Database connection details
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USER = "system";
    private static final String DB_PASSWORD = "gaurav";

    LoginPage()
    {
        Container c = getContentPane();
        c.setLayout(null);

        Font f1 = new Font("Arial Black", Font.BOLD, 45);
        Font f2 = new Font("adamina", Font.BOLD, 25);
        Font f3 = new Font("Arial Black", Font.BOLD, 25);
        Font f4 = new Font("adamina", Font.BOLD, 16);

        // Background image
        ImageIcon icon = new ImageIcon("src/resources/bg_login_page.png");
        Dimension bg_login_screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(bg_login_screenSize.width, bg_login_screenSize.height, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(scaledImg));
        background.setSize(bg_login_screenSize.width, bg_login_screenSize.height);
        c.add(background);

        // Logo image
        ImageIcon imageIcon = new ImageIcon("src/resources/logo_login_page.png");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);

        //Title
        L1 = new JLabel("Login Here", JLabel.CENTER);
        L1.setFont(f1);
        L1.setForeground(Color.blue);

        // Username
        ImageIcon user = new ImageIcon("src/resources/logo_username.png");
        JLabel imageLabel_user = new JLabel(new ImageIcon(user.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        L2 = new JLabel("Username:", JLabel.RIGHT);
        L2.setFont(f2);
        L2.setForeground(Color.black);
        tf1 = new RoundedTextField(16);
        tf1.setFont(f2);
        Border tf1_round = BorderFactory.createLineBorder(Color.blue, 1);
        tf1.setBorder(BorderFactory.createCompoundBorder(tf1_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        // Password
        ImageIcon pwd = new ImageIcon("src/resources/logo_password.png");
        JLabel imageLabel_pwd = new JLabel(new ImageIcon(pwd.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        L3 = new JLabel("Password:", JLabel.RIGHT);
        L3.setFont(f2);
        L3.setForeground(Color.black);
        tf2 = new RoundedJPasswordField(16);
        tf2.setFont(f2);
        Border tf2_round = BorderFactory.createLineBorder(Color.blue, 1);
        tf2.setBorder(BorderFactory.createCompoundBorder(tf2_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        showPasswordCheckbox = new JCheckBox("Show Password");
        showPasswordCheckbox.setFont(f4);
        showPasswordCheckbox.setForeground(Color.black);
        showPasswordCheckbox.setOpaque(false); // Make the checkbox background transparent

        // Add action listener to the checkbox to show/hide password
        showPasswordCheckbox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (showPasswordCheckbox.isSelected())
                {
                    tf2.setEchoChar((char) 0); // Show the password
                }
                else
                {
                    tf2.setEchoChar('*'); // Hide the password
                }
            }
        });

        b1 = new RoundedButton("Login", 20);  // Login button
        b1.setFont(f3);
        b1.setForeground(Color.white);
        b1.setBackground(Color.blue);

        b2 = new RoundedButton("Sign Up", 20);  // Sign Up button
        b2.setFont(f3);
        b2.setForeground(Color.white);
        b2.setBackground(Color.blue);

        imageLabel.setBounds(510, -80, 500, 500);
        L1.setBounds(510, 310, 500, 60);
        imageLabel_user.setBounds(530, 420, 40, 40);
        L2.setBounds(410, 420, 300, 40);
        tf1.setBounds(740, 420, 250, 40);
        imageLabel_pwd.setBounds(530, 500, 40, 40);
        L3.setBounds(410, 500, 300, 40);
        tf2.setBounds(740, 500, 250, 40);
        showPasswordCheckbox.setBounds(830, 545, 200, 30);
        b1.setBounds(620, 610, 300, 45);
        b2.setBounds(620, 690, 300, 45);

        background.add(imageLabel);
        background.add(L1);
        background.add(imageLabel_user);
        background.add(L2);
        background.add(tf1);
        background.add(imageLabel_pwd);
        background.add(L3);
        background.add(tf2);
        background.add(showPasswordCheckbox);
        background.add(b1);
        background.add(b2);

        // Login button action
        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String username = tf1.getText();
                String password = tf2.getText();

                // Input validation for username and password
                if (username.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Username cannot be Empty", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (password.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Password cannot be Empty", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (username.length() < 8)
                {
                    JOptionPane.showMessageDialog(null, "Username must be at least 8 characters", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (password.length() < 8)
                {
                    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    if (validateLogin(username, password))
                    {
                        JOptionPane.showMessageDialog(null, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                        new HomePage(username).setVisible(true);
                        dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Sign Up button action
        b2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new RegistrationPage().setVisible(true);
                dispose();
            }
        });

        // ActionListener to handle Enter key and field focus
        ActionListener actionListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Object source = e.getSource();
                if (source == tf1)
                {
                    tf2.requestFocus();
                }
                else if (source == tf2)
                {
                    b1.doClick();
                }
            }
        };

        tf1.addActionListener(actionListener);
        tf2.addActionListener(actionListener);

        setTitle("Fast Food Delivery");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
    }

    // Method to validate the user login against the database
    private boolean validateLogin(String username, String password)
    {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD))
        {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // returns true if a matching record is found
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while validating user credentials.");
            return false;
        }
    }

    public static void main(String args[])
    {
        LoginPage f1 = new LoginPage();
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
