package pkgfinal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JPanel;


public class laberinto extends JPanel {
    private static final int dimensionlado = 40;
    private int filas;
    private int columnas;
    private int filsalida;
    private int colsalida;
    private int filend;
    private int colend;
    
 
    public Casillas grid[][];
    
    
    
    public laberinto(String fichero){
        
        lector(fichero);
        
    }
    
    
    
    private void lector(String fichero){
        String linea = "";
        int contX = 0;
        int contY = 0;
        char[] limites = {'0','0','0','0'};
        
        try{
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
        
        try{
         int tmp = 0;
            
                                                   // Se lee la primera línea del fichero y se convierte a int
         filas = aInt(linea = br.readLine());      // Se establece el número de filas
                                                   // Se lee la segunda línea del fichero y se convierte a int
         columnas = aInt(linea = br.readLine());   // Se establece el número de columnas
         
         grid = new Casillas[filas][columnas];
         
         for (int i = 0; i<filas; i++){
             
             contX = 0;
             
             for (int j = 0; j<columnas; j++){
                 
                Rectangle2D.Float recprov= new Rectangle2D.Float(contX, contY, dimensionlado, dimensionlado);
                limites=new char[4];
                
                
                for (int cont = 0; cont<4; cont++){
                    
                    tmp = br.read();
                    char traspaso = (char) tmp;
                    
                    limites[cont]=traspaso;
                    
                    System.out.println(limites[cont]);
                    
                }
                grid[i][j]=new Casillas(recprov, limites, contX, contY);
                contX = contX + dimensionlado;
             }
             //br.readLine();
            br.readLine();
            contY = contY + dimensionlado;
             
         }
         
//         linea = br.readLine();
         
         filsalida = aInt(linea = br.readLine());
            System.out.println("filasalida "+filsalida);
         colsalida = aInt(linea = br.readLine());
            System.out.println("colsalida "+colsalida);
         
         
         
         
         
         
         
         
         
         
         
         
         br.close();
         fr.close();
         
         
            
            
         
            
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
                    
                    
                    grid[i][j].paintComponent(g);
                    
                }
                
            }
            g.setColor(Color.yellow);
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
    
    
    public static int getDimension(){
        return dimensionlado;
    }
    
    public int getFilsalida(){
        return filsalida;
    }
    
    public int getColsalida(){
        return colsalida;
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
}
