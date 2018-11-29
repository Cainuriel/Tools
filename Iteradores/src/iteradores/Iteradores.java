/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteradores;

import java.util.*;

import javax.swing.*;

/**
 *
 * @author cainuriel creamos el juego de la ruleta rusa para practicar el uso de
 * la iteración.
 *
 */
public class Iteradores {

    public static void main(String[] args) {

        Ruletarusa partida = new Ruletarusa();
        partida.prepararPistola();
        partida.partida();
        partida.disparar();

    }

}

class Ruletarusa {

    int i = 0;
    ArrayList<String> pistola = new ArrayList<String>();
    boolean turno = true;
    Iterator<String> tambor;

    public void prepararPistola() {
        while (i <= 5) {
            pistola.add("vacio");
            i++;
        }
        
        int posicion = (int) (Math.random() * 6);
        pistola.set(posicion, "bala");
    }

    public void partida() {

        int opcion = JOptionPane.showConfirmDialog(null, "¿Preparado para jugar?");

        if (opcion == 0) {
            JOptionPane.showMessageDialog(null, "metemos la bala y giramos el bombo");
        } else {
            System.exit(0);
        }

        JOptionPane.showMessageDialog(null, "Cada cual pone mil euros. quien sobreviva"
                + " se llevará toda la pasta, ¿ok? A continuación sorteamos quien será"
                + " el primero en disparar");

        int sorteo = (int) ((Math.random() * 100));

        if (sorteo % 2 == 0) {
            JOptionPane.showMessageDialog(null, "Comienzas tu, jejejejeje");

        } else {
            JOptionPane.showMessageDialog(null, "Comienzo yo... ..joder...");
            turno = false;
        }

    }

    public void disparar() {

        tambor = pistola.iterator();

        while (tambor.hasNext()) {

            String disparo = tambor.next();

            if (disparo.equals("bala")) {
                if (turno) {
                    JOptionPane.showMessageDialog(null, "BANG!!, HAS MUERTO!!");
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "BANG!!");
                    JOptionPane.showMessageDialog(null, "Enhorabuena!! La pasta es tuya.");
                    System.exit(0);

                }
            } else {

                if (turno) {
                    JOptionPane.showMessageDialog(null, "CLICK.. ...Te has salvado");
                    JOptionPane.showMessageDialog(null, "Me toca a mi.. que miedo..");
                    turno = false;
                } else {
                    JOptionPane.showMessageDialog(null, "CLICK.. ..ME SALVE!!");
                    JOptionPane.showMessageDialog(null, "Te toca a ti.. jejejeje..");
                    turno = true;
                }

            }

        }

    }

}
