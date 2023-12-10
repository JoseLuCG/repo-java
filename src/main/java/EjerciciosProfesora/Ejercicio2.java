/* 2.
    Hacer un programa que averigüe si una matriz cuadrada de orden 4 es
simétrica. Al declarar la matriz asignarle valores que representen una
matriz simétrica. Probar el programa con la matriz inicial, y después
cambiar uno de los valores para que no sea simétrica. Una matriz es
simétrica cuando a[f][c]=a[c][f] para cualquier elemento de la matriz. */
package EjerciciosProfesora;

import java.util.Random;
import static EjerciciosProfesora.Ejercicio1.showMatrix;

public class Ejercicio2 {
    public static Random rnd = new Random();

    /**
     * Create a symetrical matrix with random numbers.
     * @param matrix Table for fill.
     */
    public static void symmetricMatrixCreator (int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < row; col++) {
                matrix[row][col] = rnd.nextInt(1,10);
                matrix[col][row] = matrix[row][col];
            }
        }
    }

    /**
     * Check if the table is symetric.
     * @param matrix Table to check.
     */
    public static void checkerSymetricMatrix (int [][] matrix) {
        int counter = 0;
        int numbersForCheck = (matrix.length -1) * (matrix[0].length/2);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < row; col++) {
                if ( matrix[row][col] == matrix[col][row] ) {
                    counter++;
                }
            }
        }
        if (counter == numbersForCheck) System.out.println("La matriz es simetrica");
    }
    public static void main(String[] args) {
        int[][] symmetricalMatrix = new int[4][4]; //Declares the symetrical matrix.
        int changeValue = 0;
        // Introduce numbers in the symetric matrix.
        symmetricMatrixCreator(symmetricalMatrix);

        //Print the table.
        showMatrix(symmetricalMatrix);

        //Change one value.
        changeValue = rnd.nextInt(0,2);
        if ( !(changeValue == 0) ) symmetricalMatrix[1][0] = 2;

        // Check the matrix.
        checkerSymetricMatrix(symmetricalMatrix);
    }
}
