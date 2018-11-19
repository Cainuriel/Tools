/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba_de_dialogos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
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
        tiposimbolos = new Laminabotones("Tipo Simbolos", new String[]{
            "Error simbolo",
            "Informacion simbolo",
            "simbolo de peligro",
            "simbolo pregunta",
            "Sin simbolo"
        });
        laminamensaje = new Laminabotones("Mensaje", new String[]{
            "Cadena",
            "Icono",
            "Componente",
            "Otros",
            "Todos (array)"
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
        laminacuadricula.add(tiposimbolos);
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

    private Laminabotones laminatipo, tiposimbolos, laminamensaje,
            laminatipoopcion, laminaopciones, laminaentrada;

    private String mensaje = "Mensaje de texto";
    private Icon icono = new ImageIcon("src/prueba_de_dialogos/iconolopez.png");
    private Date fecha = new Date();
    private Component componente = new JButton("Holaaaa!!");

    // da el objeto seleccionado. 
    public Object darObjeto() {

        if (laminamensaje.darseleccion().equals("Cadena")) {
            return mensaje;
        } else if (laminamensaje.darseleccion().equals("Icono")) {
            return icono;
        } else if (laminamensaje.darseleccion().equals("Componente")) {
            return componente;
        } else if (laminamensaje.darseleccion().equals("Otros")) {
            return fecha;
        } else if (laminamensaje.darseleccion().equals("Todos (array)")) {
            return new Object[]{mensaje,
                icono, fecha, componente};
        } else {
            return "Esto no tendria que haber pasado";
        }

    }

    /**
     *
     * @return el numero entero que determina el icono. REUTILIZADO PARA
     * DETERMINAR LA CONSTANTE DE CLASE QUE DETERMINAN LOS BOTONES DE SELECCION.
     * YES, NO, OK, CANCEL, ECTA...
     */
    public int darIcono(Laminabotones lamina) {

        if (lamina.darseleccion().equals("Error simbolo")) {
            return 0;
        } else if (lamina.darseleccion().equals("Informacion simbolo")) {
            return 1;
        } else if (lamina.darseleccion().equals("simbolo de peligro")) {
            return 2;
        } else if (lamina.darseleccion().equals("simbolo pregunta")) {
            return 3;
        } else {
            return -1;
        }

    }

    public int darseleccion(Laminabotones lamina) {

        if (lamina.darseleccion().equals("Si y No, opcion")) {
            return 0;
        } else if (lamina.darseleccion().equals("Si, No y Cancel opcion")) {
            return 1;
        } else if (lamina.darseleccion().equals("Ok y Cancel opcion")) {
            return 2;
        } else {
            return -1;

        }
    }

    public Object[] damearrays(Laminabotones lamina) {
        String s = lamina.darseleccion();

        if (s.equals("String")) {
            return new Object[]{"Paco", "Pico", "Vena"};
        } else if (s.equals("Icono")) {
            return new Object[]{new ImageIcon("src/prueba_de_dialogos/iconolopez.png"),
                new ImageIcon("src/prueba_de_dialogos/iconolopez.png"),
                new ImageIcon("src/prueba_de_dialogos/iconolopez.png")};
        } else {
            return new Object[]{mensaje, icono, fecha, componente};
        }

    }

    /**
     * clase interna que gestiona todos los eventos
     */
    private class accionMostrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (laminatipo.darseleccion().equals("Mensaje")) {
                JOptionPane.showMessageDialog(Marcodialogos.this,
                        darObjeto(), "Titulo", darIcono(tiposimbolos));
            } else if (laminatipo.darseleccion().equals("Confirmar")) {

                JOptionPane.showConfirmDialog(Marcodialogos.this, darObjeto(),
                        "Titulo", darseleccion(laminatipoopcion),
                        darIcono(tiposimbolos));

            } else if (laminatipo.darseleccion().equals("Entrada")) {
                if (laminaentrada.darseleccion().equals("Campo de texto")) {
                    JOptionPane.showInputDialog(Marcodialogos.this, darObjeto(),
                            "Titulo", darIcono(tiposimbolos));
                } else { 
                    JOptionPane.showInputDialog(Marcodialogos.this, darObjeto(),
                            "Titulo", darIcono(tiposimbolos),null,
                            new String [] {"Arriba","En medio","Abajo"},"Arriba");
                }
            } else if (laminatipo.darseleccion().equals("Opcion")) {

                JOptionPane.showOptionDialog(Marcodialogos.this, darObjeto(), "Titulo",
                        1, darIcono(tiposimbolos),
                        null, damearrays(laminaopciones), null);
            }

        }

    }

}
