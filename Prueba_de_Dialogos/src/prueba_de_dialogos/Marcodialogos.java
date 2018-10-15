/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba_de_dialogos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author cainu
 */
public class Marcodialogos extends JFrame {

    public Marcodialogos() {

        setTitle("Prueba Dialogos");
        setBounds(500, 300, 600, 450);
        JPanel laminacuadricula = new JPanel();
        laminacuadricula.setLayout(new GridLayout(2, 3));

        String primeracaja[] = {"Mensaje", "Confirmar", "Opcion", "Entrada"};
        laminatipo = new Laminabotones("Tipo", primeracaja);

        // instanciamos directamente las nuevas cajas de botones
        laminatipomensaje = new Laminabotones("Tipo Mensajes", new String[]{
            "Error Mensaje",
            "Informacion Mensaje",
            "Mensaje de peligro",
            "Mensaje pregunta",
            "Mensaje Plano"
        });
        laminamensaje = new Laminabotones("Mensaje", new String[]{
            "Cadena",
            "Icono",
            "Componente",
            "Otros",
            "Object"
        });

        laminatipoopcion = new Laminabotones("Confirmar", new String[]{
            "Opcion por defecto",
            "Si y No, opcion",
            "Si, No y Cancel opcion",
            "Ok y Cancel opcion"
        });

        laminaopciones = new Laminabotones("Opcion", new String[]{
            "String",
            "Icono",
            "Objeto"
        });

        laminaentrada = new Laminabotones("Entrada", new String[]{
            "Campo de texto",
            "Combo"
        });

        laminacuadricula.add(laminatipo);
        laminacuadricula.add(laminatipomensaje);
        laminacuadricula.add(laminamensaje);
        laminacuadricula.add(laminatipoopcion);
        laminacuadricula.add(laminaopciones);
        laminacuadricula.add(laminaentrada);

        // construimos la lamina del boton que creara los diferentes mensajes.   
        JPanel laminamostrar = new JPanel();
        JButton mostrar = new JButton("Mostrar");
        mostrar.addActionListener(new accionMostrar());
        laminamostrar.add(mostrar);

        setLayout(new BorderLayout());
        // colocamos la lamina con los botones en el centro.
        add(laminacuadricula, BorderLayout.CENTER);
        add(laminamostrar, BorderLayout.SOUTH);

    }

    private Laminabotones laminatipo, laminatipomensaje, laminamensaje,
            laminatipoopcion, laminaopciones, laminaentrada;

    private class accionMostrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            System.out.println("Funciona");
        }

    }

}
