/* 2.
    Hacer un programa que averigüe si una matriz cuadrada de orden 4 es
simétrica. Al declarar la matriz asignarle valores que representen una
matriz simétrica. Probar el programa con la matriz inicial, y después
cambiar uno de los valores para que no sea simétrica. Una matriz es
simétrica cuando a[f][c]=a[c][f] para cualquier elemento de la matriz.
 */
package EjerciciosProfesora;
import static EjerciciosProfesora.Ejercicio1.showMatrix;

public class Ejercicio2 {
    public static void symmetricMatrixCreator (int[][] matrix) {

    }
    public static void main(String[] args) {
        int[][] symmetricalMatrix = new int[4][4]; //Declares the symetrical matrix.

        //Print the table.
        showMatrix(symmetricalMatrix);
    }
}
