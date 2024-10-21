package com.fastfood.delivery.ui;

import com.fastfood.delivery.model.RoundedButton;
import com.fastfood.delivery.model.RoundedTextArea;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class ContactUs extends JPanel
{
    JLabel L1, L2, L3, L4, L5, L6, L7, L8;
    RoundedTextArea jta;
    RoundedButton b1;

    public ContactUs()
    {
        setLayout(null);
        setBackground(new Color(255, 250, 205)); // Faint Lemon Yellow

        Font f1 = new Font("Arial Black", Font.BOLD, 45);
        Font f2 = new Font("Arial Black", Font.BOLD, 30);
        Font f3 = new Font("adamina", Font.BOLD, 25);
        Font f4 = new Font("Arial Black", Font.BOLD, 25);

        // Title
        L1 = new JLabel("Contact Us", JLabel.CENTER);
        L1.setFont(f1);
        L1.setForeground(Color.blue);

        L2 = new JLabel("Write to Us", JLabel.CENTER);
        L2.setFont(f2);
        L2.setForeground(Color.black);

        RoundedTextArea jta = new RoundedTextArea("We value your feedback! Let us know how your delivery experience was, and our team will assist you shortly", 30);
        jta.setFont(f3);

        jta.setForeground(Color.darkGray);

        jta.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (jta.getText().equals("We value your feedback! Let us know how your delivery experience was, and our team will assist you shortly"))
                {
                    jta.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e)
            {
                if (jta.getText().trim().isEmpty())
                {
                    jta.setText("We value your feedback! Let us know how your delivery experience was, and our team will assist you shortly");
                }
            }
        });

        Border jta_round = BorderFactory.createLineBorder(Color.blue, 2);
        jta.setBorder(BorderFactory.createCompoundBorder(jta_round, BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        b1 = new RoundedButton("Send", 30);
        b1.setFont(f4);
        b1.setForeground(Color.white);
        b1.setBackground(Color.blue);

        L3 = new JLabel("Call Us", JLabel.CENTER);
        L3.setFont(f2);
        L3.setForeground(Color.black);

        ImageIcon mobile_no = new ImageIcon("src/resources/logo_phone.png");
        JLabel imageLabel_mobile_no = new JLabel(new ImageIcon(mobile_no.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

        L4 = new JLabel("Mobile Number:", JLabel.CENTER);
        L4.setFont(f3);
        L4.setForeground(Color.black);

        L5 = new JLabel("<html><a href=''>7875335539</a></html>", JLabel.CENTER);
        L5.setFont(f3);
        L5.setForeground(Color.blue);
        L5.setCursor(new Cursor(Cursor.HAND_CURSOR));

        L6 = new JLabel("Mail Us", JLabel.CENTER);
        L6.setFont(f2);
        L6.setForeground(Color.black);

        ImageIcon email = new ImageIcon("src/resources/logo_email.png");
        JLabel imageLabel_email = new JLabel(new ImageIcon(email.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

        L7 = new JLabel("Email:", JLabel.CENTER);
        L7.setFont(f3);
        L7.setForeground(Color.black);

        L8 = new JLabel("<html><a href=''>gp949958@gmail.com</a></html>", JLabel.CENTER);
        L8.setFont(f3);
        L8.setForeground(Color.blue);
        L8.setCursor(new Cursor(Cursor.HAND_CURSOR));

        L1.setBounds(500, 30, 500, 50);
        L2.setBounds(200, 120, 400, 40);
        jta.setBounds(310, 180, 900, 120);
        b1.setBounds(600, 330, 300, 50);
        L3.setBounds(170, 430, 400, 40);
        imageLabel_mobile_no.setBounds(310, 500, 40, 40);
        L4.setBounds(370, 500, 200, 40);
        L5.setBounds(550, 500, 200, 40);
        L6.setBounds(175, 580, 400, 40);
        imageLabel_email.setBounds(310, 650, 40, 40);
        L7.setBounds(310, 650, 200, 40);
        L8.setBounds(450, 650, 300, 40);

        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String textarea = jta.getText();

                if (textarea.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Feedback cannot be Empty", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(ContactUs.this, "Feedback sent successfully!!!");
                }
            }
        });

        L5.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                try
                {
                    if (Desktop.isDesktopSupported())
                    {
                        Desktop.getDesktop().browse(new URI("tel:7875335539"));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(ContactUs.this, "Phone call feature is not supported on this system.");
                    }
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(ContactUs.this, "Error: " + ex.getMessage());
                }
            }
        });

        L8.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                try
                {
                    if (Desktop.isDesktopSupported())
                    {
                        Desktop.getDesktop().mail(new URI("mailto:gp949958@gmail.com"));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(ContactUs.this, "Mail client is not supported on this system.");
                    }
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(ContactUs.this, "Error: " + ex.getMessage());
                }
            }
        });

        add(L1);
        add(L2);
        add(jta);
        add(b1);
        add(imageLabel_mobile_no);
        add(L3);
        add(L4);
        add(L5);
        add(imageLabel_email);
        add(L6);
        add(L7);
        add(L8);
    }
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Fast Food Delivery");
        ContactUs contactUs = new ContactUs();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(contactUs);
        frame.setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
    }
}
