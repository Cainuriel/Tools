/*
 * Desplegables de menu
 */
package desplegables;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author cainu
 */
public class Desplegables extends JFrame {
    
    public Desplegables() {
        
        setBounds(350, 50, 400, 400);
        setVisible(true);
        add(new Lamina());
        
    }
    
    public class Lamina extends JPanel {
        
        public Lamina() {
            
            setLayout(new BorderLayout());
            texto = new JLabel("Texto de Prueba");
            texto.setFont(new Font("Serif", Font.PLAIN, 24));
            add(texto, BorderLayout.CENTER);
            JPanel laminadesplegables = new JPanel();
            combo = new JComboBox();
// el metodo seteditable permite editar el menu por el usuario
// en este caso, podria seleccionar otra fuente para el texto
            combo.setEditable(true);
            combo.addItem("Serif");
            combo.addItem("Arial");
            combo.addItem("Sans");
            combo.addItem("Monospaced");
            
            laminadesplegables.add(combo);
            add(laminadesplegables, BorderLayout.NORTH);
            combo.addActionListener(new cambiarFuente());
            
        }
        
        private class cambiarFuente implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
               texto.setFont(new Font(combo.getSelectedItem().toString(),Font.PLAIN,24));
            }
            
            
        }
        
        private JLabel texto;
        private JComboBox combo;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Desplegables ventana = new Desplegables();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
    
}
