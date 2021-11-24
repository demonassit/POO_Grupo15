/*

41 - 60

Las funciones de la biblioteca 

prestamo de libros

*/ 

import java.util.Scanner;
import java.util.*;
import javax.swing.*;

public class Biblioteca{

    //vamos a crear un objeto para poder introducir los datos
    Scanner entrada = new Scanner(System.in);

    /*
    Vamos a realizar el 
    Variables
    Autor, Titutlo, ISBN, Genero, 
    Ejemplares, Costo del prestamo
    //metodos
    prestamo de libros
    Devolucion de libros
    */

    String titulo, autor, isbn, genero;
    int ejemplares;
    double costo_prestamo, total;


    public void Libros(){
        //menu para el prestamo del libro

        //agregar el try catch para el manejo de errores
        //identificar si son variables publicas o privadas para el manejo de los datos
        String text;

        text = JOptionPane.showInputDialog("Elija la funcion que desea ejecutar: "
                                + "\n 1.- Prestamo del libro"
                                + "\n 2.- Devolucion del libro");

        int opcion;

        opcion = Integer.parseInt(text);

        switch (opcion) {
            case 1:

                Prestamo();
                
                break;

            case 2:

                Devolucion();

                break;
            default:

                JOptionPane.showInputDialog("Gracias por usar el programa de Prestamos de Libros");
                break;
        }
    }

    public void Prestamo(){
        /*
        Lo primero es que deberan de crear los objetos de Libros
        Donde cada uno de ustedes debera de tener 5 Libros diferentes
        Se debera de precargar la informacion del libro

        Primero se debe de crear la clase Libro
        Libro drama = new Libro("La cumbre escarlata", "No me lo se", "12345-BN", 5);
        Libro fantasmas = new Libro("Las cronicas Mutantes", "No me lo se", "00345-BN", 3);
        
        Segundo
        Tiene que aparecer la lista de todos los libros
        
        Tercero
        Ingrese el titulo que desea para su prestamo, y la cantidad de libros la debes de ir registrando
        porque se debe de preguntar, si desea agregar otro titlo

        Cuarto
        Se debe de visualizar los datos del libro que se presto y quedan x cantidad de existencias
        
        */ 

    }

    public void Devolucion(){

        /*
        Primero 

        Buscar en el sistema el libro que se presto

        Segundo 
        
        Cambiar el estado de ese prestamo -> Volver a sumar la cantidad del ejemplar

        Tercero

        Visualizar los datos del libro de nuevo
        */
    }
}


