/* Ejercicio 6
Modifica el programa anterior de tal forma que no se repita ningún número
en el array.*/
package arraysBidimensionales;

import java.util.Random;

import static arraysBidimensionales.Ejercicio1_pag84.showMatrix;

public class Ejercicio6_pag85 {
    /**
     * Iterates through the array finding the smallest number
     * @param matrix Array to iterate.
     * @return A array with a position of the min value. data[0] It's the minimun number.
     * data[1] It's the row position.
     * data[2] It's the col position.
     */
    public static int[] findMinValue(int[][] matrix) {
        int[] data = {Integer.MAX_VALUE, //data[0] The value of minimun number.
                                      0, //data[1] The row position of this number.
                                      0  //data[2] The col position of thhis number.
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

    /**
     * Fill the table with the random numbers but not repeat the number.
     * @param matrix A table to fill.
     * @param minorRandom The minor value of random number.
     * @param maxRandom The minor value of random number.
     */
    public static void fillNumbersNotRepeat (int[][] matrix,int minorRandom, int maxRandom) {
        Random rnd = new Random();
        boolean exists;
        int randomNumber;
        int c = matrix[0].length;

        for (int p = 0; p < (matrix.length * matrix[0].length); p++) {
            do {
                exists = false;
                randomNumber = rnd.nextInt(minorRandom,maxRandom);
                for (int check = 0; check < p; check++) {
                    if (matrix[check/10][check%10] == randomNumber) {
                        exists = true;
                        check = p;
                    }
                }
            }while (exists == true);
            matrix[p/c][p%c] = randomNumber;
        }

    }
    public static void main(String[] args) {
        int[][] table = new int[6][10];
        int[] dataMinValue, dataMaxValue;

        fillNumbersNotRepeat(table,0,1000);
        dataMinValue = findMinValue(table);
        dataMaxValue = findMaxValue(table);

        showMatrix(table);
        showResults(dataMinValue,dataMaxValue);
    }
}
