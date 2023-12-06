/* Ejercicio 2
    Escribe un programa que pida 20 números enteros. Estos números se deben
introducir en un array de 4 filas por 5 columnas. El programa mostrará las
sumas parciales de filas y columnas igual que si de una hoja de cálculo se
tratara. La suma total debe aparecer en la esquina inferior derecha. */
package arraysBidimensionales;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2_pag84 {
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\033[39m";
    /**
     * Show the array.
     * @param matrix Array to show.
     */
    public static void showMatrix (int[][] matrix, int[] data){
        System.out.printf("Array num %1s | ","");
        for (int c = 0; c < matrix[0].length; c++) {
            System.out.printf(RED+"Columna %1d | ", c);
        }
        System.out.println();
        for (int f = 0; f < matrix.length; f++) {
            System.out.printf(GREEN+"Fila %6s |",f);
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.printf(CYAN+"%10d |",matrix[f][c]);
            }
            System.out.printf(" %2d |",data[f]);
            System.out.println(RESET);
        }
    }

    /**
     * Request 20 numbers from the user.
     * @param matrix A table to fill.
     */
    public static void requestNumbers (int[][] matrix) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserta tus 20 numeros");
        for (int f = 0; f < matrix.length; f++) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[f][c] = sc.nextInt();
            }
        }
    }
    public static int[] sumRows (int[][] matrix) {
        int[] data = new int[4];
        int sumator;

        for (int f = 0; f < matrix.length; f++) {
            sumator = 0 ;
            for (int c = 0; c < matrix[0].length; c++) {
                sumator = sumator + matrix[f][c];
            }
            data[f] = sumator;
        }

        return data;
    }
    public static void main(String[] args) {
        int[][] table = new int[4][5];
        int[] sumData;
        requestNumbers(table);
        sumData = sumRows(table);
        showMatrix(table,sumData);
    }
}
