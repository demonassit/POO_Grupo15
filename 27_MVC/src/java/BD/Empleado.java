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
import java.util.Vector;

public class Empleado {
    
    private int num_empleado;
    private String nombre;
    private String user;
    private String pass;
    private int idrol;
    private String nombrerol;
    
    public Empleado(){
    
    }
    
     public int getNum_empleado() {
        return num_empleado;
    }

    public void setNum_empleado(int num_empleado) {
        this.num_empleado = num_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }
    
    //cuales son las funciones del usuario?
    //Registra
    
    
    //Modifica sus datos
    
    //consulta sus datos
    public Vector<Empleado> listarEmpleados() throws ClassNotFoundException{
        Vector<Empleado> listaempleados = new Vector<Empleado>();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        
        try{
            con = Conexion.getConexion();
            String q = "select * from empleado";
            pre = con.prepareStatement(q);
            rs = pre.executeQuery();
            while(rs.next()){
                Empleado emp = new Empleado();
                emp.setNum_empleado(rs.getInt("num_empleado"));
                emp.setNombre(rs.getString("nombre"));
                emp.setUser(rs.getString("user"));
                emp.setPass(rs.getString("pass"));
                emp.setIdrol(rs.getInt("id_rol"));
                emp.setNombrerol(rs.getString("nombre_rol"));
                listaempleados.add(emp);
            }
        }catch(SQLException ed){
            System.out.println("Error al consultar la tabla empleado");
            System.out.println(ed.getMessage());
            listaempleados = null;
        }finally{
            try{
                //cerrar tods las conexion por seguridad
                rs.close();
                pre.close();
                con.close();
                
            }catch(Exception e){
                System.out.println("Error de logica de datos");
                System.out.println(e.getMessage());
            }
        }
         return listaempleados;   
    }
    
    //consulta todos los empleados
    
    
    //verificar el tipo de usuario
    public Empleado verificacionUsuario(String usuario, String password) throws ClassNotFoundException{
        Empleado emp = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        
        try{
            /*
            Tengo que comparar el nombre de usuario y password respecto 
            de la bd, si coincide accede sino mando un mensaje de error
            en las credenciales 
            */
            //primero me debo de conectar a la bd
            con = Conexion.getConexion();
            String q = "select * from empleado "
                    + "where user = ? and pass = ?";
            pre = con.prepareStatement(q);
            pre.setString(1, usuario);
            pre.setString(2, password);
            
            rs = pre.executeQuery();
            
            while(rs.next()){
                emp = new Empleado();
                emp.setNum_empleado(rs.getInt("num_empleado"));
                emp.setNombre(rs.getString("nombre"));
                emp.setUser(rs.getString("user"));
                emp.setPass(rs.getString("pass"));
                emp.setIdrol(rs.getInt("id_rol"));
                emp.setNombrerol(rs.getString("nombre_rol"));
                break;
            }
            System.out.println("Empleado encontrado");
            
            
        }catch(SQLException ed){
            System.out.println("Error al conectar la tabla empleado");
            System.out.println(ed.getMessage());
            emp = null;
        }finally{
            try{
                //cerrar tods las conexion por seguridad
                rs.close();
                pre.close();
                
            }catch(Exception e){
                System.out.println("Error de logica de datos");
                System.out.println(e.getMessage());
            }
        }
        return emp;
    }

   
    
    
    
    
}
