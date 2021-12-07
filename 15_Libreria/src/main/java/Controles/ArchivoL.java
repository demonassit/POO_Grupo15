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

import Documentos.CLibro;
import java.util.*;
import java.io.*;

//implementar la serializacion de los archivos
class ArchivoL implements Serializable {
    
    /*
    vamos a crear el objeto que vamos a serializar 
    de la lista de los libros
    */
    
    ArrayList<CLibro> listarecuperada = new ArrayList<CLibro>();
    
    //metodo para generar la lectura del archivo
    //metodo que lee el archivo
    public ArrayList<CLibro> leer(){
        try{
            //primero tenemos que crear la lectura del buffer de objetos
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("libro.txt"));
            listarecuperada = (ArrayList<CLibro>)in.readObject();
            in.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("Se origino :" + e.getStackTrace());
        }
        return listarecuperada;
    }
    
    //el metodo que serializa
    //metodo que escribe el archivo
    void serializar(ArrayList<CLibro> listaserializada){
        try{
            //generar el archivo de salida
            FileOutputStream salida = new FileOutputStream("libro.txt");
            //generar la creacion de los objetos
            ObjectOutputStream salidaobjeto = new ObjectOutputStream(salida);
            
            //ya que tengo la generacion de la salida la escribimos
            
            salidaobjeto.writeObject(listaserializada);
            
            salidaobjeto.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("Se origino :" + e.getStackTrace());
        }
    }
    
    
}
