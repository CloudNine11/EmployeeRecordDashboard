
package registrationformproject;
import javax.swing.*;
import java.sql.*;
import  java.awt.*;
import java.awt.event.*;

public class RegistrationFormProject {

    JFrame f;
    JPanel p;
  
    
    public void display()
    {
        f=new JFrame();
        p=new JPanel();
       
       
        
        
        f.add(p);
        f.setLayout(null);
        f.setResizable(false);
        f.setSize(650, 600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
  
    public static void main(String[] args) {
        RegistrationFormProject r=new RegistrationFormProject();
        r.display();
    }
    
}
