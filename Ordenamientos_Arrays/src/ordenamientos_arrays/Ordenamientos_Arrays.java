/*
 * Ordenando arrays. en este caso de integers. 
 */
package ordenamientos_arrays;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author cainuriel
 */
public class Ordenamientos_Arrays {

    public int[] BubleOrder(int[] array) {
        int aux;
        // restamos uno para el ordenamiento no necesitamos llegar al final. 
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                // Es mayor el primer numero respecto al segundo?
                if (array[j] > array[j + 1]) {
                    // entonces lo intercambiamos usando el numero auxiliar. 
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;

                }

            }

        }
        return array;

    }
    /**
     * 
     * @param array lista que sera ordenada con el uso de un puntero.
     * @return  lista ordenada
     */
    public int [] OrderInsertion (int [] array) {
        int puntero;
        int elemento_punteado;
        for (int i = 0; i < array.length; i++) {
            puntero = i;
            elemento_punteado = array[i];
            
            /**
             * el puntero viajara de izquierda a derecha comparando el tamanyo
             * del numero de la izquierda con el mismo. Asi necesitamos que el 
             * puntero se salte la posicion 1, y saber si el numero de la izquierda
             * es mayor que el mismo. 
             */
            while (puntero > 0 && (array[puntero-1] < elemento_punteado)) {
                array[puntero] = array[puntero - 1];
                puntero--;
                
                
            }
            array[puntero] = elemento_punteado;
            
        }
        
        
        
        return array;
    }

    public void PrintArray(int[] array) {
        
        for (int i= 0; i< array.length; i++) {
            System.out.println("elemento nº "+ i +": "+ array[i]);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int array[];
        Scanner entrada = new Scanner(System.in);
        int n_elements = Integer.parseInt(JOptionPane.showInputDialog("Numero de objtos del array?"));
        array = new int[n_elements];

        for (int i = 0; i < n_elements; i++) {
            System.out.println("Introduzca elemento nº " + (i+1));
            array[i] = entrada.nextInt();
        }

        Ordenamientos_Arrays ordenar = new Ordenamientos_Arrays();
       /* array = ordenar.BubleOrder(array);
        ordenar.PrintArray(array); */
        
        System.out.println("____ORDEN POR INSERCION____");
        
        ordenar.OrderInsertion(array);
        ordenar.PrintArray(array);
        
    }

}
