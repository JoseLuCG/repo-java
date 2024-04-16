package ejerciciosClasesJava4;

import static ejerciciosClasesJava4.functions.*;
import static ejerciciosClasesJava4.Prueba.arrayVias;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static PrintStream outPut = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
            outPut.println("========================================");
            outPut.println("========================================");
            outPut.println("Seleccione la opción que desea realizar:");
            outPut.println("[ 1 ] - Rellenar datos.");
            outPut.println("[ 2 ] - Realizar un listado de las vias.");
            outPut.println("[ 3 ] - Mostrar la via más antigua.");
            outPut.println("[ 4 ] - Mostrar las carreteras con más vias.");
            outPut.println("[ 5 ] - Mostrar las vias ordenadas por kilómetros.");
            outPut.println("[ 6 ] - Salir.");
            outPut.println("========================================");
            outPut.println("========================================");
            option = sc.nextInt();

            switch (option) {
                case 1: fillArray(arrayVias); break;
                case 2: showArray(arrayVias); break;
                case 3: oldestRoad(arrayVias); break;
                case 4: roadWithMoreRoads(arrayVias); break;
                case 5: System.out.println("5"); break;
                case 6: outPut.println("Sesión cerrada."); break;
                default: outPut.println("Ha ocurrido un error."); break;
            }
        }while(option != 6);

    }
}
