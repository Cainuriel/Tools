/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros_directorios;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cainuriel
 */
public class Ficheros_directorios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Directorios ejemplo = new Directorios();
       ejemplo.sobredirectorios();
       Creando crear = new Creando();
       crear.creacionArchivos();
        

    
    }
}

class Directorios {
    
    
    public void sobredirectorios () {
    // si no se especifica una ruta, por defecto, es la misma que el proyecto. 
        File archivo = new File("Ejemplo_archivo");
        System.out.println(archivo.getAbsolutePath());
        // existe el archivo?
        System.out.println(archivo.exists());
        
// como imprimir lo que contiene una carpeta
// File.separator es la barra separadora, tanto "/" como "\" que difiere en 
// diferentes SSOO. Colocando esta constante de clase nos aseguramos que puede
// usarse con cualquiera.
       File carpetatools = 
                new File("C:"+File.separator+"Users"+File.separator+
                        "cainu"+File.separator+"OneDrive"+File.separator+
                        "Documents"+File.separator+"Tools"+File.separator+
                        "Tools");
            
            String contenido [] = carpetatools.list();
            
            // se imprime el contenido.
            for (String s: contenido) {
                System.out.println("Carpetas del directorio: "+s);
// vamos a imprimir el contenido de todos los directorios. para ello debemos
//almacenar las rutas de cada carpeta. usaremos el constructor con "padre e hijo".
            File f = new File(carpetatools.getAbsolutePath(),s);
            
            if (f.isDirectory()) {
                String arraysubcarpeta [] = f.list();
                for (String str: arraysubcarpeta) {
                    System.out.println("Subcarpeta: ");
                    System.out.println(str);
                }
            }
            
    }
            
    }
}

class Creando {
    
    public void creacionArchivos() {
        
       
            File creandocarpeta =
                    new File("C:"+File.separator+"Users"+File.separator+
                            "cainu"+File.separator+"OneDrive"+File.separator+
                            "Documents"+File.separator+"Tools"+File.separator+
                            "Tools"+File.separator+"Carpetacreadaconcodigo");
            // metodo que crea la carpeta con el nombre escrito anteriormente.
            creandocarpeta.mkdir();
            
            File creandoarchivo =
                    new File("C:"+File.separator+"Users"+File.separator+
                            "cainu"+File.separator+"OneDrive"+File.separator+
                            "Documents"+File.separator+"Tools"+File.separator+
                            "Tools"+File.separator+"Carpetacreadaconcodigo"+
                            File.separator+"archivocreadodesdecodigo.txt");
            
            
            
          try {   creandoarchivo.createNewFile();
        } catch (IOException ex) {
            System.out.println("Error en la creacion del archivo");
        }
          
          String rutadelarchivo = creandoarchivo.getAbsolutePath();
          
          Escribiendo escribir = new Escribiendo();
          escribir.escribir(rutadelarchivo);
          
          
         
        
    }
    /**
     * clase privada creada para escribir en el archivo.
     */
     private class Escribiendo {
         
         public void escribir(String ruta) {
             
             String texto = "Texto escrito desde codigo.";
             
             try {
                 FileWriter escribiendo = new FileWriter(ruta);
                 
                 for (int i=0; i<texto.length(); i++) {
                 escribiendo.write(texto.charAt(i)); }
                 
                 escribiendo.close();
             } catch (IOException e){
                 System.out.println("Error al escribir la frase en el archivo");
                 
             }
             
         }
              
          }
          
}
