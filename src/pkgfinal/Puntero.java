/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 *
 * @author alvar
 */
public class Puntero {
    
   
    public void PaintComponent(Graphics g, float x, float y, Color cpuntero) {
        
        
       Graphics2D puntero = (Graphics2D) g;
        
        puntero.setColor(cpuntero); 
        puntero.fillOval((int)x+10, (int)y+10, 20, 20);
        
      
    }
    
    
}
