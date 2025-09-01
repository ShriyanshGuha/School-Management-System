package SMS;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminHomePage extends JFrame implements ActionListener{
  private JMenuItem addTeacherDetailsItem;
    private JMenuItem updateTeacherDetailsItem;
    private JMenuItem viewTeacherProfileItem;
    private JMenuItem addStudentDetailsItem;
    private JMenuItem updateStudentDetailsItem;
    private JMenuItem viewStudentProfileItem;
    private JMenuItem addNewClassItem;
    private JMenuItem updateClassDetailsItem;
    private JMenuItem logoutItem;
  
  public AdminHomePage() {
    setTitle("Admin Home Page");
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(true);
    // ---------- Small Menu Bar ----------
        JMenuBar smallMenuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu reportsMenu = new JMenu("Reports");
        JMenu helpMenu = new JMenu("Help");
        smallMenuBar.add(fileMenu);
        smallMenuBar.add(reportsMenu);
        smallMenuBar.add(helpMenu);
        setJMenuBar(smallMenuBar);

        // ---------- Main Content Panel ----------
        JPanel contentPanel = new JPanel(new BorderLayout());
        setContentPane(contentPanel);

        // ---------- Top Panel for Title ----------
        JPanel topPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(136, 39, 1)); // Set background color to (136, 39, 1)
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        topPanel.setOpaque(false);
        JLabel titleLabel = new JLabel("Little Wonders Convent School", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 40));
        titleLabel.setForeground(Color.WHITE); // Set title color to white
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // ---------- Layered Pane for Overlapping ----------
        JLayeredPane layeredPane = new JLayeredPane();

        // ---------- Background Image Panel ----------
        ImageIcon bgIcon = new ImageIcon("C:\\Users\\shriy\\OneDrive\\Desktop\\JavaProjects\\SchoolManagementSystem\\src\\icons\\School.jpg");
        Image img = bgIcon.getImage();

        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        imagePanel.setOpaque(true);

        // ---------- Big Menu Bar (Centered & Transparent) ----------
        JMenuBar bigMenuBar = new JMenuBar();
        bigMenuBar.setOpaque(false); // Make menu bar transparent
        bigMenuBar.setBackground(new Color(0, 0, 0, 0)); // Fully transparent background
        String[] menus = {"Teacher Profile", "Student Profile", "Class Details", "Logout"};
        for (String name : menus) {
            JMenu menu = new JMenu(name);
            menu.setFont(new Font("SansSerif", Font.BOLD, 18));
            menu.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
            menu.setOpaque(false); // Make menu transparent
            menu.setBackground(new Color(0, 0, 0, 0));
            bigMenuBar.add(menu);

            if (name.equals("Teacher Profile")) {
                addTeacherDetailsItem = new JMenuItem("Add Teacher Details");
                addTeacherDetailsItem.addActionListener(this);
                menu.add(addTeacherDetailsItem);

                updateTeacherDetailsItem = new JMenuItem("Update Teacher Details");
                updateTeacherDetailsItem.addActionListener(this);
                menu.add(updateTeacherDetailsItem);

                viewTeacherProfileItem = new JMenuItem("View Teacher Profile");
                viewTeacherProfileItem.addActionListener(this);
                menu.add(viewTeacherProfileItem);

            } else if (name.equals("Student Profile")) {
                addStudentDetailsItem = new JMenuItem("Add Student Details");
                addStudentDetailsItem.addActionListener(this);
                menu.add(addStudentDetailsItem);

                updateStudentDetailsItem = new JMenuItem("Update Student Details");
                updateStudentDetailsItem.addActionListener(this);
                menu.add(updateStudentDetailsItem);

                viewStudentProfileItem = new JMenuItem("View Student Profile");
                viewStudentProfileItem.addActionListener(this);
                menu.add(viewStudentProfileItem);

            } else if (name.equals("Class Details")) {
                addNewClassItem = new JMenuItem("Add New Class");
                addNewClassItem.addActionListener(this);
                menu.add(addNewClassItem);

                updateClassDetailsItem = new JMenuItem("Update Class Details");
                updateClassDetailsItem.addActionListener(this);
                menu.add(updateClassDetailsItem);

            } else if (name.equals("Logout")) {
                // No submenu, just add action listener to the menu itself
                menu.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        dispose();
                        new Login();
                    }
                });
            }
        }
        JPanel bigMenuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 5));
        bigMenuPanel.setOpaque(false); // Make panel transparent
        bigMenuPanel.add(bigMenuBar);

        // ---------- Add to LayeredPane ----------
        layeredPane.add(imagePanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(bigMenuPanel, JLayeredPane.PALETTE_LAYER);

        // ---------- Resize Components on LayeredPane Resize ----------
        layeredPane.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                int w = layeredPane.getWidth();
                int h = layeredPane.getHeight();
                int menuBarHeight = bigMenuPanel.getPreferredSize().height;
                imagePanel.setBounds(0, 0, w, h);
                bigMenuPanel.setBounds(0, 0, w, menuBarHeight);
            }
        });

        // ---------- Add Panels to Content Panel ----------
        contentPanel.add(topPanel, BorderLayout.NORTH);
        contentPanel.add(layeredPane, BorderLayout.CENTER);

        // ---------- Initial Sizing ----------
        SwingUtilities.invokeLater(() -> {
            layeredPane.setPreferredSize(new Dimension(800, 600));
            layeredPane.setSize(contentPanel.getSize());
            layeredPane.revalidate();
        });
    setVisible(true);
  }
  @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addTeacherDetailsItem) {
            new Teacher_Details();
        } else if (e.getSource() == updateTeacherDetailsItem) {
            new UpdateTeacher_Details();
        } else if (e.getSource() == viewTeacherProfileItem) {
            new ViewTeacher_Profile();
        } else if (e.getSource() == addStudentDetailsItem) {
            new AddStudent_Details();
        } else if (e.getSource() == updateStudentDetailsItem) {
            new UpdateStudent_Details();
        } else if (e.getSource() == viewStudentProfileItem) {
            new ViewStudent_Profile();
        } else if (e.getSource() == addNewClassItem) {
            new AddNew_Class();
        } else if (e.getSource() == updateClassDetailsItem) {
            new UpdateClass_Details();
        } else if (e.getSource() == logoutItem) {
            // Example: Close the current window or perform logout logic
            dispose();
        }
    }
public static void main(String[] args) {
        new AdminHomePage();
    }
}
