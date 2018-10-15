/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajas;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author cainu
 */
public class Cajas extends JFrame {

    public Cajas() {

        setTitle("Probando la clase Box");
        setBounds(600, 350, 200, 200);

        JLabel rotulo1 = new JLabel("Nombre");
        JTextField texto1 = new JTextField(10);
// limitamos el tamanyo del texto en su redimensionado. 
        texto1.setMaximumSize(texto1.getPreferredSize());
// creamos la primera caja horizontal con un metod estatico
        Box boxhorizontal1 = Box.createHorizontalBox();
        boxhorizontal1.add(rotulo1);
// creamos un espacio de diez pixeles        
        boxhorizontal1.add(Box.createHorizontalStrut(10));
        boxhorizontal1.add(texto1);

        JLabel rotulo2 = new JLabel("Password");
        JTextField texto2 = new JTextField(10);
        // limitamos el tamanyo del texto en su redimensionado. 
        texto2.setMaximumSize(texto2.getPreferredSize());

        Box boxhorizontal2 = Box.createHorizontalBox();
        boxhorizontal2.add(rotulo2);
        boxhorizontal2.add(Box.createHorizontalStrut(10));
        boxhorizontal2.add(texto2);

        JButton ok = new JButton("Ok");
        JButton cancelar = new JButton("Cancelar");

        Box boxhorizontal3 = Box.createHorizontalBox();

        boxhorizontal3.add(ok);
// pegamento que separa en proporcion a los botones.
        boxhorizontal3.add(Box.createGlue());

        boxhorizontal3.add(cancelar);

        Box boxpadre = Box.createVerticalBox();
// metemos las cajas horizontales en la caja vertical.
        boxpadre.add(boxhorizontal1);
        boxpadre.add(boxhorizontal2);
        boxpadre.add(boxhorizontal3);

        add(boxpadre, BorderLayout.CENTER);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cajas caja = new Cajas();
        caja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        caja.setVisible(true);
    }

}
