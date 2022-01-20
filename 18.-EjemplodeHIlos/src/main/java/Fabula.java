/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author demon
 */
public class Fabula {
    
    public static void main(String[] args){
        
        Tortuga tortugui = new Tortuga();
        Liebre tony = new Liebre();
        
        //inicializar el hilo
        tortugui.start();
        tony.start();
    }
    
}
