/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.ServletConfig;

/**
 *
 * @author demon
 */
public class registrousuario extends HttpServlet {

/**
    Para poder realizar una conexion con la base de datos se necesita el uso de los objetos
    * Connection
    * Statement
    * ResultSet
    *Esos objetos deben de ser privados, porque vamos a establecer una conexion remota a un 
    * servidor diferente 
     */
    private Connection con = null; //establece la conexion con BD
    private Statement set = null;  //establece las operaciones o sentencias sql para insert, update, delete 
                                    //maneja sql como lenguaje de LDD (lenguaje de definicion de datos)
    private ResultSet rs = null;   //manjear todo tipo de consultas
    
    //necesitamos el constructor de la clase
    
    public void init(ServletConfig cfg) throws ServletException{
        //hay que definir los elementos del constructor que se encargan ahora de conectar con la BD
        //para establecer la conexion necesitamos la ruta 
        
        String URL = "jdbc:mysql://localhost:/funkos?useSSL=false&serverTimezone=UTC";     //jdbc:mysql:puerto//localhost/nombrebd
        //?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
        String userName = "root";
        String password = "n0m3l0";
        
        try{
            //establecer el manejador del driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //URL = "jdbc:mysql://localhost:3306/funkos";
            con = DriverManager.getConnection(URL, userName, password);
            
            set = con.createStatement();
            
            System.out.println("Se conecto con la BD");
        }catch(Exception e ){
            System.out.println("No se conecto a l BD");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registrousuario</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<table border=1 >"
                    + "<tr>  "
                        + "<th>Num_Empleado</th>"
                        + "<th>Nombre</th>"
                        + "<th>User</th>"
                        + "<th>Password</th>"
                    + "</tr>"
                    + "</table>");
            
            try{
                int num_empleado;
                String nombre, user, password;
                
                num_empleado = Integer.parseInt(request.getParameter("num_emp"));
                nombre = request.getParameter("nombre");
                user = request.getParameter("user");
                password = request.getParameter("password");
                
                //tenemos que insertarlos
                
                String q = "insert into empleado values("+num_empleado+", '"+nombre+"', '"+user+"', '"+password+"') ";
                
                set.executeUpdate(q);
                
                
                 out.println("<h1>registro Exitoso</h1>");
            
            }catch(SQLException ex){
                System.out.println("No se conecto con la tabla");
                System.out.println(ex.getMessage());
                System.out.println(ex.getStackTrace());
                
                 out.println("<h1>Registro No Exitoso</h1>");
            
            }
            
            
           
            out.println("<a href='registro.html' >Regresar al registro</a>");
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
