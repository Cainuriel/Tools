/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolbars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
/**
 *
 * @author cainu
 */
public class ToolBars extends JFrame {

 

    public ToolBars() {

        setTitle("Ventana");

        setBounds(400, 450, 400, 450);

        add(new Lamina());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    

    public class Lamina extends JPanel {

        JButton rojo;
        JButton verde;
        JButton amarillo;
        Color c;

        public Lamina() {
// la clase Colores es una Clase interna que hereda de AbstractAction
            Colores rojo = new Colores("Rojo", Color.RED);
            Colores verde = new Colores("Verde", Color.GREEN);
            Colores amarillo = new Colores("Amarillo", Color.YELLOW);
            // creamos una accion con la implementacion con clase anonima.
            Action salir = new AbstractAction("Salir"){
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
                
            };

            
            JMenu menu = new JMenu("Color");
            menu.add(rojo);
            menu.add(verde);
            menu.add(amarillo);
            
            JMenuBar menubar = new JMenuBar();
            menubar.add(menu);
            
//metodo de la clase JFrame para agregar barras de menu directamente.             
            setJMenuBar(menubar);
            
            
// CONSTRUCCION DE LA BARRA DE HERRAMIENTAS
            JToolBar barra =new  JToolBar();
            barra.add(rojo);
            barra.add(verde);
            barra.add(amarillo);
            barra.addSeparator();
            barra.add(salir);
// SI COLOCAMOS LA BARRA EN EL BORDERLAYOUT PODREMOS MOVERLA
// Y COLOCARLA EN CUALQUIER OTRA POSICION
            add(barra,BorderLayout.NORTH);
        }
  private class Colores extends AbstractAction {
                
            public Colores(String name, Color color_fondo) {
                putValue(Action.NAME, name);
                putValue(Action.SHORT_DESCRIPTION, "Pinta de " + name);
                putValue("Color de fondo", color_fondo);
            }

            @Override
            public void actionPerformed(ActionEvent e) {
  // getValue devuelve un objeto de la clase Object por eso
  // tenemos que hacer el casting. 
                setBackground(c =(Color) getValue("Color de fondo"));

              
                }
            }
      

        }

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ToolBars root = new ToolBars();
        root.setVisible(true);

    }

}
