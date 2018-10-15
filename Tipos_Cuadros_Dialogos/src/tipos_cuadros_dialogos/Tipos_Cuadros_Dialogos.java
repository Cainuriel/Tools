package tipos_cuadros_dialogos;

import javax.swing.*;

import java.awt.event.*;

public class Tipos_Cuadros_Dialogos {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Cuadros_Dialogos mimarco = new Cuadros_Dialogos();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mimarco.setVisible(true);

    }

}

class Cuadros_Dialogos extends JFrame {

    public Cuadros_Dialogos() {

        setBounds(500, 300, 400, 250);

        add(new Lamina_Cuadros_Dialogos());

    }

}

class Lamina_Cuadros_Dialogos extends JPanel {

    public Lamina_Cuadros_Dialogos() {

        boton1 = new JButton("Mensajes de dialogo");

        boton2 = new JButton("Introduce texto");

        boton3 = new JButton("boton confirmación");

        boton4 = new JButton("mensaje personalizado");

        boton1.addActionListener(new Accion_botones());
        boton2.addActionListener(new Accion_botones());
        boton3.addActionListener(new Accion_botones());
        boton4.addActionListener(new Accion_botones());

        add(boton1);

        add(boton2);

        add(boton3);

        add(boton4);

    }

    private class Accion_botones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // metodo getSource responde con QUIEN ha sido pulsado.

            if (e.getSource() == boton1) {
// primer argumento, nombre del componente padre. en este caso la lamina
// en donde estamos.
                JOptionPane.showMessageDialog(Lamina_Cuadros_Dialogos.this,
                        "Mensaje sencillo de informacion");
                JOptionPane.showMessageDialog(Lamina_Cuadros_Dialogos.this,
                        "Mensaje con titulo", "Esto es el titulo", 0);
                JOptionPane.showMessageDialog(Lamina_Cuadros_Dialogos.this,
                        "Mensaje con triangulo de advertencia",
                        "Esto es el titulo", 2);
                JOptionPane.showMessageDialog(Lamina_Cuadros_Dialogos.this,
                        "Mensaje con interrogante", "Esto es el titulo", 3);

            } else if (e.getSource() == boton2) {
                JOptionPane.showInputDialog(Lamina_Cuadros_Dialogos.this,
                        "con boton cancelar y aceptar", "introduce texto", 3);

            } else if (e.getSource() == boton3) {

                JOptionPane.showConfirmDialog(Lamina_Cuadros_Dialogos.this,
                        "Si, No cancelar", "Opcion 1", 1);
                JOptionPane.showConfirmDialog(Lamina_Cuadros_Dialogos.this,
                        "Si y No", "Opcion 0", 0);
                JOptionPane.showConfirmDialog(Lamina_Cuadros_Dialogos.this,
                        "Aceptar, cancelar", "Opcion 2", 2);

            } else {
                String array[] = {"lo que yo quiera", "opcion personalizada",
                    "tantos botones como quieras"};
                JOptionPane.showOptionDialog(Lamina_Cuadros_Dialogos.this,
                        "el texto de los botones introducido con un array",
                        "icono 3, de pregunta", 1, 3,null, array, null);

            }

        }

    }

    private JButton boton1, boton2, boton3, boton4;
}
