package com.fastfood.delivery.ui;

import com.fastfood.delivery.model.RoundedButton_Blue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        setPreferredSize(new Dimension(1500, 6000));
    }

    // Method to display orders in the order history page
    private void displayOrderHistory()
    {
        try
        {
            // Establish connection to the database
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "SELECT id, full_name, phone_number, email, address, food_item, price, quantity, payment_method, delivery_time FROM Orders";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            // Reset positions for card layout
            int cardPositionX = 20;
            int cardPositionY = 30;
            int cardWidth = 470;
            int cardHeight = 710;
            int cardGap = 500;

            int cardCount = 0;

            // Iterate through each row in the result set and create a card
            while (rs.next())
            {
                int orderId = rs.getInt("id"); // Get order ID for deletion
                JPanel card = createCard(
                        orderId, // Pass order ID to the card
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
            // Set the preferred size of the panel based on the number of cards added
            int preferredHeight = cardPositionY + 50; // Adding 50 pixels at the bottom
            setPreferredSize(new Dimension(1500, preferredHeight)); // Width fixed, height dynamic

            // Close the result set, prepared statement, and connection
            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // Method to create a card with order details
    private JPanel createCard(int orderId, String fullName, String phoneNumber, String email, String address,
                              String foodItem, String price, int quantity, String paymentMethod, String deliveryTime)
    {
        JPanel card = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.darkGray);
                g2.setStroke(new BasicStroke(2));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
            }
        };

        card.setLayout(null); // Use absolute layout to position components manually

        Font f1 = new Font("SansSerif", Font.BOLD, 18);
        Font f2 = new Font("Arial Black", Font.BOLD, 20);

        // Add the order details to the card
        JLabel imageLabel = new JLabel();
        ImageIcon icon = getImageForFoodItem(foodItem); // Get image based on food item name
        if (icon != null)
        {
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(464, 306, Image.SCALE_SMOOTH); // Resize image slightly smaller
            imageLabel.setIcon(new ImageIcon(scaledImg));
        }
        imageLabel.setBounds(3, 3, 464, 306); // Adjust image bounds
        card.add(imageLabel);

        JLabel fullNameLabel = new JLabel("Full Name: " + fullName, JLabel.LEFT);
        fullNameLabel.setFont(f1);
        fullNameLabel.setBounds(30, 330, 500, 35);  // Adjust position
        card.add(fullNameLabel);

        JLabel phoneLabel = new JLabel("Mobile Number: " + phoneNumber, JLabel.LEFT);
        phoneLabel.setFont(f1);
        phoneLabel.setBounds(30, 360, 500, 35);
        card.add(phoneLabel);

        JLabel emailLabel = new JLabel("Email Address: " + email, JLabel.LEFT);
        emailLabel.setFont(f1);
        emailLabel.setBounds(30, 390, 500, 35);  // Adjust position
        card.add(emailLabel);

        JLabel addressLabel = new JLabel("Delivery Address: " + address, JLabel.LEFT);
        addressLabel.setFont(f1);
        addressLabel.setBounds(30, 420, 500, 35);  // Adjust position
        card.add(addressLabel);

        JLabel foodItemLabel = new JLabel("Food Item Name: " + foodItem, JLabel.LEFT);
        foodItemLabel.setFont(f1);
        foodItemLabel.setBounds(30, 450, 500, 35);  // Adjust position
        card.add(foodItemLabel);

        JLabel priceLabel = new JLabel("Price (Per Item): " + price, JLabel.LEFT);
        priceLabel.setFont(f1);
        priceLabel.setBounds(30, 480, 500, 35);  // Adjust position
        card.add(priceLabel);

        JLabel quantityLabel = new JLabel("Quantity: " + quantity, JLabel.LEFT);
        quantityLabel.setFont(f1);
        quantityLabel.setBounds(30, 510, 500, 35);  // Adjust position
        card.add(quantityLabel);

        JLabel paymentLabel = new JLabel("Payment Method: " + paymentMethod, JLabel.LEFT);
        paymentLabel.setFont(f1);
        paymentLabel.setBounds(30, 540, 500, 35);  // Adjust position
        card.add(paymentLabel);

        JLabel deliveryLabel = new JLabel("Delivery Time: " + deliveryTime, JLabel.LEFT);
        deliveryLabel.setFont(f1);
        deliveryLabel.setBounds(30, 570, 500, 35);  // Adjust position
        card.add(deliveryLabel);

        RoundedButton_Blue cancelOrderButton = new RoundedButton_Blue("Cancel Order", 20);
        cancelOrderButton.setFont(f2);
        cancelOrderButton.setBounds(30, 630, 410, 45);  // Adjust position
        card.add(cancelOrderButton);

        // Add action listener to the cancel button
        cancelOrderButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Confirm deletion
                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this order?", "Confirm Cancel", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION)
                {
                    deleteOrder(orderId); // Call delete method
                    remove(card); // Remove the card from the panel
                    revalidate(); // Refresh the layout
                    repaint(); // Repaint the panel
                }
            }
        });

        return card;
    }

    // Method to delete an order from the database
    private void deleteOrder(int orderId)
    {
        try
        {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "DELETE FROM Orders WHERE id = ?"; // Use the correct identifier (order ID)
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, orderId);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

            JOptionPane.showMessageDialog(null, "Order canceled successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            refreshOrder();// Refresh the records after deletion

        } catch (Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to cancel order: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void refreshOrder() {
        removeAll();
        displayOrderHistory(); // Call to repopulate the order history
        revalidate(); // Refresh the UI
        repaint();
    }

    // Helper method to get the image based on the food item name
    private ImageIcon getImageForFoodItem(String foodItem)
    {
        String imagePath = "src/resources/card_images/" + foodItem + ".jpg"; // Image path based on food item name
        return new ImageIcon(imagePath);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Fast Food Delivery");
        OrderHistory orderHistoryPanel = new OrderHistory();

        JScrollPane scrollPane1 = new JScrollPane(orderHistoryPanel);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane1.getVerticalScrollBar().setUnitIncrement(16);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane1);
        frame.setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
    }
}
