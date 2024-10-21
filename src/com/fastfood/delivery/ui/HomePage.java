package com.fastfood.delivery.ui;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class HomePage extends JFrame
{
    // Database connection details
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USER = "system";
    private static final String DB_PASSWORD = "gaurav";

    private OrderHistory orderHistory;  // Declare OrderHistory as a class member

    HomePage(String username)
    {
        Container c = getContentPane();

        Font f1 = new Font("Arial Black", Font.BOLD, 20);

        JTabbedPane jtp = new JTabbedPane();
        jtp.setFont(f1);

        UserData userData = getUserData(username); // Fetch data for the logged-in/registered user

        // Check if userData is not null
        if (userData != null)
        {
            Home home = new Home();
            orderHistory = new OrderHistory();  // Initialize OrderHistory
            MyProfile myProfile = new MyProfile(userData.getName(), userData.getMobileNo(), userData.getEmailId(), userData.getUsername(), userData.getPassword());
            AboutUs aboutUs = new AboutUs();
            ContactUs contactUs = new ContactUs();

            // Create a scroll pane for the Home panel
            JScrollPane scrollPane1 = new JScrollPane(home);
            scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane1.getVerticalScrollBar().setUnitIncrement(16); // Smooth scrolling

            // Create a scroll pane for the Order History panel
            JScrollPane scrollPane2 = new JScrollPane(orderHistory);
            scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane2.getVerticalScrollBar().setUnitIncrement(16); // Smooth scrolling

            // Create a scroll pane for the AboutUs panel
            JScrollPane scrollPane3 = new JScrollPane(aboutUs);
            scrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane3.getVerticalScrollBar().setUnitIncrement(16); // Smooth scrolling

            // Add tabs to the tabbed pane
            jtp.addTab("Home", scrollPane1);
            jtp.addTab("Order History", scrollPane2);
            jtp.addTab("My Profile", myProfile);
            jtp.addTab("About Us", scrollPane3);  // Add scroll pane for About Us
            jtp.addTab("Contact Us", contactUs);

            // Set background colors for each tab
            jtp.setBackgroundAt(0, new Color(255, 224, 178)); // Faint Light Orange
            jtp.setForegroundAt(0, Color.black);

            jtp.setBackgroundAt(1, new Color(255, 228, 225)); // Faint Blush Pink
            jtp.setForegroundAt(1, Color.black);

            jtp.setBackgroundAt(2, new Color(224, 255, 255)); // Faint Light Cyan
            jtp.setForegroundAt(2, Color.black);

            jtp.setBackgroundAt(3, new Color(220, 220, 220)); // Faint Grey
            jtp.setForegroundAt(3, Color.black);

            jtp.setBackgroundAt(4, new Color(255, 250, 205)); // Faint Lemon Yellow
            jtp.setForegroundAt(4, Color.black);

            // Set the Home tab as the default selected tab
            jtp.setSelectedIndex(0);

            // Add the tabbed pane to the container
            c.add(jtp);
        }
        else
        {
            // Show an error message if no user data was found
            JOptionPane.showMessageDialog(this, "User not found. Please check the username.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        setTitle("Fast Food Delivery");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
    }

    // Fetch user data from the database
    private UserData getUserData(String username)
    {
        UserData userData = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD))
        {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                String name = rs.getString("name");
                String mobileNo = rs.getString("mobile_no");
                String emailId = rs.getString("email_id");
                String password = rs.getString("password");
                userData = new UserData(name, mobileNo, emailId, username, password);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return userData;
    }

    public void refreshOrderHistory()
    {
        if (orderHistory != null) {
            orderHistory.refreshOrder(); // Call refresh method on OrderHistory
        }
    }

    public static void main(String args[])
    {
        HomePage f1 = new HomePage("Gaurav123");
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// Class to hold user data
class UserData
{
    private String name, mobileNo, emailId, username, password;

    public UserData(String name, String mobileNo, String emailId, String username, String password) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
        this.username = username;
        this.password = password;
    }

    public String getName() { return name; }
    public String getMobileNo() { return mobileNo; }
    public String getEmailId() { return emailId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
