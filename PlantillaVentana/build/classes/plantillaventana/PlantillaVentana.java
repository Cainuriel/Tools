/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantillaventana;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author cainu
 */
public class PlantillaVentana extends JFrame {

    public PlantillaVentana() {

        setTitle("Ventana");

        setBounds(400, 450, 400, 450);

        add(new Lamina());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public class Lamina extends JPanel {

        public Lamina() {

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        PlantillaVentana ventana = new PlantillaVentana();
        ventana.setVisible(true);
    }

}
