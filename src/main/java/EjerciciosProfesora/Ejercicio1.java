/* 1.
    Hacer un programa que genere y escriba una matriz unitaria de orden 10.
Una matriz unitaria de orden 10 es una matriz de 10x10 en la que todos los
elementos valen 0, excepto los de la diagonal principal que valen 1. La diagonal
principal es la que va de la esquina superior izquierda a la inferior derecha. */
package EjerciciosProfesora;

public class Ejercicio1 {
    public static final String CYAN = "\u001B[36m";
    public static final String PURPLE = "\u001B[35m";
    public static final String RESET = "\033[39m";
    /**
     * Save a one in the main diagonal positions.
     * @param matrix Matrix to roam.
     */
    public static void recordMainDiagonalwithOne (int [][] matrix) {
        int col = 0;

        for (int row = 0; row < matrix.length && col < matrix[0].length; row++) {
            matrix[row][col] = 1;
            col++;
        }
    }

    /**
     * Print the table in the console.
     * @param matrix Matrix to show.
     */
    public static void showMatrix (int[][] matrix) {
        System.out.printf("M%1s","");
        for (int c = 0; c < matrix[0].length; c++) {
            System.out.printf(PURPLE+"%4s", "C"+c);
        }
        System.out.println();
        for (int row = 0; row < matrix.length; row++) {
            System.out.print(CYAN+"R"+row);
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.printf(RESET+"%4d",matrix[row][col]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int [][] unitaryMatrix = new int[10][10];

        // Place the diagonal of 1.
        recordMainDiagonalwithOne(unitaryMatrix);

        // Show the table.
        showMatrix(unitaryMatrix);
    }
}
