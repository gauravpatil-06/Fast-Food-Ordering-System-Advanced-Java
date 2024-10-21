package com.fastfood.delivery.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class AboutUs extends JPanel
{
    JLabel L1, L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,L13,L14;
    public AboutUs()
    {
        setLayout(null);
        setBackground(new Color(220, 220, 220)); // Faint Grey

        Font f1 = new Font("Arial Black", Font.BOLD, 45);
        Font f2 = new Font("Adamina", Font.BOLD, 20);
        Font f3 = new Font("Arial Black", Font.PLAIN, 25);

        // Title
        L1 = new JLabel("About Us", JLabel.CENTER);
        L1.setFont(f1);
        L1.setForeground(Color.blue);

        // Introduction
        L2 = new JLabel("<html><div style='text-align: left;'>"
                + "Fast Bites is a fast food delivery service dedicated to delivering fresh, hot meals "
                + "right to your door with the click of a button. Our mission is to make it easy for "
                + "people to enjoy their favorite food from local restaurants without leaving their homes."
                + "</div></html>");
        L2.setFont(f2);
        L2.setForeground(Color.darkGray);

        // Features Title
        L3 = new JLabel("Features", JLabel.CENTER);
        L3.setFont(f3);
        L3.setForeground(Color.black);

        // Features Content
        L4= new JLabel("<html><ul>"
                + "<li>Fast delivery time</li>"
                + "<li>Wide range of restaurants</li>"
                + "<li>Easy-to-use ordering system</li>"
                + "<li>Secure payment methods</li>"
                + "</ul></html>");
        L4.setFont(f2);
        L4.setForeground(Color.darkGray);

        // Vision & Mission section Title
        L5 = new JLabel("Our Vision & Mission", JLabel.CENTER);
        L5.setFont(f3);
        L5.setForeground(Color.black);

        // Vision & Mission section Content
        L6 = new JLabel("<html><div style='text-align: left;'>"
                + "Our vision is to make Fast Bites the go-to app for every meal, providing customers "
                + "with an unmatched selection of restaurants, secure payments, and quick deliveries. Our mission is to empower "
                + "local businesses while delivering happiness to customers through quality service."
                + "</div></html>");
        L6.setFont(f2);
        L6.setForeground(Color.darkGray);

        // Team Introduction Title
        L7 = new JLabel("Meet Our Team", JLabel.CENTER);
        L7.setFont(f3);
        L7.setForeground(Color.black);

        // Team Introduction Content
        L8 = new JLabel("<html><div style='text-align: left;'>"
                + "Our team is composed of experienced professionals who are passionate about "
                + "food, technology, and customer satisfaction. We strive to bring the best experience to your doorstep every day."
                + "</div></html>");
        L8.setFont(f2);
        L8.setForeground(Color.darkGray);

        // Technology & Partnerships Title
        L9 = new JLabel("Technology & Partnerships", JLabel.CENTER);
        L9.setFont(f3);
        L9.setForeground(Color.black);

        // Technology & Partnerships Content
        L10 = new JLabel("<html><div style='text-align: left;'>"
                + "Fast Bites utilizes state-of-the-art technology to ensure secure payments, "
                + "efficient restaurant connections, and a smooth user experience. We are proud to partner "
                + "with a variety of local and international restaurants to bring you the best food in your area."
                + "</div></html>");
        L10.setFont(f2);
        L10.setForeground(Color.darkGray);

        // Contact Title
        L11 = new JLabel("Contact Us", JLabel.LEFT);
        L11.setFont(f3);
        L11.setForeground(Color.black);

        // Contact Content
        L12 = new JLabel("<html><div style='text-align: left;'>"
                + "For inquiries, contact us at: <br>"
                + "Email: gp949958@gmail.com <br>"
                + "Mobile No: 7875335539"
                + "</div></html>");
        L12.setFont(f2);
        L12.setForeground(Color.darkGray);

        // Follow us on social media: Title
        L13 = new JLabel("Follow us on social media:", JLabel.LEFT);
        L13.setFont(f3);
        L13.setForeground(Color.black);

        // Follow us on social media: Content
        L14 = new JLabel("<html><div style='text-align: left;'>"
                + "<span style='color:blue;'>Facebook</span> | "
                + "<span style='color:blue;'>Instagram</span> | "
                + "<span style='color:blue;'>Twitter</span>"
                + "</div></html>");
        L14.setFont(f2);
        L14.setForeground(Color.darkGray);

        // Set bounds for the components
        L1.setBounds(500, 30, 500, 50);
        L2.setBounds(50, 100, 1460, 100);
        L3.setBounds(40, 200, 200, 50);
        L4.setBounds(30, 260, 500, 100);
        L5.setBounds(510, 390, 500, 50);
        L6.setBounds(50, 430, 1470, 100);
        L7.setBounds(510, 530, 500, 50);
        L8.setBounds(50, 570, 1470, 100);
        L9.setBounds(510, 670, 500, 50);
        L10.setBounds(50, 710, 1450, 100);
        L11.setBounds(60, 820, 200, 50);
        L12.setBounds(60, 870, 500, 100);
        L13.setBounds(60, 980, 400, 50);
        L14.setBounds(60, 1000, 500, 100);

        L14.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                try
                {
                    String[] options = {"Facebook", "Instagram", "Twitter"};
                    int choice = JOptionPane.showOptionDialog(null, "Which platform do you want to visit?",
                            "Open Social Media", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                    String url = null;
                    if (choice == 0)
                    {
                        url = "https://www.facebook.com";
                        L14.setBackground(Color.cyan);
                    }
                    else if (choice == 1)
                    {
                        url = "https://www.instagram.com";
                    }
                    else if (choice == 2)
                    {
                        url = "https://www.twitter.com";
                    }
                    if (url != null)
                    {
                        Desktop.getDesktop().browse(new URI(url));
                    }
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
          }

          @Override
          public void mouseEntered(MouseEvent e)
          {
              L14.setCursor(new Cursor(Cursor.HAND_CURSOR));
          }
        });

        // Add components to the panel
        add(L1);
        add(L2);
        add(L3);
        add(L4);
        add(L5);
        add(L6);
        add(L7);
        add(L8);
        add(L9);
        add(L10);
        add(L11);
        add(L12);
        add(L13);
        add(L14);

        // Set the preferred size of the panel (based on content height)
        setPreferredSize(new Dimension(1500, 1150));
    }
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Fast Food Delivery");
        AboutUs aboutUs = new AboutUs();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(aboutUs);
        frame.setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
    }
}
