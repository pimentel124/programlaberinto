package pkgfinal;

import static com.sun.java.accessibility.util.AWTEventMonitor.removeKeyListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Final extends JFrame {   //se puede quitar el public
  
    
    private int ubiX, ubiY;
          
    private static int filas;
    private static int columnas;
    private String fichero = "maze1.txt";
    //private Casillas [][] casillas;
    private laberinto fin;
    
    
    public void inicio(){
        importlaberinto();
        
        atributosventana();
        
        
        
        
        
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
              
        
        
        
    }
    
    
    
    private void importlaberinto(){
        
        fin = new laberinto(fichero);
        
        
        filas = fin.getFilas();
        columnas = fin.getColumnas();
      //  casillas=fin.grid;
        
        this.add(fin);
    }
    
    private void atributosventana(){
    
    this.setSize(columnas*laberinto.getDimension()+8,filas*laberinto.getDimension()+54);    
    this.setResizable(false);
    this.setTitle("Proyecto final laberinto");
    setDefaultCloseOperation(EXIT_ON_CLOSE);    
    
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
                try {
                  
                boolean cambio = false;
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        if (fin.grid[i][j].info()) {
                            switch (ke.getKeyCode()) {
                                case KeyEvent.VK_W:
                                                        
                                    System.out.println("w");
                                    if (j != 0) {
                                        if (fin.grid[i][j].limites[0] == '0') {
                                            
                                            fin.grid[i][j-1].setOcupada();   
                                            fin.grid[i][j].setLibre();             
//                                            Laberinto.setnFilas(i); 
//                                            Laberinto.setnColumnas(j);
                                             
                                        }else{System.out.println("limite norte");}
                                    }else{System.out.println("limite norte");}
                                    cambio = true;
                                    break;
                                    
                                case KeyEvent.VK_UP:
                                                        //KeyEvent.VK_UP 
                                    System.out.println("arriba");
                                    if (j != 0) {
                                        if (fin.grid[i][j].limites[0] == '0') {
                                            fin.grid[i][j-1].setOcupada();  
                                            fin.grid[i][j].setLibre();             
//                                            Laberinto.setnFilas(i); 
//                                            Laberinto.setnColumnas(j);
                                             
                                        }else{System.out.println("limite norte");}
                                    }else{System.out.println("limite norte");}
                                    cambio = true;
                                    break;
 
                                case KeyEvent.VK_D:
                                    System.out.println("d");
                                    if (i != columnas-1) {
                                        if (fin.grid[i][j].limites[1] == '0') {
                                            fin.grid[i+1][j].setOcupada();
                                            fin.grid[i][j].setLibre();
//                                            Laberinto.setnFilas(i);
//                                            Laberinto.setnColumnas(j);
 
                                        }else{System.out.println("limite derecha");}
                                    }else{System.out.println("limite derecha");}
                                    cambio = true;
                                    break;
                                    
                                case KeyEvent.VK_RIGHT:
                                    System.out.println("derecha");
                                    if (i != columnas-1) {
                                        if (fin.grid[i][j].limites[1] == '0') {
                                            fin.grid[i+1][j].setOcupada();
                                            fin.grid[i][j].setLibre();
//                                            Laberinto.setnFilas(i);
//                                            Laberinto.setnColumnas(j);
 
                                        }else{System.out.println("limite derecha");}
                                    }else{System.out.println("limite derecha");}
                                    cambio = true;
                                    break;
 
 
                                case KeyEvent.VK_S:
                                    System.out.println("s");
                                    if (j != filas) {
                                        if (fin.grid[i][j].limites[2] == '0') {
                                            fin.grid[i][j+1].setOcupada();
                                            fin.grid[i][j].setLibre();
//                                            Laberinto.setnFilas(i);
//                                            Laberinto.setnColumnas(j);
 
                                        }else{System.out.println("limite sur");}
                                    }else{System.out.println("limite sur");}
                                    cambio = true;
                                    break;
                                    
                                case KeyEvent.VK_DOWN:
                                    System.out.println("abajo");
                                    if (j != filas) {
                                        if (fin.grid[i][j].limites[2] == '0') {
                                            fin.grid[i][j+1].setOcupada();
                                            fin.grid[i][j].setLibre();
//                                            Laberinto.setnFilas(i);
//                                            Laberinto.setnColumnas(j);
 
                                        }else{System.out.println("limite sur");}
                                    }else{System.out.println("limite sur");}
                                    cambio = true;
                                    break;
 
                                case KeyEvent.VK_A:
                                    System.out.println("A");
                                    if (i != 0) {
                                        if (fin.grid[i][j].limites[3] == '0') {
                                            fin.grid[i-1][j].setOcupada();
                                            fin.grid[i][j].setLibre();
//                                            Laberinto.setnFilas(i);
//                                            Laberinto.setnColumnas(j);
 
                                        }else{System.out.println("limite izquierda");}
                                    }else{System.out.println("limite izquierda");}
                                    cambio = true;
                                    break;
                                case KeyEvent.VK_LEFT:
                                    System.out.println("izquierda");
                                    if (i != 0) {
                                        if (fin.grid[i][j].limites[3] == '0') {
                                            fin.grid[i-1][j].setOcupada();
                                            fin.grid[i][j].setLibre();
//                                            Laberinto.setnFilas(i);
//                                            Laberinto.setnColumnas(j);
 
                                        }else{System.out.println("limite izquierda");}
                                    }else{System.out.println("limite izquierda");}
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
 
            @Override
            public void keyReleased(KeyEvent ke) {}
 
            @Override
            public void keyTyped(KeyEvent ke) {}
        });
    
    //fin.addKeyListener(ke);
    
    
    class selecclab implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Selecclab");
                Filechooser();
                System.out.println("Se ha seleccionado el fichero: "+fichero);
                
                fin.setVisible(false);
                
                importlaberinto();
            }
        
    }
    
    selecclab.addActionListener(new selecclab());
    
    class reinlab implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent ae) {
               
               
               fin.setVisible(false);
               //inicio();
               System.out.println("Reinlab");
               importlaberinto();
               
               
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
    
    repaint();
    
    
    this.setVisible(true);
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
