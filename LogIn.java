package registrationformproject;


import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LogIn extends JFrame implements ActionListener {
    JButton Login,signup;
     JTextField tfusername;
    JTextField pw;
    LogIn() {
        setSize(900, 400);
        setLocation(400, 200);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        JPanel p1 = new JPanel();
       // p1.setBackground(new Color(131, 143, 250));
        p1.setBackground(Color.WHITE);
        p1.setBounds(0, 0, 400, 400);
        add(p1);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/LogIn.jpg"));
       Image i2 = i1.getImage().getScaledInstance(300, 340, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
         img.setBounds(100,200,200,200);
        p1.add(img);

       //For right side panel
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);
        //inserting text in right panel using Jlabel
        JLabel username =new JLabel(" Username ");
        username.setBounds(60,20,100,25);
        username.setFont(new Font("San Serif",Font.PLAIN,18));
        p2.add(username);

         tfusername =new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());

        p2.add(tfusername);
        //----------------------------------------------------------------------------------------
        // password
        JLabel password =new JLabel(" Password");
        password .setBounds(60,100,100,25);
        password .setFont(new Font("San Serif",Font.PLAIN,18));
        p2.add(password);

        //JTextField tfpassword =new JTextField();
         pw= new JTextField(); 
        pw .setBounds(60,140,300,30);
        pw .setBorder(BorderFactory.createEmptyBorder());
        p2.add(pw);

        //JBUTTON for login
        Login =new JButton("Login");
        Login.setBounds(100,200,100,30);
        Login.setBackground(new Color(100,150,200));
        Login.setForeground(Color.WHITE);
        Login.setBorder(new LineBorder(new Color(100,150,200)));
        Login.addActionListener(this);
        p2.add(Login);

        //Jbutton for signUp

        signup =new JButton("Signup");
        signup.setBounds(220,200,100,30);
        signup.setBackground(new Color(100,150,200));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(100,150,200)));
        signup.addActionListener(this);
        p2.add(signup);

        JLabel signUpNew =new JLabel("\uD83D\uDC48  New User ?");//code for <-
        signUpNew.setBounds(330,200,100,30);
        signUpNew.setFont(new Font("San Serif",Font.PLAIN,12));
        p2.add(signUpNew);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==signup)
        {
            setVisible(false);
            new SignUp();
        }
        else if(ae.getSource()==Login)
        {
            
//            Boolean status = false;
            try {
                String username =tfusername.getText();
                String password=pw.getText();
                 Class.forName("com.mysql.cj.jdbc.Driver");
              Connection  c = DriverManager.getConnection("jdbc:mysql:///mysql", "root",
                    "itstudent");
                    String query= "select * from signup where username=? and password=?";
                    PreparedStatement st = c.prepareStatement(query);

                st.setString(1, username);
                   st.setString(2, password);

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        setVisible(false);
                        new DashBoardOpen();
                    } else
	JOptionPane.showMessageDialog(null, "Invalid Login or Password!");
                       
                  } 
            catch (Exception e2) {
                    e2.printStackTrace();
		}
            
            
       
//             setVisible(false);
//              new EmployeeDetails();
               
        }
        else
        {
            setVisible(false);
        }
        
//            {
//                    setVisible(false);
//            }
    }

    public static void main(String[] args) {
        LogIn l = new LogIn();
    }
}
