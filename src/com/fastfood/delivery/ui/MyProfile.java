package com.fastfood.delivery.ui;

import javax.swing.*;
import java.awt.*;

public class MyProfile extends JPanel
{
    public MyProfile()
    {
        setLayout(null);
        setBackground(new Color(224, 255, 255));

        Font f1 = new Font("Arial Black", Font.BOLD, 45);
        Font f2 = new Font("Arial Black", Font.BOLD, 30);
        Font f3 = new Font("adamina", Font.BOLD, 25);
        Font f4 = new Font("Arial Black", Font.BOLD, 25);
    }
    public static void main(String args[])
    {
        JFrame f1 = new JFrame("Contact Us");
        MyProfile c1 = new MyProfile();
        f1.add(c1);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f1.setSize(screenSize.width, screenSize.height);
    }
}
