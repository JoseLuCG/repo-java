package examenEvaluacion1;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio3 {
    /**
     * Rellena el tablero de unos y ceros.
     * @param matriz Matriz a rellenar.
     */
    public static void relledorAleatorio (int[][] matriz){
        Random rnd = new Random();

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[0].length; columna++) {
                matriz[fila][columna] = rnd.nextInt(0,2);
            }
        }
    }
    /**
     * Muestra el tablero en pantalla.
     * @param matriz Matriz a mostrar.
     */
    public static void printMatriz (int[][] matriz) {
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[0].length; columna++) {
                System.out.printf("%3d",matriz[fila][columna]);
            }
            System.out.println();
        }
    }
    /**
     * Comprueba las posiciones de los colindates en el arco establecido por el usuario.
     * @param matriz Tabla a analizar.
     * @return Condicion para que se pare el programa.
     */
    public static boolean rastreador (int[][] matriz) {
        Scanner sc = new Scanner(System.in);
        int arco = 0;
        int posicionFila, posicionColumna;
        int counter = 0 ;
        boolean finDelPrograma = false;
        int filaInicial, filaFinal,columnaInicial, columnaFinal;

        System.out.println("Escibe el arco a recorrer:");
        arco = sc.nextInt();
        if (arco == -1) finDelPrograma = true;

        if (!finDelPrograma){
            do {
                System.out.println("Escribe tu fila de posicion:");
                posicionFila = sc.nextInt();
            }while (posicionFila < 0 || posicionFila >10 );
            do {
                System.out.println("Escribe tu columna de posicion");
                posicionColumna = sc.nextInt();
            }while (posicionColumna < 0 || posicionColumna > 10);

            //Comprobaciones de los puntos colindantes.
            filaInicial = posicionFila - arco;
            filaFinal = posicionFila + arco;
            columnaInicial = posicionColumna - arco;
            columnaFinal = posicionColumna + arco;

            if (filaInicial<0) filaInicial = 0;
            if (columnaInicial<0) columnaInicial = 0;
            if (filaFinal >= matriz.length) filaFinal = matriz.length-1;
            if (columnaInicial >= matriz[0].length) columnaFinal = matriz[0].length -1;

            for (int fila = filaInicial; fila <= filaFinal; fila++) {
                for (int columna = columnaInicial; columna <= columnaFinal; columna++) {
                    if (matriz[fila][columna] ==1) counter++;
                }
            }
            System.out.println("En las posiciones colindantes tienes "+counter+" asteroides.");
        }
        return finDelPrograma;
    }
    public static void main(String[] args) {
        int[][] tablero = new int[10][10];
        boolean stop;

        //Rellenamos la matriz.
        relledorAleatorio(tablero);

        // Mostramos nustro tablero.
        printMatriz(tablero);
        do {
            //Hacemos los calculos.
            stop = rastreador(tablero);
        }while (stop == false);
    }
}
