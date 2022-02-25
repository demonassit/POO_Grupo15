/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet._sockets;

/**
 *
 * @author demon
 */
import java.io.*;
import java.net.*;
import java.util.*;


public class Escribir extends Thread {
    Socket socket;
    String nombre;
    Scanner entrada;
    
    Escribir( Socket socket, String nombre ){
        /*
        Recibeun objeto tipo socket
        para identificar el socket que se esta ejecutando
        en el procesoentre el cliente y el Servidor
        */
        entrada = new Scanner(System.in);
        this.socket = socket;
        this.nombre = nombre;
        //inicializa
        start();
        
        //al metodo run
        
            
    }
    
    public void run(){
        
        try{
            boolean terminar = false;
            String mensaje;
            while(!terminar){
                OutputStream os = socket.getOutputStream();
                DataOutputStream flujoDOS = new DataOutputStream(os);
                System.out.println("Escribe tu mensaje "+ nombre + "");
                mensaje = entrada.nextLine();
                //un bucle para ingresar las palabras
                if(mensaje.equals("salir")){
                    terminar = true;
                }else{
                    //escribir el flujo de datos de salida
                    flujoDOS.writeUTF(nombre + " dice: " + mensaje);
                }
            }
            //se cierra el socket
            socket.close();
        }catch(Exception e){
            System.out.println("Error al conectar");
            System.out.println(e.getMessage());
        
        }
        }
}
