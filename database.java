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
import javax.swing.table.DefaultTableModel;


public class database extends JFrame  {
    
//    database()
//    {
//        
//    }
    
    public static void main(String []args)
    {
        try 
  {
      String url = "jdbc:mysql://localhost:3306/mysql";
      String user = "root";
      String password = "itstudent";
    
      Connection con = DriverManager.getConnection(url, user, password);
    
      String query = "SELECT * FROM record ";
    
      Statement stm = con.createStatement();
      ResultSet ps = stm.executeQuery(query);
    
      String columns[] = { "Username", "EmpId", "RegNo","Name", "Gender", "Country", "Address", "Phone", "Email"};
      String data[][] = new String[50][10];
    
      int i = 0;
      while (ps.next()) {
//        int id = ps.getInt("ID");
//        String nom = res.getString("name");
//        String age = res.getString("Roll");
//        
        String Username=ps.getString("Username");
              String EmpId =ps.getString("EmpId");
              String RegNo=ps.getString("RegNo");
              String name = ps.getString("Name");
              String Gender=ps.getString("Gender");
              String country =ps.getString("Country");
             String address =ps.getString("Address");
              String phone=ps.getString("Phone");
              String email= ps.getString("Email");
              
              
        data[i][0] = Username ;
        data[i][1] = EmpId ;
        data[i][2] = RegNo;
         data[i][3] = name ;
        data[i][4] = EmpId ;
        data[i][5] = Gender;
         data[i][6] = country;
        data[i][7] = address ;
        data[i][8] = phone;
        data[i][9] = email;
        
        
        i++;
      }
    
      DefaultTableModel model = new DefaultTableModel(data, columns);
      JTable table = new JTable(model);
      table.setShowGrid(true);
      table.setShowVerticalLines(true);
      JScrollPane pane = new JScrollPane(table);
      JFrame f = new JFrame("Populate JTable from Database");
      JPanel panel = new JPanel();
      panel.add(pane);
      f.add(panel);
      f.setSize(500, 500);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
    
    } catch(SQLException e) {
      e.printStackTrace();
    }
    }
}
