/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;



public class Casillas {
    
    private int X;
    private int Y;
    private boolean ocupada;
    private boolean norte, sur, este, oeste = false;
    public int[] limites = {0,0,0,0};
    private Rectangle2D.Float cuadrado;
    private Puntero punt;
    private int anchuralinea = 2;
    
    
    
        public Casillas(){
    
            ocupada = false;
       
    }
        public Casillas(Rectangle2D.Float c, int[] lim, int X, int Y) {
        limites = lim;
        this.X = X;
        this.Y = Y;
        cuadrado = c;
    }
        public Casillas(int[] bordes){
            if (bordes[0] == 1) norte = true;
            if (bordes[1] == 1) este = true;
            if (bordes[2] == 1) sur = true;
            if (bordes[3] == 1) oeste = true;
        }
    
    void setLibre() {
        ocupada=false;
    }
    
    
    boolean info() {
        return ocupada;
        
    }
    
    public void setOcupada() {
        ocupada=true;
    }
    
   
    
    public void setFicha(Puntero p) {
        System.out.println("setficha");
        ocupada = true;
        punt = p;
    }
    
    public int[] getLimites() {
        return limites;
    }
 
    
   public void paintComponent(Graphics g) throws Exception {
       
       Graphics2D aux;
        aux = (Graphics2D) g;
       
       aux.setColor(Color.WHITE);
       aux.fill(cuadrado);
       
       
       if(limites[0] == 1){   //NORTE
           Rectangle2D.Float pared= new Rectangle2D.Float(X,Y+2,laberinto.getDimension(),anchuralinea);
           
           aux.setColor(Color.BLACK);
           aux.fill(pared);
           System.out.println("norte");
           
       }
       /*
       if(limites[1] == 1){  //ESTE //DERECHA
           Rectangle2D.Float pared= new Rectangle2D.Float(X+laberinto.getDimension()-2,Y,anchuralinea,laberinto.getDimension()); 
           aux.setColor(Color.GREEN);
           aux.fill(pared);
           System.out.println("derecha");
           
           
       }
       
       */
       
       if(limites[2] == 1){   //SUR   
//           aux.setColor(Color.RED);
//           aux.drawLine(X, Y+laberinto.getDimension(), X+laberinto.getDimension(), Y+laberinto.getDimension());
//           aux.setColor(Color.BLACK);
//           aux.drawLine(X, Y, X+laberinto.getDimension(), Y+laberinto.getDimension());
           Rectangle2D.Float pared= new Rectangle2D.Float(X,Y+laberinto.getDimension()-2,laberinto.getDimension(),anchuralinea); 
           aux.setColor(Color.RED);
           aux.fill(pared);
           System.out.println("sur");
           
       }
       
       
       if(limites[3] == 1){   //OESTE   //IZQUIERDA
           Rectangle2D.Float pared= new Rectangle2D.Float(X,Y,anchuralinea,laberinto.getDimension()); 
           aux.setColor(Color.blue);
           aux.fill(pared);
           System.out.println("izquierda");
           
       }
       
       
       
       
   }
    
    
    
    
    
    
    
}
