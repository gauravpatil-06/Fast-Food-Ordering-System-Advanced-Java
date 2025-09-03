package com.fastfood.delivery.ui;

import com.fastfood.delivery.model.RoundedButton;
import com.fastfood.delivery.model.RoundedTextField_Black;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class OrderDetailsPage extends JFrame
{
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USER = "system";
    private static final String DB_PASSWORD = "gaurav";

    JLabel title, full_name, phone_no, email_id, address, food_Item, price, quantity, payment_method, delivery_time;
    RoundedTextField_Black nameField, phoneField, emailField, addressField,foodItemField,priceField,
            quantityField, paymentMethodField, deliveryTimeField;
    RoundedButton confirm_order, clear;

    OrderDetailsPage(String foodnametext, String pricetext)
    {
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(255, 250, 205)); // Faint Lemon Yellow

        Font f1 = new Font("Arial Black", Font.BOLD, 45);
        Font f2 = new Font("adamina", Font.BOLD, 25);
        Font f3 = new Font("Arial Black", Font.BOLD, 25);

        // Title
        title = new JLabel("Order Details", JLabel.CENTER);
        title.setFont(f1);
        title.setForeground(Color.blue);

        // Full Name
        ImageIcon name = new ImageIcon("src/resources/logo_name.png");
        JLabel imageLabel_name = new JLabel(new ImageIcon(name.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        full_name = new JLabel("Full Name:", JLabel.CENTER);
        full_name.setFont(f2);
        full_name.setForeground(Color.black);
        nameField = new RoundedTextField_Black(16);
        nameField.setFont(f2);
        Border name_round = BorderFactory.createLineBorder(Color.black, 1);
        nameField.setBorder(BorderFactory.createCompoundBorder(name_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        // Mobile Number
        ImageIcon mobileno = new ImageIcon("src/resources/logo_phone.png");
        JLabel imageLabel_mobile_no = new JLabel(new ImageIcon(mobileno.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        phone_no = new JLabel("Mobile No:", JLabel.CENTER);
        phone_no.setFont(f2);
        phone_no.setForeground(Color.black);
        phoneField = new RoundedTextField_Black(16);
        phoneField.setFont(f2);
        Border mobileno_round = BorderFactory.createLineBorder(Color.black, 1);
        phoneField.setBorder(BorderFactory.createCompoundBorder(mobileno_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        // Email ID
        ImageIcon email= new ImageIcon("src/resources/logo_email.png");
        JLabel imageLabel_email_id = new JLabel(new ImageIcon(email.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        email_id = new JLabel("Email ID:", JLabel.CENTER);
        email_id.setFont(f2);
        email_id.setForeground(Color.black);
        emailField = new RoundedTextField_Black(16);
        emailField.setFont(f2);
        Border email_round = BorderFactory.createLineBorder(Color.black, 1);
        emailField.setBorder(BorderFactory.createCompoundBorder(email_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        // Address
        ImageIcon address_delivery = new ImageIcon("src/resources/logo_address.png");
        JLabel imageLabel_address = new JLabel(new ImageIcon(address_delivery.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        address = new JLabel("Delivery Address:", JLabel.CENTER);
        address.setFont(f2);
        address.setForeground(Color.black);
        addressField = new RoundedTextField_Black(16);
        addressField.setFont(f2);
        Border address_delivery_round = BorderFactory.createLineBorder(Color.black, 1);
        addressField.setBorder(BorderFactory.createCompoundBorder(address_delivery_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        // Food Item Name
        ImageIcon foodItem = new ImageIcon("src/resources/logo_food_name.png");
        JLabel imageLabel_foodItem = new JLabel(new ImageIcon(foodItem.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
        food_Item = new JLabel("Food Item Name:", JLabel.CENTER);
        food_Item.setFont(f2);
        food_Item.setForeground(Color.black);
        foodItemField = new RoundedTextField_Black(16);
        foodItemField.setFont(f2);
        foodItemField.setText(foodnametext);
        Border foodItem_round = BorderFactory.createLineBorder(Color.black, 1);
        foodItemField.setBorder(BorderFactory.createCompoundBorder(foodItem_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        // Price
        ImageIcon food_price = new ImageIcon("src/resources/logo_price.png");
        JLabel imageLabel_food_price = new JLabel(new ImageIcon(food_price.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        price = new JLabel("Price (Per Item):", JLabel.CENTER);
        price.setFont(f2);
        price.setForeground(Color.black);
        priceField = new RoundedTextField_Black(16);
        priceField.setFont(f2);
        priceField.setText(pricetext);

        Border food_price_round = BorderFactory.createLineBorder(Color.black, 1);
        priceField.setBorder(BorderFactory.createCompoundBorder(food_price_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        // Quantity
        ImageIcon food_quantity = new ImageIcon("src/resources/logo_quantity.jpg");
        JLabel imageLabel_food_quantity = new JLabel(new ImageIcon(food_quantity.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        quantity = new JLabel("Quantity:", JLabel.CENTER);
        quantity.setFont(f2);
        quantity.setForeground(Color.black);
        quantityField = new RoundedTextField_Black(16);
        quantityField.setFont(f2);
        Border food_quantity_round = BorderFactory.createLineBorder(Color.black, 1);
        quantityField.setBorder(BorderFactory.createCompoundBorder(food_quantity_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        // Payment Method
        ImageIcon paymentmethod= new ImageIcon("src/resources/logo_payment.png");
        JLabel imageLabel_paymentmethod = new JLabel(new ImageIcon(paymentmethod.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        payment_method = new JLabel("Payment Method:", JLabel.CENTER);
        payment_method.setFont(f2);
        payment_method.setForeground(Color.black);
        paymentMethodField = new RoundedTextField_Black(16);
        paymentMethodField.setFont(f2);
        Border paymentmethod_round = BorderFactory.createLineBorder(Color.black, 1);
        paymentMethodField.setBorder(BorderFactory.createCompoundBorder(paymentmethod_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        // Delivery Time
        ImageIcon deliverytime = new ImageIcon("src/resources/logo_time.png");
        JLabel imageLabel_deliverytime = new JLabel(new ImageIcon(deliverytime.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
        delivery_time = new JLabel("Delivery Time:", JLabel.CENTER);
        delivery_time.setFont(f2);
        delivery_time.setForeground(Color.black);
        deliveryTimeField = new RoundedTextField_Black(16);
        deliveryTimeField.setFont(f2);
        Border deliverytime_round = BorderFactory.createLineBorder(Color.black, 1);
        deliveryTimeField.setBorder(BorderFactory.createCompoundBorder(deliverytime_round, BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        // Buttons
        confirm_order = new RoundedButton("Confirm Order", 20);
        confirm_order.setForeground(Color.WHITE);
        confirm_order.setFont(f3);
        confirm_order.setBackground(Color.BLUE);

        clear = new RoundedButton("Clear", 20);
        clear.setForeground(Color.WHITE);
        clear.setFont(f3);
        clear.setBackground(Color.RED);

        // Set bounds for components
        title.setBounds(500, 70, 500, 60);

        imageLabel_name.setBounds(90, 220, 40, 40);
        full_name.setBounds(100, 220, 300, 40);
        nameField.setBounds(380, 220, 330, 40);

        imageLabel_mobile_no.setBounds(90, 300, 40, 40);
        phone_no.setBounds(100, 300, 300, 40);
        phoneField.setBounds(380, 300, 330, 40);

        imageLabel_email_id.setBounds(90, 380, 40, 40);
        email_id.setBounds(100, 380, 300, 40);
        emailField.setBounds(380, 380, 330, 40);

        imageLabel_address.setBounds(85, 460, 50, 50);
        address.setBounds(100, 460, 300, 40);
        addressField.setBounds(380, 460, 330, 40);

        imageLabel_foodItem.setBounds(85, 540, 45, 45);
        food_Item.setBounds(100, 540, 300, 40);
        foodItemField.setBounds(380, 540, 330, 40);

        imageLabel_food_price.setBounds(795, 220, 50, 50);
        price.setBounds(820, 220, 300, 40);
        priceField.setBounds(1100, 220, 330, 40);

        imageLabel_food_quantity.setBounds(795, 300, 50, 50);
        quantity.setBounds(810, 300, 300, 40);
        quantityField.setBounds(1100, 300, 330, 40);

        imageLabel_paymentmethod.setBounds(800, 380, 40, 40);
        payment_method.setBounds(820, 380, 300, 40);
        paymentMethodField.setBounds(1100, 380, 330, 40);

        imageLabel_deliverytime.setBounds(800, 460, 45, 45);
        delivery_time.setBounds(820, 460, 300, 40);
        deliveryTimeField.setBounds(1100, 460, 330, 40);

        confirm_order.setBounds(450, 650, 300, 50);
        clear.setBounds(800, 650, 300, 50);

        confirm_order.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // Check if all fields are filled
                if (nameField.getText().isEmpty() || phoneField.getText().isEmpty() ||
                        emailField.getText().isEmpty() || addressField.getText().isEmpty() ||
                        foodItemField.getText().isEmpty() || priceField.getText().isEmpty() ||
                        quantityField.getText().isEmpty() || paymentMethodField.getText().isEmpty() ||
                        deliveryTimeField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "All fields must be filled!", "Validation Error", JOptionPane.WARNING_MESSAGE);
                }
                else if (Integer.parseInt(quantityField.getText()) <= 0 || quantityField.getText().toString().length() > 100)
                {
                    JOptionPane.showMessageDialog(null, "Invalid Quantity!", "Validation Error", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    // Insert order data into the database
                    insertOrderData(nameField.getText(), phoneField.getText(), emailField.getText(), addressField.getText(),
                            foodItemField.getText(), priceField.getText(), Integer.parseInt(quantityField.getText()),
                            paymentMethodField.getText(), deliveryTimeField.getText());
                }
            }
        });

        clear.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                nameField.setText("");
                phoneField.setText("");
                emailField.setText("");
                addressField.setText("");
                foodItemField.setText("");
                priceField.setText("");
                quantityField.setText("");
                paymentMethodField.setText("");
                deliveryTimeField.setText("");
            }
        });

        c.add(title);
        c.add(imageLabel_name);          c.add(full_name);       c.add(nameField);
        c.add(imageLabel_mobile_no);     c.add(phone_no);        c.add(phoneField);
        c.add(imageLabel_email_id);      c.add(email_id);        c.add(emailField);
        c.add(imageLabel_address);       c.add(address);         c.add(addressField);
        c.add(imageLabel_foodItem);      c.add(food_Item );      c.add(foodItemField);
        c.add(imageLabel_food_price);    c.add(price);           c.add(priceField);
        c.add(imageLabel_food_quantity); c.add(quantity);        c.add(quantityField);
        c.add(imageLabel_paymentmethod); c.add(payment_method ); c.add(paymentMethodField);
        c.add(imageLabel_deliverytime);  c.add(delivery_time);   c.add(deliveryTimeField);
        c.add(confirm_order);            c.add(clear);

        // Frame settings
        setTitle("Fast Food Delivery");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
    }

    private void insertOrderData(String fullName, String phoneNumber, String email, String address, String foodItem,
                                 String price, int quantity, String paymentMethod, String deliveryTime)
    {
        // Check if the price starts with "₹" and contains only digits after that
        if (!isValidPrice(price))
        {
            JOptionPane.showMessageDialog(null, "Invalid price format. Please enter a valid price starting with '₹'.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return; // Exit the method if the price format is invalid
        }

        // Strip the "₹" symbol to parse the numeric value
        String cleanedPrice = price.substring(1).trim(); // Remove "₹" from the start

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD))
        {
            String sql = "INSERT INTO Orders (full_name, phone_number, email, address, food_item, price, quantity, payment_method, delivery_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql))
            {
                pstmt.setString(1, fullName);
                pstmt.setString(2, phoneNumber);
                pstmt.setString(3, email);
                pstmt.setString(4, address);
                pstmt.setString(5, foodItem);
                pstmt.setDouble(6, Double.parseDouble(cleanedPrice)); // Use cleaned price
                pstmt.setInt(7, quantity);
                pstmt.setString(8, paymentMethod);
                pstmt.setString(9, deliveryTime);

                // Execute the update
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Order Confirmed successfully!!!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid number format for price or quantity.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Method to validate the price input
    private boolean isValidPrice(String price)
    {
        // Check if the price starts with "₹" and is followed by digits (allowing for decimals)
        return price.matches("^₹ \\d+(\\.\\d+)?$");
    }
    public static void main(String[] args)
    {
        OrderDetailsPage f1 = new OrderDetailsPage("Pizza", "₹ 200");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
    }
}
