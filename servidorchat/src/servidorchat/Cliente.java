/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorchat;

import java.applet.AudioClip;
import java.net.*;
import java.io.*;
import java.util.Scanner;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Cliente {

    private Socket socket;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    Scanner teclado = new Scanner(System.in);
    final String COMANDO_TERMINACION = "..salir";
    private File sound1 =new File("sounds/mensaje.wav");
    private File sound2 =new File("sounds/pop.wav");

    public void establecerConexion(String ip, int puerto) {
        try {
            socket = new Socket(ip, puerto);
            mostrarTexto("\033[33m\n Conectado a :" + socket.getInetAddress().getHostName());
            mostrarTexto("\033[33mPara cerrar su conversacion. escriba: '..salir'");
            
            playSound(sound1);
            
            
        } catch (ConnectException e) {
            System.out.println(" ...esperando a su interlocutor... ");
            establecerConexion(ip, puerto);

        } catch (Exception e) {
            mostrarTexto("\n Error al establecer la conexión: " + e.getMessage());

        }
    }

    public static void mostrarTexto(String s) {
        System.out.println("\033[33m" + s);
    }

    public void abrirFlujos() {
        try {
            bufferDeEntrada = new DataInputStream(socket.getInputStream());
            bufferDeSalida = new DataOutputStream(socket.getOutputStream());
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en la apertura de flujos");
        }
    }

    public void enviar(String s) {
        try {
            bufferDeSalida.writeUTF(s);
            bufferDeSalida.flush();
        } catch (Exception e) {
            mostrarTexto("Error al enviar los datos, o no hay nadie conectado. ");
        }
    }

    public void cerrarConexion() {
        try {
            bufferDeEntrada.close();
            bufferDeSalida.close();
            socket.close();
            mostrarTexto("Conexión finalizada");
        } catch (IOException e) {
            mostrarTexto("IOException al  cerrar la Conexion()");
        } finally {
            System.exit(0);
        }
    }

    public void Conectando(String ip, int puerto) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    establecerConexion(ip, puerto);
                    abrirFlujos();
                    recibirDatos();
                } finally {
                    cerrarConexion();
                }
            }
        });
        hilo.start();
    }

    public void recibirDatos() {
        String st = "";
        try {
            do {
                st = (String) bufferDeEntrada.readUTF();
                mostrarTexto("\n" + "\033[32m[Fernando] => " + st);
                playSound(sound2);
                System.out.print("\n" + "\033[33m[Cristina] => ");
            } while (!st.equals(COMANDO_TERMINACION));
        } catch (IOException e) {
        }
    }

    public void escribirDatos() {
        String entrada = "";
        while (true) {
            System.out.print("\n" + "\033[33m[Cristina] => ");
            entrada = teclado.nextLine();
            if (entrada.length() > 0) {
                enviar(entrada);
            }
        }
    }

    public static void main(String[] argumentos) {
        Cliente cliente = new Cliente();
        Scanner escaner = new Scanner(System.in);
        mostrarTexto("Ingresa la IP: [localhost por defecto] ");
        String ip = escaner.nextLine();
        if (ip.length() <= 0) {
            ip = "localhost";
        }

        mostrarTexto("Puerto: [5050 por defecto] ");
        String puerto = escaner.nextLine();
        if (puerto.length() <= 0) {
            puerto = "5050";
        }
        cliente.Conectando(ip, Integer.parseInt(puerto));
        cliente.escribirDatos();
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
    
