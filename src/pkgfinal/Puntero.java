/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author alvar
 */
public class Puntero {
 
    private final String imagen = "circulo.png";
    private BufferedImage png;
    
    
    public Puntero(String imagen){
       
        try{
            png = ImageIO.read(new File(imagen));
            
        }catch(IOException e){
            
        }
        
        
    }
    
    
  

    void PaintComponent(Graphics g, float x, float y) {
        g.drawImage(png, (int)x+10, (int)y+10, null);
    }
    
    
}
