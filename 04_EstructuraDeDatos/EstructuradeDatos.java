/*
Vamos a crear un programa que se encargue de realizar las siguientes operaciones

1.- Bono o descuento por edad
2.- Convertir numeros decimales a binarios
3.- Convertir temperaturas celcius, kelvine y rankine
4.- Numero de positivos y negativos segun una lista de numeros
5.- Tiendita peke
6.- Area y Perimetro de figuras geometricas
7.- Tabla
8.- Factorial
9.- Dibujitos de codigo
10.- Figuras huecas de codigo
11.- Patrones de codigos
12.- Diamante de codigo
13.- Calculadora
14.- Salir


*/ 

import java.util.Scanner;

class EstructuradeDatos{

    //Programa 1
    /*
    EL PROGRAMA DEBE SOLICITAR LA EDAD DEL USUARIO. SI ÉSTA ES MAYOR DE 65, 
    AL PRECIO DEL ABONO SE LE APLICA UN DESCUENTO DEL 40%. 
    SI LA EDAD ES MENOR QUE 21, SE PREGUNTA AL USUARIO SI SUS PADRES SON 
    SOCIOS. SI LA RESPUESTA ES AFIRMATIVA, SE LES APLICA UN DESCUENTO DEL 
    45%; EN CASO CONTRARIO, SE LES APLICA UN 25%. 

    variable edad
    condiciones
    */ 

    public static void main(String[] args){

        //objetos
        Scanner entrada = new Scanner(System.in);
        //Scanner socio = new Scanner(System.in);


        //variables
        int edad, opcion, socio;
        double precio, bono;


        //cuerpo del programa

        //menu de las opciones de arriba

        System.out.println("Bienvenido a tu primer programa de estructuras.");
        System.out.println("Por favor elija la opcion deseada:");
        System.out.println("1.- Descuento por edad");
        System.out.println("2.- Convertir numero decimal a binario");
        System.out.println("3.- Conversiones de temperatura");
        System.out.println("4.- Numeros positivos y negativos");
        System.out.println("5.- Tienda");
        System.out.println("6.- Area y Perimetros");
        System.out.println("7.- Tabla");
        System.out.println("8.- Factorial");
        System.out.println("9.- Dibujos de codigo");
        System.out.println("10.- Figura Hueca");
        System.out.println("11.- Patrones de codigo");
        System.out.println("12.- Diamente");
        System.out.println("13.- Calculadora");
        System.out.println("14.- Salir");

        //condicion switch para el menu

        opcion = entrada.nextInt();


        switch(opcion){

            case 1: //problema 1
                System.out.println("Ingresa el Bono A cobrar");
                bono = entrada.nextDouble();
                System.out.println("Ingresa la edad");
                edad = entrada.nextInt();
                //la estructura de condiciones
                // SI ÉSTA ES MAYOR DE 65, AL PRECIO DEL ABONO SE LE APLICA UN DESCUENTO DEL 40%.
                if(edad >= 65){
                    //proceso
                    bono = bono*.6;
                    System.out.println("Su descuento es de 40%");
                    System.out.println("El total a pagar es de: " + bono);
                }
                /*
                SI LA EDAD ES MENOR QUE 21, SE PREGUNTA AL USUARIO SI SUS PADRES SON 
    SOCIOS. SI LA RESPUESTA ES AFIRMATIVA, SE LES APLICA UN DESCUENTO DEL 
    45%; EN CASO CONTRARIO, SE LES APLICA UN 25%. 
                */ 
                if(edad <= 21){
                    System.out.println("Si tus padres son socios ingresa 1, sino lo son ingresa 2");
                    socio = entrada.nextInt();

                    switch(socio){
                        case 1: 
                            bono = bono*.55;
                            System.out.println("Su descuento fue del 45%");
                            System.out.println("El total a pagar es de: " +bono);
                            break;
                        case 2: 
                            bono = bono*.75;
                            System.out.println("Su descuento fue del 25%");
                            System.out.println("El total a pagar es de: " +bono);
                            break;
                        default:
                        //es el caso por defecto osea los demas casos
                            System.out.println("Opcion no valida");

                    }
                }
                System.out.println("Tu edad es de: " + edad);
                System.out.println("El total a pagar es: " + bono);
                break;

                case 2:


                case 3:

                case 4:

                case 5:

                case 6:

                case 7: 

                case 8:

                case 9:


                case 10:

                case 11:

                case 12:

                case 13:

                default:
                    System.out.println("Gracias por ver este hermoso programa :3");



        }
    }
}