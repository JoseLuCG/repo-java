/* Ejercicio 9
    Realiza un programa que sea capaz de rotar todos los elementos de una
matriz cuadrada una posición en el sentido de las agujas del reloj. La matriz
debe tener 12 filas por 12 columnas y debe contener números generados al
azar entre 0 y 100. Se debe mostrar tanto la matriz original como la matriz
resultado, ambas con los números convenientemente alineados. */
package arraysBidimensionales;

import static arraysBidimensionales.Ejercicio3_pag85.fillNumbers;
import static arraysBidimensionales.Ejercicio1_pag84.showMatrix;

public class Ejercicio9_pag85 {
    public static void rotateNumbers (int[][] matrix) {
        for (int f = 0; f < matrix.length; f++) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[f][c] = matrix[f][c+1];
            }
        }
    }
    public static void main(String[] args) {
        int[][] rotateTable = new int[12][12];

        // Fill the table with random numbers between 1-100.
        fillNumbers(rotateTable,1,100);

        //Change the position of the numbers.

        // Show the table.
        showMatrix(rotateTable);

    }
}
