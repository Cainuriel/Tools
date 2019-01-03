/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usothreads;

import java.awt.geom.*;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsoThreads {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        JFrame marco = new MarcoRebote();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        marco.setVisible(true);

    }

}

//Movimiento de la pelota-----------------------------------------------------------------------------------------
class Pelota {

    // Mueve la pelota invirtiendo posición si choca con límites
    public void mueve_pelota(Rectangle2D limites) {

        x += dx;

        y += dy;

        if (x < limites.getMinX()) {

            x = limites.getMinX();

            dx = -dx;
        }

        if (x + TAMX >= limites.getMaxX()) {

            x = limites.getMaxX() - TAMX;

            dx = -dx;
        }

        if (y < limites.getMinY()) {

            y = limites.getMinY();

            dy = -dy;
        }

        if (y + TAMY >= limites.getMaxY()) {

            y = limites.getMaxY() - TAMY;

            dy = -dy;

        }

    }

    //Forma de la pelota en su posición inicial
    public Ellipse2D getShape() {

        return new Ellipse2D.Double(x, y, TAMX, TAMY);

    }

    private static final int TAMX = 15;

    private static final int TAMY = 15;

    private double x = 0;

    private double y = 0;

    private double dx = 1;

    private double dy = 1;

}

// Lámina que dibuja las pelotas----------------------------------------------------------------------
class LaminaPelota extends JPanel {

    //Añadimos pelota a la lámina
    public void add(Pelota b) {

        pelotas.add(b);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLACK);
            for (Pelota b : pelotas) {
                g2.fill(b.getShape());
            if (g2.getColor() == Color.BLACK) {
                g2.setColor(Color.RED);
            } else if (g2.getColor() == Color.RED) {
                g2.setColor(Color.BLUE);
            } else {
                g2.setColor(Color.BLACK);
            }

        }
    }

    private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
}

//Marco con lámina y botones------------------------------------------------------------------------------
class MarcoRebote extends JFrame {

    public MarcoRebote() {

        setBounds(600, 300, 400, 350);

        setTitle("Rebotes");

        lamina = new LaminaPelota();

        add(lamina, BorderLayout.CENTER);

        JPanel laminaBotones = new JPanel();

        ponerBoton(laminaBotones, "Dale!", new ActionListener() {

            public void actionPerformed(ActionEvent evento) {

                comienza_el_juego();
            }

        });

        ponerBoton(laminaBotones, "Salir", new ActionListener() {

            public void actionPerformed(ActionEvent evento) {

                System.exit(0);

            }

        });

        // boton que detiene el hilo activado. 
        ponerBoton(laminaBotones, "Detener", new ActionListener() {

            public void actionPerformed(ActionEvent evento) {

                detener();

            }

        });

        add(laminaBotones, BorderLayout.SOUTH);
    }

    //Ponemos botones
    public void ponerBoton(Container c, String titulo, ActionListener oyente) {

        JButton boton = new JButton(titulo);

        c.add(boton);

        boton.addActionListener(oyente);

    }

    //Añade pelota y la bota 1000 veces. Como lo realiza a gran
    // velocidad, tendremos que generar una pausa. 
    public void comienza_el_juego() {

        Pelota pelota = new Pelota();

        lamina.add(pelota);

        // creamos un objeto Runnable
        Runnable r = new hiloPelota(pelota, lamina);
        // a continuacion para crear el hilo paralelo activamos el objeto
        // de la clase Thread. pasandole por argumento el objeto runnable
        // instanciado en la linea anterior.
        hilo = new Thread(r);

        // activamos el hilo con el metodo start()
        hilo.start();

        // nos llevamos el bucle a la clase que implementa el hilo paralelo.
        /*for (int i = 1; i <= 3000; i++) {

            pelota.mueve_pelota(lamina.getBounds());

            lamina.paint(lamina.getGraphics());
            
            // para generar la pausa, usamos el metodo Sleep de la clase
            // Thread. Argumento en minisegundos y es necesario capturar
            // la excepcion. 
            try {
                Thread.sleep(4);
            } catch (InterruptedException ex) {
                Logger.getLogger(MarcoRebote.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        } */
    }

    public void detener() {
        hilo.interrupt();

        // paradojicamente el metodo stop() depreciado si detiene
        // sin problemas al hilo pero no lo podemos usar.
        //hilo.stop();
    }
    // esta variable es creada como campo de clase para que pueda ser
    // utilizada por ambos metodos: comienza_el_juego y detener.
    private Thread hilo;
    private LaminaPelota lamina;

}

// clase que implementa la interface Runnable para generar el hilo paralelo.
class hiloPelota implements Runnable {

    // args: un objeto pelota y la lamina en donde rebota. 
    public hiloPelota(Pelota p, Component l) {
        pelota = p;
        componente = l;
    }
    private Pelota pelota;
    private Component componente;

    @Override
    public void run() {
        for (int i = 1; i <= 3000; i++) {

            pelota.mueve_pelota(componente.getBounds());

            componente.paint(componente.getGraphics());

            // para generar la pausa, usamos el metodo Sleep de la clase
            // Thread. Argumento en minisegundos y es necesario capturar
            // la excepcion. 
            try {
                Thread.sleep(4);
            } catch (InterruptedException ex) {
                // como usamos el metodo sleep para interrumpir un hilo que
                // esta dormido, tendremos que disparar en la excepion la 
                //instruccion de deteccion.
                // currentThread nos da un objeto referencia Thread, que puede
                //  interrumpirse. 
                Thread.currentThread().interrupt();
            }

        }

    }

}
