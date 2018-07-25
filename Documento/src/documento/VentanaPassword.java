/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documento;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import javax.swing.text.*;


/**
 *
 * @author cainuriel
 */

    
    public class VentanaPassword extends JFrame {
    
    public VentanaPassword () {
		setTitle("Ventana");
		setBounds(1100,500,300,200);
		Lamina lamina = new Lamina();
		add(lamina);
	}
    
    
    
    public class Lamina extends JPanel {
        
        public Lamina() {
        
            setLayout(new BorderLayout());
// creamos otra lamina para colocarla en la zona norte de la lamina principal
            JPanel Lamina_superior = new JPanel();
            Lamina_superior.setLayout(new GridLayout(2,2));
            add(Lamina_superior, BorderLayout.NORTH);
            JLabel etiqueta1 = new JLabel("Usuario");
             JLabel etiqueta2 = new JLabel("Password");

        JTextField textousuario = new JTextField(15);
        password = new JPasswordField(15);
        
        Lamina_superior.add(etiqueta1);
        Lamina_superior.add(textousuario);
        Lamina_superior.add(etiqueta2);
        Lamina_superior.add(password);
        
        JButton enviar = new JButton("Enviar");
        add(enviar, BorderLayout.SOUTH);
        
 // creamos en el constructor de la lamina los objetos de la clase Document
        Document doc = password.getDocument();
// Y lo ponemos a la escucha:
        doc.addDocumentListener(new comprobarPassword());
        

        
        }
// creamos la clase interna que implemente la interfaz gestora de documentos:
        
        private class comprobarPassword implements DocumentListener {

            @Override
            public void insertUpdate(DocumentEvent e) {
                char [] contrasena = password.getPassword();
                
                if (contrasena.length < 8 || contrasena.length > 12 ) {
                    password.setBackground(Color.red);
                } else {
                    password.setBackground(Color.yellow);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                this.insertUpdate(e);
            }
// se ejecuta si se cambia el texto de negrita a cursiva, cambio de tamano, ecta.
            @Override
            public void changedUpdate(DocumentEvent e) {

            }
            
            
        }
        JPasswordField password;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
      VentanaPassword documento = new VentanaPassword();
      documento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      documento.setVisible(true);
      
      TextArea textarea = new TextArea();
      textarea.setVisible(true);

    }
    
    
    
}
