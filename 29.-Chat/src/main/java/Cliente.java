/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author demon
 */

import java.net.*;
import java.io.*;
import java.util.*;

public class Cliente {
    
    //definir notificaciones
    private String notificacion = " *** ";
    
    //objetos in out socket
    private ObjectInputStream in;
    private ObjectOutputStream os;
    private Socket socket;
    
    private String server, username;
    
    private int port;
    
    public String getusername(){
        return username;
    }
    
    public void setusername(String username){
        this.username = username;
    }
    
    public Cliente(String server, int port, String username){
        this.server = server;
        this.port = port;
        this.username = username;
    }
    
    //iniciar el chat
    
    public boolean start(){
        try{
            socket = new Socket(server, port);
            
        }catch(Exception e){
            display("Error al conectar con el servidor: " + e);
            System.out.println(e.getMessage());
            return false;
        }
        
        String msg = "Conexion establecida " 
                + socket.getInetAddress() + " : " 
                + socket.getPort();
        display(msg);
        
        //obtener los flujos
        try{
            in = new ObjectInputStream(socket.getInputStream());
            os = new ObjectOutputStream(socket.getOutputStream());
        }catch(IOException eio){
            display("Error al conectar los flujos de datos" + eio);
            System.out.println(eio.getMessage());
            
            return false;
        
        }
        
        //crear el hilo por donde se escucha al puerto del servidor
        //T_T
        
        
        //aqui debo de llamar al servidor T_T
        new ListenFromServer().start(); 
        
        
        try{
            os.writeObject(username);
        }catch(IOException eio){
            display("Error al autenticarte en el chat" + eio);
            disconnect();
            return false;
        
        }
        return true;

    }
    
    //enviar mensajes
    void sendMessage(ChatMessage msg){
        try{
            os.writeObject(msg);
        }catch(IOException eio){
            display("Error al escribir los mensajes");
        }
    }

    private void display(String msg) {
        System.out.println(msg);
    }

    private void disconnect() {
        try{
                    if(os != null) 
                        os.close();
                }catch(Exception e){
                    try{
                        if(in != null)
                            in.close();
                    }catch(Exception ed){
                        try{
                            if(socket != null)
                                socket.close();
                        }catch(Exception ev){
                        
                        }
                    }
                }
    }
    
    public static void main(String[] args){
        int port = 1500;
        String serverAddress = "localhost";
        String userName = "Juanito";
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Ingresa tu nombre de usuario");
        userName = scan.nextLine();
        
        //los diferentes casos dependiendo de los mensajes
        switch (args.length) {
            case 3:
                //cuando el cliente usa todos los datos
                serverAddress = args[2];
            case 2:
                //cuando el cliente mal puerto
                try{
                    port = Integer.parseInt(args[1]);
                }catch(Exception e){
                    System.out.println("Puerto invalido");
                    System.out.println("Use el puerto 1500 para conectarse");
                    return;
                 
                }
            case 1:
                userName = args[0];
                
            case 0:
                break;
            default:
                System.out.println("Para conectarse al chat, ingrese su usuario, puerto 1500, direccion del servidor");
                return;
        }
        
        Cliente clientesito = new Cliente(serverAddress, port, userName);
        
        if(!clientesito.start()){
            return;
                }
        
        System.out.println("Hola bienvenido al chat de los reprobados del grupo de quinto de ISC UTC");
        System.out.println("Aquel que no se conecte lo voy a tronar wiiiii");
        System.out.println("Porque se hicieron patos durante toda la clase del chat");
        System.out.println("siga las instrucciones:");
        System.out.println("1.- Enviar un mensaje por el flujo de los clientes");
        System.out.println("2.- debe de usar @username <espacio> tu mensaje para poder enviarlo");
        System.out.println("3.- Debe usar WHOISIN para escuchar a otros clientes");
        System.out.println("4.- Debe de usar LOGOUT para salir de la sala");
        
        while(true){
            System.out.println(" > > ");
            String msg = scan.nextLine();
            if(msg.equalsIgnoreCase("LOGOUT")){
                clientesito.sendMessage(new ChatMessage(ChatMessage.LOGOUT, ""));
                break;
            }else if(msg.equalsIgnoreCase("WHOISIN")){
                clientesito.sendMessage(new ChatMessage(ChatMessage.WHOISIN, ""));
            }else{
                clientesito.sendMessage(new ChatMessage(ChatMessage.MESSAGE, msg));
            }
            scan.close();
            clientesito.disconnect();
        }
    }
    
    
    
    class ListenFromServer extends Thread{
        public void run(){
            while(true){
                try{
                    String msg = (String)in.readObject();
                    System.out.println(msg);
                    System.out.println(" > > ");
                }catch(IOException eio){
                    display(notificacion + " Servidor cerrado " + eio + notificacion);
                    break;
                
                }catch(ClassNotFoundException ec){
                
                }
            }
        }
    }
}
