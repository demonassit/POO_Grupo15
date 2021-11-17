

import java.util.*;


public class arreglosMatriz{

    public static void main(String[] args){
        /*
        Vamos a realizar un arreglo unidimensional
        y recorreclo para ver que hay dentro de cada elemento
        */
        //arreglo unidimensional
        //tipo de dato   nombre   tamanio
        //int arreglo[] = new int[10];

        //vamos a recorrerlo

        //for(int i = 0; i<arreglo.length; i++){
        //    System.out.println("Magia: " + arreglo[i]);
        //}

        //bidimensional

        Scanner entrada = new Scanner(System.in);

        int matriz[][] = new int[3][3];

        //vamos a sumar las filas del arreglo y sacar el promedio 

        float sumarFilas = 0;

        //filas
        //ingresar los valores a mi matriz
        for(int i = 0; i < matriz.length; i++){
            //System.out.println(i);
            //columnas
            for(int j = 0; j < matriz.length; j++){
                //System.out.println(j);
                //vamos a llenar la matriz
                System.out.println("Ingresa el valor de la fila: " 
                + i + " Ingresa el valor de la columna : " + j +" ");

                //vamos a ver la posicion
                matriz[i][j] = entrada.nextInt();

            }
        }


        //vamos a realizar la operacion de la suma y promedio
        for(int i = 0; i < matriz.length; i++){

            for(int j = 0; j < matriz.length; j++){
                sumarFilas += matriz[i][j];
                //sumarFilas = sumarFilas + matriz[i][j];
                System.out.println(String.format("%d", matriz[i][j]));
            }
            System.out.println(String.format("\n Suma de las filas %f, Promedio de la fila %.2f", sumarFilas, sumarFilas/matriz.length));
        }
    }

    /*
    Para el primero

    solo es un

    if(num > 0){
        positivo y lo guardo en un arreglo
    }else{
        negativo y lo guardo en otro arreglo
    }
    */ 
}
