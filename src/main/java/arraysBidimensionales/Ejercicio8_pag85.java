/* Ejercicio 8
    Escribe un programa que, dada una posición en un tablero de ajedrez, nos diga
a qué casillas podría saltar un alfil que se encuentra en esa posición. Como se
indica en la figura, el alfil se mueve siempre en diagonal. El tablero cuenta con
64 casillas. Las columnas se indican con las letras de la “a” a la “h” y las filas
se indican del 1 al 8. */
package arraysBidimensionales;

import java.util.Scanner;

public class Ejercicio8_pag85 {
    public static final String CYAN = "\u001B[36m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String GREEN = "\u001B[32m";
    /**
     * Parse the user's entered position to valid coordinates for the matrix.
     * @param userPosition Coordinates that introduce the user in string format.
     * @return Array with the bishop position in the matrix in integer format. pos[0] = row coordinate, pos[1] = col coordinate.
     */
    public static int[] parsingPosition(String userPosition){
        char row = userPosition.charAt(1);
        char col = userPosition.charAt(0);
        int rowBishopPosition, colBishopPosition;
        int[] parsingCoordinates = new int[2];

        rowBishopPosition = 8-((int)row-48);
        colBishopPosition = (int)col-97;
        parsingCoordinates[0] = rowBishopPosition;
        parsingCoordinates[1] = colBishopPosition;

        return parsingCoordinates;
    }

    /**
     * Request the bishop position to user. This request requests a string with a letter and a number.
     */
    public static int[] requestPosition () {
        Scanner sc = new Scanner(System.in);
        String position;
        int[] positionCoordinates;

        System.out.println("Introduce la posicion del alfil:");
        position = sc.next().toLowerCase();
        positionCoordinates = parsingPosition(position);

        return positionCoordinates;
    }

    /**
     * Range the upward part of the main diagonal.
     * @param position The position of the bishop.
     * @param letters Array for transform the coordinates of the matrix for the user.
     */
    public static void upwardMainDiagonal (int[] position, char[] letters) {
        int row = position[0];
        int col = position[1];
        int colP = col-1;

        for (int pos = row-1; pos >=0 && colP >= 0 ; pos--) {
            System.out.print(CYAN+"("+letters[colP]+""+(8-pos)+")");
            colP--;
        }
    }

    /**
     * Range the descending part of the main diagonal.
     * @param position The position of the bishop.
     * @param letters Array for transform the coordinates of the matrix for the user.
     */
    public static void descendingMainDiagonal (int[] position, char[] letters) {
        int row = position[0];
        int col = position[1];
        int colP = col+1;

        for (int rowPosition = row+1; rowPosition < 8 && colP < 8; rowPosition++) {
            System.out.print(BLUE+"("+letters[colP]+""+(8-rowPosition)+")");
            colP++;
        }
    }
    /**
     * Range the upward part of the second diagonal.
     * @param position The position of the bishop.
     * @param letters Array for transform the coordinates of the matrix for the user.
     */
    public static void upwardSecondDiagonal (int[] position, char[] letters) {
        int row = position[0];
        int col = position[1];
        int colP = col+1;

        for (int rowPosition = row-1; rowPosition >=0 && colP <8; rowPosition--) {
            System.out.print(PURPLE+"("+letters[colP]+""+(8-rowPosition)+")");
            colP++;
        }
    }

    /**
     * Range the descending part of the second diagonal.
     * @param position The position of the bishop.
     * @param letters Array for transform the coordinates of the matrix for the user.
     */
    public static void descendingSecondDiagonal (int[] position, char[] letters) {
        int row = position[0];
        int col = position[1];
        int colP = col-1;

        for (int rowPosition = row+1; rowPosition < 8 && colP >= 0 ; rowPosition++) {
            System.out.print(GREEN+"("+letters[colP]+""+(8-rowPosition)+")");
            colP--;
        }
    }
    public static void main(String[] args) {
        int[][] chessBoard = new int[8][8];
        char[] columnPosition = {'a','b','c','d','e','f','g','h'};

        int[] position;

        // Request the bishop position.
        position = requestPosition();

        // Show the solution.
        System.out.println("Las posiciones en las que puede ubicarse el alfil son:");

        // Range the main diagonal.
        upwardMainDiagonal(position,columnPosition);
        descendingMainDiagonal(position,columnPosition);

        // Range the second diagonal.
        upwardSecondDiagonal(position,columnPosition);
        descendingSecondDiagonal(position,columnPosition);
    }
}
