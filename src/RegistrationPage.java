import com.fastfood.delivery.model.RoundedButton;
import com.fastfood.delivery.model.RoundedTextField;
import com.fastfood.delivery.ui.MyProfile;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RegistrationPage extends JFrame
{
    JLabel L1, L2, L3, L4, L5, L6;
    RoundedTextField tf1, tf2, tf3, tf4, tf5;
    RoundedButton b1;

    // Database connection details
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USER = "system";
    private static final String DB_PASSWORD = "gaurav";

    RegistrationPage()
    {
        Container c = getContentPane();
        c.setLayout(null);

        Font f1 = new Font("Arial Black", Font.BOLD, 45);
        Font f2 = new Font("adamina", Font.BOLD, 25);
        Font f3 = new Font("Arial Black", Font.BOLD, 25);

        // Set background
        ImageIcon icon = new ImageIcon("src/resources/bg_registration_page.png");
        Dimension bg_login_screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(bg_login_screenSize.width, bg_login_screenSize.height, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(scaledImg));
        background.setSize(bg_login_screenSize.width, bg_login_screenSize.height);
        c.add(background);

        // Title
        L1 = new JLabel("Register Here", JLabel.CENTER);
        L1.setFont(f1);
        L1.setForeground(Color.blue);

        // Name
        ImageIcon name = new ImageIcon("src/resources/logo_name.png");
        JLabel imageLabel_name = new JLabel(new ImageIcon(name.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        L2 = new JLabel("Name:", JLabel.CENTER);
        L2.setFont(f2);
        tf1 = new RoundedTextField(16);
        tf1.setFont(f2);
        Border tf1_round = BorderFactory.createLineBorder(Color.blue, 1);
        tf1.setBorder(BorderFactory.createCompoundBorder(tf1_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        // Mobile Number
        ImageIcon mobile_no = new ImageIcon("src/resources/logo_phone.png");
        JLabel imageLabel_mobile_no = new JLabel(new ImageIcon(mobile_no.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        L3 = new JLabel("Mobile No:", JLabel.CENTER);
        L3.setFont(f2);
        tf2 = new RoundedTextField(16);
        tf2.setFont(f2);
        Border tf2_round = BorderFactory.createLineBorder(Color.blue, 1);
        tf2.setBorder(BorderFactory.createCompoundBorder(tf2_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        // Email ID
        ImageIcon email_id = new ImageIcon("src/resources/logo_email.png");
        JLabel imageLabel_email_id = new JLabel(new ImageIcon(email_id.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        L4 = new JLabel("Email ID:", JLabel.CENTER);
        L4.setFont(f2);
        tf3 = new RoundedTextField(16);
        tf3.setFont(f2);
        Border tf3_round = BorderFactory.createLineBorder(Color.blue, 1);
        tf3.setBorder(BorderFactory.createCompoundBorder(tf3_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        // Username
        ImageIcon user = new ImageIcon("src/resources/logo_username.png");
        JLabel imageLabel_user = new JLabel(new ImageIcon(user.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        L5 = new JLabel("Username:", JLabel.CENTER);
        L5.setFont(f2);
        tf4 = new RoundedTextField(16);
        tf4.setFont(f2);
        Border tf4_round = BorderFactory.createLineBorder(Color.blue, 1);
        tf4.setBorder(BorderFactory.createCompoundBorder(tf4_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        // Password
        ImageIcon pwd = new ImageIcon("src/resources/logo_password.png");
        JLabel imageLabel_pwd = new JLabel(new ImageIcon(pwd.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        L6 = new JLabel("Password:", JLabel.CENTER);
        L6.setFont(f2);
        tf5 = new RoundedTextField(16);
        tf5.setFont(f2);
        Border tf5_round = BorderFactory.createLineBorder(Color.blue, 1);
        tf5.setBorder(BorderFactory.createCompoundBorder(tf5_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        b1 = new RoundedButton("Register", 20);
        b1.setFont(f3);
        b1.setForeground(Color.white);
        b1.setBackground(Color.blue);

        // Set bounds for components
        L1.setBounds(150, 80, 500, 60);

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

        // Add components to the background
        background.add(L1);
        background.add(imageLabel_name); background.add(L2); background.add(tf1);
        background.add(imageLabel_mobile_no); background.add(L3); background.add(tf2);
        background.add(imageLabel_email_id); background.add(L4); background.add(tf3);
        background.add(imageLabel_user); background.add(L5); background.add(tf4);
        background.add(imageLabel_pwd); background.add(L6); background.add(tf5);
        background.add(b1);

        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = tf1.getText();
                String mobile_no = tf2.getText();
                String email_id = tf3.getText();
                String username = tf4.getText();
                String password = tf5.getText();

                if (name.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Name cannot be Empty", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (mobile_no.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Mobile No. cannot be Empty", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (mobile_no.length() != 10)
                {
                    JOptionPane.showMessageDialog(null, "Mobile No. must be 10 characters", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (email_id.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Email ID cannot be Empty", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (username.isEmpty())
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
                    boolean success = registerUser(name, mobile_no, email_id, username, password);
                    if (success)
                    {
                        // After successful registration, open the Profile page and pass the details
                        new MyProfile(name, mobile_no, email_id, username, password);
                        dispose();
                    }
                }
            }
        });

        ActionListener actionListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Object source = e.getSource(); // Get the source of the event

                switch (source.getClass().getSimpleName())
                {
                    case "RoundedTextField_Register":
                        if (source == tf1)
                        {
                            tf2.requestFocus(); // Move to Mobile No. field
                        }
                        else if (source == tf2)
                        {
                            tf3.requestFocus(); // Move to Email ID field
                        }
                        else if (source == tf3)
                        {
                            tf4.requestFocus(); // Move to Username field
                        }
                        else if (source == tf4)
                        {
                            tf5.requestFocus(); // Move to Password field
                        }
                        else if (source == tf5)
                        {
                            b1.doClick(); // Simulate clicking the Register button
                        }
                        break;
                }
            }
        };

        tf1.addActionListener(actionListener);
        tf2.addActionListener(actionListener);
        tf3.addActionListener(actionListener);
        tf4.addActionListener(actionListener);
        tf5.addActionListener(actionListener);

        setTitle("Fast Food Delivery");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
    }

    // Method to connect to the database and insert user details
    private boolean registerUser(String name, String mobileNo, String emailId, String username, String password)
    {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD))
        {
            String query = "INSERT INTO users (name, mobile_no, email_id, username, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, mobileNo);
            preparedStatement.setString(3, emailId);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, password);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0)
            {
                JOptionPane.showMessageDialog(null, "Registered successfully!");
                return true;  // Indicate success
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while registering the user.");
        }
        return false;  // Indicate failure
    }

    public static void main(String args[])
    {
        RegistrationPage f1 = new RegistrationPage();
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
