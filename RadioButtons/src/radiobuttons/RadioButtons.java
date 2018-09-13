/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiobuttons;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author cainu
 */
public class RadioButtons extends JFrame {

    public RadioButtons() {

        setVisible(true);
        setBounds(450, 400, 500, 450);
        setLayout(new BorderLayout());
        add(new Lamina(), BorderLayout.CENTER);

    }

    public class Lamina extends JPanel {

        public Lamina() {

            setLayout(new BorderLayout());
            texto = new JLabel("TEXTO DE PRUEBA");
            add(texto, BorderLayout.CENTER);

            ButtonGroup grupo = new ButtonGroup();

            radiobutton1 = new JRadioButton("pequeno", false);
            radiobutton2 = new JRadioButton("mediano", true);
            radiobutton3 = new JRadioButton("grande", false);
            radiobutton4 = new JRadioButton("muy grande", false);

            grupo.add(radiobutton1);
            grupo.add(radiobutton2);
            grupo.add(radiobutton3);
            grupo.add(radiobutton4);

            JPanel laminabotones = new JPanel();
            
            aumentarTexto aumentar = new aumentarTexto();
            
            radiobutton1.addActionListener(aumentar);
            radiobutton2.addActionListener(aumentar);
            radiobutton3.addActionListener(aumentar);
            radiobutton4.addActionListener(aumentar);
            
            laminabotones.add(radiobutton1);
            laminabotones.add(radiobutton2);
            laminabotones.add(radiobutton3);
            laminabotones.add(radiobutton4);

            add(laminabotones, BorderLayout.SOUTH);

        }

        private JLabel texto;
        private JRadioButton radiobutton1;
        private JRadioButton radiobutton2;
        private JRadioButton radiobutton3;
        private JRadioButton radiobutton4;

        private class aumentarTexto implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                // el metodo getSource() nos devuelve el protagonista de la accion
                   if (e.getSource()==radiobutton1) {
                // usamos el metodo que cambia la fuente del texto
                // primer parametro tipo de letra, cursiva o negrita, y  tamano
                texto.setFont(new Font("Serif",Font.PLAIN,10));
                   } else if (e.getSource()==radiobutton2) {
                 texto.setFont(new Font("Serif",Font.PLAIN,13)); }
                 else if (e.getSource()==radiobutton3) {
                 texto.setFont(new Font("Serif",Font.PLAIN,24));
            }  else if (e.getSource()==radiobutton4) {
                 texto.setFont(new Font("Serif",Font.PLAIN,45)); }
                   
            }

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        RadioButtons radiobuttons = new RadioButtons();
        radiobuttons.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        radiobuttons.setVisible(true);
        
        RadioButtons2 radiobuttons2 = new RadioButtons2();
        radiobuttons2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        radiobuttons2.setVisible(true);
    }

}
