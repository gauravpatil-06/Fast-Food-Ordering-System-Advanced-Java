package com.fastfood.delivery.ui;

import com.fastfood.delivery.model.RoundedButton_Blue;

import javax.swing.*;
import java.awt.*;

public class OrderHistory extends JPanel
{
    JLabel full_name,mobile_no,email_id,address,food_item_name,price,quantity,payment_method,delivery_time;
    RoundedButton_Blue cancel_order;
    public OrderHistory()
    {
        setLayout(null);
        setBackground(new Color(255, 228, 225));

        // Create and add multiple cards with updated prices
        JPanel card1 = createCard("src/resources/card_images/pizza.jpg");
        card1.setBounds(20, 30, 470, 710);
        add(card1);

        JPanel card2 = createCard("src/resources/card_images/pizza.jpg");
        card2.setBounds(520, 30, 470, 710);
        add(card2);

        JPanel card3 = createCard("src/resources/card_images/pizza.jpg");
        card3.setBounds(1020, 30, 470, 710);
        add(card3);

        //Next Line

        JPanel card4 = createCard("src/resources/card_images/pizza.jpg");
        card4.setBounds(20, 780, 470, 710);
        add(card4);

        JPanel card5 = createCard("src/resources/card_images/pizza.jpg");
        card5.setBounds(520, 780, 470, 710);
        add(card5);

        JPanel card6 = createCard("src/resources/card_images/pizza.jpg");
        card6.setBounds(1020, 780, 470, 710);
        add(card6);

        // Set the preferred size of the Home panel
        setPreferredSize(new Dimension(1500, 4070)); // Width should accommodate all cards
    }

    private JPanel createCard(String imagePath)
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

        // Load and add an image to the card
        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon(imagePath); // Use provided image path
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(464, 306, Image.SCALE_SMOOTH); // Resize image slightly smaller
        imageLabel.setIcon(new ImageIcon(scaledImg));

        // Set padding (2 pixels on all sides) between image and card border
        imageLabel.setBounds(3, 3, 464, 306); // Adjust image bounds
        card.add(imageLabel);

        JLabel full_name,mobile_no,email_id,address,food_item_name,quantity,payment_method,delivery_time;
        RoundedButton_Blue cancel_order;

        full_name = new JLabel("Full Name: ", JLabel.LEFT);
        full_name.setFont(f1);
        full_name.setForeground(Color.black);
        full_name.setBounds(20, 330, 500, 35);  // Adjust position
        card.add(full_name);

        mobile_no = new JLabel("Mobile Number: ", JLabel.LEFT);
        mobile_no.setFont(f1);
        mobile_no.setForeground(Color.black);
        mobile_no.setBounds(20, 360, 500, 35);
        card.add(mobile_no);

        email_id = new JLabel("Email Address: ", JLabel.LEFT);
        email_id.setFont(f1);
        email_id.setForeground(Color.black);
        email_id.setBounds(20, 390, 500, 35);  // Adjust position
        card.add(email_id);

        address = new JLabel("Delivery Address: ", JLabel.LEFT);
        address.setFont(f1);
        address.setForeground(Color.black);
        address.setBounds(20, 420, 500, 35);  // Adjust position
        card.add(address);

        food_item_name = new JLabel("Food Item Name: ", JLabel.LEFT);
        food_item_name.setFont(f1);
        food_item_name.setForeground(Color.black);
        food_item_name.setBounds(20, 450, 500, 35);  // Adjust position
        card.add(food_item_name);

        price = new JLabel("Price (Per Item): ", JLabel.LEFT);
        price.setFont(f1);
        price.setForeground(Color.black);
        price.setBounds(20, 480, 500, 35);  // Adjust position
        card.add(price);

        quantity = new JLabel("Quantity: ", JLabel.LEFT);
        quantity.setFont(f1);
        quantity.setForeground(Color.black);
        quantity.setBounds(20, 510, 500, 35);  // Adjust position
        card.add(quantity);

        payment_method = new JLabel("Payment Method: ", JLabel.LEFT);
        payment_method.setFont(f1);
        payment_method.setForeground(Color.black);
        payment_method.setBounds(20, 540, 500, 35);  // Adjust position
        card.add(payment_method);

        delivery_time = new JLabel("Delivery Time: ", JLabel.LEFT);
        delivery_time.setFont(f1);
        delivery_time.setForeground(Color.black);
        delivery_time.setBounds(20, 570, 500, 35);  // Adjust position
        card.add(delivery_time);

        cancel_order = new RoundedButton_Blue("Cancel Order",20);
        cancel_order.setFont(f2);
        cancel_order.setForeground(Color.white);
        cancel_order.setBounds(30, 630, 410, 45);  // Adjust position
        card.add(cancel_order);

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
