package pkgfinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Puntero {  //clase encargada de pintar el puntero
    
   //único método de la clase, y encargado de pintar el puntero a partir de los datos
    //Pasador por parámetro
    public void PaintComponent(Graphics g, int x, int y, Color cpuntero) {
        
       //Se genera un Graphics2D a partir del Graphics pasado por parámetro
       Graphics2D puntero = (Graphics2D) g;
        
       
        //Se establece el clor del puntero
        puntero.setColor(cpuntero); 
        
        //y se pinta un óvalo en las coordenadas (x+10 , y+10) y de dimensiones 20 x 20
        //para que sea un círculo y esté centrado
        puntero.fillOval(x+10, y+10, 20, 20);
        
      
    }
    
    
}
