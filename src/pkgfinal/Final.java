package pkgfinal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Final extends JFrame {   //se puede quitar el public
  
    private static final Color VERDE = Color.GREEN;    
    private static final Color NEGRO = Color.BLACK;
    private int ubiX, ubiY;
          
    private static int filas;
    private static int columnas;
    private String fichero = "maze1.txt";
    private Casillas [][] casillas;
    
    public void inicio(){
        atributosventana();
        importlaberinto();
        
        
        
        
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
              
        
        setVisible(true);
        
    }
    
    
    
    private void importlaberinto(){
        
        laberinto lab = new laberinto(fichero);
        
        
        filas = lab.getFilas();
        columnas = lab.getColumnas();
        casillas=new Casillas[filas][columnas];
        
        this.add(lab);
    }
    
    private void atributosventana(){
    
    this.setSize(500,600);    
    this.setTitle("Proyecto final laberinto");
        
    
    JMenuBar barramenu = new JMenuBar();
    this.setJMenuBar(barramenu);
    JMenu menlaber = new JMenu("Laberintos");
    JMenuItem selecclab = new JMenuItem("Seleccionar laberinto");
    JMenuItem reinlab = new JMenuItem("Reiniciar laberinto");
    JMenuItem exitlab = new JMenuItem("Salir del laberinto");

    
    //
    
    
    addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent ke) {
                System.out.println("w");
                boolean cambio = false;
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        if (casillas[i][j].info()) {
                            switch (ke.getKeyCode()) {
                                case KeyEvent.VK_W:
                                                        //KeyEvent.VK_UP 
                                    if (i != 0) {
                                        if (laberinto.grid[i][j].limites[0] == 0) {
                                            laberinto.grid[i - 1][j].setOcupada();   //ocupada means occupied
                                            laberinto.grid[i][j].setLibre();             //libre means free
//                                            Laberinto.setnFilas(i); 
//                                            Laberinto.setnColumnas(j);
                                             
                                        }
                                    }
                                    cambio = true;
                                    break;
                                    
                                case KeyEvent.VK_UP:
                                                        //KeyEvent.VK_UP 
                                    if (i != 0) {
                                        if (laberinto.grid[i][j].limites[0] == 0) {
                                            laberinto.grid[i - 1][j].setOcupada();   //ocupada means occupied
                                            laberinto.grid[i][j].setLibre();             //libre means free
//                                            Laberinto.setnFilas(i); 
//                                            Laberinto.setnColumnas(j);
                                             
                                        }
                                    }
                                    cambio = true;
                                    break;
 
                                case KeyEvent.VK_D:
                                    if (j != columnas-1) {
                                        if (laberinto.grid[i][j].limites[1] == 0) {
                                            laberinto.grid[i][j + 1].setOcupada();
                                            laberinto.grid[i][j].setLibre();
//                                            Laberinto.setnFilas(i);
//                                            Laberinto.setnColumnas(j);
 
                                        }
                                    }
                                    cambio = true;
                                    break;
                                    
                                case KeyEvent.VK_RIGHT:
                                    if (j != columnas-1) {
                                        if (laberinto.grid[i][j].limites[1] == 0) {
                                            laberinto.grid[i][j + 1].setOcupada();
                                            laberinto.grid[i][j].setLibre();
//                                            Laberinto.setnFilas(i);
//                                            Laberinto.setnColumnas(j);
 
                                        }
                                    }
                                    cambio = true;
                                    break;
 
 
                                case KeyEvent.VK_S:
                                    if (i != filas-1) {
                                        if (laberinto.grid[i][j].limites[2] == 0) {
                                            laberinto.grid[i + 1][j].setOcupada();
                                            laberinto.grid[i][j].setLibre();
//                                            Laberinto.setnFilas(i);
//                                            Laberinto.setnColumnas(j);
 
                                        }
                                    }
                                    cambio = true;
                                    break;
                                    
                                case KeyEvent.VK_DOWN:
                                    if (i != filas-1) {
                                        if (laberinto.grid[i][j].limites[2] == 0) {
                                            laberinto.grid[i + 1][j].setOcupada();
                                            laberinto.grid[i][j].setLibre();
//                                            Laberinto.setnFilas(i);
//                                            Laberinto.setnColumnas(j);
 
                                        }
                                    }
                                    cambio = true;
                                    break;
 
                                case KeyEvent.VK_A:
                                    if (j != 0) {
                                        if (laberinto.grid[i][j].limites[3] == 0) {
                                            laberinto.grid[i][j - 1].setOcupada();
                                            laberinto.grid[i][j].setLibre();
//                                            Laberinto.setnFilas(i);
//                                            Laberinto.setnColumnas(j);
 
                                        }
                                    }
                                    cambio = true;
                                    break;
                                case KeyEvent.VK_LEFT:
                                    if (j != 0) {
                                        if (laberinto.grid[i][j].limites[3] == 0) {
                                            laberinto.grid[i][j - 1].setOcupada();
                                            laberinto.grid[i][j].setLibre();
//                                            Laberinto.setnFilas(i);
//                                            Laberinto.setnColumnas(j);
 
                                        }
                                    }
                                    cambio = true;
                                    break;
 
                            }
                            break;
 
                        }
                    }
                    if (cambio) {
                        break;
                    }
                }
 
                
                repaint();
            }
 
            @Override
            public void keyReleased(KeyEvent ke) {}
 
            @Override
            public void keyTyped(KeyEvent ke) {}
        });
    
    
    class selecclab implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent ae) {
                Filechooser();
                System.out.println("Selecclab");
            }
        
    }
    
    selecclab.addActionListener(new selecclab());
    
    class reinlab implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent ae) {
               
            }
        
        
    }
    
    reinlab.addActionListener(new reinlab());
    
    
    class exitlab implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent ae) {
               System.exit(0);
            }
        
    }
    
    exitlab.addActionListener(new exitlab());
    
        
    
    
    
    barramenu.add(menlaber);
    menlaber.add(selecclab);
    menlaber.add(reinlab);
    menlaber.add(exitlab);
    }
    
       
        
        
        
        
        
        
        
        
        
    
    
    public static void main(String[] args) throws IOException{
        new Final().inicio();
    }
    
    
    
    private String Filechooser(){    //metodo encargado de seleecionar un fichero de texto
        
        JFileChooser fc = new JFileChooser();    //se intanca la componente JFileChooser
        
        File dir = new File(System.getProperty("user.dir"));     //Se obtiene el directorio del usuario
        fc.setCurrentDirectory(dir);                             //y se vincula al FileChooser para que a la hora se abrir la ventana
                                                                 //Esta no sea la de documentos, sino la del usuaro (en la que esta el programa)
        
        FileNameExtensionFilter txt = new FileNameExtensionFilter("Ficheros de texto", "txt");    //Un filtro que sólo se permite seleccionar al usario ficheros terminados en .txt
        fc.setFileFilter(txt);                                   //Se añade el filto al FileChooser
        
        //se abre la ventana y se ejecuta la selección del fichero. 
        int funciona = fc.showOpenDialog(fc);
        fichero = null;
        if (funciona == JFileChooser.APPROVE_OPTION){
            
            fichero = fc.getSelectedFile().getName();
        }
        
        //En caso de que la operación se haya realizado correctamente, el método devuelve el nombre del fichero como String
        
        return fichero;
    }
    
    
    
    
    
    
    
}
