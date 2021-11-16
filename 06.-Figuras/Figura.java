

import java.util.Scanner;
import java.lang.Math;

public class Figura{

    //variables globales
    double lado, altura, area, perimetro, lado2, lado3, diametro, base;
    int opcion;
    char letra;

    //objeto
    Scanner entrada = new Scanner(System.in);


    public void menu(){
        /*
        Vamos a realizar un programa que se encargue de realizar el calculo
        del area y perimetro de:
        cuadrado
        triangulo
        circulo
        */
        do{
            System.out.println("Programa de calculo de area y perimetro.");
            System.out.println("Elija la opcion deseada: ");
            System.out.println("1.- Cuadrado");
            System.out.println("2.- Triangulo");
            System.out.println("3.- Circulo");
            System.out.println("4.- Salir");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    calcularCuadrado();             
                    break;

                case 2:
                    calcularTriangulo();                
                    break;

                case 3:
                    calcularCirculo();                
                    break;
            
                default:
                    System.out.println("Gracias hasta la proxima");
                    break;
            }
            System.out.println("Desea repetir el programa? S para repetir");
            letra = entrada.next().charAt(0);

        }while(letra == 's' || letra == 'S');
    }

    public void calcularCuadrado(){
        //do
        try{
            System.out.println("Ingrese el valor del lado del cuadrado: ");
            //do
            lado = entrada.nextDouble();
            perimetro = lado*4;
            area = lado*lado;
            System.out.println("El perimetro es de : " +perimetro + " y su area es de: " + area);
        }catch(Exception e){
            System.out.println("Ingresa unicamente valores numericos");
            System.out.println("Error: " + e.getMessage());

        }
        
        
    }

    public void calcularTriangulo(){
        System.out.println("Ingrese 1 para el area y 2 para el perimetro");
        opcion = entrada.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ingresa la base del triguangulo: ");
                base = entrada.nextDouble();
                System.out.println("Ingresa la altura del triangulo: ");
                altura = entrada.nextDouble();
                area = (base*altura)/2;
                System.out.println("El area es de :" +area);              
                break;
            case 2:
                System.out.println("Ingresa el primer lado del triangulo: ");
                lado = entrada.nextDouble();
                System.out.println("Ingresa el segundo lado del triangulo: ");
                lado2 = entrada.nextDouble();
                System.out.println("Ingresa el tercer lado del triangulo: ");
                lado3 = entrada.nextDouble();
                perimetro = lado + lado2 + lado3;
                System.out.println("El perimetro es de: "+ perimetro);
                break;
        
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    public void calcularCirculo(){
        System.out.println("Ingrese 1 para el area y 2 para el perimetro");
        opcion = entrada.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ingresa el radio del circulo: ");
                lado = entrada.nextDouble();

                //pi*r*r
                area = Math.PI*lado*lado;
                System.out.println("El area es de :" +area);

                
                break;
            case 2:
                System.out.println("Ingresa el diametro del circulo: ");
                diametro = entrada.nextDouble();
                perimetro = 3.1416*diametro;

                System.out.println("El perimetro es de: "+ perimetro);
                break;
        
            default:
            System.out.println("Opcion no valida");
                break;
        }

    }
}