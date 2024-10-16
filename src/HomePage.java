import javax.swing.*;
import java.awt.*;
import com.fastfood.delivery.ui.Home;
import com.fastfood.delivery.ui.OrderHistory;
import com.fastfood.delivery.ui.MyProfile;
import com.fastfood.delivery.ui.AboutUs;
import com.fastfood.delivery.ui.ContactUs;

public class HomePage extends JFrame
{
    HomePage()
    {
        Container c = getContentPane();

        Font f1 = new Font("Arial Black", Font.BOLD, 20);

        JTabbedPane jtp = new JTabbedPane();
        jtp.setFont(f1);

        Home home = new Home();
        OrderHistory orderHistory = new OrderHistory();
        MyProfile myProfile = new MyProfile("Gaurav Patil", "7875335539", "gp949958@gmail.com", "Gaurav123@#$", "Gaurav123@#$");
        AboutUs aboutUs = new AboutUs();
        ContactUs contactUs = new ContactUs();

        // Create a scroll pane for the AboutUs panel
        JScrollPane scrollPane = new JScrollPane(aboutUs);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Smooth scrolling

        // Add tabs to the tabbed pane
        jtp.addTab("Home", home);
        jtp.addTab("Order History", orderHistory);
        jtp.addTab("My Profile", myProfile);
        jtp.addTab("About Us", scrollPane);  // Add scroll pane for About Us
        jtp.addTab("Contact Us", contactUs);

        // Set background colors for each tab
        jtp.setBackgroundAt(0, new Color(255, 224, 178)); // Faint Light Orange
        jtp.setForegroundAt(0, Color.black);

        jtp.setBackgroundAt(1, new Color(255, 228, 225)); // Faint Blush Pink
        jtp.setForegroundAt(1, Color.black);

        jtp.setBackgroundAt(2, new Color(224, 255, 255)); // Faint Light Cyan
        jtp.setForegroundAt(2, Color.black);

        jtp.setBackgroundAt(3, new Color(220, 220, 220)); // Faint Grey
        jtp.setForegroundAt(3, Color.black);

        jtp.setBackgroundAt(4, new Color(255, 250, 205)); // Faint Lemon Yellow
        jtp.setForegroundAt(4, Color.black);

        // Set the Home tab as the default selected tab
        jtp.setSelectedIndex(0);

        // Add the tabbed pane to the container
        c.add(jtp);

        setTitle("Fast Food Delivery");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
    }

    public static void main(String args[])
    {
        HomePage f1 = new HomePage();
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
