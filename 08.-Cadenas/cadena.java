
import java.util.Scanner;


public class cadena{

    Scanner entrada = new Scanner(System.in);

    /*
    Vamos a empezar a jugar con cadenas 
    */

    public void cadenas(){

        String s1 = "Hola habia una vez un patito que decia miau miau";

        //obtener la longitud de la cadena

        System.out.println("El tamanio de la cadena es: " + s1.length());

        //si comienza con .....

        System.out.println("La cadena inicia V o F con Hola?" + s1.startsWith("Hola"));

        //si termina con ...

        System.out.println("La cadena termina V o f con gato?" + s1.endsWith("gato"));


        //vamos a leer una variable
        System.out.println("Ingrese una palabra: ");
        String s2 = entrada.nextLine();
        System.out.println("La palabra es: " + s2);


        //vamos a obtener subcadenas de la primera cadena

        System.out.println("Parte de una subcadena de s1: "+ s1.indexOf("tito"));


        //vamos a sustraer una palabra de una cadena

        System.out.println("Primera parte: " + s1.substring(12));
        System.out.println("Segunda parte: " + s1.substring(3, 11));

        //convertir una variable de la cadena
        int valor = 24;

        String s3 = String.valueOf(valor);

        System.out.println("El valor es de : " + s3 + "como cadena");

        /*
        cadena         int  
        2 + 2 = 22    2 + 2 = 4
        */

        //convertir una cadena a un numero

        String s4 = "20";

        int numero = Integer.parseInt(s4);

        System.out.println("El valor es de: " + numero + "ahora es un numero");

        //convertir cadena a un decimal

        String s5 = "20.89";

        Double numero1 = Double.parseDouble(s5);

        System.out.println("La cadena: " + s5 );

        System.out.println("El valor es de: " + numero1 + "ahora es un double");

        numero1 = numero + numero1;

        System.out.println("El resultado es: " + numero1);

        //metodo toString conviernte un entero a una cadena

        Integer x = 5;

        System.out.println("El valor de :" + x.toString() + "ahora es una cadena");

        System.out.println("El valor de " + Integer.toString(12) + "ahora es una cadena");



    }
}