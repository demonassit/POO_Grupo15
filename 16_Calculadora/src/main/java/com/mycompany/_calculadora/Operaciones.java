/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._calculadora;

/**
 *
 * @author demon
 */
public class Operaciones {
    
    /*
    Vamos a realizar una calculadora maizoro
    + - * /
    */
    
    private double num1;
    private double num2;
    
    public Operaciones(){
    }

    public Operaciones(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    
    

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }
    
    //crear los metodos de la operacion
    
    public double suma(){
        return num1 + num2;
    }
    
    public double resta(){
        return num1 - num2;
    }
    
    public double producto(){
        return num1 * num2;
    }
    
    public double division(){
        return num1 / num2;
    }
    
}
