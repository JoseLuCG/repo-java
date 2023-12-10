/* 3.
    Hacer un programa que genere e imprima un cuadrado latino de orden 10
(matriz 10x10). Un cuadradado latino de orden n es aquel en el que la primera
fila tiene los nº naturales del 1 a n, y cada una de las filas restantes de
la matriz es igual a su fila superior desplazada una posicion hacia la derecha,
entrando por la izquierda el número que se pierde en el desplazamiento. Por
ejemplo, un cuadrado latino de orden 5 es:

        1  2  3  4  5
        5  1  2  3  4
        4  5  1  2  3
        3  4  5  1  2   */
package EjerciciosProfesora;

import static EjerciciosProfesora.Ejercicio1.showMatrix;

public class Ejercicio3 {
    public static void fillerSquare (int[][] matrix) {
        int counter = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = counter;
                counter++;
                if (counter > 10) counter = 1;
                matrix[row][col] = counter;
            }
            counter--;
        }
    }
    public static void main(String[] args) {
        int[][] latinSquare = new int[10][10];

        // Fill the matrix with the numbers.
        fillerSquare(latinSquare);
        // Print the table in console.
        showMatrix(latinSquare);
    }
}
