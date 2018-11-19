/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamsdebytes;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sun.security.krb5.Confounder.bytes;

/**
 *
 * @author cainuriel
 */
public class Streamsdebytes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
           leerimagen lectura = new leerimagen();
           int [] arraydatos = lectura.lecturaimagen();
           lectura.construyeImagen(arraydatos); 
           
           Serializar lecturaobjeto = new Serializar();
           lecturaobjeto.serializando();
           lecturaobjeto.lecturaSerial();
        
    }
    
}

class leerimagen {
    int [] bytesimagen;
      
      public int [] lecturaimagen() {
          
          int contador = 0;
          bytesimagen = new int[55489];
          
          try {
              FileInputStream cargarimagen = new  FileInputStream("C:/Users/cainu/OneDrive/Documents/Tools/Tools/foto.jpg");
              boolean finaldelarchivo = false;
              
              while (!finaldelarchivo) {
                  
                  int bytedelarchivo = cargarimagen.read();
                  
                  
                  if (bytedelarchivo != -1) {
                      bytesimagen[contador] = bytedelarchivo;
                      
                  } else {     
                      finaldelarchivo = true; }
                   System.out.println(bytesimagen[contador]);
                  contador++;
                 
                  
              }
              
              
              cargarimagen.close();
              
              
          } catch (IOException ex) {
              System.out.println("Error en la lectura de la imagen");
          }
          
          return bytesimagen;
          
      }
      
      public void construyeImagen(int arraydatos [])  {
          // array de bytes para cargar la imagen en el caso de querer hacerlo asi. 
          byte [] arraydebytes = new byte[55489];
          
          try {
              FileOutputStream imagen = 
                      new FileOutputStream("C:/Users/cainu/OneDrive/Documents/Tools/Tools/nuevafoto.jpg");
            
                for (int i =0; i< arraydatos.length; i++) {
                  imagen.write(arraydatos[i]); 
                 // se podria hacer transformando los datos a bytes....
                 //arraydebytes[i] = (byte) arraydatos[i];
                  
                
            }  
                // y despues cargar el array de bytes directamente...
               // imagen.write(arraydebytes);
              imagen.close();
          } catch (IOException e) {System.out.println("Fallo en el montaje de imagen");}
          
          
          
      }
}

/**
 * 
 * @author cainuriel
 * la serializacion es preparar un objeto para que pueda ser enviado como stream.
 * para el ejemplo usaremos un array de strings. pero puede realizarse con cualquier
 * objeto.
 */
class Serializar implements Serializable {
    
    /** los programas tienen todos un numero identificador. Si este identificador no se fija, una
     * actualizacion del programa, genera otro diferente. suponiendo que el receptor del stream
     * tenga una version antigua, entonces no podra leer el stream al tener el serialVersionUID
     * diferente. 
     * Para evitar todo esto. Nosotros generamos la matricula, que por defecto suele ser: 1L.
     *
     * 
     */
    private static final long serialVersionUID = 1L;
    
    String [] arraystrings = {"este","array","es para ","serializar"};
    
    /**
     * preparando un array de Strings para serializar como stream. fichero exterior. 
     */
    public void serializando() {
        try {
            ObjectOutputStream serializador =
                    new ObjectOutputStream(
                            new FileOutputStream("C:/Users/cainu/OneDrive/Documents/Tools/Tools/objeto_serializado.dat")
                    );
            serializador.writeObject(arraystrings);
            serializador.close();
        } catch (IOException e) {
            System.out.println("Fallo en la serializacion");
        }
    }
    
    /**
     * leyendo un stream que es un objeto. en este caso un array String. 
     */
    public void lecturaSerial() {
        String [] array = new String[10];
         try {
            ObjectInputStream lecturastream =
                    new ObjectInputStream(
                            new FileInputStream("C:/Users/cainu/OneDrive/Documents/Tools/Tools/objeto_serializado.dat")
                    );
 // la lectura del flujo de datos del objeto devuelve un objeto de clase Objeto...
 // Se tiene que hacer un catch para transformarlo en el tipo del objeto. en este caso array String.
            array =(String[])lecturastream.readObject();
            lecturastream.close();
        } catch (Exception e) {
            System.out.println("Fallo en la serializacion");
        }
         
         for (String s: array) {
             System.out.println(s);
             
         }
    }
        
    }

    
    



