package pkgfinal;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.filechooser.FileNameExtensionFilter;

public class Final extends JFrame {   //se genera un JFrame a partir de la clase??

    //declaración de las variables filas y columnas 
    private int filas;
    private int columnas;

    //Declaración de un String con el nombre del fichero por defecto
    private String fichero = "maze1.txt";

    //Declaración de una varable de tipo laberinto
    private Laberinto lab;

    //Declaración de múltiples variables Color para poder personalizar la apariencia
    //del laberinto
    private Color caux;
    private Color cfondo = Color.WHITE;
    private Color cpuntero = Color.RED;
    private Color cparedes = Color.BLACK;

    public void inicio() {   //Método inicial

        //llamada al método encargado de generar el laberinto
        importlaberinto();

        //llamada al método encargado de gestional los componentes de la ventana
        atributosventana();

    }

    private void importlaberinto() {  //método encargado de generar el laberinto 

        //se genera el laberinto llamando al constructor de la clase 
        //y pasándole por pámetro un String con el nombre del fichero 
        lab = new Laberinto(fichero);

        //obtención de la cantidad de filas y columnas en el laberinto a partir
        //de los métodos getFilas() y getColumnas()
        filas = lab.getFilas();
        columnas = lab.getColumnas();

        //se añade la variable lab de tipo laberindo (que es un JPanel) al JFame principal
        this.add(lab);
    }

    private void atributosventana() {

        //se selecciona el tamaño de la ventana
        this.setSize(columnas * lab.getDimension() + 8, filas * lab.getDimension() + 60);

        //no se le permite al usuario cambiar las dimensions de la ventana
        this.setResizable(false);
        //se establece el título de la ventana principal
        this.setTitle("Proyecto final laberinto");

        //al pulsar la cruz superior derecha se saldrá del programa
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //declaración de una barra de menú superior
        JMenuBar barramenu = new JMenuBar();
        this.setJMenuBar(barramenu);  //se asigna la barra de menú al JFrame principal

        //declaración del primer apartado de la barra de menú y sus componentes 
        //o apartados JMenuItem con sus correspondientes nombres
        JMenu menlaber = new JMenu("Laberintos");
        JMenuItem selecclab = new JMenuItem("Selecionar laberinto");
        JMenuItem reinlab = new JMenuItem("Reiniciar laberinto");
        JMenuItem exitlab = new JMenuItem("Salir del laberinto");

        //declaración del segundo apartado de la barra de menú y sus componentes 
        //o apartados JMenuItem con sus correspondientes nombres
        JMenu colores = new JMenu("Visualización");
        JMenuItem colorfondo = new JMenuItem("Seleccionar color de fondo");
        JMenuItem colorpuntero = new JMenuItem("Seleccionar color del puntero");
        JMenuItem colorparedes = new JMenuItem("Seleccionar color de las paredes");

        //implementación del KeyListener para gestionar el movimiento del puntero seún 
        //la tecla pulsada
        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent ke) {
                try {

                    //declaración de un booleano que en caso de encontrar la casilla ocupada
                    //saldrá del bucle de recorrido evitando tener que recorrer el resto de casillas
                    boolean encontrada = false;

                    //se genera un bucle encargado de recorrer cada una de las 
                    //casillas de izquierda a derecha de arriba a abajo
                    for (int i = 0; i < filas; i++) {

                        for (int j = 0; j < columnas; j++) {

                            //el bucle ignora todas las casillas hasta que encuentre la casilla ocupada
                            if (lab.grid[i][j].info()) {

                                //una vez se encuentra la casilla ocupada se intentará
                                //mover el puntero dependiendo de la tecla pulsada 
                                //Tal y como funciona el switch en Java, en el caso de no haber break
                                //en el caso actual, se avanza al siguiente caso. De esta manera,
                                //independientemende de si el usuario ha pulsado W o la tecla de flecha hacia arriba
                                //la acción será la misma
                                switch (ke.getKeyCode()) {
                                    case KeyEvent.VK_W:

                                    case KeyEvent.VK_UP:
                                        //Si se ha pulsado la tecla W o UP, lo primero que se comprueba 
                                        //es que el puntero no se encuentre en la primera fila
                                        //ya que en ese caso NUNCA podrá ir más hacia arriba
                                        //puesto que las dimensiones del laberinto son limitadas                    
                                        System.out.println("arriba");
                                        if (i != 0) {
                                            //en el caso de que no se encuentre en la primera fila,
                                            //se comprueba si existe un muro en la parte superior de la casilla
                                            if (lab.grid[i][j].limites[0] == '0') {

                                                //en el caso de que no haya un muro en la parte superior,
                                                //se procede a ocupar la casilla immediatamente superior 
                                                //y a desocupar la casilla inicial
                                                lab.grid[i - 1][j].setOcupada();
                                                lab.grid[i][j].setLibre();
//                                          
                                            } else {
                                                System.out.println("limite norte");
                                            }
                                        } else {
                                            System.out.println("limite norte");
                                        }

                                        //como se ha encontrado la casilla ocupada, se cambia el valor
                                        //de la variable booleana
                                        encontrada = true;
                                        break;

                                    case KeyEvent.VK_D:

                                    case KeyEvent.VK_RIGHT:
                                        System.out.println("derecha");

                                        //Si se ha pulsado la tecla D o RIGHT, lo primero que se comprueba
                                        //es que el puntero no se encuentre en la última columna
                                        //ya que en ese caso NUNCA podrá ir más hacia la derecha 
                                        //puesto que las dimensiones del laberinto son limitadas
                                        if (j != columnas) {

                                            if (lab.grid[i][j].limites[1] == '0') {

                                                //en el caso de que no haya un muro en la parte derecha,
                                                //se procede a ocupar la casilla immediatamente a la derecha 
                                                //y a desocupar la casilla inicial
                                                lab.grid[i][j + 1].setOcupada();
                                                lab.grid[i][j].setLibre();
//                                          

                                            } else {
                                                System.out.println("limite derecha");
                                            }
                                        } else {
                                            System.out.println("limite derecha");
                                        }

                                        //como se ha encontrado la casilla ocupada, se cambia el valor
                                        //de la variable booleana
                                        encontrada = true;
                                        break;

                                    case KeyEvent.VK_S:

                                    case KeyEvent.VK_DOWN:

                                        //Si se ha pulsado la tecla S o DOWN, lo primero que se comprueba
                                        //es que el puntero no se encuentre en la última fila
                                        //ya que en ese caso NUNCA podrá ir más hacia abajo 
                                        //puesto que las dimensiones del laberinto son limitadas
                                        System.out.println("abajo");
                                        if (i != filas) {

                                            //en el caso de que no haya un muro en la parte inferior,
                                            //se procede a ocupar la casilla immediatamente inferior 
                                            //y a desocupar la casilla inicial
                                            if (lab.grid[i][j].limites[2] == '0') {
                                                lab.grid[i + 1][j].setOcupada();
                                                lab.grid[i][j].setLibre();

                                            } else {
                                                System.out.println("limite sur");
                                            }
                                        } else {
                                            System.out.println("limite sur");
                                        }
                                        //como se ha encontrado la casilla ocupada, se cambia el valor
                                        //de la variable booleana
                                        encontrada = true;
                                        break;

                                    case KeyEvent.VK_A:

                                    case KeyEvent.VK_LEFT:

                                        //Si se ha pulsado la tecla S o LEFT, lo primero que se comprueba
                                        //es que el puntero no se encuentre en la primera fila
                                        //ya que en ese caso NUNCA podrá ir más hacia la izquierda 
                                        //puesto que las dimensiones del laberinto son limitadas
                                        System.out.println("izquierda");
                                        if (j != 0) {
                                            if (lab.grid[i][j].limites[3] == '0') {

                                                //en el caso de que no haya un muro en la parte izquierda,
                                                //se procede a ocupar la casilla immediatamente a la izquierda 
                                                //y a desocupar la casilla inicial
                                                lab.grid[i][j - 1].setOcupada();
                                                lab.grid[i][j].setLibre();

                                            } else {
                                                System.out.println("limite izquierda");
                                            }
                                        } else {
                                            System.out.println("limite izquierda");
                                        }

                                        //como se ha encontrado la casilla ocupada, se cambia el valor
                                        //de la variable booleana
                                        encontrada = true;
                                        break;

                                }
                                break;

                            }
                        }

                        //en el caso de que se haya encontrado la casilla inicial 
                        //se sale del bucle
                        if (encontrada) {
                            break;
                        }
                    }

                    //se actualiza el laberinto
                    repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }

            @Override
            public void keyTyped(KeyEvent ke) {
            }
        });

        class selecclab implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Selecclab");
                Filechooser();
                while (fichero == null) {
                    JOptionPane.showMessageDialog(new JFrame(), "Por favor, seleccione un archivo .txt");

                    Filechooser();
                }
                System.out.println("Se ha seleccionado el fichero: " + fichero);

                lab.setVisible(false);

                importlaberinto();
            }

        }

        selecclab.addActionListener(new selecclab());

        class reinlab implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {

                lab.setVisible(false);
                //inicio();
                System.out.println("Reinlab");
                importlaberinto();

            }

        }

        reinlab.addActionListener(new reinlab());

        class exitlab implements ActionListener {

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

        class colorfondo implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {
                caux = cfondo;

                caux = colorchooser();
                if (caux != null) {
                    cfondo = caux;
                }

                //cfondo = colorchooser();
                lab.setColorFondo(cfondo);
                repaint();
            }
        }
        colorfondo.addActionListener(new colorfondo());

        class colorpuntero implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {

                caux = cpuntero;

                caux = colorchooser();
                if (caux != null) {
                    cpuntero = caux;
                }

                //cpuntero = colorchooser();
                lab.setColorPuntero(cpuntero);
                repaint();
            }
        }
        colorpuntero.addActionListener(new colorpuntero());

        class colorparedes implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {
                caux = cparedes;

                caux = colorchooser();
                if (caux != null) {
                    cparedes = caux;
                }

                lab.setColorParedes(cparedes);
                repaint();
            }
        }

        colorparedes.addActionListener(new colorparedes());

        barramenu.add(colores);
        colores.add(colorfondo);
        colores.add(colorpuntero);
        colores.add(colorparedes);

        //se actualiza la ventana
        repaint();

        //se hace visible la ventana
        this.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        //se genera un constructor fuera del main para desaherse del atributo static
        new Final().inicio();
    }

    private String Filechooser() {    //metodo encargado de seleecionar un fichero de texto

        //Falta control de excepciones
        try {

            JFileChooser fc = new JFileChooser();    //se intanca la componente JFileChooser

            File dir = new File(System.getProperty("user.dir"));     //Se obtiene el directorio del usuario/programa
            fc.setCurrentDirectory(dir);                             //y se vincula al FileChooser para que a la hora se abrir la ventana
            //esta no sea la de Documentos, sino la del usuaro (en la que esta el programa)

            //Se declara un filtro que sólo se permite seleccionar al usario ficheros terminados en .txt
            FileNameExtensionFilter txt = new FileNameExtensionFilter("Ficheros de texto", "txt");
            fc.setFileFilter(txt);                                   //Se añade el filto al FileChooser

            //se abre la ventana y se ejecuta la selección del fichero. 
            int funciona = fc.showOpenDialog(fc);
            fichero = null;

            //en el caso de que se haya seleccionado un fichero correctamente,
            //la variable fichero pasa a valer el nombre del fichero seleccionado
            if (funciona == JFileChooser.APPROVE_OPTION) {

                fichero = fc.getSelectedFile().getName();
            }
        } catch (HeadlessException e) {
        } catch (Exception e2) {

        }

        //el método devuelve el nombre del fichero como String
        return fichero;
    }

    //Método encargado de abrir una ventana para que el usuario seleccione un Color y devolverlo 
    private Color colorchooser() {

        //el color devuelto será igual al solor selecccionado por la ventade del JColorChooser
        //A la ventana se le asigna un titulo y un color por defecto
        return JColorChooser.showDialog(null, "SELECCIONE EL COLOR DE FONDO", Color.WHITE);

    }

}
