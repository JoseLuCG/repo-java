package arraysBidimensionales;

public class Ejercicio1_pag84 {
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\033[39m";
    /**
     * Show the array.
     * @param matrix Array to show.
     */
    public static void showMatrix (int[][] matrix){
        System.out.printf("Array num %1s | ","");
        for (int c = 0; c < matrix[0].length; c++) {
            System.out.printf(RED+"Columna %1d | ", c);
        }
        System.out.println();
        for (int f = 0; f < matrix.length; f++) {
            System.out.printf(GREEN+"Fila %6s |",f);
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.printf(CYAN+"%10d |",matrix[f][c]);
            }
            System.out.println(RESET);
        }
    }

    public static void fillMatrix (int[][] matrix){
        matrix[0][1] = 30;
        matrix[0][2] = 2;
        matrix[0][5] = 5;
        matrix[1][0] = 75;
        matrix[2][2] = -2;
        matrix[2][3] = 9;
        matrix[2][5] = 11;
    }
    public static void main(String[] args) {
        /* Ejercicio 1.
        Define un array de números enteros de 3 filas por 6 columnas con nombre
        num y asigna los valores según la siguiente tabla. Muestra el contenido
        de todos los elementos del array dispuestos en forma de tabla como se
        muestra en la figura. */
        int[][] num = new int[3][6];

        fillMatrix(num);
        showMatrix(num);
    }
}
