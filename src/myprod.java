
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
       
       
       public void delprod (int ID){
     
       try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection(driver,us,ps1);
           PreparedStatement pres = con.prepareStatement("Delete from producttbl where ID =?");
           pres.setInt(1, ID);
           pres.executeUpdate();
           
           
       
   }   catch (ClassNotFoundException ex) {
           Logger.getLogger(myprod.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(myprod.class.getName()).log(Level.SEVERE, null, ex);
       }
       }
       
       
       public void edit(int id, String product, String price){
       try {
           Class.forName(forname);
           PreparedStatement ps = DriverManager.getConnection(driver,us,ps1).prepareStatement("update producttbl set product = ?, price = ? where id = ?");
           ps.setString(1, product);
           ps.setString(2, price);
           ps.setInt(3, id);
           ps.executeUpdate();
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(myprod.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(myprod.class.getName()).log(Level.SEVERE, null, ex);
       }
       }
       
       
       
       
       public void editqy(int id,int qty){
           try {
           Class.forName(forname);
           Connection con = DriverManager.getConnection(driver,us,ps1);
           PreparedStatement ps = con.prepareStatement("update producttbl set QUANTITY= (QUANTITY+?) where ID = ?");
           ps.setInt(1, qty);
           ps.setInt(2, id);
           
           ps.executeUpdate();
           
          
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(myprod.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(myprod.class.getName()).log(Level.SEVERE, null, ex);
          } 
           
       }
}
       

