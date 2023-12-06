/* Ejercicio 5
    Realiza un programa que rellene un array de 6 filas por 10 columnas
con números enteros positivos comprendidos entre 0 y 1000 (ambos incluidos).
A continuación, el programa deberá dar la posición tanto del máximo como del
mínimo. */
package arraysBidimensionales;

import static arraysBidimensionales.Ejercicio3_pag85.fillNumbers;
import static arraysBidimensionales.Ejercicio1_pag84.showMatrix;

public class Ejercicio5_pag85 {
    /**
     * Iterates through the array finding the smallest number
     * @param matrix Array to iterate.
     * @return A array with a position of the min value. data[0] It's the minimun number.
     * data[1] It's the row position.
     * data[2] It's the col position.
     */
    public static int[] findMinValue(int[][] matrix) {
        int[] data = {Integer.MAX_VALUE, //data[0] The value of minimun number.
                      0,                 //data[1] The row position of this number.
                      0                  //data[2] The col position of thhis number.
        };

        // Find the max value.
        for (int f = 0; f < matrix.length; f++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if ( matrix[f][c] < data[0] ) {
                    data[0] = matrix[f][c];
                    data[1] = f;
                    data[2] = c;
                }
            }
        }
        return data;
    }
    /**
     * Iterates through the array finding the largest number
     * @param matrix Array to iterate.
     * @return A array with a position of the max value. data[0] It's the maximun number.
     * data[1] It's the row position.
     * data[2] It's the col position.
     */
    public static int[] findMaxValue(int[][] matrix) {
        int[] data = {Integer.MIN_VALUE, //data[0] The value of maximun number.
                                      0, //data[1] The row position of this number.
                                      0 //data[2] The col position of thhis number.
        };

        // Find the max value.
        for (int f = 0; f < matrix.length; f++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if ( matrix[f][c] > data[0] ) {
                    data[0] = matrix[f][c];
                    data[1] = f;
                    data[2] = c;
                }
            }
        }
        return data;
    }
    /**
     * Print the position and value of the minimun and maximun numbers.
     * @param dataMinValue Array with the value and position of minimun number.
     * @param dataMaxValue Array with the value and position of maximun number.
     */
    public static void showResults (int[] dataMinValue,int[] dataMaxValue) {
        System.out.println("El numero mas pequeño encontrado es: "+dataMinValue[0]);
        System.out.println("Este numero esta en la fila: "+dataMinValue[1]+" columna: "+dataMinValue[2]);
        System.out.println();
        System.out.println("El numero mas alto encontrado es: "+dataMaxValue[0]);
        System.out.println("Este numero esta en la fila: "+dataMaxValue[1]+" columna: "+dataMaxValue[2]);
    }
    public static void main(String[] args) {
        int[][] table = new int[6][10];
        int[] dataMinValue, dataMaxValue;

        fillNumbers(table,0,1000);
        dataMinValue = findMinValue(table);
        dataMaxValue = findMaxValue(table);

        showMatrix(table);
        showResults(dataMinValue,dataMaxValue);
    }
}
