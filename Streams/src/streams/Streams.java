/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streams;

import java.io.*;
import java.util.logging.*;

/**
 * lectura y escritura de archivos externos. 
 * @author cainuriel
 */

class escribirArchivo {
    
    public void escribir() {
        
        String frase = "Frase de prueba que se introducirá en un archivo creado desde código ";
        
        try {
    // el parametro booleano determina sobre-escritura en el archivo si lo encuentra. Es decir, si no existe        
    // lo crea, y si existe, re-escribe sobre el. 
            FileWriter creararchivo = new FileWriter("C:/Users/cainu/archivocreadodesdecodigo.txt",true);
           
            // creamos el bucle que introducira la frase letra por letra en el archivo.
            
            for (int i=0; i<frase.length();i++) {
                
                creararchivo.write(frase.charAt(i));
            }
            // no olvidar cerrar el flujo de datos.
            creararchivo.close();
            
            
        } catch (IOException ex) {
            System.out.println("No se ha podido crear el archivo correctamente");
        }
        
    }
    
    
}

public class Streams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LecturaArchivo lectura = new LecturaArchivo();
        lectura.leerarchivos();
        
        escribirArchivo escribir = new escribirArchivo();
        escribir.escribir();
        

    }

}

class LecturaArchivo {

    // se inicializa fuera para que se tenga acceso al objeto en todo lugar.
    FileReader archivo;

    public void leerarchivos() {

        try {
            archivo = new FileReader("C:/Users/cainu/OneDrive/Documents/Tools/Tools/streams.txt");

            // guardamos el caracter de entrada del fichero. si es -1 se ha acabado el archivo.
            int caracter = archivo.read();

            // que pinte cada caracter que vaya leyendo mientras no sea el final
            while (caracter != -1) {
                // hacemos un casting para convertir el numero en una letra
                char letra = (char) caracter;
                System.out.print(letra);
                caracter = archivo.read();
            }

            // colocamos la excepcion IO para capturar los dos errores. el del FileReader y el del metodo read()
        } catch (IOException ex) {
            System.out.println("No se ha encontrado el archivo  o error de lectura");
        } finally {
            try {
                // siempre hay que cerrar el flujo de datos
                archivo.close();
            } catch (IOException ex) {
                System.out.println("No se ha podido cerrar el flujo de datos");
            }

        }

    }

}
