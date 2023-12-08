/* Ejercicio 7
    Mejora el juego “Busca el tesoro” de tal forma que si hay una mina a una casilla
de distancia, el programa avise diciendo ¡Cuidado! ¡Hay una mina cerca! */
package arraysBidimensionales;

import java.util.Random;
import java.util.Scanner;

import static arraysBidimensionales.Ejercicio1_pag84.showMatrix;

public class Ejercicio7_pag85 {
    /**
     * Locate the game object in the game.
     * @param matrix The board of the game.
     * @param gameObject The game object. 2: the treasure and 1: the mine.
     */
    public static int[] locator (int[][] matrix,int gameObject) {
        Random rnd = new Random();
        int locationRow, locationColumn;
        int l = matrix.length-1;
        int l0 = matrix[0].length-1;
        int[] mineLocation = new int[2];

        if (gameObject == 2) {
            locationRow = rnd.nextInt(0, l);
            locationColumn = rnd.nextInt(0, l0);
            matrix[locationRow][locationColumn] = gameObject;
        } else {
            do {
                locationRow = rnd.nextInt(0,l);
                locationColumn = rnd.nextInt(0,l0);
                matrix[locationRow][locationColumn] = gameObject;
                mineLocation[0] = locationRow;
                mineLocation[1] = locationColumn;
            } while (matrix[locationRow][locationColumn] == 2);
        }
        return mineLocation;
    }

    public static int[] requestTheCoordinates (int[][] matrix) {
        Scanner sc = new Scanner(System.in);
        int[] coordinates = new int[2];

        do {
            System.out.println("Escribe el numero de fila:");
            coordinates[0] = sc.nextInt();
            System.out.println("Escribe el numero de columna:");
            coordinates[1] = sc.nextInt();
        }while ( (coordinates[0] > (matrix.length-1)) && (coordinates[1] > (matrix[0].length-1)) );
        return coordinates;
    }
    public static void trackTheMine(int[][] matrix,int rowUser, int colUser,int[] mineData){
        int mineRowPosition = mineData[0];
        int mineColPosition = mineData[1];
        int absRowPos = Math.abs(mineRowPosition-rowUser);
        int absColPos = Math.abs(mineColPosition-colUser);

        if ( (absRowPos == 1 && absColPos == 1) || (absRowPos == 0 && absColPos == 1) || (absRowPos == 1 && absColPos == 0) ) {
            System.out.println("Tienes una mina cerca");
        }
    }

    /**
     * Check the position given by the player and indicates if has a mine nearby.
     * @param matrix - Board of the game.
     * @param coordinatesUser The array with the coordinates of the user: pos[0] = row, pos[1] = col.
     * @param dataMine The array with the coordinates of the mine: pos[0] = row, pos[1] = col.
     * @return A boolean that indicates if the program continue.
     */
    public static boolean checkoutPosition (int[][] matrix, int[] coordinatesUser,int[] dataMine) {
        int rowPosition = coordinatesUser[0];
        int colPosition = coordinatesUser[1];
        boolean gameContinue = true;

        if (matrix[rowPosition][colPosition] == 0) {
            System.out.println("No has encontrado nada.");
            trackTheMine(matrix,rowPosition,colPosition, dataMine);
            gameContinue = true;
        } else if (matrix[rowPosition][colPosition] == 1) {
            System.out.println("Has perdido. Te ha explotado la mina");
            gameContinue = false;
        } else {
            System.out.println("Enhorabuena!, has encontrado el tesoro!");
            gameContinue = false;
        }
        return gameContinue;
    }
    public static void main(String[] args) {
        // Treasure = 2.
        // Mine     = 1.
        int[][] game = new int[5][4];
        int[] data, mine;
        int attempts = 3;
        boolean continueGame;

        // Allocate the treasure.
        locator(game,2);

        // Allocate the mine.
        mine = locator(game,1);

        do {
            // Reques the player the coordinates.
            data = requestTheCoordinates(game);
            // Check what's in the coordinates given by the player.
            continueGame = checkoutPosition(game,data,mine);
            attempts--;
        } while (continueGame && attempts > 0);

        //show the game.
        showMatrix(game);
    }
}
