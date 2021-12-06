/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Documentos;

/**
 *
 * @author demon
 */
import java.util.*;

public class Periodico extends CLibro {
    
    //fecha de publicacion
    
    private Date fecha = new Date();
    private String fecha2;
    
    public Periodico(){
    
    }
    
    public Periodico(String nombre, String autor, String editorial, float precio) {
        super(nombre, autor, editorial, precio);
        this.fecha2 = fecha2;
    }
    
    
    
    public void agregarPeriodico(){
        //primero necesito jalar el metodo de aceptar datos y despues agregar
        //el tipo de revista
        CLibro datoslibro = new CLibro();
        
        Scanner entrada = new Scanner(System.in);
        
        datoslibro.aceptarDatos(); //tdos los datos del documento
        System.out.println("Ingresa la fecha de publicacion");
        fecha2 = entrada.nextLine();
        //13 de enero de 2021
        //13/01/2021
        //13/Enero/2021
        //2021/01/13
        //casteo del objeto
        //Date = new String("el formato")
        //String = new Date("datos")
        /*System.out.println("Año: " + fecha.getYear());
        System.out.println("Mes: " + fecha.getMonth());
        System.out.println("Dia: " + fecha.getDay());
        */
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFecha2() {
        return fecha2;
    }

    public void setFecha2(String fecha2) {
        this.fecha2 = fecha2;
    }
    
    
    
}
