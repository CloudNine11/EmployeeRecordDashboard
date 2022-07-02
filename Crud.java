
package registrationformproject;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;


public class Crud extends JFrame implements ActionListener  {
    JPanel p;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
     JComboBox comboBox;
      JRadioButton r1,r2,r3;
      JButton b1,b2,b3,b4;

      Crud()
      {
               p = new JPanel();
               p.setLayout(null);
               p.setBackground(new Color(221,160,221));
                
                JLabel l1= new JLabel("NEW EMPLOYEE DETAILS");
                l1.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
                l1.setBounds(240, 11, 260, 53);
                add(l1);
               
                JLabel l2 = new JLabel("Username :");
                l2.setFont(new Font("Yu Mincho", Font.PLAIN, 18));
                l2.setBounds(100, 70, 200, 14);
                p.add(l2);
                
               t2 = new JTextField();
               t2.setBounds(271, 70, 150, 20);
               p.add(t2);
               t2.setColumns(10);
               
                 JLabel l3= new JLabel("EMPID :");
                 l3.setFont(new Font("Yu Mincho", Font.PLAIN, 18));
                 l3.setBounds(100, 110, 200, 14);
                 p.add(l3);
                 
                 comboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license"});
	comboBox.setBounds(271, 110, 150, 20);
	p.add(comboBox);
        
                JLabel l4 = new JLabel("REGNo :");
                l4.setFont(new Font("Yu Mincho", Font.PLAIN, 18));
                l4.setBounds(100, 150, 200, 14);
                p.add(l4);
                
                t3 = new JTextField();
                t3.setBounds(271, 150, 150, 20);
                p.add(t3);
                t3.setColumns(10);
                
                
               JLabel l5 = new JLabel("Name :");
               l5.setFont(new Font("Yu Mincho", Font.PLAIN, 18));
               l5.setBounds(100, 190, 200, 14);
               p.add(l5);
		
               t4 = new JTextField();
               t4.setBounds(271, 190, 150, 20);
               p.add(t4);
               t4.setColumns(10);
               
               
                JLabel lGender = new JLabel("Gender :");
               lGender.setFont(new Font("Yu Mincho", Font.PLAIN, 18));
                lGender.setBounds(100, 230, 200, 14);
                p.add(lGender);
                
                r1 = new JRadioButton("Male");
                r1.setFont(new Font("Raleway", Font.BOLD, 14));
                r1.setBounds(271, 230, 80, 12);
                add(r1);
                
                r2 = new JRadioButton("Female");
                r2.setFont(new Font("Raleway", Font.BOLD, 14));
                r2.setBounds(350, 230, 100, 12);
		add(r2);
                
                
                  JLabel lblCountry = new JLabel("Country :");
                  lblCountry.setFont(new Font("Yu Mincho", Font.PLAIN, 18));
                  lblCountry.setBounds(100, 270, 210, 22);
                  p.add(lblCountry);
                
                t5 = new JTextField();
                t5.setBounds(271, 270, 150, 20);
                p.add(t5);
               t5.setColumns(10);
               
               
               JLabel l6 = new JLabel(" Address :");
               l6.setFont(new Font("Yu Mincho", Font.PLAIN, 18));
                l6.setBounds(98, 310, 200, 14);
                p.add(l6);
                
                t6 = new JTextField();
               t6.setBounds(271, 310, 150, 20);
               p.add(t6);
               t6.setColumns(10);
               
               JLabel l7= new JLabel("Phone :");
               l7.setFont(new Font("Yu Mincho", Font.PLAIN, 18));
               l7.setBounds(100, 350, 200, 14);
               p.add(l7);
                
                t7= new JTextField();
                 t7.setBounds(271, 350, 150, 20);
                  p.add(t7);
                  t7.setColumns(10);
               
                  
                  
                   JLabel l8= new JLabel("Email :");
                    l8.setFont(new Font("Yu Mincho", Font.PLAIN, 18));
                   l8.setBounds(100, 390, 200, 14);
                   p.add(l8);
		
                  t8 = new JTextField();
                  t8.setBounds(271, 390, 150, 20);
                  p.add(t8);
                 t8.setColumns(10);
                
                 b1=new JButton("ADD");
                 b1.setBounds(140,450,120,30);
                 b1.addActionListener(this);
                 p.add(b1);
                 
                 b2=new JButton("UPDATE");
                 b2.setBounds(300,450,120,30);
                 b2.addActionListener(this);
                 p.add(b2);
                 
                 b3=new JButton("DELETE");
                 b3.setBounds(460,450,120,30);
                 b3.addActionListener(this);
                 p.add(b3);
                 
                 b4=new JButton("back");
                 b4.setBounds(600,450,100,30);
                 b4.addActionListener(this);
                 p.add(b4);
                 
                
                add(p);
                 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                setLocationRelativeTo(null);
                setSize(800,600);
                setVisible(true);
                
      }
      
      public void  actionPerformed(ActionEvent e)
      {
          if(e.getSource()==b1)
          {
           String Username =t2.getText();
           String EmpId = (String)comboBox.getSelectedItem(); 
           String  RegNo=t3.getText();
           String Name=t4.getText();
           
           String radio = null;
                            
                            if(r1.isSelected()){ 
                                radio = "Male";
                            }
                            else if(r2.isSelected()){ 
                                radio = "Female";
                            }
           String Gender=radio;
           String Country=t5.getText();
           String Address=t6.getText();
           String Phone=t7.getText();
           String Email=t8.getText();
           
       //  ============================INSERT================================  
          try
          {
              Class.forName("com.mysql.cj.jdbc.Driver");
              Connection  c = DriverManager.getConnection("jdbc:mysql:///mysql", "root",
                    "itstudent");
            PreparedStatement ps=c.prepareStatement("Insert into record(Username,EmpId,RegNo,Name,Gender,Country,Address,Phone,Email)values(?,?,?,?,?,?,?,?,?)");
                                    ps.setString(1,Username);
                                    ps.setString(2,EmpId);
                                    ps.setString(3,RegNo);
                                    ps.setString(4,Name);
                                    ps.setString(5,Gender);
                                    ps.setString(6,Country);
                                    ps.setString(7,Address);
                                    ps.setString(8,Phone);
                                    ps.setString(9,Email);
                             int roweffected =ps.executeUpdate();
                                        if(roweffected>0)
                                        {
                                             JOptionPane.showMessageDialog(null, " Record Added successfully");
                                            System.out.println("Data succesfully inserted");

                                        }       
                                        
                                        new Crud();
                                        setVisible(false);
          }
          catch(Exception ae)
          {
              ae.printStackTrace();
          }
          
      }
          //===========================UPDATE======================================
          else if(e.getSource()==b2)
          {
               String Username =t2.getText();
           String EmpId = (String)comboBox.getSelectedItem(); 
           String  RegNo=t3.getText();
           String Name=t4.getText();
           
           String radio = null;
                            
                            if(r1.isSelected()){ 
                                radio = "Male";
                            }
                            else if(r2.isSelected()){ 
                                radio = "Female";
                            }
           String Gender=radio;
           String Country=t5.getText();
           String Address=t6.getText();
           String Phone=t7.getText();
           String Email=t8.getText();
           
             
              try
          {
              Class.forName("com.mysql.cj.jdbc.Driver");
              Connection  c = DriverManager.getConnection("jdbc:mysql:///mysql", "root",
                    "itstudent");
            PreparedStatement ps=c.prepareStatement("UPDATE record SET Username=? ,EmpId=?,RegNo=?,Name=?,Gender=?,Country=?,Address=?,Phone=?,Email=? WHERE Username =?");
                                    ps.setString(1,Username);
                                    ps.setString(2,EmpId);
                                    ps.setString(3,RegNo);
                                    ps.setString(4,Name);
                                    ps.setString(5,Gender);
                                    ps.setString(6,Country);
                                    ps.setString(7,Address);
                                    ps.setString(8,Phone);
                                    ps.setString(9,Email);
                            ps.executeUpdate();
                                       
                                       
                                  JOptionPane.showMessageDialog(null, " Record Updated successfully");
                                  System.out.println("Data succesfully inserted");
                                    new Crud();
                                        
          }
          catch(Exception ae)
          {
              ae.printStackTrace();
          }
          }
     //     ================ ================DELETE============================
          else if(e.getSource()==b3)
          {
              String Username =t2.getText();
              try{
        Class.forName("com.mysql.cj.jdbc.Driver");
          Connection  c = DriverManager.getConnection("jdbc:mysql:///mysql", "root",
                    "itstudent");
          PreparedStatement ps =c.prepareStatement("delete from record where Username=?");
          ps.setString(1,Username);
        
                                             JOptionPane.showMessageDialog(null, "Data succesfully deleted");
                                            System.out.println("Data succesfully deleted");

                                        
      }
      catch(Exception ae)
      {
          ae.printStackTrace();
      }
          }
          else
          {
              setVisible(false);
              new DashBoardOpen();
          }
          
          
      }
      public static void main(String[] args)
      {
          Crud f =new Crud();
      }
    
}
