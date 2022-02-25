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

public class Leer extends Thread {
    Socket socket;
    Leer(Socket socket){
        //se debe recibir el objeto del socket para indicar que 
        //se ejecuta el proceso
        this.socket = socket;
        start();
    
    }
    
    public void run(){
        try{
            while(true){
                InputStream aux = socket.getInputStream();
                DataInputStream flujo = new DataInputStream(aux);
                System.out.println("Datos: " + flujo.readUTF());
            }
        
        }catch(Exception e){
            System.out.println("Error al leer");
            System.out.println(e.getMessage());
        }
    }
}
