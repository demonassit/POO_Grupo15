

import java.util.Scanner;


public class Ejercicios{
    /*
    Vamos a hacer un ejemplo donde tengamos un menu con 4 opciones:

    1 .- es una calculadora
    2.- conversion de unidades
    3.- creacion de cuadros
    4.- Movimiento en cuadro
    
    */


    Scanner entrada = new Scanner(System.in);

    char op;

    //metodos propios de la clase
    //un metodo es una operacion o una accion que puede realizar una clase

    public void menu(){
        //menu del programa
        

        System.out.println("Ejercicios por yo, elija una opcion deseada: ");
        System.out.println("a.- Calculadora");
        System.out.println("b.- Conversion de unidades");
        System.out.println("c.- Creacion de cuadros");
        System.out.println("d.- Movimiento en cuadro");
        System.out.println("Cualquier otra opcion sale del programa");

        op = entrada.next().charAt(0);

        //la estructura que se necesita es: 

        switch(op){
            case 'a':
                //implementar metodos independientes para cada opcion
                Ejercicio1();
                break;

            case 'b':
                Ejercicio2();
                break;

            case 'c':
                Ejercicio3();
                break;

            case 'd':
                Ejercicio4();
                break;

            default: 
                System.out.println("Gracias por jugar");
        }
    }


    public void Ejercicio1(){
        /*
        La calculadora sera maizoro suma resta multicion y division
        */

        double numero1 = 0.00, suma = 0.00, multi = 1.00;
        char operacion;

        System.out.println("Selecciona la operacion que deseas realizar:");
        System.out.println("a. Suma y Resta");
        System.out.println("b. Multiplicacion");
        System.out.println("c. División");

        operacion = entrada.next().charAt(0);

        switch (operacion) {
            case 'a' :
                //suma y resta
                do{
                    //meter tantos numeros como quiera sumar o restar hasta que ponga 0
                    System.out.println("Para detener la operacion presiona 0");
                    System.out.println("Escriba los numeros que desee sumar o restar");
                    numero1 = entrada.nextDouble();

                    suma += numero1;
                    //suma = suma + numero1;

                }while(numero1 != 0);

                System.out.println("El resultado es: " + suma);
                
                break;
            
            case 'b' :
                do{
                    System.out.println("Para detener la operacion digite 0");
                    System.out.println("Escriba los numeros que desee multiplicar:");
                    numero1 = entrada.nextDouble();

                    if(numero1 > 0){
                        multi *= numero1;
                   }else{
                       System.out.println("Error solo con positivos");
                   }

                }while(numero1 != 0);
                System.out.println("El resultado es: " + multi);

                break;

            case 'c' :

                double r, aux, aux2;
                int aux3 = 0;

                do{
                    System.out.println("Ingresa el dividendo: ");
                    aux = entrada.nextDouble();
                    //do
                    System.out.println("Ingresa el divisor");
                    //deben de hacer la modificion para poder leer que no sea 0 y que vuelva a solicitar el divisor
                    aux2 = entrada.nextDouble();
                    //condicion

                    r = aux/aux2;

                    System.out.println("El resultado es: "+ r);

                }while(aux3 != 0);
                break;
        
            default:
                System.out.println("Opcion no valida. ayos");
                break;
        }
    }

    public void Ejercicio2(){
        /*
        Vamos a crear un programa que convierta de:
        metros a cm y pulgadas
        kg a libras y gramos
        m/s a km/s
        */

        double metros = 0.00,  kilogramos = 0.00, velocidad = 0.00, cm = 100.00, pulgada = 39.37, gramos = 1000.00, libra = 2.20, ms = 0.00;
        double a, b;
        System.out.println("Seleccione la cantidad que desee convertir: ");
        System.out.println("a. Metros a cm y pulgadas");
        System.out.println("b. Kilogramos a libras y gramos");
        System.out.println("c. m/s a km/h");

        op = entrada.next().charAt(0);

        switch (op) {
            case 'a':
                System.out.println("Ingrese los metros: ");
                metros = entrada.nextDouble();
                //metros a cm
                a = metros*cm;
                //metros a pulgadas 
                b = metros*pulgada;

                System.out.println("La cantidad en metros es: " + metros + " de m a cm son : " + a 
                + " de m a pulgadas son: " + b);
                break;

            case 'b':
                System.out.println("Ingrese los kilogramos: ");
                kilogramos = entrada.nextDouble();
                //kg a g
                a = kilogramos*gramos;
                //kg a lbs 
                b = kilogramos*libra;

                System.out.println("La cantidad en kilogramos es: " + kilogramos + " de kg a g son : " + a 
                + " de kg a libras son: " + b);


                break;
            
            case 'c':
                System.out.println("Ingrese la velocidad en m/s: ");
                ms = entrada.nextDouble();
                //ms a km/h
                a = ms*(3600/1000);
                

                System.out.println("La conversion de m/s a km/h es de: " + a);

                break;
        
            default:
                System.out.println("Opcion no valida");
                break;
        }
        

    }

    public void Ejercicio3(){
        /*
        Vamos a realizar un programa que se encargue de imprimir con * 
        un cuadrado de maximo 1000 de dimension
        */

        int n, m=0;

        do{
            System.out.println("Ingrese el numero de asteristicos que desea que tenga el cuadro: ");
            n = entrada.nextInt();

            //no debe de estar entre 1 y mil
            if( n<0 || n>1000){
                System.out.println("El cuadro no acepta ni negativos ni mayores a 1000");
            }else{
                //cuando si esta en el rango
                for(int i = 1; i<=n; i++){
                    System.out.print("*");
                }
                System.out.println();

                for(int i = 0; i< n-2; i++){
                    System.out.print("*");
                    for(int j = 0; j < n-2; j++){
                        System.out.print(" ");
                    }
                    System.out.println("*");
                }

                for(int i = 1; i<=n; i++){
                    System.out.print("*");
                }
                System.out.println();

            }
            //salir de ese bucle infinito :3 que se quiebren la cabezita un ratito
        }while(m==0);

    }

    public void Ejercicio4(){
        //

        /*
        Quiero que se imprima una figura de la siguiente forma:


        ***********
        ///////////
        ***********
        ///////////
        **********
        //////////

        Hasta cubrir el tamaño de un cuadrado
        2 x 2

        **
        //


        3 x 3

        ***
        ///
        ***
        
        
        
        */

    }
}