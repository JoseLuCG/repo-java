package examenEvaluacion1;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio2 {
    /**
     * Rellena la matriz con mueros aleatorios.
     * @param matriz array a rellenar.
     * @param menor menor numero del rango a rellenar.
     * @param mayor mayor numero del rango a rellenar.
     */
    public static void rellenador (int[][] matriz, int menor, int mayor) {
        Random rnd = new Random();

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[0].length; columna++) {
                matriz[fila][columna] = rnd.nextInt(menor, mayor);
            }
        }
    }

    /**
     * Metodo para obtener la suma de las filas de la matriz, es decir,
     * la lluvia total en una provincia durante toda la semana.
     * @param matriz Matriz a operar.
     * @param dias Indicador de datos.
     */
    public static void lluviaAcumProvincia (int[][] matriz, String[] dias){
        int sumatorioFila;

        System.out.printf("%10s |","");
        for (int dia = 0; dia < dias.length; dia++) {
            System.out.printf("%12s |",dias[dia]);
        }
        System.out.printf("%12s","Total L/m2");
        System.out.println();
        for (int fila = 0; fila < matriz.length; fila++) {
            System.out.print("Provincia: "+fila);
            sumatorioFila = 0;
            for (int columna = 0; columna < matriz[0].length; columna++) {
                System.out.printf("%12d |",matriz[fila][columna]);
                sumatorioFila = sumatorioFila + matriz[fila][columna];
            }
            System.out.printf("%12d",sumatorioFila);
            System.out.println();
        }
    }

    /**
     * Calcula la media semanal para cada provincia, es decir, calcula la lluvia media de cada fila.
     * @param matriz Tabla a comprobar.
     */
    public static void lluviaMediaSemanal (int[][] matriz) {
        int sumatorio;
        int media;

        for (int fila = 0; fila < matriz.length; fila++) {
            sumatorio = 0;
            for (int columna = 0; columna < matriz[0].length; columna++) {
                sumatorio = sumatorio + matriz[fila][columna];
            }
            media = sumatorio / matriz[0].length;
            System.out.println("Provincia "+fila+" La media de lluvia semanal es: "+media);

        }

    }

    /**
     * Calcula la media general de todas las provincias y muestra los dias mas lluviosos.
     * @param matriz Tabla de datos
     * @param dias Arrray con el nombre de los dias de la semana.
     */
    public static void provinciaDiasMasLluvioso (int[][] matriz, String[] dias) {
        int sumatorio;
        int media,mediaGeneral;
        int provinciasAConsultar = matriz.length;
        int[] datos = new int[provinciasAConsultar];

        // Calculamos la media por provincia.
        for (int fila = 0; fila < matriz.length; fila++) {
            sumatorio = 0;
            for (int columna = 0; columna < matriz[0].length; columna++) {
                sumatorio = sumatorio + matriz[fila][columna];
            }
            media = sumatorio / matriz[0].length;
            datos[fila] = media;
        }
        // Calculamos la media de la media de todas las provincias.
        sumatorio = 0;
        for (int mediaProvincia = 0; mediaProvincia < datos.length; mediaProvincia++) {
            sumatorio = sumatorio + datos[mediaProvincia];
        }
        mediaGeneral = sumatorio / provinciasAConsultar;

        // Mostramos en pantalla la media gneral.
        System.out.println("La media general de lluvias es: "+mediaGeneral);

        // Comprobamos los dias que superan la media general.
        System.out.println("Dias por provincia que supera la media general");
        for (int fila = 0; fila < matriz.length; fila++) {
            System.out.print("Provincia: "+fila+" | ");
            for (int columna = 0; columna < matriz[0].length; columna++) {
                if ( matriz[fila][columna] > mediaGeneral ) {
                    System.out.print(dias[columna]+",");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

        System.out.println("Indica las provincias a consultar:");
        int n = sc.nextInt();
        int[][] tabla = new int[n][7];

        //rellenamos la matriz.
        rellenador(tabla,0,150);
        System.out.println();
        // Implementamos el metodo 1.
        lluviaAcumProvincia(tabla,dias);
        System.out.println();
        // Implementacion del metodo 2.
        lluviaMediaSemanal(tabla);
        System.out.println();
        // Implementacion del metodo 3.
        provinciaDiasMasLluvioso(tabla,dias);

    }
}
