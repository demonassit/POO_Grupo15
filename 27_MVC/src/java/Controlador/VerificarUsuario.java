/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BD.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author demon
 */
public class VerificarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //obtener los datos del ofrmulario
            String usuario, password;
            
            usuario = request.getParameter("txtUsuario");
            password = request.getParameter("txtPassword");
            
            /*
            Si el usuario no existe en la BD que voy a hacer
            
            Si el usuario es 1 = dueño
            si el usuario es 2 = encargado de tienda
            si el usuario es 3 es encargado de bodega
            si el usuario es 4 = vendedor
            
            */
            Empleado emp = new Empleado();
            //mando a llamar al metodo de verificacion
            emp = emp.verificacionUsuario(usuario, password);
            
            if(emp!=null){
                //vamos a crear la sesion del usuario
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("empleado", emp);
                
                HttpSession sesionok = request.getSession();
                sesionok.setAttribute("rol", usuario);
                System.out.println(emp.getIdrol());
                System.out.println(emp.getNombre());
                System.out.println(emp.getUser());
                if(emp.getIdrol()==1){
                    //es el dueño
                    response.sendRedirect("dueno.jsp");
                }/*
                else if(emp.getIdrol()==2){
                    //encargado de tienda
                }
                else if(emp.getIdrol()==3){
                    //encargado de bodega
                }
                else if(emp.getIdrol()==4){
                    //vendedor
                }*/
                else{
                    //cliente
                    response.sendRedirect("cliente.jsp");
                }
                
            }else{
                //el usuario no existe
                response.sendRedirect("errores.jsp");
            }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
