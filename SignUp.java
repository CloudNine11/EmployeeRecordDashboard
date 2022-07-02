
package registrationformproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.*;


public class SignUp extends JFrame implements ActionListener {
   
  JButton b, back;
  JTextField text, text1, text2, text3;
  Choice securityQ;

  SignUp() {
    setBounds(350, 200, 900, 360);
    getContentPane().setBackground(new Color(110, 160, 200));// awt package
    setLayout(null);

    JPanel p1 = new JPanel();
    p1.setBackground(new Color(133, 195, 250));
    p1.setBounds(0, 0, 500, 400);
    p1.setLayout(null);

    // username
    JLabel username = new JLabel(" Username ");
    username.setBounds(80, 20, 100, 25);
    username.setFont(new Font("Cambria", Font.BOLD, 18));
    p1.add(username);
    add(p1);

    text = new JTextField();
    text.setBounds(190, 20, 180, 25);
    text.setBorder(BorderFactory.createEmptyBorder());
    p1.add(text);

    // For name
    JLabel name = new JLabel(" Name ");
    name.setBounds(115, 60, 160, 25);
    name.setFont(new Font("Cambria", Font.BOLD, 18));
    p1.add(name);
    add(p1);

    text1 = new JTextField();
    text1.setBounds(190, 60, 180, 25);
    text1.setBorder(BorderFactory.createEmptyBorder());
    p1.add(text1);

    // password
    JLabel password = new JLabel(" Password");
    password.setBounds(80, 100, 160, 25);
    password.setFont(new Font("Cambria", Font.BOLD, 18));
    p1.add(password);
    add(p1);

    text2 = new JTextField();
    text2.setBounds(190, 100, 180, 25);
    text2.setBorder(BorderFactory.createEmptyBorder());
    p1.add(text2);

    // Security question
    JLabel security = new JLabel("Security Question ");
    security.setBounds(20, 140, 160, 25);
    security.setFont(new Font("Cambria", Font.BOLD, 18));
    p1.add(security);
    add(p1);
    // Dropdown
    securityQ = new Choice();
    securityQ.add("Favorite Color");
    securityQ.add("Favorite Bird");
    securityQ.add("Favorite Animal");
    securityQ.add("Favorite Number");
    securityQ.setBounds(190, 140, 180, 25);
    p1.add(securityQ);

    // Security answer
    JLabel sqanswer = new JLabel("Security Answer ");
    sqanswer.setBounds(30, 180, 160, 25);
    sqanswer.setFont(new Font("Cambria", Font.BOLD, 18));
    p1.add(sqanswer);
    add(p1);

    text3 = new JTextField();
    text3.setBounds(190, 180, 180, 25);
    text3.setBorder(BorderFactory.createEmptyBorder());
    p1.add(text3);

    // create button "create"
    b = new JButton("Create Account");
    b.setBounds(120, 240, 140, 30);
    b.setBackground(Color.WHITE);
    b.setForeground(new Color(100, 150, 180));
    b.addActionListener(this);
    p1.add(b);

    // Back button
    back = new JButton("Back ");
    back.setBounds(280, 240, 100, 30);
    back.setBackground(Color.WHITE);
    back.setForeground(new Color(100, 150, 180));// textWrite
    back.addActionListener(this);

    p1.add(back);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupimage.jpg"));
    Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel img = new JLabel(i3);
    img.setBounds(590, 60, 200, 200);
    add(img);

    setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == b) {
      String username = text.getText();
      String name = text1.getText();
      String password = text2.getText();
      String securityq = securityQ.getSelectedItem();
      String securityanswer = text3.getText();
      

      try {

          
           Class.forName("com.mysql.cj.jdbc.Driver");
          Connection  c = DriverManager.getConnection("jdbc:mysql:///mysql", "root",
                    "itstudent");
        PreparedStatement ps=c.prepareStatement("Insert into signup(username,name,password,securityq,securityanswer)values(?,?,?,?,?)");

                                    ps.setString(1,username);
                                    ps.setString(2,name);
                                    ps.setString(3,password);
                                    ps.setString(4,securityq);
                                    ps.setString(5,securityanswer);
                                    int roweffected =ps.executeUpdate();
                                        if(roweffected>0)
                                        {
                                             JOptionPane.showMessageDialog(null, "Account created successfully");
                                            System.out.println("Data succesfully inserted");

                                        }
        setVisible(false);
       new LogIn();
      } catch (Exception e) {
         
        e.printStackTrace();
      }
    } else if (ae.getSource() == back) {
      setVisible(false);
      new LogIn();

    }
  }

  public static void main(String[] args) throws SQLException {
    SignUp su = new SignUp();
  }
}