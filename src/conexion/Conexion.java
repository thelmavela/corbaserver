/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Thelma del Rosario
 */
public class Conexion {
 public  Connection getConnection(){
        Connection cn = null;  
        String user = "root";
        String pass = ""; 
            try {
          
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost/rfid?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=utf-8";//"jdbc:mysql://localhost:3306/Ventas";//parametros de la conexion a la BD 
                    //
                    //
            cn = DriverManager.getConnection(url, user, pass);
            
            System.out.println("Conexion Exitosa");
        } 
        catch (Exception e) {
            //e.printStackTrace();
            System.out.println("ERROR"+e.getMessage());
        }
        
        return cn;
    }
 
 public static void main(String [] args){
   Conexion con = new Conexion();
   con.getConnection();
 
 }
 
 
 
}
