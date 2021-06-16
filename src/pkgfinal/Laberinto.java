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

public class Laberinto extends JPanel {

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

    public Laberinto(String fichero) { //constructor de la clase laberinto

        //a start se le asocia un nuevo Random
        this.start = new Random();

        //se ejecuta el método lector a partir del String con el nombre del fichero pasado por parámetro
        lector(fichero);
    }

    //Método encargado de generar el laberinto y las Casillas a partir del fichero .txt
    private void lector(String fichero) {

        //Se declara un String que actuará como buffer para leer línea a línea
        String linea = "";
        //Se declaran dos int que serán los encargados de gestionar las COORDENADAS (en píxeles)
        int coordX = 0;
        int coordY = 0;

        //Se declarna un array de caracteres que será el encardado de guardar
        //en qué lados hay muros y en cuales no 
        char[] limites = {'0', '0', '0', '0'};

        try {
            //se establece el enlace con el fichero y se le aplica el BufferedReader
            //para poder leer de línea en línea y carácter a carácter
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            try {
                // Se lee la primera línea del fichero y se convierte a int mediante el método aInt()
                filas = aInt(linea = br.readLine());      // Se establece el número de filas

                // Se lee la segunda línea del fichero y se convierte a int  mediante el método aInt()                                     
                columnas = aInt(linea = br.readLine());   // Se establece el número de columnas

                //se genera el array de casillas con dimensiones filas x columnas
                grid = new Casillas[filas][columnas];

                //se declara un int para poder leer mediante el métood br.read()  
                int tmp = 0;

                //se empieza un bucle para recorrer la parte de información sobre los muros que contiene el fichero
                for (int i = 0; i < filas; i++) { //encargado de recorrer las filas

                    //cada vez que se salta de fila, se vuelve a poner a 0 la coordenada X
                    coordX = 0;

                    for (int j = 0; j < columnas; j++) {  //encargado de recorrer las columnas

                        //se genera un rectangulo que empieza en las coordenadas X e Y y tiene como lado la variable dimensionlado
                        Rectangle2D.Float recprov = new Rectangle2D.Float(coordX, coordY, dimensionlado, dimensionlado);

                        //Se genera un nuevo array de chars de 4 dimensón 4 componentes
                        limites = new char[4];

                        //un bucle encargado de recorrer grupos de 4 caracteres
                        for (int cont = 0; cont < 4; cont++) {

                            //el método br.read devuelve el carácter como int, por ello empleamos
                            //la variable tmp
                            tmp = br.read();

                            //creamos una variable traspaso de tipo char y convertimos tmp en char
                            char traspaso = (char) tmp;

                            //finalmente guardamos el char en la posición correspondiente dentro del array:
                            //limites[0] -> norte || limites[1] -> este || limites[2] -> sur || limites[3] -> oeste                        
                            limites[cont] = traspaso;

                        }

                        //De esta manera, se va generando una casilla por cada grupo de 4 caracteres leídos
                        //y se pasa por parámetro al constructor el rectangulo de la casilla, el arrat con los
                        //chars que indican dónde hay paredes, y las coordenadas dónde empieza la casilla
                        grid[i][j] = new Casillas(recprov, limites, coordX, coordY);

                        //se añade la dimensionlado a la coordenada X para avanzar al lugar donde 
                        //corresponde, la siguiente columna
                        coordX = coordX + dimensionlado;
                    }
                    //se avanza a la siguiente línea una vez se han leído todos los caracteres de la fila; 
                    br.readLine();

                    //se añade la dimensionlado a la coordenada X para avanzar al lugar donde 
                    //corresponde, la siguiente dila 
                    coordY = coordY + dimensionlado;

                }

                //una vez ya se han leído las paredes, las dos úlitmas líneas indican en qué casilla está el final
                //de esta manera, se leen y se convierten a int mediante el método aInt()
                filend = aInt(linea = br.readLine());
                colend = aInt(linea = br.readLine());

                //se cierran los enclaces del bufferedreader y el filereader
                br.close();
                fr.close();

                casillainicio(); //se llama al método encargado de generar la casilla de inicio
                casillafinal();  //se llama al método encargado de generar la casilla del final

            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    //Método encargado de generar una casilla de inicio aleatoria
    private void casillainicio() {

        //la fila de salida será un valor aleatorio que como máximo será el número de filas
        filsalida = start.nextInt(filas);

        //la columna de salida será un valor aleatorio que como máximo será el número de columnas
        colsalida = start.nextInt(columnas);

        //se establece como ocupada la casilla de inicio
        grid[filsalida][colsalida].setOcupada();


    }

    private void casillafinal() {

        //se establece como casilla de victora la casilla en la filnd, colend-1 (para que no salga del laberinto)
        grid[filend][colend - 1].setWin();


    }

    @Override
    public void paintComponent(Graphics g) {

        try {
            //se genera un bucle para que a la hora de llamar al dibujado del laberinto
            //se llame al dibujado de cada una de las casillas
            for (int i = 0; i < filas; i++) {

                for (int j = 0; j < columnas; j++) {

                    //a cada una de las casillas se les pasa mediante los métodos set
                    //los colores de cada componente
                    grid[i][j].setColorFondo(cFondo);
                    grid[i][j].setColorPuntero(cPuntero);
                    grid[i][j].setColorParedes(cParedes);

                    //se llama al dibujado de cada una de las casillas del laberinto
                    grid[i][j].paintComponent(g);
                    
                    
                }
            }
        } catch (Exception e) {
        }
    }

    //Método encargado de convertir un String (pasado pro parámetro) en un int
    private int aInt(String num) {
        int aux = 0;
        try {
            aux = Integer.parseInt(num);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            return aux;
        }

    }

    //METODOS SET encargados de establecer los Colores de los componentes
    public void setColorFondo(Color fondo) {
        this.cFondo = fondo;

    }

    public void setColorPuntero(Color puntero) {
        this.cPuntero = puntero;
    }

    public void setColorParedes(Color paredes) {
        this.cParedes = paredes;
    }

    //METODOS GET encargados de devolver la cantidad de filas y columnas
    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    //el método getDimension es static para que pueda ser llamado desde cualquier clase
    public static int getDimension() {
        return dimensionlado;
    }

    //método encargado de devolver el char[] con los límites pasando 
    //por parámetro una fila y una columna.
    public char[] Limites(int i, int j) {

        return grid[i][j].getLimites();
    }
}
