/*
 *Aprendiendo a sincronizar hilos para que no comience uno ANTES de
otro. 
 */
package sincronizandohilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cainuriel
 */
public class SincronizandoHilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        sincronizablesHilos hilo1 = new sincronizablesHilos();
        sincronizablesHilos hilo2 = new sincronizablesHilos();
        sincronizablesHilos hilo3 = new sincronizablesHilos();
        hilo1.start();
        
        Sincronizador sincroniza1 = new Sincronizador(hilo1);
        sincroniza1.run();
 
        hilo2.start();
        System.out.println("Esto aparece despues de ejecutarse el primer \n"
                + "hilo. Porque? Por que el main dispone de su propio hilo \n"
                + "de ejecucion y no espera a que termine el segundo.");
        
        Sincronizador sincroniza2 = new Sincronizador(hilo2);
        sincroniza2.run();
        
        hilo3.start();
        System.out.println("La secuenciación \n"
                + "de los hilos paralelos, sirve para que el hilo principal, éste \n"
                + "que escribe esto, sea el único simultáneo con los demás hilos.");

    }

}

class sincronizablesHilos extends Thread {

    @Override
    /**
     * metodo de la interface Runnable que se ha de rellenar con la
     * actividad del hilo. 
     */
    public void run() {

        for (int i = 0; i < 15; i++) {
            System.out.println(" Ejecutando hilo: " + getName());
            try {
                sleep(700);
            } catch (InterruptedException ex) {
                System.out.println("Cuando duermes un metodo no puedes \n"
                        + "detenerlo.");
            }
        }

    }

}
/**
 * Clase que sincroniza hilos.
 * @author cainu
 */
class Sincronizador extends Thread {

    Thread hilo;
    /**
     * 
     * @param hilo a sincronizar.
     */
    public Sincronizador(Thread hilo) {

        this.hilo = hilo;

    }

    public void run() {
        try {
            hilo.join();
        } catch (InterruptedException ex) {
            System.out.println("Fallo en la sincronizacion");
        }
    }

}
