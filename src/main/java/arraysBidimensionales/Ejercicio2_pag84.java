/* Ejercicio 2
    Escribe un programa que pida 20 números enteros. Estos números se deben
introducir en un array de 4 filas por 5 columnas. El programa mostrará las
sumas parciales de filas y columnas igual que si de una hoja de cálculo se
tratara. La suma total debe aparecer en la esquina inferior derecha. */
package arraysBidimensionales;

import java.util.Scanner;
import static arraysBidimensionales.Ejercicio1_pag84.showMatrix;

public class Ejercicio2_pag84 {
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
    public static void main(String[] args) {
        int[][] table = new int[4][5];

        requestNumbers(table);
        showMatrix(table);

    }
}
