package pkgfinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javax.swing.JPanel;


public class laberinto extends JPanel {
    
    //se declara una variable int con atributo final que es el tamaño del lado
    //de los cuadrados que componen las casillas
    private static final int dimensionlado = 40;
    
    //se declaran variables int para contener:
    private int filas;  //la cantidad de filas
    private int columnas;  //la cantidad de columnas
    
    private int filsalida;  //la fila de la casilla salida
    private int colsalida;  //la columna de la casilla de salida
   
    private int filend;    //la fila de la casilla de victoria
    private int colend;    //la columna de la casilla de victoria
    
    private Color cFondo = Color.WHITE;  //el color de fondo y su color por defecto                                
    private Color cPuntero = Color.RED;  //el color del puntero y su color por defecto
    private Color cParedes = Color.BLACK;  //el color de las paredes y su color por defecto
    
    
    private Random start;  //una variable de tipo random para generar el inicio aleatorio
    
   //un array de Casillas multidimensional que contendrá todas las casillas
    public Casillas grid[][]; 
     
    
    public laberinto(String fichero){ //constructor de la clase laberinto
        
        //a start se le asocia un nuevo Random
        this.start = new Random();        
        
        //se ejecuta el método lector a partir del String con el nombre del fichero pasado por parámetro
        lector(fichero);
       
    }
    
    
    //Método encargado de generar el laberinto y las Casillas a partir del fichero .txt
    private void lector(String fichero){
        
        //Se declara un String que actuará como buffer para leer línea a línea
        String linea = "";
        //Se declaran dos int que serán los encargados de gestionar las COORDENADAS (en píxeles)
        int coordX = 0;
        int coordY = 0;
        
        //Se declarna un array de caracteres que será el encardado de guardar
        //en qué lados hay muros y en cuales no 
        char[] limites = {'0','0','0','0'};
        
        try{
            //se establece el enlace con el fichero y se le aplica el BufferedReader
            //para poder leer de línea en línea y carácter a carácter
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
        
        try{
            // Se lee la primera línea del fichero y se convierte a int mediante el método aInt()
            filas = aInt(linea = br.readLine());      // Se establece el número de filas
            
            // Se lee la segunda línea del fichero y se convierte a int  mediante el método aInt()                                     
            columnas = aInt(linea = br.readLine());   // Se establece el número de columnas

            //se genera el array de casillas con dimensiones filas x columnas
            grid = new Casillas[filas][columnas];

            //se declara un int para poder leer mediante el métood br.read()  
            int tmp = 0;
         
         //se empieza un bucle para recorrer la parte de información sobre los muros que contiene el fichero
         
         for (int i = 0; i<filas; i++){ //encargado de recorrer las filas
             
             //cada vez que se salta de fila, se vuelve a poner a 0 la coordenada X
             coordX = 0;
             
             
             for (int j = 0; j<columnas; j++){  //encargado de recorrer las columnas
                 
                Rectangle2D.Float recprov= new Rectangle2D.Float(coordX, coordY, dimensionlado, dimensionlado);
                limites=new char[4];
                
                
                for (int cont = 0; cont<4; cont++){
                    
                    tmp = br.read();
                    char traspaso = (char) tmp;
                    
                    limites[cont]=traspaso;
                    
                   
                }
                grid[i][j]=new Casillas(recprov, limites, coordX, coordY);
                coordX = coordX + dimensionlado;
             }
             
            br.readLine();
            coordY = coordY + dimensionlado;
             
         }
         

         
         filend = aInt(linea = br.readLine());
            System.out.println("filas "+filsalida);
         colend = aInt(linea = br.readLine());
            System.out.println("columnas "+colsalida);
         
         
         
         
         
         
         
         
         
         
         
         
         br.close();
         fr.close();
         
         //grid[filsalida][colsalida].setOcupada();
         
        casillainicio();
        casillafinal();
         
            
        }catch(IOException e2){
            e2.printStackTrace();
        }catch(Exception e3){
            e3.printStackTrace();
        }
        
        
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(Exception e2){
            e2.printStackTrace();
        }
    }
    
    
    @Override
    public void paintComponent(Graphics g){
 
        try {
           
            for (int i = 0; i < filas; i++) {
                
                for (int j = 0; j < columnas; j++) {
                    
                    grid[i][j].setColorFondo(cFondo);
                    grid[i][j].setColorPuntero(cPuntero);
                    grid[i][j].setColorParedes(cParedes);
                    grid[i][j].paintComponent(g);
                
                    

                }
                
            }
            //g.setColor(Color.yellow);
        //g.fillRect((dimensionlado*colsalida)-dimensionlado, dimensionlado*filsalida, dimensionlado, dimensionlado);
            

        } catch (Exception e) {
        }
    }
    
    
//    public Dimension getPreferredsize(){
//        return new Dimension(dimensionlado*columnas, dimensionlado*filas);
//    }
        
    
    
    private int aInt(String num){
        int aux = 0;
        try{
            aux = Integer.parseInt(num);
            
        }catch(NumberFormatException e){
            e.printStackTrace();
        }catch(Exception e2){
            e2.printStackTrace();
        }finally{
            return aux;
        }
        
        
        
        
        
    }
    
    
    public void setColorFondo(Color fondo){
        this.cFondo = fondo;
        
    }
    
    public void setColorPuntero(Color puntero) {
        this.cPuntero = puntero;
    }
    
    public void setColorParedes(Color paredes) {
        this.cParedes = paredes;
    }
    
    
    public static int getDimension(){
        return dimensionlado;
    }
   
    public int getFilas(){
        return filas;
    }
    public int getColumnas(){
        return columnas;
    }
    public int getFilend(){
        return filend;
    }
   
    public int getColend(){
        return colend;
    }
    
    
    public char[] Limites(int i, int j){
        
        
        return grid[i][j].getLimites();
    }
    
    
    private void casillainicio(){
        
        filsalida = start.nextInt(filas);
        colsalida = start.nextInt(columnas);
        
        grid[filsalida][colsalida].setOcupada();
        //grid[filsalida][colsalida].setOcupada();
         System.out.println("fila: "+filsalida+"   |    columna: "+colsalida);
      
    }
    private void casillafinal(){
        
        grid[filend][colend-1].setWin();
        
        System.out.println("Final en: "+filend+" y "+colend);
        
        
        
    }
}
