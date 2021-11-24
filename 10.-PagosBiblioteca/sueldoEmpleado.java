/*
21 - 40

Obtener los pagos correspondientes a los trabajadores

ingresar el nombre del trabajador
sueldo
tipo de trabajador

*/ 


import javax.swing.*;
import java.util.*;


public class sueldoEmpleado(){

    private int ID_empleado, num_horas;
    private String nombre, appat, appatmat;
    private Double sueldo;


    public void MenuEmpleado(){

        String text;

        text = JOptionPane.showInputDialog("Selecciona la opcion deseada:"
                                        + "\n 1.- Agregar nuevo empleado"
                                        + "\n 2.- Consultar empleado por ID"
                                        + "\n 3.- Consultar todos los empleados"
                                        + "\n 4.- Pagar al empleado por ID");

        /*
        
        Primero debo de tener una clase llamada Empleado

        Quiero 5 Empleados 

        Si elijo 1 
        Se debe de ingresar id, num_horas que trabaja, nombre, appat, appmat, sueldo por hr

        Si elijo 2
        Se debe de tener un metodo en el cual se va a buscar por el ID

        public int buscaridempleado(int id)

        Si elijo 3
        Debo de imprimir la informacion de todos los empleados

        Si elijo 4
        VOy a tener dos opciones
        1 pago quincenal
            sueldo y el num de horas * 15 y que aparezca la informacion del empleado + el pago
        2 pago mensual
            sueldo y el num de horas * 30 y que aparezca la informacion del empleado + el pago
        */
    }
}