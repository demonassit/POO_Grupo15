/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author demon
 */

import java.io.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;   //para dar formato a textos

public class Servidor {
    
    //id
    private static int uniqueID;
    
    //una lista de clientes
    private ArrayList<ClienteThread> al;
    
    //para visualizar la fecha
    private SimpleDateFormat fecha;
    
    //definir el puerto de conexion
    private int port;
    
    //saber si el servidor esta corriendo
    private boolean keepgoing;
    
    //tener notificaciones wiiiii
    private String notificaciones = " *** ";
    
    //constructor del servidor
    
    public Servidor(int port){
        this.port = port;
        fecha = new SimpleDateFormat("HH:mm:ss");
        al = new ArrayList<ClienteThread>();
    }
    
    //vamos a inicializarlo
    public void start(){
        keepgoing = true;
        //hay que crear el socket de conexiones
        try{
            ServerSocket  serversocket = new ServerSocket(port);
            //que sea infinito para esperar conexiones
            while(keepgoing){
                display("Servidor esperando por el cliente en el puerto : " + port + " . ");
                //aceptando conexiones
                Socket socket = serversocket.accept();
                if(!keepgoing){
                    break;
                   
                    
                }
                 ClienteThread t = new ClienteThread(socket);
                 al.add(t);
                 t.start();
                 try{
                     //cuando se detiene el servidor
                     serversocket.close();
                     for(int i = 0; i < al.size(); ++i){
                         ClienteThread tc = new ClienteThread(socket);
                         tc.in.close();
                         tc.os.close();
                         tc.socket.close();
                         
                     }
                 }catch(IOException e){
                     System.out.println("Error no se puede cerrar al cliente");
                     System.out.println(e.getMessage());
                 
                 }
            }
        }catch(IOException e){
            System.out.println("Nadie te quiere, solo juguito contigo again");
            System.out.println(e.getMessage());
        }
    }
    
    //detener el servidor
    protected void stop(){
        keepgoing = false;
        try{
            new Socket ("localhost", port);
        }catch(Exception e){
            System.out.println("No se quiere mudar el server");
            System.out.println(e.getMessage());
        
        }
    }

    private void display(String msg) {
        String tiempo = fecha.format(new Date() + " " + msg);
        System.out.println(tiempo);
    }
    
    //sincronizar los mensajes 
    private synchronized boolean broadcast(String mensaje){
        String tiempo = fecha.format(new Date());
        
        //checar los mensajes privados entre los clientes
        String[] escribir = mensaje.split(" ", 3);
        
        boolean esprivado = false;
        if(escribir[1].charAt(0) == '@' ){
            esprivado = true;
        }
        
        //si es privado el mensaje 
        if(esprivado == true){
            String tocheck = escribir[1].substring(1, escribir[1].length());
            
            mensaje = escribir[0] + escribir[2];
            
            String mensajepriv = tiempo + " " + mensaje + "\n";
            
            boolean encontrar = false;
            
            for(int y=al.size(); --y>=0;  ){
                ClienteThread ct1 = al.get(y);
                String check = ct1.getusername();
                if(check.equals(tocheck)){
                    //vamos a escribir dentro del cliente las rmaas que se han eliminado
                    if(!ct1.writeMsg(mensajecliente)){
                        al.remove(y);
                        display("Se desconecto el cliente " + ct1.username + " se elimino de lista  ");
                    }
                    encontrar = true;
                    break;
                }
                if(encontrar != true){
                    return false;
                }
                else{
                    String mensajecliente = fecha + " " + mensaje + "\n";
                    System.out.println(mensajecliente);
                    
                    for(int i = al.size(); --i>=0;){
                        ClienteThread ct = al.get(i);
                        if(!ct.writeMsg(mensajecliente)){
                            al.remove(i);
                            display("Se desconecto el cliente " + ct.username + "se elimino de la lista");
                        }
                    }
                }
                
            } 
            
            
        }
        return true;
    }
    
    //la sincronizacion del mensaje cuando se va el cliente
    synchronized void remove(int id){
        String desconectadoCliente = "";
        
        for(int i = 0; i < al.size(); ++i){
            ClienteThread ct = al.get(i);
            //si encuentro al cliente que eliminar
            if(ct.id == id){
                desconectadoCliente = ct.getusername();
                al.remove(i);
                break;
            }
        }
        broadcast(notificaciones + desconectadoCliente + "Se fue del chat");
    }
    
    //al fin el main T_T
    public static void main(String[] args){
        int numeropuerto = 1500;
        
        switch (args.length) {
            case 1:
                try{
                    numeropuerto = Integer.parseInt(args[0]);
                }catch(Exception e){
                    System.out.println("Puerto invalido");
                    return;
                }
            case 0:
                break;
            default:
                System.out.println("Usa el puerto: " + numeropuerto);
                return;
        }
        Servidor server = new Servidor(numeropuerto);
        server.start();
    }
    
    //declarar la clase para que ya no mas error
    
    class ClienteThread extends Thread{
        Socket socket;
        ObjectInputStream in;
        ObjectOutputStream os;
        int id;
        String username;
        //objeto para los mensajes ChatMessage
        ChatMessage cm;
        String dato;
        
        
        //constructor
        public ClienteThread(Socket socket){
            id = ++uniqueID;
            this.socket = socket;
            System.out.println("Creacion del Hilo de los flujos Input/Output");
            try{
                in = new ObjectInputStream(socket.getInputStream());
                os = new ObjectOutputStream(socket.getOutputStream());
                username = (String)in.readObject();
                //me faltaria saber si se conecto para obtener la notificacion 
            }catch(IOException e){
                System.out.println("Error al conectar");
                System.out.println(e.getMessage());
            }catch(ClassNotFoundException ce){
                System.out.println("Error al no se encuentra la clase");
                System.out.println(ce.getMessage());
            }
            dato = new Date().toString() + "\n";
        }
        
        public String getusername(){
            return username;
        }
        
        public void setusername(String username){
            this.username = username;
        }
        
        //vamos a crear el bucle para el hilo del cliente
        public void run(){
            boolean keepgoing = true;
            while(keepgoing){
                try{
                    cm = (ChatMessage)in.readObject();
                }catch(IOException e){
                    display(username + "Error al leer el flujo " + e);
                    System.out.println(e.getMessage());
                    break;
                
                }catch(ClassNotFoundException ec){
                    System.out.println("Error no se encuentra la clase");
                    System.out.println(ec.getMessage());
                    break;
                
                }
                String mensajes = cm.getMessage();
                
                switch (cm.getType()) {
                    case ChatMessage.MESSAGE:
                        boolean confirmacion = broadcast(username+ " : " + mensajes);
                        if(confirmacion == false){
                            String msg = notificaciones + " No hay mas mensajes "+ notificaciones;
                            writeMsg(msg);
                        }
                        break;
                    case ChatMessage.LOGOUT:
                        display(username + " Se ha desconectado ayos ");
                        keepgoing = false;
                        break;
                    case ChatMessage.WHOISIN:
                        writeMsg("Se ha conectado un nuevo participante: " + fecha.format(new Date()) + "\n");
                        //hay que mandarlo a todos
                        for(int i = 0; i < al.size(); ++i){
                            ClienteThread ct = al.get(i);
                            writeMsg((i+1) + ")" + ct.username + " desde " +ct.dato);
                        }
                        break;
                        
                }
                remove(id);
                close();
            }
            
            
            }
        
        private void close(){
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
        
        private boolean writeMsg(String msg){
            if(!socket.isConnected()){
                close();
                return false;
            }
            try{
                os.writeObject(msg);
            }catch(IOException e){
                display(notificaciones + "Error al enviar el mensaje " + username + notificaciones);
                display(e.toString());
            }
            return true;
        }
        
        
    }
    
}
