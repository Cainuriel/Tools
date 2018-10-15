/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disposicionlibre;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author cainu
 */
public class DisposicionLibre extends JFrame {

    public DisposicionLibre() {
        setTitle("Posicion libre");
        setBounds(450, 350, 600, 400);
        Lamina lamina = new Lamina();
        add(lamina);
        setVisible(true);

    }

    class Lamina extends JPanel {

        public Lamina() {
            // metemos como Layout nuestra propia clase de Layout
            setLayout(new encolumnas());
            
            JLabel nombre = new JLabel("Nombre");
            JTextField textonombre = new JTextField();
            JLabel apellido = new JLabel("Apellido");
            JTextField textoapellido = new JTextField();
            JLabel telefono = new JLabel("Nombre");
            JTextField textotelefono = new JTextField();
            
            add(nombre);
            add(textonombre);
            add(apellido);
            add(textoapellido);
            add(telefono);
            add(textotelefono);
            
            

        }
    }
    
    class encolumnas implements LayoutManager {

        @Override
        public void addLayoutComponent(String string, Component cmpnt) {

        }

        @Override
        public void removeLayoutComponent(Component cmpnt) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Dimension preferredLayoutSize(Container cntnr) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Dimension minimumLayoutSize(Container cntnr) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void layoutContainer(Container contenedor) {
            int x, y=20;
        // necesitamos conocer la anchura de la ventana para centrar
        // los componentes
            int anchura = contenedor.getWidth();
           // dividiendo entre dos tendremos el punto intermedio 
            x = anchura / 2;
            
            int contadordecomponentes=0;
            int almacendecomponentes = contenedor.getComponentCount();
            
            for (int i=0;i<almacendecomponentes; i++) {
                contadordecomponentes++;
  // cogemos el primer contenedor para colocarlo.          
            Component c = contenedor.getComponent(i);
   // restamos cien a x (que es el tamanyo del objeto) para centrarlo.
            c.setBounds(x-100, y, 100, 20);
            // incrementamos la x para no solaparse
            x +=100;
   // solo cambiamos la y si es un segundo competente
   // lo sabemos con el contador. si es par, podemos aumentarlo
            if (contadordecomponentes%2==0) {
           // volvemos a centrar la x.     
                x = anchura / 2;
                y += 40;
            }
            }
        }

        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DisposicionLibre ventana = new DisposicionLibre();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
