/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantillatextarea;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author cainuriel
 */
public class PlantillaTextArea extends JFrame {
    
   private JPanel laminabotones;
   private JButton insertarfirma;
   private JButton saltarlinea;
   private JTextArea areatexto;
// lamina con barras
   private JScrollPane scroll;
    
    public  PlantillaTextArea() {
        
        setBounds(600,180,770,500);
        setTitle("Area de Texto");
 // disponemos del Layout en el marco no en la lamina
        setLayout(new BorderLayout());
        laminabotones = new JPanel();
        insertarfirma = new JButton("Insertar Firma");
        areatexto = new JTextArea(15,15);
        
// vamos a intentar poner en escucha al boton sin crear una clase:
        insertarfirma.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
// utilizamos el metodo append porque agrega sin borrar un texto
// a diferencia del setText, que si borra el texto existente. 
            areatexto.append("Fernando Lopez Lopez. "+ new Date());
            }
        });
        
        laminabotones.add(insertarfirma);
        saltarlinea = new JButton("Salto de linea: ON/OFF");
        
// de nuevo lo ponemos a la escucha sin crear clase aparte
        saltarlinea.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
// almacenamos lo contrario del salto de linea, para poder activarlo y 
// desactivarlo con un click del boton
               boolean onoff =! areatexto.getLineWrap();
               areatexto.setLineWrap(onoff);
               if (onoff) {
                   saltarlinea.setBackground(Color.red);
                  
               } else {
                   saltarlinea.setBackground(Color.white);

               }
/**
 * operador ternario, '?' lo que hara si es true ':' lo hara si es false
  usando la variable booleana */
                saltarlinea.setText(onoff ? "On" : "Off");
            }
           
        });
        
        laminabotones.add(saltarlinea);
        add(laminabotones,BorderLayout.SOUTH);
        scroll = new JScrollPane(areatexto);
        add(scroll,BorderLayout.CENTER);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         PlantillaTextArea textarea = new  PlantillaTextArea();
         textarea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         textarea.setVisible(true);
         
    }
    
}
