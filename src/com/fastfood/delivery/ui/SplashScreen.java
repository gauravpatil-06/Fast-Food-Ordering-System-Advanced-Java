package com.fastfood.delivery.ui;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;

class SplashScreen extends JFrame
{
    JLabel L1, L2;

    SplashScreen()
    {
        Container c = getContentPane();
        c.setLayout(null);

        Font f1 = new Font("Britannic Bold", Font.BOLD, 45);
        Font f2 = new Font("Cambria", Font.BOLD, 20);

        // Background image
        ImageIcon icon = new ImageIcon("src/resources/bg_splash.jpeg");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Image img = icon.getImage();
        // Scale the image to fit the full screen
        Image scaledImg = img.getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(scaledImg));
        background.setSize(screenSize.width, screenSize.height);
        c.add(background);

        // Logo image
        ImageIcon imageIcon = new ImageIcon("src/resources/logo_splash.png");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);  // Add the logo to the label

        //Title
        L1 = new JLabel("Fast Food Delivery");
        L1.setFont(f1);
        L1.setForeground(new Color(220, 60, 0));  // Set title text color

        //Slogan
        L2 = new JLabel("Food So Good, It's Worth the Wait... Not! Fresh, Hot, and Right Now!");
        L2.setFont(f2);
        L2.setForeground(Color.black);

        imageLabel.setBounds(500, 70, 500, 500);
        L1.setBounds(555, 500, 1000, 50);
        L2.setBounds(440, 580, 1500, 40);

        background.add(imageLabel);
        background.add(L1);
        background.add(L2);

        // Timer to display splash screen for 3 seconds, then open the login page
        new Timer().schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                dispose();  // Close splash screen
                new LoginPage().setVisible(true);  // Open login page after splash screen
            }
        }, 3000);  // 3-second delay
    }

    public static void main(String args[])
    {
        SplashScreen f1 = new SplashScreen();
        f1.setVisible(true);
        f1.setTitle("Fast Food Delivery");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the splash screen size to match full screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f1.setSize(screenSize.width, screenSize.height);
    }
}
