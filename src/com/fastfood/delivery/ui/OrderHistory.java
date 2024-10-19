package com.fastfood.delivery.ui;

import com.fastfood.delivery.model.RoundedButton_Blue;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderHistory extends JPanel
{
    // Database connection details (Update as per your database configuration)
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Replace with your DB URL
    private static final String DB_USER = "system"; // Replace with your DB username
    private static final String DB_PASSWORD = "gaurav"; // Replace with your DB password

    public OrderHistory()
    {
        setLayout(null);
        setBackground(new Color(255, 228, 225));

        // Call the method to fetch data from the database
        displayOrderHistory();

        // Set the preferred size of the panel (adjust according to your needs)
        setPreferredSize(new Dimension(1500, 4070)); // Width should accommodate all cards
    }

    // Method to display orders in the order history page
    private void displayOrderHistory()
    {
        try
        {
            // Establish connection to the database
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "SELECT full_name, phone_number, email, address, food_item, price, quantity, payment_method, delivery_time FROM Orders";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            int cardPositionX = 20; // Initial x position for the first card
            int cardPositionY = 30; // Initial y position for the first card
            int cardWidth = 470;
            int cardHeight = 710;
            int cardGap = 500; // Gap between cards

            int cardCount = 0;

            // Iterate through each row in the result set and create a card
            while (rs.next())
            {
                JPanel card = createCard(
                        rs.getString("full_name"),
                        rs.getString("phone_number"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("food_item"),
                        rs.getString("price"),
                        rs.getInt("quantity"),
                        rs.getString("payment_method"),
                        rs.getString("delivery_time")
                );

                // Set the card's position on the panel
                card.setBounds(cardPositionX, cardPositionY, cardWidth, cardHeight);
                add(card);

                // Adjust position for the next card (in a row-wise arrangement)
                cardPositionX += cardGap;
                cardCount++;

                // Start a new row if three cards are added in a row
                if (cardCount % 3 == 0)
                {
                    cardPositionX = 20; // Reset to initial x position
                    cardPositionY += cardHeight + 50; // Move down for the next row
                }
            }

            // Close the result set, prepared statement, and connection
            rs.close();
            pstmt.close();
            conn.close();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // Method to create a card with order details
    private JPanel createCard(String fullName, String phoneNumber, String email, String address, String foodItem,
                              String price, int quantity, String paymentMethod, String deliveryTime)
    {
        JPanel card = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Set the border color and thickness
                g2.setColor(Color.darkGray);
                g2.setStroke(new BasicStroke(2));

                // Draw a rounded rectangle border with padding
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
            }
        };

        card.setLayout(null);  // Use absolute layout to position components manually

        Font f1 = new Font("SansSerif", Font.BOLD, 18);
        Font f2 = new Font("Arial Black", Font.BOLD, 20);

        // Add the order details to the card
        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon("src/resources/card_images/pizza.jpg"); // Replace with actual path
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(464, 306, Image.SCALE_SMOOTH); // Resize image slightly smaller
        imageLabel.setIcon(new ImageIcon(scaledImg));
        imageLabel.setBounds(3, 3, 464, 306); // Adjust image bounds
        card.add(imageLabel);

        JLabel fullNameLabel = new JLabel("Full Name: " + fullName, JLabel.LEFT);
        fullNameLabel.setFont(f1);
        fullNameLabel.setBounds(20, 330, 500, 35);  // Adjust position
        card.add(fullNameLabel);

        JLabel phoneLabel = new JLabel("Mobile Number: " + phoneNumber, JLabel.LEFT);
        phoneLabel.setFont(f1);
        phoneLabel.setBounds(20, 360, 500, 35);
        card.add(phoneLabel);

        JLabel emailLabel = new JLabel("Email Address: " + email, JLabel.LEFT);
        emailLabel.setFont(f1);
        emailLabel.setBounds(20, 390, 500, 35);  // Adjust position
        card.add(emailLabel);

        JLabel addressLabel = new JLabel("Delivery Address: " + address, JLabel.LEFT);
        addressLabel.setFont(f1);
        addressLabel.setBounds(20, 420, 500, 35);  // Adjust position
        card.add(addressLabel);

        JLabel foodItemLabel = new JLabel("Food Item Name: " + foodItem, JLabel.LEFT);
        foodItemLabel.setFont(f1);
        foodItemLabel.setBounds(20, 450, 500, 35);  // Adjust position
        card.add(foodItemLabel);

        JLabel priceLabel = new JLabel("Price (Per Item): " + price, JLabel.LEFT);
        priceLabel.setFont(f1);
        priceLabel.setBounds(20, 480, 500, 35);  // Adjust position
        card.add(priceLabel);

        JLabel quantityLabel = new JLabel("Quantity: " + quantity, JLabel.LEFT);
        quantityLabel.setFont(f1);
        quantityLabel.setBounds(20, 510, 500, 35);  // Adjust position
        card.add(quantityLabel);

        JLabel paymentLabel = new JLabel("Payment Method: " + paymentMethod, JLabel.LEFT);
        paymentLabel.setFont(f1);
        paymentLabel.setBounds(20, 540, 500, 35);  // Adjust position
        card.add(paymentLabel);

        JLabel deliveryLabel = new JLabel("Delivery Time: " + deliveryTime, JLabel.LEFT);
        deliveryLabel.setFont(f1);
        deliveryLabel.setBounds(20, 570, 500, 35);  // Adjust position
        card.add(deliveryLabel);

        RoundedButton_Blue cancelOrderButton = new RoundedButton_Blue("Cancel Order",20);
        cancelOrderButton.setFont(f2);
        cancelOrderButton.setBounds(30, 630, 410, 45);  // Adjust position
        card.add(cancelOrderButton);

        return card;
    }

    public static void main(String args[])
    {
        JFrame frame = new JFrame("Fast Food Delivery");
        OrderHistory homePanel = new OrderHistory();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a scroll pane for the home panel
        JScrollPane scrollPane = new JScrollPane(homePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Smooth scrolling

        frame.add(scrollPane);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize()); // Set size to full screen
        frame.setVisible(true);
    }
}