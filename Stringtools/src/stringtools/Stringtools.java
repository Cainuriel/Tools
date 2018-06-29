/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringtools;

/**
 *
 * @author cainu
 */
public class Stringtools {
    
    /** Si se desea recortar un String en base a dos caracteres y no 
     * a través de una palabra. 
     * @param original cadena a cortar, z caracter final, a caracter inicial.
     * @return cadena recortada
     */
        public static String cortarStringconchar(String original, String z, String a ) {
        String substitution;
        String recorte;
       // el ultimo punto marca el final del nombre, sabiendo que no habra mas.
      int lastpoint = original.lastIndexOf(z);
      // como hay mas de un guion bajo sustituimos el primero por un simbolo unico
      substitution=original.replaceFirst("_","&");
      // ahora lo buscamos, al simbolo, sabiendo que el ultimo sera el primero al n0 haber mas
      int firstpoint = substitution.lastIndexOf(a);
      // se recorta segun esten las posiciones, sumando uno a la primera posicion.
      recorte = substitution.substring(firstpoint+1, lastpoint);
        
        return  recorte;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Se saca el nombre del archivo, sabiendo que está entre el primer _ y el último punto. 
         String actual = "1231231223123131_FILE_NAME.EXTENSION.OTHEREXTENSION";
         /**
          * podemos encontrar el ultimo caracter, pero no el primero de una serie
          * repetida de caracteres. por ese motivo introducimos un caracter unico,
          * para cambiarlo por el primero de los caracteres repetidos que nos da el primer corte
          * el segundo lo marca el ultimo caracter de los puntos, suerte en este caso, por
          * eso lo introducimos tranquilamente por parametro
          */
        System.out.println(cortarStringconchar(actual,".","&"));
    }
    
}
