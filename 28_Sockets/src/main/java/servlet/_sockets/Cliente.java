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
import java.util.*;

//sockets
import java.net.*;


public class Cliente {
    
    Scanner entrada = new Scanner (System.in);
    Cliente(){
        try{
            Socket skcliente = new Socket("localhost", 5000);
            System.out.println("Introduce tu nombre: ");
            String nombre = entrada.next();
            //se debe de crear un hilo que atienda las peticiones del cliente
            Escribir hilo1 = new Escribir(skcliente, nombre);
            //se envia el hilo que escribe el nombre del cliente
            //debo de leer
            Leer hilo2 = new Leer(skcliente);

        }catch(Exception e){
            System.out.println("Error de comunicacion");
            System.out.println(e.getMessage());

    }
    }
    
    public static void main(String[] args){
        new Cliente();
    }
}
