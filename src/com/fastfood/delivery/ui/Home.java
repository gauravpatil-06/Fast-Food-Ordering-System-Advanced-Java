package com.fastfood.delivery.ui;

import com.fastfood.delivery.model.RoundedButton;
import com.fastfood.delivery.model.RoundedButton_Blue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class Home extends JPanel
{
    JLabel foodname,price,discount;
    RoundedButton_Blue purchase;
    JButton rating;
    public Home()
    {
        setLayout(null);
        setBackground(new Color(255, 224, 178));

        // Create and add multiple cards with updated prices
        JPanel card1 = createCard("src/resources/card_images/pizza.jpg", "Pizza", "₹ 300", "20% OFF", "4.5 ★", "Purchase");
        card1.setBounds(20, 30, 350, 460);
        add(card1);

        JPanel card2 = createCard("src/resources/card_images/burger.jpg", "Burger", "₹ 150", "15% OFF", "4.2 ★", "Purchase");
        card2.setBounds(394, 30, 350, 460);
        add(card2);

        JPanel card3 = createCard("src/resources/card_images/sandwich.jpg", "Sandwich", "₹ 120", "10% OFF", "4.0 ★", "Purchase");
        card3.setBounds(770, 30, 350, 460);
        add(card3);

        JPanel card4 = createCard("src/resources/card_images/pasta.jpg", "Pasta", "₹ 250", "25% OFF", "4.3 ★", "Purchase");
        card4.setBounds(1144, 30, 350, 460);
        add(card4);

// Next Line
        JPanel card5 = createCard("src/resources/card_images/momos.jpg", "Momos", "₹ 100", "30% OFF", "4.1 ★", "Purchase");
        card5.setBounds(20, 529, 350, 460);
        add(card5);

        JPanel card6 = createCard("src/resources/card_images/fries.jpg", "Fries", "₹ 80", "5% OFF", "3.9 ★", "Purchase");
        card6.setBounds(394, 529, 350, 460);
        add(card6);

        JPanel card7 = createCard("src/resources/card_images/dhokla.jpg", "Dhokla", "₹ 150", "12% OFF", "4.4 ★", "Purchase");
        card7.setBounds(770, 529, 350, 460);
        add(card7);

        JPanel card8 = createCard("src/resources/card_images/manchurian.jpeg", "Manchurian", "₹ 200", "20% OFF", "4.6 ★", "Purchase");
        card8.setBounds(1144, 529, 350, 460);
        add(card8);

// Next Line
        JPanel card9 = createCard("src/resources/card_images/nachos_with_chees.jpg", "Nachos with Cheese", "₹ 180", "18% OFF", "4.0 ★", "Purchase");
        card9.setBounds(20, 1029, 350, 460);
        add(card9);

        JPanel card10 = createCard("src/resources/card_images/grilled_prawn.jpg", "Grilled Prawn", "₹ 400", "22% OFF", "4.5 ★", "Purchase");
        card10.setBounds(394, 1029, 350, 460);
        add(card10);

        JPanel card11 = createCard("src/resources/card_images/apple_pie.jpg", "Apple Pie", "₹ 100", "25% OFF", "4.3 ★", "Purchase");
        card11.setBounds(770, 1029, 350, 460);
        add(card11);

        JPanel card12 = createCard("src/resources/card_images/chicken_biryani.jpg", "Chicken Biryani", "₹ 350", "15% OFF", "4.7 ★", "Purchase");
        card12.setBounds(1144, 1029, 350, 460);
        add(card12);

// Next Line
        JPanel card13 = createCard("src/resources/card_images/paneer_biryani.jpg", "Paneer Biryani", "₹ 320", "18% OFF", "4.5 ★", "Purchase");
        card13.setBounds(20, 1529, 350, 460);
        add(card13);

        JPanel card14 = createCard("src/resources/card_images/calamari_ring.jpg", "Calamari Ring", "₹ 450", "20% OFF", "4.6 ★", "Purchase");
        card14.setBounds(394, 1529, 350, 460);
        add(card14);

        JPanel card15 = createCard("src/resources/card_images/fish_tacos.jpg", "Fish Tacos", "₹ 200", "10% OFF", "4.4 ★", "Purchase");
        card15.setBounds(770, 1529, 350, 460);
        add(card15);

        JPanel card16 = createCard("src/resources/card_images/samosa.jpg", "Samosa", "₹ 20", "30% OFF", "3.9 ★", "Purchase");
        card16.setBounds(1144, 1529, 350, 460);
        add(card16);

// Next Line
        JPanel card17 = createCard("src/resources/card_images/vada pav.jpg", "Vada Pav", "₹ 30", "25% OFF", "4.0 ★", "Purchase");
        card17.setBounds(20, 2029, 350, 460);
        add(card17);

        JPanel card18 = createCard("src/resources/card_images/aloo_tikki.jpg", "Aloo Tikki", "₹ 40", "20% OFF", "3.8 ★", "Purchase");
        card18.setBounds(394, 2029, 350, 460);
        add(card18);

        JPanel card19 = createCard("src/resources/card_images/pani_puri.jpg", "Pani Puri", "₹ 50", "10% OFF", "4.2 ★", "Purchase");
        card19.setBounds(770, 2029, 350, 460);
        add(card19);

        JPanel card20 = createCard("src/resources/card_images/lobster_roll.jpg", "Lobster Roll", "₹ 900", "15% OFF", "4.8 ★", "Purchase");
        card20.setBounds(1144, 2029, 350, 460);
        add(card20);

// Next Line
        JPanel card21 = createCard("src/resources/card_images/cake.jpg", "Cake", "₹ 350", "20% OFF", "4.5 ★", "Purchase");
        card21.setBounds(20, 2529, 350, 460);
        add(card21);

        JPanel card22 = createCard("src/resources/card_images/gulab_jamun.jpg", "Gulab Jamun", "₹ 150", "15% OFF", "4.6 ★", "Purchase");
        card22.setBounds(394, 2529, 350, 460);
        add(card22);

        JPanel card23 = createCard("src/resources/card_images/cheesecake.jpg", "Cheesecake", "₹ 300", "10% OFF", "4.7 ★", "Purchase");
        card23.setBounds(770, 2529, 350, 460);
        add(card23);

        JPanel card24 = createCard("src/resources/card_images/tiramisu.jpg", "Tiramisu", "₹ 400", "25% OFF", "4.4 ★", "Purchase");
        card24.setBounds(1144, 2529, 350, 460);
        add(card24);

// Next Line
        JPanel card25 = createCard("src/resources/card_images/rasgulla.jpg", "Rasgulla", "₹ 100", "20% OFF", "4.5 ★", "Purchase");
        card25.setBounds(20, 3029, 350, 460);
        add(card25);

        JPanel card26 = createCard("src/resources/card_images/mango_smoothi.jpg", "Mango Smoothie", "₹ 120", "10% OFF", "4.0 ★", "Purchase");
        card26.setBounds(394, 3029, 350, 460);
        add(card26);

        JPanel card27 = createCard("src/resources/card_images/cold_coffee.jpg", "Cold Coffee", "₹ 150", "15% OFF", "4.3 ★", "Purchase");
        card27.setBounds(770, 3029, 350, 460);
        add(card27);

        JPanel card28 = createCard("src/resources/card_images/milk-shake.jpg", "Milk Shake", "₹ 100", "5% OFF", "4.2 ★", "Purchase");
        card28.setBounds(1144, 3029, 350, 460);
        add(card28);

// Next Line
        JPanel card29 = createCard("src/resources/card_images/lemno_lced_tea.jpg", "Lemon Iced Tea", "₹ 80", "12% OFF", "4.1 ★", "Purchase");
        card29.setBounds(20, 3529, 350, 460);
        add(card29);

        JPanel card30 = createCard("src/resources/card_images/tea.jpg", "Tea", "₹ 40", "5% OFF", "3.9 ★", "Purchase");
        card30.setBounds(394, 3529, 350, 460);
        add(card30);

        JPanel card31 = createCard("src/resources/card_images/pepsi.jpg", "Pepsi", "₹ 35", "5% OFF", "3.8 ★", "Purchase");
        card31.setBounds(770, 3529, 350, 460);
        add(card31);

        JPanel card32 = createCard("src/resources/card_images/fanta.jpg", "Fanta", "₹ 40", "5% OFF", "3.9 ★", "Purchase");
        card32.setBounds(1144, 3529, 350, 460);
        add(card32);


        // Set the preferred size of the Home panel
        setPreferredSize(new Dimension(1500, 4070)); // Width should accommodate all cards
    }

    private JPanel createCard(String imagePath,String foodnametext,String pricetext,String discounttext,String ratingtext,String purchasetext)
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

        Font f1 = new Font("Arial Black", Font.BOLD, 30);
        Font f2 = new Font("adamina", Font.BOLD, 25);
        Font f3 = new Font("adamina", Font.BOLD, 20);
        Font f4 = new Font("SansSerif", Font.BOLD, 15);
        Font f5 = new Font("Arial Black", Font.BOLD, 20);

        // Load and add an image to the card
        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon(imagePath); // Use provided image path
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(344, 246, Image.SCALE_SMOOTH); // Resize image slightly smaller
        imageLabel.setIcon(new ImageIcon(scaledImg));

        // Set padding (2 pixels on all sides) between image and card border
        imageLabel.setBounds(3, 3, 344, 246); // Adjust image bounds
        card.add(imageLabel);

        // Add food name
        foodname = new JLabel(foodnametext, JLabel.CENTER);
        foodname.setFont(f1);
        foodname.setForeground(Color.black);
        foodname.setBounds(-25, 280, 400, 40);  // Adjust position
        card.add(foodname);

        // Add discount
        discount = new JLabel(discounttext, JLabel.CENTER);
        discount.setFont(f2);
        discount.setForeground(Color.red);
        discount.setBounds(-10, 335, 250, 35);  // Adjust position
        card.add(discount);

        // Add price in Marathi
        price = new JLabel(pricetext, JLabel.CENTER);
        price.setFont(f3);
        price.setForeground(Color.darkGray); // Green color for price
        price.setBounds(230, 335, 100, 35);  // Adjust position
        card.add(price);

        // Add rating button
        rating = new JButton(ratingtext);
        rating.setBounds(270, 250, 75, 25);   // Adjust position
        rating.setFont(f4);
        rating.setBackground(Color.green);
        card.add(rating);

        // Add purchase button (you can customize the RoundedButton for this)
        purchase = new RoundedButton_Blue(purchasetext,20);
        purchase.setBounds(25, 400, 300, 45);  // Adjust position
        purchase.setFont(f5);
        card.add(purchase);

        return card;
    }


    public static void main(String args[])
    {
        JFrame frame = new JFrame("Fast Food Delivery");
        Home homePanel = new Home();
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
