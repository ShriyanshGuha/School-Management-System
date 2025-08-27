package SMS;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
public class Login extends JFrame implements ActionListener
{
    JFrame f;
    JLabel l1, l2,l3,l4,l5;
    Choice ch1;
    TextField tf1;
    JPasswordField pf1;
    JButton bt1,bt2;
    Login()
    {
        try
        {
        f = new JFrame("Login School Account");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l1 = new JLabel();
        l1.setBounds(0,0,750,450);
        l1.setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/pencils.jpg"));
        Image i1 = img.getImage().getScaledInstance(750,450,Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);
        
        l2 = new JLabel("Login School Account");
        l2.setBounds(300,132,500,50);
        l2.setFont(new Font("Arial", Font.BOLD,30));
        l2.setForeground(Color.BLUE);
        l1.add(l2);
        f.add(l1);
        
        l3 = new JLabel("Account :");
        l3.setBounds(280,200,150,30);
        l3.setFont(new Font("Arial", Font.BOLD,20));
        l3.setForeground(Color.BLACK);
        l1.add(l3);
        
        ch1 = new Choice();
        ch1.add("Admin");
        ch1.add("Faculty");
        ch1.add("User");
        ch1.setBounds(450,200,170,30);
        ch1.setFont(new Font("Arial", Font.PLAIN,20));
        l1.add(ch1);
        
        
        
        l4 = new JLabel("Username :");
        l4.setBounds(280,245,150,30);
        l4.setFont(new Font("Arial", Font.BOLD,20));
        l4.setForeground(Color.BLACK);
        l1.add(l4);

        tf1 = new TextField();
        tf1.setFont(new Font("Arial", Font.PLAIN,20));
        tf1.setBounds(450,245,170,30);
        l1.add(tf1);
        
        l5 = new JLabel("Password :");
        l5.setBounds(280,290,150,30);
        l5.setFont(new Font("Arial", Font.BOLD,20));
        l5.setForeground(Color.BLACK);
        l1.add(l5);
        
        pf1 = new JPasswordField();
        pf1.setBounds(450,290,170,30);
        pf1.setFont(new Font("Arial", Font.PLAIN,20));
        l1.add(pf1);
        
        
        bt1 = new JButton("Login");
        bt2 = new JButton("Back");
        bt1.setFont(new Font("Arial", Font.PLAIN,20));
        bt2.setFont(new Font("Arial", Font.PLAIN,20));
        bt1.setBounds(300,340,120,40);
        bt2.setBounds(470,340,120,40);
        bt1.setBackground(new Color(83,253,236));
        bt2.setBackground(Color.lightGray);
        bt1.setForeground(Color.WHITE);
        bt1.setForeground(Color.BLACK);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        l1.add(bt1);
        l1.add(bt2);
        f.setVisible(true);
        f.setSize(750,460);
        f.setLocation(300,100);
        
        
        
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Login();
        /*System.out.println("Headless: " + java.awt.GraphicsEnvironment.isHeadless());
        javax.swing.JOptionPane.showMessageDialog(null, "Hello, Swing!");*/
    }
    public void actionPerformed(ActionEvent e)
    {
       if(e.getSource()==bt1)
       {
           try
           {
               ConnectionClass obj = new ConnectionClass();
               String username = tf1.getText();
               String password = new String(pf1.getPassword());
               String account = ch1.getSelectedItem();
               
               String q = "select * from admin where username='"+username+"' and password='"+password+"';";
               ResultSet rs =obj.st.executeQuery(q);
               if(rs.next())
               {
                   new AdminHomePage().setVisible(true);
                   System.out.println("Login Successful");
                   JOptionPane.showMessageDialog(null,"Login Successful\nWelcome "+username);
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "You have entered wrong username and password");
                   f.setVisible(false);
                   f.setVisible(true);
               }
               
           }
           catch(Exception ex)
           {
               ex.printStackTrace();
           }
       }
       if(e.getSource()== bt2)
       {
           f.setVisible(false);
       }
    }
}