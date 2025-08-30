package SMS;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminHomePage extends JFrame{
  public AdminHomePage() {
    setTitle("Admin Home Page");
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(true);
    setVisible(true);
  }
public static void main(String[] args) {
        new AdminHomePage();
    }
}
