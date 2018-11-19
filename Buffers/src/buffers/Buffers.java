/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buffers;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cainuriel
 */
public class Buffers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        leerBuffer lecturabuffer = new leerBuffer();
        lecturabuffer.lectura();
        escribirBuffer escritura = new escribirBuffer();
        escritura.escrituraconbuffer();

    }

}

class leerBuffer {

    FileReader archivo;

    public void lectura() {
        try {
            archivo = new FileReader("C:/Users/cainu/OneDrive/Documents/Tools/Tools/lecturaconbuffer.txt");

            BufferedReader buffer = new BufferedReader(archivo);

            String lineadelectura = "";
            lineadelectura = buffer.readLine();

            // que lea hasta que no encuentre mas limeas
            while (lineadelectura != null) {
                System.out.println(lineadelectura);
                lineadelectura = buffer.readLine();

            }

        } catch (IOException ex) {
            System.out.println("Error en la lectura del archivo");
        } finally {
            try {
                archivo.close();
            } catch (IOException ex) {
                System.out.println("No se ha podido cerrar el flujo de datos");
            }
        }

    }

}

class escribirBuffer {

    FileWriter archivoescritura;

    public void escrituraconbuffer() {
        try {
            // el booleano sobre-escribe en el documento, o en caso contrario crea uno nuevo. 
            archivoescritura = new FileWriter("C:/Users/cainu/OneDrive/Documents/Tools/Tools/creadoconbuffer.txt", false);

            BufferedWriter buffer = new BufferedWriter(archivoescritura);

            String linea1 = "Probando creacion de un documento de texto de varias lineas";
            String linea2 = "Para ello utilizaremos un buffer";
            String linea3 = "Y estamos experimentado como hacerlo";

            buffer.write(linea1);
            buffer.newLine();
            buffer.write(linea2);
             buffer.newLine();
            buffer.write(linea3);
            buffer.close();

        } catch (IOException ex) {
            System.out.println("Error en la escritura del archivo");
        } finally {
            try {
                archivoescritura.close();
            } catch (IOException ex) {
                System.out.println("No se ha podido cerrar el flujo de datos");
            }
        }

    }

}
