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
        //Scanner letras = new Scanner(System.in);


        //variables
        int edad, opcion, socio, numbinario, total, numerototal, n, a, b;
        int positivos = 0;
        int negativos = 0;
        double precio, bono;
        char letras, operacion;
        float precios = 0;
        float resultado = 0;
        int cantidad = 0; 
        String binario = "";


        //cuerpo del programa

        //menu de las opciones de arriba

        do{

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

                    System.out.println("Ingrese un numero positivo entero que desee convertir a binario");
                    numbinario = entrada.nextInt();
                    /*
                    Tengo que comprobar que sea positivo?
                    condicion donde numbinario > 0
                    entonces aplico el algoritmo de convertir a binario
                    sino no se puede convertir
                    */ 

                    if(numbinario > 0){
                        /*
                        Como el algoritmo para convertir un numero decimal en binario
                        aplicar al numbinario mod 2
                        */
                        while(numbinario > 0){
                            if(numbinario % 2 == 0){
                                binario = "0" + binario;
                            }else{
                                binario = "1" + binario;
                            }
                            numbinario = (int)numbinario / 2;
                        }
                    }else if (numbinario == 0){
                        binario = "0";
                    }else{
                        binario = "No se pudo convertir el numero, ingrese solo positivos.";
                    }
                    System.out.println("El numero convertirdo a binario es: " + binario);
                    break;


                case 3:
                    //tarea

                case 4:

                    /*
                    Un numero positivo y un num negativo
                    entonces para poder identificar si un numero positivo o negativo
                    debo de poder diferenciar si es 
                    num > 0
                    */ 

                    System.out.println("Inserte ¿cuantos numeros va a ingresar?");
                    total = entrada.nextInt();

                    do{
                        System.out.println("Inserte el numero");
                        numerototal = entrada.nextInt();

                        //condicion
                        if(numerototal == 0){
                            //contar cuantos positivos hubo
                            //vamos a ir acumulando el numero de positivos
                            positivos = positivos + 0;

                        }else{
                            if(numerototal > 0){
                                positivos = positivos +1;
                            }else{
                                negativos = negativos +1;
                            }
                        }

                        //saber el total
                        total = total-1;



                    }while(total != 0);

                    System.out.println("El total de positivos es: "+ positivos);
                    System.out.println("El total de negativos es: "+ negativos);

                    break;

                case 5:
                    System.out.println("¿Cuantos elementos vas a ingresar?");
                    total = entrada.nextInt();

                    for(int i = 1; i <= total; i++){
                        System.out.println("Ingresa el Precio producto");
                        precios = entrada.nextFloat();
                        System.out.println("Ingresa el Cantidad del Producto");
                        cantidad = entrada.nextInt();

                        resultado = precios * cantidad;
                    }

                    System.out.println("El resultado es: " + resultado);

                case 6:
                    //tarea

                case 7: 
                    for(n = 1; n<= 10; n++){
                        System.out.println(n + " " + (n*10)+ " " + (n*100) + " " + (n*1000));
                    }
                    break;

                case 8:
                    //tarea de ustedes
                    /*
                    introduce el digito
                    for (num ; iterador >0; i--)
                    factorial = factorial * iterador
                    
                    
                    while(num == 1){
                        factorial = factorial - 1
                    }


                    */ 

                case 9:
                    /*
                    ESCRIBA UN PROGRAMA QUE LEA EL LADO DE UN CUADRADO Y A CONTINUACIÓN LO IMPRIMA 
                    EN FORMA DE ASTERISCOS SU PROGRAMA DEBERa PODER FUNCIONAR PARA CUADRADOS 
                    DE TODOS TAMAÑOS ENTRE 1 Y 20. 
                    */

                    System.out.println("Cuadrado Magico");
                    System.out.println("Inserta el num de lados: ");
                    n = entrada.nextInt();

                    if( n>= 1 && n <=20){
                        //se puede imprimir
                        //aqui tengo las filas
                        for(int i = 1; i<=n; i++){
                            //columnas
                            for(int j = 1; j<=n; j++){
                                System.out.print("* ");

                            }
                        System.out.println(" ");


                            
                        }
                    }else{
                        System.out.println("Error, el rango debe de ser entre 1 y 20, intente de nuevo");
                    }

                    break;



                case 10:

                    System.out.println("Cuadrado Magico Hueco (Como tu ex asi dejo tu kokoro wiiii)");
                    System.out.println("Inserta el num de lados: ");
                    n = entrada.nextInt();

                    if( n>= 1 && n <=20){
                        //se puede imprimir

                        //imprima la linea superior
                        for(int i = 0; i < n; i++){
                            System.out.print(" * ");
                        }
                        System.out.println();

                        //lo de enmedio solo quiero las esquinas
                        //cuadrado interno
                        //aqui tengo las filas
                        for(int i = 0; i < n-2; i++){
                            System.out.print(" * ");
                            //columnas
                            for(int j = 0; j < n-2; j++){
                                System.out.print("  ");

                            }
                        System.out.println("   * ");


                            
                        }

                        //imprimir la linea inferior
                        for(int i = 0; i < n; i++){
                            System.out.print(" * ");
                        }
                        System.out.println();
                    }else{
                        System.out.println("Error, el rango debe de ser entre 1 y 20, intente de nuevo");
                    }

                    break;

                case 11:
                    //tarea

                case 12:
                    //tarea

                case 13:

                    System.out.println("Calculadora maizsoro");
                    System.out.println("Ingresar un número");
                    a = entrada.nextInt();
                    System.out.println("Ingresa un segundo número");
                    b = entrada.nextInt();
                    System.out.println("Ingresa el tipo de operacion que deseas realizar : (+ , -, *, /)");
                    operacion = entrada.next().charAt(0);

                    /*
                    switch 
                        case +
                        case -
                        case *
                        case /
                    */ 

                    switch(operacion){
                        case '+' :
                            resultado = a+b;
                            System.out.println("La suma es de: " + resultado);
                            break;
                        case '-' :
                            resultado = a-b;
                            System.out.println("La resta es de: " + resultado);
                            break;
                        case '*' :
                            resultado = a*b;
                            System.out.println("La multiplicación es de: " + resultado);
                            break;
                        case '/' :
                            if(b != 0){
                                resultado = a/b;
                                System.out.println("La división es de: " + resultado);
                               
                            }else{
                                System.out.println("No es posible dividir entre 0");
                            }
                            break;
                        default :
                            System.out.println("Operación no valida");

                    }

                default:
                    System.out.println("Gracias por ver este hermoso programa :3");



        }
    
        System.out.println("¿Deseas repetir el programa? Si lo desea escriba s");
        /*
            para recibir la respuesta debo de obtener un caracter s
            para cuando se reciben char se utiliza ''
            para cuando se reciben String se utiliza ""
        */ 
    
        letras = entrada.next().charAt(0);
    
        //si el usuario ingresa si  solo detecto la s  es la posicion del caracter que queremos lee
    
    
    
    
    }while(letras == 's');
    //aqui se cierra el do

   

    }

}