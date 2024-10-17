package com.fastfood.delivery.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Home extends JPanel {
    private ArrayList<FoodItem> foodItems; // ArrayList to hold the food items

    public Home() {
        // Set layout and background
        setLayout(new GridLayout(4, 5, 10, 10)); // 4 rows, 5 columns, 10px gap
        setBackground(new Color(255, 224, 178)); // Faint Light Orange

        // Populate the food items
        foodItems = createFoodItems();

        // Add cards for each food item
        for (FoodItem item : foodItems) {
            add(createFoodCard(item));
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
    }

    // Method to create a food card
    private JPanel createFoodCard(FoodItem item) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS)); // Set vertical layout for the card
        card.setPreferredSize(new Dimension(500, 800)); // Set card size to 500x800
        card.setBackground(Color.WHITE);

        // Image (500x400)
        JLabel imageLabel = new JLabel();
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setPreferredSize(new Dimension(500, 400));

        // Load image from the path
        ImageIcon icon = new ImageIcon(item.getImagePath());
        Image image = icon.getImage(); // Transform to Image object
        Image scaledImage = image.getScaledInstance(500, 400, Image.SCALE_SMOOTH); // Resize the image to 500x400
        imageLabel.setIcon(new ImageIcon(scaledImage));

        card.add(imageLabel);

        // Food name
        JLabel foodNameLabel = new JLabel(item.getFoodName());
        foodNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        foodNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        foodNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        card.add(foodNameLabel);

        // Restaurant name
        JLabel restaurantLabel = new JLabel("Restaurant: " + item.getRestaurantName());
        restaurantLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        restaurantLabel.setHorizontalAlignment(SwingConstants.CENTER);
        card.add(restaurantLabel);

        // Price
        JLabel priceLabel = new JLabel("Price: $" + item.getPrice());
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        card.add(priceLabel);

        // Rating
        JLabel ratingLabel = new JLabel("Rating: " + item.getRating() + " ★");
        ratingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ratingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        card.add(ratingLabel);

        // Discount
        JLabel discountLabel = new JLabel(item.getDiscount() + "% off");
        discountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        discountLabel.setForeground(Color.RED);
        discountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        card.add(discountLabel);

        return card;
    }

    // Create a list of food items
    private ArrayList<FoodItem> createFoodItems() {
        ArrayList<FoodItem> items = new ArrayList<>();

        // Replace these with valid image paths or URLs
        String[] imagePaths = {
                "src/resources/bg_login_page.png", "src/resources/bg_login_page.png", "src/resources/bg_login_page.png",
                "src/resources/bg_login_page.png", "src/resources/bg_login_page.png", "src/resources/bg_login_page.png"
        };

        // Dummy data for the food items (20 items)
        for (int i = 1; i <= 20; i++) {
            items.add(new FoodItem(
                    "Food " + i,
                    "Restaurant " + i,
                    (i * 5), // Price
                    (i % 5) + 1, // Rating
                    (i % 2 == 0) ? 20 : 50, // Discount
                    imagePaths[i % imagePaths.length] // Cycle through image paths
            ));
        }

        return items;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fast Food Delivery - Home");
        Home homePanel = new Home();
        frame.add(homePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 800); // Set frame size
        frame.setVisible(true);
    }
}

// Class to represent a food item
class FoodItem {
    private String foodName;
    private String restaurantName;
    private int price;
    private int rating;
    private int discount;
    private String imagePath;

    public FoodItem(String foodName, String restaurantName, int price, int rating, int discount, String imagePath) {
        this.foodName = foodName;
        this.restaurantName = restaurantName;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
        this.imagePath = imagePath;
    }

    // Getters for the food item attributes
    public String getFoodName() { return foodName; }
    public String getRestaurantName() { return restaurantName; }
    public int getPrice() { return price; }
    public int getRating() { return rating; }
    public int getDiscount() { return discount; }
    public String getImagePath() { return imagePath; }
}
