package ejerciciosColecciones;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static ejerciciosColecciones.functions.*;

public class Main {
    public static PrintStream outPut = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Integer> listOfIntegers = new ArrayList<>(
            Arrays.asList(
                    1, -2, 3, -4, 5, -6, 7, -8, 9, -10
            ));
    public static ArrayList<Integer> orderedList = new ArrayList<>(
            Arrays.asList(
                    1, 2, 3, 4, 5, 6, 7, 8, 9, 10
            ));
    public static ArrayList<Integer> repeatList = new ArrayList<>(
            Arrays.asList(
                    1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10
            ));
    public static ArrayList<Integer> positiveNumbers = new ArrayList<>();
    public static ArrayList<Integer> negativeNumbers = new ArrayList<>();
    public static ArrayList<Integer> fashionListNumbers = new ArrayList<>(
            Arrays.asList(
                    1,1,1,2,3,3,4,5,5,5,5,6,7,8,8,9,10
            ));

    public static void main(String[] args) {
        int operation;

        outPut.println("Selecciona la operación a realizar:");
        outPut.println("[ 1 ]: Eliminar los números negativos de una lista.");
        outPut.println("[ 2 ]: Clasificación de números sobre 3 listas.");
        outPut.println("[ 3 ]: Eliminación de elementos repetidos sobre una lista.");
        outPut.println("[ 4 ]: Sorteo de lotería.");
        outPut.println("[ 5 ]: Desordena una lista ordenada.");
        outPut.println("[ 6 ]: Devuelve la moda de una lista de enteros.");
        operation = sc.nextInt();

        switch (operation) {
            case 1:
                showArray(listOfIntegers);
                removeNegativeNumbers(listOfIntegers);
                showArray(listOfIntegers);
                break;
            case 2:
                showArray(listOfIntegers);
                classifyNumbers(listOfIntegers, positiveNumbers, negativeNumbers);
                outPut.print("Números positivos: ");
                showArray(positiveNumbers);
                outPut.print("Números negativos: ");
                showArray(negativeNumbers);
                break;
            case 3:
                showArray(repeatList);
                removeRepeatNumbers(repeatList);
                showArray(repeatList);
                break;
            case 4:
                bonolotolottery();
                break;
            case 5:
                showArray(orderedList);
                listDisorderer(orderedList);
                showArray(orderedList);
                break;
            case 6:
                fashionList();
            default:
                outPut.println("Error");
        }
    }
}
