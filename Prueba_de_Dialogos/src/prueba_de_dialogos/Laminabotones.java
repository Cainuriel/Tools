/*
 * Clase que creara la lamina de los botones seleccionables.
tambien se creara las cajas donde ellos iran metidos, junto
al borde de los mismos con su correspondiente titulo. 
 */
package prueba_de_dialogos;

import javax.swing.*;

/**
 *
 * @author cainu
 */
public class Laminabotones extends JPanel {
    
   private ButtonGroup grupo;
    
    /**
     * 
     * @param titulo titulo de la caja de botones
     * @param opciones nombre de los botones
     */
    public Laminabotones(String titulo, String[] opciones) {
        
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                titulo));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        grupo = new ButtonGroup();
        // construccion de los RadioButtons.
        for (int i=0; i<opciones.length; i++) {
            JRadioButton boton = new JRadioButton(opciones[i]);
            boton.setActionCommand(opciones[i]);
            add(boton);
            grupo.add(boton);
            
            
  
// para seleccionar al primer argumento, usamos el parametro booleano con
// una condicion. si se cumple, se seleccionara, sino no se seleccionara
            boton.setSelected(i==0);
            
        }
        
    }
    
    public String darseleccion() {
// el metodo getSelection devuelve el objeto boton seleccionado. en este objeto
// tenemos el metodo getActionCommand que devuelve el String del boton.
        return grupo.getSelection().getActionCommand();
    }
    
}
