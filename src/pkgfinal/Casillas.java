/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.geom.Rectangle2D;



public class Casillas {
    
    private int fila;
    private int columna;
    private boolean ocupada;
    private boolean norte, sur, este, oeste = false;
    public int[] limites;
    private Rectangle2D.Float cuadrado;
    private Puntero punt;
    
    
    
        public Casillas(){
    
            ocupada = false;
       
    }
        public Casillas(Rectangle2D.Float c, int[] lim, int X, int Y) {
        limites = lim;
        fila = X;
        columna = Y;
        cuadrado = c;
    }
        public Casillas(int[] bordes){
            if (bordes[0] == 1) norte = true;
            if (bordes[1] == 1) sur = true;
            if (bordes[2] == 1) este = true;
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
    
}
