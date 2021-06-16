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

            //se dibuja un rectángulo que empieza en las coordenadas (X , Y + anchuralinea)
            //y tiene como anchura el lado de la casilla+anchuralinea y como altura el lado de la casilla
            Rectangle2D.Float cwin = new Rectangle2D.Float(X, Y + anchuralinea, Laberinto.getDimension() + anchuralinea, Laberinto.getDimension());
            //se asigna el color de la casilla
            aux.setColor(Color.GREEN);
            //se dibuja la casilla
            aux.fill(cwin);
        }

        //en el caso de que la casilla esté ocupada
        if (ocupada) {

            //se declara una varibable de tipo Puntero
            Puntero bola = new Puntero();

            //se llama al dibujado del puntero pasando por parámetro el Graphics,
            //las coordenadas de la casilla y el color del puntero
            bola.PaintComponent(g, X, Y, cpuntero);
           
            //en el caso de que la casilla ocupada, también sea la de victoria
            //significa que el usuario ha ganado
            if (win) {

                //Se genera una ventana JOptionPane con el mensaje: ¡¡Has ganado!!
                JOptionPane.showMessageDialog(new JFrame(), "            ¡¡Has ganado!!");

                //una ves se cierra el JOptionPane se cierra el programa
                System.exit(0);

            }

        }

    }

}
