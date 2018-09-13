/*
 * Creamos otra ventana con menos codigo. 
 */
package radiobuttons;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author cainu
 */
public class RadioButtons2 extends JFrame {

    public RadioButtons2() {

        setVisible(true);
        setBounds(20, 400, 500, 450);
        setLayout(new BorderLayout());
        add(new Lamina(), BorderLayout.CENTER);

    }

    public class Lamina extends JPanel {

        public Lamina() {

            setLayout(new BorderLayout());
            texto = new JLabel("TEXTO DE PRUEBA 2");

            texto.setFont(new Font("Serif", Font.PLAIN, 12));

            add(texto, BorderLayout.CENTER);
            grupo = new ButtonGroup();
            laminabotones = new JPanel();

            // hemos creado un metodo para crear a los botones y ponerlos en escucha
            colocarbotones("pequeno", false, 10);
            colocarbotones("normal", true, 14);
            colocarbotones("grande", false, 21);
            colocarbotones("muy grande", false, 45);

            add(laminabotones, BorderLayout.SOUTH);

        }

        public void colocarbotones(String nombre, boolean seleccionado, int tamano) {
            JRadioButton boton = new JRadioButton(nombre, seleccionado);

            grupo.add(boton);
            laminabotones.add(boton);
            ActionListener accion = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    texto.setFont(new Font("Serif", Font.PLAIN, tamano));

                }
                // este punto y ocma corresponde al final de la linea de creacion
                // del objeto ActionListener
            };
            // y concluimos en este metodo anadiendo la escucha al boton creado
            boton.addActionListener(accion);
        }

        private JLabel texto;
        private JRadioButton boton1, boton2, boton3, boton4;
        private ButtonGroup grupo;
        private JPanel laminabotones;
    }

}
