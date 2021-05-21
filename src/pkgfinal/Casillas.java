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
    public int[] limites;
    private Rectangle2D.Float cuadrado;
    private Puntero punt;
    private int anchuralinea = 4;
    
    
    
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
    
    
    
//    public boolean getNorte(){
//        return norte;
//    }
    
    public void setFicha(Puntero p) {
        System.out.println("setficha");
        ocupada = true;
        punt = p;
    }
    
    public int[] getLimites() {
        return limites;
    }
 
    
   public void paintComponent(Graphics g) throws Exception {
       
       Graphics2D aux = (Graphics2D) g;
       
       aux.setColor(Color.GREEN);
       aux.fill(cuadrado);
       
       
       if(limites[0] == 1){
           Rectangle2D.Float pared= new Rectangle2D.Float(X,Y-2,laberinto.getDimension(),anchuralinea); 
           aux.setColor(Color.BLACK);
           aux.fill(pared);
           
           
       }
       if(limites[1] == 1){
           Rectangle2D.Float pared= new Rectangle2D.Float(X+laberinto.getDimension()-2,Y,anchuralinea,laberinto.getDimension()); 
           aux.setColor(Color.BLACK);
           aux.fill(pared);
           
           
       }
       if(limites[2] == 1){
           Rectangle2D.Float pared= new Rectangle2D.Float(X,Y+laberinto.getDimension()-2,laberinto.getDimension(),anchuralinea); 
           aux.setColor(Color.BLACK);
           aux.fill(pared);
           
           
       }
       if(limites[3] == 1){
           Rectangle2D.Float pared= new Rectangle2D.Float(X-2,Y,anchuralinea,laberinto.getDimension()); 
           aux.setColor(Color.BLACK);
           aux.fill(pared);
           
           
       }
       
       
       
       
       
   }
    
    
    
    
    
    
    
}
