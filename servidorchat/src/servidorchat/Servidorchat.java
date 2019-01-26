/*
 *Sencillo Chat por consola. 

 */
package servidorchat;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



 class Servidor {

    private Socket socket;
    private ServerSocket serverSocket;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    Scanner escaner = new Scanner(System.in);
    final String COMANDO_TERMINACION = "..salir";
    private File sound1 =new File("sounds/mensaje.wav");
    private File sound2 =new File("sounds/pop.wav");

    public void establecerConexion(int puerto) {
        
        try {
            serverSocket = new ServerSocket(puerto);
            mostrarTexto("Esperando conexión entrante en el puerto " + String.valueOf(puerto) + "...");
            socket = serverSocket.accept();
            mostrarTexto("Conexión establecida con: " + socket.getInetAddress().getHostName() + "\n");
            
            playSound(sound1);
            
        } catch (Exception e) {
            mostrarTexto("Error al crear la conexion(): " + e.getMessage());
            System.exit(0);
        }
    }
    public void flujos() {
        try {
            bufferDeEntrada = new DataInputStream(socket.getInputStream());
            bufferDeSalida = new DataOutputStream(socket.getOutputStream());
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en la creación de los flujos" + e.getMessage());
        }
    }

    public void recibirDatos() {
        String st = "";
        try {
            do {
                st = (String) bufferDeEntrada.readUTF();
                mostrarTexto("\n"+"\033[33m[Cristina] => " + st);
                playSound(sound2);
                System.out.print("\n"+"\033[32m[Fernando] => "); 

            } while (!st.equals(COMANDO_TERMINACION));
        } catch (IOException e) {
            System.out.println("\033[32mConexión cerrada. ");
            cerrarConexion();
        }
    }


    public void enviar(String s) {
        try {
            bufferDeSalida.writeUTF(s);
            bufferDeSalida.flush();
        } catch (Exception e) {
            mostrarTexto("No hay nadie conectado... ...espere. \n " + e.getMessage());
        }
    }

    public static void mostrarTexto(String s) {
        System.out.print("\033[32m"+s);
        
    }

    public void escribirDatos() {
        while (true) {
            System.out.print("\n"+"\033[32m[Fernando] => ");
            enviar(escaner.nextLine());   
        }
    }

    public void cerrarConexion() {
        try {
            bufferDeEntrada.close();
            bufferDeSalida.close();
            socket.close();
        } catch (IOException e) {
          mostrarTexto("Excepción al  cerrar la Conexion. " + e.getMessage());
        } finally {
            mostrarTexto("Conversación finalizada....");
            System.exit(0);

        }
    }

    public void Conectando(int puerto) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        establecerConexion(puerto);
                        flujos();
                        recibirDatos();
                    } finally {
                        cerrarConexion();
                    }
                }
            }
        });
        hilo.start();
    }

    public static void main(String[] args) throws IOException {
        Servidor s = new Servidor();
        Scanner sc = new Scanner(System.in);
        mostrarTexto("\033[32mIngresa el puerto [5050 por defecto]: ");
        String puerto = sc.nextLine();
        if (puerto.length() <= 0) puerto = "5050";
        s.Conectando(Integer.parseInt(puerto));
        s.escribirDatos();
    }
    
        public static void playSound(File sound) {
        
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
            
            Thread.sleep(clip.getMicrosecondLength()/1000);
        } catch (Exception e) {
            System.out.println("Fallo en el sonido: "+e.getMessage());
            
        }
        
    }
}