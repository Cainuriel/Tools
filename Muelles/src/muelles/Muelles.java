/*
 * Trabajamos con la disposicion en muelle. la clase SprintLayout.
 */
package muelles;

import javax.swing.*;

/**
 *
 * @author cainu
 */
public class Muelles extends JFrame {
    
    public Muelles () {
        setBounds(300,400,1000,300);
        Lamina lamina = new Lamina();
        add(lamina);
        setVisible(true);
        
        
    }
    class Lamina extends JPanel {
        
        public Lamina() {
            JButton boton1 = new JButton("Boton 1");
            JButton boton2 = new JButton("Boton 2");
            JButton boton3 = new JButton("Boton 3");
            
 // instanciamos la clase SpringLayout.
            SpringLayout layout = new SpringLayout();
            // la disponemos en la lamina.
            setLayout(layout);
            
            add(boton1);
            add(boton2);
            add(boton3);
            
            
       // creamos un muelle con el metodo statico de tres argumentos
          Spring muelle = Spring.constant(0,10,100);
       // muelle rigido. el parametro hace referencia a la distancia
       // fija que establecera el muelle en donde lo coloquemos. 
          Spring muellerigido = Spring.constant(50);
   
 // colocamos el muelle entre los botones y entre las paredes y los botones
           layout.putConstraint(SpringLayout.WEST, boton1, muelle,
                   SpringLayout.WEST, this);
// las constantes de clase, hacen referencia a donde se coloca cada
// extremo del muelle. ya sea la derecha o la izquierda de un boton
// o la derecha o la izquierda de la ventana.
            layout.putConstraint(SpringLayout.WEST, boton2, muellerigido,
                   SpringLayout.EAST, boton1);
            layout.putConstraint(SpringLayout.WEST, boton3, muellerigido,
                   SpringLayout.EAST, boton2);
            layout.putConstraint(SpringLayout.EAST, this, muelle,
                   SpringLayout.WEST, boton3);
            
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Muelles ventana = new Muelles();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
