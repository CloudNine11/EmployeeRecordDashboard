/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationformproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.border.Border;
/**
 *
 * @author KAUSANI
 */
public class DashBoardOpen extends JFrame implements ActionListener {
    
    JButton  b,b1,b2,b3;
    DashBoardOpen()
    {

//        setLocationRelativeTo(null);
        
                JButton  b = new JButton("ADD RECORD");
                b.setBounds(90, 240, 180, 100);
                b.setFont(new java.awt.Font("Tahoma", 1, 14)); 
                b.setBackground(Color.WHITE);
//            b.setForeground(new Color(100, 150, 180));
                b.addActionListener(this);
              add(b);
              
              
                JButton  b1 = new JButton(" UPDATE RECORD ");
                b1.setBounds(300, 240, 180, 100);
                b1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
                b1.setBackground(Color.WHITE);
//            b.setForeground(new Color(100, 150, 180));
                b1.addActionListener(this);
                add(b1);
                
                   JButton  b2 = new JButton(" DELETE RECORD ");
                b2.setBounds(500, 240, 180, 100);
                b2.setFont(new java.awt.Font("Tahoma", 1, 14)); 
                b2.setBackground(Color.WHITE);
//            b.setForeground(new Color(100, 150, 180));
                b2.addActionListener(this);
                add(b2);
                
                
                JButton  b3 = new JButton(" back ");
                b3.setBounds(560, 400, 100, 40);
                b3.setFont(new java.awt.Font("Tahoma", 1, 14)); 
                b3.setBackground(Color.WHITE);
//            b.setForeground(new Color(100, 150, 180));
                b3.addActionListener(this);
                add(b3);
                
                
         getContentPane().setBackground(new Color(204, 166, 166));// awt package
         setLayout(null);
        
        setResizable(false);
        setSize(800,600);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
         
        if(ae.getSource()==b)
        {
            setVisible(false);
            new Crud();
        }
        else if(ae.getSource()==b1)
        {
             setVisible(false);
             new Crud();
        }
        else 
        {
            setVisible(false);
             new Crud();
        }
        
        
        
    }
    public void b3actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b3)
        {
            setVisible(false);
             new LogIn();
        }
    }
    
    
    public static void main(String [] args)
    {
        DashBoardOpen d=new DashBoardOpen();
    }
}
