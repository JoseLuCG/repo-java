/* 4.
Se define el punto de silla de una matriz como un elemento de la matriz
que es el más pequeño de su fila y el más grande de su columna. Hacer un
programa en el que se le den valores a una matriz en la declaración y que
calcule si tiene o no punto de silla. */

package EjerciciosProfesora;

import java.util.Random;
import static EjerciciosProfesora.Ejercicio1.showMatrix;

public class Ejercicio4 {
    /**
     * Fill the table with the random numbers.
     * @param matrix A table to fill.
     * @param minorRandom The minor value of random number.
     * @param maxRandom The minor value of random number.
     */
    public static void fillMatrixRandom (int[][] matrix, int minorRandom, int maxRandom) {
        Random rnd = new Random();
        for (int f = 0; f < matrix.length; f++) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[f][c] = rnd.nextInt(minorRandom,maxRandom);
            }
        }
    }

    /**
     * Check in the table if it have a saddle stitch.
     * @param matrix Table to check.
     */
    public static void checkSaddleStitch (int[][] matrix) {
        int column = 0;
        int maxValue;
        int minValue;

        for (int row = 0; row < matrix.length; row++) {
            minValue = Integer.MAX_VALUE;
            for (int col = 0; col < matrix[0].length; col++) {
                if ( matrix[row][col] < minValue ) {
                    minValue = matrix[row][col];
                    column = col;
                }
            }
            maxValue = Integer.MIN_VALUE;
            for (int fil = 0; fil < matrix.length; fil++) {
                if ( matrix[fil][column] > maxValue ) {
                  maxValue = matrix[fil][column];
                }
            }
            if (minValue == maxValue) {
                System.out.println("Hay un punto de silla en la fila: "+row+" columna: "+column+" del numero: "+matrix[row][column]);
            }
        }
    }
    public static void main(String[] args) {
        int[][] saddleStitch = new int[8][10];

        // Fill the table with random numbers.
        fillMatrixRandom(saddleStitch,0,101);

        // Print the table.
        showMatrix(saddleStitch);

        // Check the matrix.
        checkSaddleStitch(saddleStitch);
    }
}
