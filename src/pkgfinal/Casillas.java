package pkgfinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Casillas {

    private int X;   //coordenada pixeles X
    private int Y;   //coordenada pixeles Y
    
    //booleano encargado de gestionar si la casilla está ocupada
    private boolean ocupada;
    
     //booleano encargado de gestionar si la casilla es la de victoria
    private boolean win;
    
    //char[] con los la información sobre las paredes de la casilla
    public char[] limites;  
    
    //cuadrado para gestionar la casilla
    private Rectangle2D.Float cuadrado;
    
   
    private Puntero punt;   //declaración del puntero
    
    private int anchuralinea = 2;  //se establece el ancho de las paredes
    
    
    private Color cfondo = Color.WHITE;     //el color de fondo y su color por defecto
    private Color cpuntero = Color.RED;     //el color del puntero y su color por defecto
    private Color cparedes = Color.BLACK;   //el color de las paredes y su color por defecto


    //CONSTRUCTOR  
    public Casillas(Rectangle2D.Float c, char[] lim, int X, int Y) {
        //por defecto todas las casillas NO estarán ocupadas
        ocupada = false;
        
        //se copian el resto de datos pasados al constructor a las variables privadas
        limites = lim;
        this.X = X;
        this.Y = Y;
        cuadrado = c;
    }

    //METODOS SET encargados de establecer valores para los atributos de la clase
    
    public void setOcupada() { //ocupa la casilla
        ocupada = true;
    }
    
    void setLibre() {       //libera la casilla
        
        ocupada = false;
    }
     
    public void setWin() {   //establece la casilla como ganadora
        win = true;
    }

    public void setColorFondo(Color fondo) {  //establece el color de fondo
        this.cfondo = fondo;

    }

    public void setColorPuntero(Color puntero) { //establece el color del puntero
        this.cpuntero = puntero;
    }

    public void setColorParedes(Color paredes) { //establece el color de las paredes
        this.cparedes = paredes;
    }

    boolean info() {  //devuelve true si la casilla está ocupada y false de lo contrario
        return ocupada;

    }

    public char[] getLimites() { //devuelve el char[] con la información de las paredes
        return limites;
    }

    //Método encargado de pintar la casilla
    public void paintComponent(Graphics g) throws Exception {

        //Se genera un Graphics2D a partir del Graphics pasado por parámetro desde Laberinto 
        
        Graphics2D aux = (Graphics2D) g;     
        
        //se le asigna el color de fondo
        aux.setColor(cfondo);
        //se dibuja el cuadrado antes pasado al costructor
        aux.fill(cuadrado);
        
        //DIBUJADO DE PAREDES
        //el lugar de dibujar líneas, se dibujan rectánculos muy finos paraque, en caso de querer,
        //se pueda modificar el grosor de las líneas
        
        if (limites[0] == '1') {   // PARED NORTE == 1
            
            //se dibuja un rectángulo que empieza en las coordenadas (X , Y) 
            //y tiene como anchura el lado de la casilla y como altura el grosor de línea
            Rectangle2D.Float pared = new Rectangle2D.Float(X, Y, Laberinto.getDimension(), anchuralinea);

            //se asigna el color de las paredes
            aux.setColor(cparedes);
            //se dibuja la pared
            aux.fill(pared);

        }

        if (limites[1] == '1') {  //PARED ESTE == 1
            
            //se dibuja un rectángulo que empieza en las coordenadas (X+ladocasilla , Y) 
            //y tiene como anchura el el grosor de la línea y como altura ladocasilla
            Rectangle2D.Float pared = new Rectangle2D.Float(X + Laberinto.getDimension(), Y, anchuralinea, Laberinto.getDimension());
            
            //se asigna el color de las paredes
            aux.setColor(cparedes);
            //se dibuja la pared
            aux.fill(pared);
            

        }

        if (limites[2] == '1') {   //PARED SUR == 1
            
            //se dibuja un rectángulo que empieza en las coordenadas (X , Y+ladocasilla) 
            //y tiene como anchura el lado de la casilla y como altura el grosor de línea
            Rectangle2D.Float pared = new Rectangle2D.Float(X, Y + Laberinto.getDimension(), Laberinto.getDimension(), anchuralinea);
            
            //se asigna el color de las paredes
            aux.setColor(cparedes);
            //se dibuja la pared
            aux.fill(pared);

        }

        if (limites[3] == '1') {   //PARED OESTE == 1 
            
            //se dibuja un rectángulo que empieza en las coordenadas (X , Y) 
            //y tiene como anchura el lado de la casilla y como altura el grosor de línea
            Rectangle2D.Float pared = new Rectangle2D.Float(X, Y, anchuralinea, Laberinto.getDimension());
            
            //se asigna el color de las paredes
            aux.setColor(cparedes);
            //se dibuja la pared
            aux.fill(pared);

        }
        
        //en el caso de que la casilla sea la de victoria 
        if (this.win) {
            Rectangle2D.Float cwin = new Rectangle2D.Float(X + anchuralinea, Y + anchuralinea, Laberinto.getDimension(), Laberinto.getDimension());
            aux.setColor(Color.lightGray);
            aux.fill(cwin);
        }

        if (ocupada) {
            Puntero bola = new Puntero();

            bola.PaintComponent(g, X, Y, cpuntero);
            //punt.PaintComponent(g, X, Y, cpuntero);
            //puntero.setColor(cpuntero); 
            //puntero.fillOval(X+10, Y+10, 20, 20);

            if (win) {

                System.out.println("Has ganado");

                JOptionPane.showMessageDialog(new JFrame(), "            ¡¡Has ganado!!");

                ocupada = false;

                System.exit(0);

            }

        }

    }

}
