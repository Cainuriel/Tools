/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capturarexcepciones;

import javax.swing.JOptionPane;

/**
 *
 * @author cainu
 */
public class CapturarExcepciones {


    public static void dividir() {
        
        try {
        int uno = Integer.parseInt(JOptionPane.showInputDialog("introduce dividendo"));
        int dos = Integer.parseInt(JOptionPane.showInputDialog("introduce divisor"));
        
        System.out.println("El resultado es: "+ uno/dos); }
        catch (ArithmeticException e){
            
            System.out.println("No se puede dividir por cero. Reinicie el Programa");
            // getClass nos devuelve la clase de excepcion. 
            System.out.println("El error es de tipo: "+ e.getClass());
            
        
        } catch (NumberFormatException e) {
            System.out.println("Introduzca numeros enteros por favor. Reinicie el programa");
        // nos informa del error, con un mensaje que explica la excepcion
            System.out.println(e.getMessage());
            // nos da el nombre del error getName. 
            System.out.println(e.getClass().getName());
        } // la clausula finally ejecuta codigo ocurra la excepcion o no. 
        finally {
            System.out.println("Yo siempre salgo gracias a la clausula finally");
        }
        
                
    }
    
    
    public static void main(String[] args) {
       
        dividir();
        
    }
    
}
