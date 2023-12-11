/* 5.
    Hacer un programa que esté asignando valores al azar comprendidos entre
1 y 50 a una matriz de orden 8 x 10 hasta que se cumpla que la matriz generada
tenga al menos un punto de silla. Cuando se halla generado una matriz que tenga
puntos de silla se ha de escribir en pantalla la matriz generada, el punto de
silla junto con sus coordenadas y el número de matrices que se generaron hasta
que se encontró una con puntos de silla. A continuación se muestra un ejemplo
de la salida del programa:  */
package EjerciciosProfesora;

import static EjerciciosProfesora.Ejercicio1.showMatrix;
import static EjerciciosProfesora.Ejercicio4.fillMatrixRandom;
import static EjerciciosProfesora.Ejercicio4.checkSaddleStitch;

public class Ejercicio5 {
    public static void main(String[] args) {
        int[][] table = new int[8][10];
        int counter = 0;
        boolean stopProgram;

        do {
            // Fill the table with random numbers.
            fillMatrixRandom(table,0,101);

            // Print the table.
            showMatrix(table);

            // Check the matrix.
            stopProgram = checkSaddleStitch(table);
            counter++;
        }while (stopProgram);

        System.out.println("Se ha ejecutado el programa "+counter+" veces.");
    }
}
