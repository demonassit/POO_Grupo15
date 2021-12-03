/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._ejemploserializacion;

/**
 *
 * @author demon
 */

import java.io.*;
import java.util.*;
import javax.swing.*;

public class Funciones {
    
    //variables y objetos
    ArrayList<Persona> listapersonas = new ArrayList();
    String rep = "si";
    String nombre = "";
    int edad, numero_empleado, bol;
    
    //vamos aplicar el polimorfismo
    Persona profesor = new Profesor();
    
    Persona alumno = new Alumno();
    
    //menu
    
    void menu(){
    
        //ciclo infinito
        while(true){
            //ciclo para repetirlo
            while(rep.equalsIgnoreCase("si")){
                //mis excepciones
                try{
                    String var = JOptionPane.showInputDialog("Ingresa la Opcion deseada: \n"
                            + "1.- Registrar nuevo Profesor."
                            + "2.- Registrar nuevo Alumno."
                            + "3.- Consultar Alumnos"
                            + "4.- Salir.");
                    
                    if(var == null){
                        System.exit(0);
                    }
                    
                    int opcion = Integer.parseInt(var);
                    
                    switch (opcion) {
                        case 1:
                            //metodos
                            pedirDatosProfesor();
                            //asignar los datos del profesor
                            profesor = new Profesor(numero_empleado, nombre, edad);
                            //para guardarlo
                            guardarProfesor();
                            break;
                        
                        case 2:
                            pedirDatosAlumno();
                            alumno = new Alumno(bol, nombre, edad);
                            guardarAlumno();
                            break;
                        
                        case 3:
                            //metodo para leer a los alumnos
                            leerAlumno();
                            break;
                        default:
                            System.out.println("Opcion no valida");
                    }
                    rep = JOptionPane.showInputDialog("¿Desea repetir?");
                
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                
                }
            }
        }
        
    }

    private void pedirDatosProfesor() {
        //obtener todos los datos para el registro del profesor
        numero_empleado = Integer.parseInt(
                JOptionPane.showInputDialog("Ingresa el numero de empleado:"));
        nombre = JOptionPane.showInputDialog("Ingresa el nombre del profesor");
        edad = Integer.parseInt(
                JOptionPane.showInputDialog("Ingresa la edad del profesor"));
        
    }

    private void guardarProfesor() throws IOException {
        //agregamos al objeto de la lista de personas el objeto profesor
        listapersonas.add(profesor);
        //el metodo para que se guarde
        guardar();
    }

    private void pedirDatosAlumno() {
        //obtener todos los datos para el registro del profesor
        bol = Integer.parseInt(
                JOptionPane.showInputDialog("Ingresa la boleta del alumno:"));
        nombre = JOptionPane.showInputDialog("Ingresa el nombre del alumno");
        edad = Integer.parseInt(
                JOptionPane.showInputDialog("Ingresa la edad del alumno"));
    }

    private void guardarAlumno() throws IOException {
        //agregamos al objeto de la lista de personas el objeto alumno
        listapersonas.add(alumno);
        //el metodo para que se guarde
        guardar();
    }
    //aplicamos la serializacion porque tenemos que leer el archivo de los alumnos
    private void leerAlumno() throws FileNotFoundException, IOException, ClassNotFoundException {
        
        //hay que definir la entrada del archivo o fichero
        FileInputStream archivo = new FileInputStream("archivo.dat");
        //generamos la lectura del buffer de los objetos
        ObjectInputStream entrada = new ObjectInputStream(archivo);
        //existe esa transformacion del objeto a los bytes
        //casteo del tipo de dato o de la variable
        listapersonas = (ArrayList)entrada.readObject();
        
        //como tenemos que saber cuantos objetos de alumno hay y sus valores
        //si es una variable obtener el tamaño es .lentgh
        //si es un objeto .size
        
        for(int i = 0; i<listapersonas.size(); i++){
            //para poder recorrer necesitamos a un obj de tipo persona
            
            Alumno obj = (Alumno)listapersonas.get(i);
            //sacamos solo la informacion de los alumnos
            JOptionPane.showMessageDialog(null, "\n"
                    + "Numero de Alumno: " + (i+1) + "\n"
                    + "Boleta: " + obj.getBoleta() + "\n"
                    + "Nombre: " + obj.getNombre() + "\n"
                    + "Edad: " + obj.getEdad() + "\n"
                    + "Tipo de Persona: " + obj.tipoPersona() +"\n");
        }
        
    }

    private void guardar() throws FileNotFoundException, IOException {
        //para guardar es lo mismo para alumnos que para profesores al final son objetos
        
        FileOutputStream archivo = new FileOutputStream("archivo.dat");
        //definimos el buffer para la salida de los objetos
        ObjectOutputStream salida = new ObjectOutputStream(archivo);
        
        salida.writeObject(listapersonas);
        salida.close();
    }
    
}
