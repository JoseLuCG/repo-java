/* 6.
    Un cuadrado mágico de orden N es una matriz cuadrada de dimensiones
NxN que contiene a los números naturales de 1 a N2, tal que la suma de
cualquier columna, fila o diagonal es siempre la misma. El algoritmo para
construir el cuadrado mágico es:

1.- El número 1 se coloca en la casilla central de la primera fila.
2.- Cada número siguiente se coloca en la casilla correspondiente a la fila
anterior y columna posterior.
3.- Si el número es el siguiente a un múltiplo de N no se aplica la regla 2,
sino que se coloca en la casilla de la fila posterior en la misma columna.
4.- La fila anterior a la primera es la última.
5.- La columna posterior a la última es la primera.

Hacer un programa que pida por teclado un número impar N comprendido entre 3 y 49, y
que a continuación genere e imprima un cuadrado mágico de orden N. */
package EjerciciosProfesora;

import java.util.Random;
import java.util.Scanner;
import static EjerciciosProfesora.Ejercicio1.showMatrix;

public class Ejercicio6 {
    public static Random rnd = new Random();

    /**
     * Get the dimension from the user and size the array.
     * @return Already dimensioned matrix.
     */
    public static int[][] requestDimension () {
        int[][] matrix;
        Scanner sc = new Scanner(System.in);
        int dimension;

        System.out.println("Escribe la dimension que tendra el cuadrado magico, un numero impar:");
        dimension = sc.nextInt();

        matrix = new int[dimension][dimension];
        return matrix;
    }

    /**
     * Fill the matrix in order by magic square.
     * @param matrix Table to fill.
     */
    public static void fillMagicSquare (int[][] matrix) {
        int column = matrix[0].length / 2;
        int dimension = matrix.length;
        int row = 0;

        matrix[row][column] = 1;
        for (int number = 2; number <= matrix.length * matrix.length; number++) {
            if ( (number-1) % dimension != 0 ) {
                row--;
                column++;
                if (row == -1) row = dimension-1;
                if ( column == dimension ) column = 0;
            } else row ++;
            matrix[row][column] = number;
        }
    }

    public static void main(String[] args) {
        int[][] magicSquare;

        // Give the dimension to the matrix.
        magicSquare = requestDimension();

        // Fill the matrix whit the numbers.
        fillMagicSquare(magicSquare);

        //Print matrix.
        showMatrix(magicSquare);

    }
}
