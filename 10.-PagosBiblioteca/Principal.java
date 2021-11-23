/*

Vamos a realizar un programa mediante el cual el usuario pueda gestionar
los pagos de los libros atrasados de la biblioteca

*/


//librerias
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Principal{


    int choice;
        String text_menu;
        
        

    public static void main(String[] args){
        String text;
        int opciones=0;

    /*
    Vamos a visualizar en una interfaz pequeña las opciones del menu
    */
        //menu
        //instancia
        Principal mainp = new Principal();

        //ciclo para que el menu se repita y sea visible para el usuario
        do{
            mainp.MenuP();
            text = JOptionPane.showInputDialog("En caso de que desee regresar al menu principal digite 1");
            opciones = Integer.parseInt(text);

        }while(opciones == 1);



    }

    public void MenuP(){
        String text;
        int opciones =0;
        //los metodos void (vacios), son porque no reciben ningun parametro

        //excepciones
        try{
            //es para ingresar texto
            text = JOptionPane.showInputDialog("Seleccione el programa a ejecutar de la siguiente lista: "
                    + "\n 1.- Consultar el sueldo Personal." 
                    + "\n 2.- Costos y Proveedores."
                    + "\n 3.- Prestamo y devolucion de libros");
                    // cuando se utiliza JOptionPane solo se reciben cadenas
                    //voy a convertir esa cadena en un entero
                    opciones = Integer.parseInt(text);

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Para acceder a un programa solo se puede ingresar los numeros del 1 al 3");
            //vamos a obtener el error, es visible para el usuario
            JOptionPane.showMessageDialog(null, " "+e.getMessage());
            //si solo queremos imprimir el error en consola
            System.out.println("El erro es: " + e.getMessage());

        }


        switch (opciones) {
            case 1:
                //metodo
                break;

            case 2:
                //metodo
                break;
            
            case 3:
                //metodo
                break;
        
            default:
                JOptionPane.showMessageDialog(null, "Vuelva pronto");
                break;
        }
    }

    



}