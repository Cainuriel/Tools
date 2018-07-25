/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documento;

import javax.swing.*;

/**
 *
 * @author cainu
 */
public class Textarea extends JFrame {
    
    public Textarea() {
        
        setTitle("Area de texto");
        
        setBounds(400,450,400,450);
        
        add(new LaminaArea());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        
      
    }
    

    public class LaminaArea extends JPanel {
        
        public LaminaArea() {
            
            
            
        }
    }
    
    
}

