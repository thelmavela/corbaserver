/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbainterfaz;

import conexion.Conexion;
import corba1.pruebaPOA;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thelma del Rosario
 */
public class Implemento extends pruebaPOA {
    @Override 
    public String generar(String numero) {
	String cadena = "";
      String tarjeta="";
        Conexion con = new Conexion();
        Connection conn=con.getConnection();
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery("select * from login where serial='"+numero+"'");
            if(rs.next()){
                System.out.println("llega usuario");
                cadena="El usuario "+rs.getString("nombre")+" esta registrado con el numero de tarjeta "+rs.getString("serial");
            return cadena;
            
            }else{
            return "No hay usuarios registerados con la tarjeta "+tarjeta;
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Implemento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "error con el numero de usuario: "+numero;
    }
}
