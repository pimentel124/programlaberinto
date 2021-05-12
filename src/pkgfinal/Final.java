/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Final extends JFrame {   //se puede quitar el public
  
    private static final Color VERDE = Color.GREEN;    
    private static final Color NEGRO = Color.BLACK;
    private static int filas;
    private static int columnas;
    private String fichero = "maze1.txt";
    private Casillas [][] casillas;
    
    public void inicio(){
        
        importlaberinto();
        
        
        atributosventana();
        this.setSize(500,500);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
              
        
        setVisible(true);
        
    }
    
    
    
    private void importlaberinto(){
        
        laberinto lab = new laberinto(fichero);
        
        
        filas = lab.getFilas();
        columnas = lab.getColumnas();
        casillas=new Casillas[filas][columnas];
        
        
    }
    
    private void atributosventana(){
    
        
    this.setTitle("Proyecto final laberinto");
        
    
    JMenuBar barramenu = new JMenuBar();
    this.setJMenuBar(barramenu);
    JMenu menlaber = new JMenu("Laberintos");
    JMenuItem selecclab = new JMenuItem("Seleccionar laberinto");
    JMenuItem reinlab = new JMenuItem("Reiniciar laberinto");
    JMenuItem exitlab = new JMenuItem("Salir del laberinto");

    
    //
    
    
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
