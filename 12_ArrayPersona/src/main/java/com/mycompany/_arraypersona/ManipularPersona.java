/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._arraypersona;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author demon
 */
public class ManipularPersona {
    
    Scanner entrada = new Scanner(System.in);
    
    int opcion;
    
    //instancia de la clase controladorpersona
    ControladorPersona crud = new ControladorPersona();
    
    
    //metodo principal del menu
    
    public void Principal(){
        do{
            System.out.println("Bienvenido a NetBeans");
            System.out.println("Por favor elige una opcion del siguiente menu: "
                    + "\n 1.- Mostrar lista del Personal"
                    + "\n 2.- Registrar una nueva Persona"
                    + "\n 3.- Editar los datos de una persona"
                    + "\n 4.- Borrar el registro de una persona"
                    + "\n 5.- Salir");
            opcion = entrada.nextInt();
            
            switch (opcion) {
                case 1:
                    ArrayList<Persona> listadepersonas = crud.mostrarPersonas();
                    //recorro el objeto de personas para mostrarlo
                    for(Persona objeto : listadepersonas){
                        System.out.println("El id: " + objeto.getId()
                                           + " El nombre es: " + objeto.getNombre()
                                           + " La edad es: " + objeto.getEdad()+"\n");
                    }
                    break;
                case 2:
                    System.out.println("ingresa el id de la persona: ");
                    int idpersona = entrada.nextInt();
                    System.out.println("Ingresa el nombre de la persona");
                    String nombrepersona = entrada.nextLine();
                    System.out.println("Ingresa la edad de la persona");
                    int edadpersona = entrada.nextInt();
                    
                    //enviar los nuevos datos a mi listadepersonas
                    Persona nuevapersona = new Persona(idpersona, nombrepersona, edadpersona);
                    
                    crud.registrarPersona(nuevapersona);
                    
                    break;
                    
                case 3: 
                    //primero busco
                    System.out.println("Ingresa el ID de la persona que desea actualizar: ");
                    int id = entrada.nextInt();
                    
                    Persona personaSeleccionada = crud.buscarPersona(id);
                    
                    //mostrar los datos
                    System.out.println("La informacion de la persona es: ");
                    System.out.println("Id: " + personaSeleccionada.getId()
                                        + "\n Nombre: " + personaSeleccionada.getNombre()
                                        + "\n Edad: " + personaSeleccionada.getEdad() + "\n");
                    
                    //ingreso los cambios
                    
                    System.out.println("Ingresa el nuevo nombre para el registro: ");
                    String nuevonombre = entrada.nextLine();
                    System.out.println("Ingresa la nueva edad para el registro: ");
                    int nuevaedad = entrada.nextInt();
                    
                    //envio los datos nuevos
                    personaSeleccionada.setNombre(nuevonombre);
                    personaSeleccionada.setEdad(nuevaedad);
                    
                    crud.actualizarPersona(personaSeleccionada);
                    
                    break;
                    
                case 4:
                    System.out.println("Ingresa el ID de la persona a borrar: ");
                    int ideliminar = entrada.nextInt();
                    
                    Persona personaEliminar = crud.buscarPersona(ideliminar);
                    
                    crud.eliminarPersona(personaEliminar);
                    
                    System.out.println("Registro eliminado");
                    break;
                case 5: 
                    System.exit(1);
                    break;
                    
                default:
                    System.out.println("Digite una opcion valida");
            }
        
        }while(opcion != 5);
    }
    
}
