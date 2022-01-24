/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author demon
 */
public class MainThread {
    
    public static void main(String[] args){
        Cliente cliente1 = new Cliente("Cliente Michael", new int[]{2,2,1,5,2});
        Cliente cliente2 = new Cliente("Cliente Mario", new int[]{2,1,1,5,1});
        Cliente cliente3 = new Cliente("Cliente Diana", new int[]{8,1,1,7,3});
        
        
        long initialTime = System.currentTimeMillis();
        
        
        CajeraHilo cajero1 = new CajeraHilo("Cajero Cesar", cliente1, initialTime);
        CajeraHilo cajero2 = new CajeraHilo("Cajero Dionisio", cliente2, initialTime);
        CajeraHilo cajero3 = new CajeraHilo("Cajera Pancha", cliente2, initialTime);
        
        cajero1.start();
        cajero2.start();
        cajero3.start();
        
    } 
    
}
