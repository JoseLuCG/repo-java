/* Ejercicio 3.
    Modifica el programa anterior de tal forma que los números que se introducen
en el array se generen de forma aleatoria (valores entre 100 y 999). */
package arraysBidimensionales;

import java.util.Random;

public class Ejercicio3_pag85 {
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\033[39m";
    public static final String PURPLE = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";
    /**
     * Show the array.
     * @param matrix Array to show.
     */
    public static void showMatrix (int[][] matrix, int[] data, int[] dataCols){
        int sumColTotal=0, sumRowTotal=0;
        int sumTotal=0;

        for (int sumRows = 0; sumRows < data.length; sumRows++) {
            sumRowTotal = sumRowTotal + data[sumRows];
        }
        for (int sumCol = 0; sumCol < dataCols.length; sumCol++) {
            sumColTotal = sumColTotal + dataCols[sumCol];
        }
        sumTotal = sumColTotal + sumRowTotal;

        // Print the header of the table.
        System.out.printf("Array num %1s | ","");
        for (int c = 0; c < matrix[0].length; c++) {
            System.out.printf(RED+"Columna %1d | ", c);
        }
        // Print the column of the sums.
        System.out.printf("TOTAL %1s |", "");
        System.out.println();
        // Print the content of the table.
        for (int f = 0; f < matrix.length; f++) {
            // Print the column index.
            System.out.printf(GREEN+"Fila %6s |",f);
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.printf(CYAN+"%10d |",matrix[f][c]);
            }
            // Print the sum of the Rows.
            System.out.printf(" %7d |",data[f]);
            System.out.println(RESET);
        }
        //Print the sum of columns.
        System.out.printf("TOTAL %5s |","");
        for (int d = 0; d < dataCols.length; d++) {
            System.out.printf(PURPLE+"%10d |",dataCols[d]);
        }
        System.out.printf(BLUE+" %7d |",sumTotal);
    }

    /**
     * Fill the table with the random numbers.
     * @param matrix A table to fill.
     */
    public static void fillNumbers (int[][] matrix) {
        Random rnd = new Random();
        for (int f = 0; f < matrix.length; f++) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[f][c] = rnd.nextInt(100,1000);
            }
        }
    }

    /**
     * Sum the data of each row.
     * @param matrix A table to sum.
     */
    public static int[] sumRows (int[][] matrix) {
        int[] data = new int[matrix.length];
        int sumator;

        for (int f = 0; f < matrix.length; f++) {
            sumator = 0 ;
            for (int c = 0; c < matrix[0].length; c++) {
                sumator = sumator + matrix[f][c];
            }
            data[f] = sumator;
        }
        return data;
    }
    /**
     * Sum the data of each column.
     * @param matrix A table to sum.
     */
    public static int[] sumColumns (int[][] matrix) {
        int[] data = new int[matrix[0].length];
        int sumator;

        for (int c = 0; c < matrix[0].length; c++) {
            sumator = 0 ;
            for (int f = 0; f < matrix.length; f++) {
                sumator = sumator + matrix[f][c];
            }
            data[c] = sumator;
        }
        return data;
    }
    public static void main(String[] args) {
        int[][] table = new int[4][5];
        int[] sumRowsData, sumColData;
        fillNumbers(table);
        sumRowsData = sumRows(table);
        sumColData = sumColumns(table);

        showMatrix(table,sumRowsData,sumColData);
    }
}
