
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class myprod {
   String forname=  "com.mysql.jdbc.Driver";
   String driver = "jdbc:mysql://localhost/bsit21";
   String us = "root";
   String ps1 ="";
   String name;
   
   public void addnew(String name,int quantity, String price){
       try {
           Class.forName(forname);
           Connection con = DriverManager.getConnection(driver,us,ps1);
           PreparedStatement ps = con.prepareStatement("insert into producttbl values(null,?,?,?)");
           ps.setString(1,name);
           ps.setInt(2, quantity);
           ps.setString(3, price);
           ps.executeUpdate();
           
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(myprod.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(myprod.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
