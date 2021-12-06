/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

/**
 *
 * @author demon
 */
//apuntador -> nivel del acceso a la clase, porque esta separada en paquetes
import Documentos.CLibro;
import java.util.*;
import java.io.*;

public class ManipularLibros implements Serializable{
    
    //vamos a crear un metodo para agregar varios libros
    
    //los objetos que son capaces de soportar diferentes tipos de dato
    
    private ArrayList<CLibro> listadelibros;
    
    //un objeto para el archivo de mis libros
    
    private ArchivoL objetoarchivolibros = new ArchivoL();
    /*
    esta clase u objeto es la que se va a encargar de poder
    crear y leer los archivos del documento de libro
    */
    
    //vamos a hacer el crud de libros
    //c create, r read, u update, d delete
    
    public listadeLibros(){
        //vamos a cargar la instancia de la lista de los libros
        listadelibros = new ArrayList<CLibro>();
        //vamos aplicar una sobrecarga al objeto para mandar
        //a llamara su lectura correspondiente del archivo creado
        listadelibros = objetoarchivolibros.leer();
    }
    
    //crud
    public void agregarLibro(){
        Scanner entrada = new Scanner(System.in);
        char resp = 's';
        //ciclo para solicitar datos de los libros
        while(resp == 's'){
            //hago un objeto de CLibro y mando a llamar al metodo de los datos
            CLibro objlibro = new CLibro();
            objlibro.aceptarDatos();
            //lo agrego al array
            listadelibros.add(objlibro);
            System.out.println("¿Deseas agregar otro libro?");
            resp = entrada.next().charAt(0);
        }
    }
    
    
}
