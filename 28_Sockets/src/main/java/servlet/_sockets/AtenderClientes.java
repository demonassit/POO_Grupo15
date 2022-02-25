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

import java.net.*;
import java.io.*;
import java.util.*;

public class AtenderClientes extends Thread {
    //tener un proceso para colocar en fila
    //las peticiones de los clientes
    Socket socket;
    String mensajes;
    //lista de todos los clientes que estan
    ArrayList<Socket> listaCliente;
    int clientes;
    
    //primero que recibir toda la lista de los clientes
    //a partir de ahi atender las solicitudes por FIFO
    //constructor
    public AtenderClientes(ArrayList<Socket> lista, Socket socket){
        
        this.listaCliente = lista;
        this.socket = socket;
        //inicialice el hilo
        start();
                 
        
    }
    
    public void run(){
       //un bucle infinito para que pueda atender
       //a todos los clientes que existan
       while(true){
        try{
            InputStream is = socket.getInputStream();
            DataInputStream flujo = new DataInputStream(is);
            mensajes = flujo.readUTF();
            //tenemos que leer todos los mensajes que vienen
            //por parte de los cleintes
            for(int cont = 0; cont < listaCliente.size(); cont++ ){
                OutputStream os = listaCliente.get(cont).getOutputStream();
                DataOutputStream flujoDOS = new DataOutputStream(os);
                flujoDOS.writeUTF(mensajes);
            }
            
        }catch(Exception e){
            System.out.println("Error de comunicacion");
            System.out.println(e.getMessage());
        }
       
       }
    }
    
    
}
