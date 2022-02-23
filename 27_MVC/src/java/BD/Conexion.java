/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

/**
 *
 * @author demon
 */

import java.sql.*;

public class Conexion {
    
    public static Connection getConexion() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/funkos";
            String user = "root";
            String password = "n0m3l0";
            
            return DriverManager.getConnection(url, user, password);
        }catch(SQLException ed){
            System.out.println("Error al conectar");
            System.out.println(ed.getMessage());
        
        }catch(Exception ex){
            System.out.println("Error logico");
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
}
