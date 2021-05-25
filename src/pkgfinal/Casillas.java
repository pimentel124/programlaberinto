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
    public char[] limites;
    private Rectangle2D.Float cuadrado;
    private Puntero punt;
    private int anchuralinea = 2;
    private boolean win;
    
    
    
        public Casillas(){
    
            ocupada = false;
            win = false;
       
    }
        public Casillas(Rectangle2D.Float c, char[] lim, int X, int Y) {
        limites = lim;
        this.X = X;
        this.Y = Y;
        cuadrado = c;
    }
//        public Casillas(int[] bordes){
//            if (bordes[0] == 1) norte = true;
//            if (bordes[1] == 1) este = true;
//            if (bordes[2] == 1) sur = true;
//            if (bordes[3] == 1) oeste = true;
//        }
    
    void setLibre() {
        ocupada=false;
    }
    
    public void setWin(){
        win = true;
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
    
    public char[] getLimites() {
        return limites;
    }
 
    
   public void paintComponent(Graphics g) throws Exception {
       
       //System.out.println(limites);
       
       Graphics2D aux = (Graphics2D) g;
       Graphics2D puntero = (Graphics2D) g;
       
       aux.setColor(Color.WHITE);
       aux.fill(cuadrado);
       
       
       if(ocupada){
                       puntero.setColor(Color.RED); 
                       puntero.fillOval(X+10, Y+10, 20, 20);
                       
                       //punt.PaintComponent(g, i, j);
                        
                    }else{
           
          
       }
       
       
       if(limites[0] == '1'){   //NORTE
           Rectangle2D.Float pared= new Rectangle2D.Float(X,Y,laberinto.getDimension(),anchuralinea);
           
           aux.setColor(Color.BLACK);
           aux.fill(pared);
           //System.out.println("norte");
           
       }
       
       if(limites[1] == '1'){  //ESTE //DERECHA
           Rectangle2D.Float pared= new Rectangle2D.Float(X+laberinto.getDimension(),Y,anchuralinea,laberinto.getDimension()); 
           aux.setColor(Color.BLACK);
           aux.fill(pared);
           //System.out.println("derecha");
           
           
       }
       
      
       
       if(limites[2] == '1'){   //SUR   
//           aux.setColor(Color.RED);
//           aux.drawLine(X, Y+laberinto.getDimension(), X+laberinto.getDimension(), Y+laberinto.getDimension());
//           aux.setColor(Color.BLACK);
//           aux.drawLine(X, Y, X+laberinto.getDimension(), Y+laberinto.getDimension());
           Rectangle2D.Float pared= new Rectangle2D.Float(X,Y+laberinto.getDimension(),laberinto.getDimension(),anchuralinea); 
           aux.setColor(Color.BLACK);
           aux.fill(pared);
           //System.out.println("sur");
           
       }
       
       
       if(limites[3] == '1'){   //OESTE   //IZQUIERDA
           Rectangle2D.Float pared= new Rectangle2D.Float(X,Y,anchuralinea,laberinto.getDimension()); 
           aux.setColor(Color.BLACK);
           aux.fill(pared);
           //System.out.println("izquierda");
           
       }
       if (this.win) {
           Rectangle2D.Float cwin = new Rectangle2D.Float(X,Y,laberinto.getDimension(),laberinto.getDimension());
           aux.setColor(Color.GREEN);
           aux.fill(cwin);
        }
       
       
       
       
       
       
       
       
   }
    
    
    
    
    
    
    
}
