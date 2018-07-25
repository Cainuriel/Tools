/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkbox;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author cainu
 */
public class CheckBox extends JFrame {
    
    
    
    public CheckBox() {
        
        setBounds(350,350,350,350);
        Lamina lamina = new Lamina();
        add(lamina);
        setVisible(true);
        
    }
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        CheckBox checkbox = new CheckBox();
        checkbox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}

     class Lamina extends JPanel {
         private JLabel texto;
         private JCheckBox check1, check2;
        
        public Lamina(){
            
            setLayout(new BorderLayout());
// creamos un tipo de letra
            Font letras = new Font("Serif",Font.PLAIN,24);
            texto = new JLabel("TEXTO DE PRUEBA");
            texto.setFont(letras);
            JPanel laminatexto = new JPanel();
            laminatexto.add(texto);
            add(laminatexto, BorderLayout.NORTH);
            check1 = new JCheckBox("Negrita");
            check2 = new JCheckBox("Cursiva");
            check1.addActionListener(new fuenteTexto());
            check2.addActionListener(new fuenteTexto());
            
            JPanel laminachecks = new JPanel();
            laminachecks.add(check1);
            laminachecks.add(check2);
   // colocamos la lamina en el sur de la lamina principal.
            add(laminachecks, BorderLayout.SOUTH);
            
        }
        
        private class fuenteTexto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
// como la constante de clase es un entero, podemos hacer lo siguiente
// el valor de la negrita es 1 y el valor de la cursiva es 2
// 3 es cursiva y negrita a la vez. 0 letra normal.
        int opcion=0;
        if (check1.isSelected()) 
            opcion +=Font.BOLD;

         if (check2.isSelected()) 
            opcion +=Font.ITALIC;
// asi ahora podemos sustituir la constante de clase por la 
// variable opcion, sea 0 1 2 o 3.

        texto.setFont(new Font("Serif",opcion,24));

        }
         
     }
        
    }


