package EjerciciosAceptaElReto.Ejercicio416_MichaelFox;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static ejerciciosColecciones.Main.outPut;
import static EjerciciosAceptaElReto.Ejercicio416_MichaelFox.functions.*;

public class Ejercicio416 {
    public static void main(String[] args) {
        ArrayList<Fecha_Nacimiento> fechas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int persons;

        do {
            outPut.println("¿Cuantas personas son?");
            persons = sc.nextInt();

            fillArrayList(persons, fechas);
            outPut.println(fechas);
            checkerDatesEquals(fechas);

        }while (persons != 0);

    }
}
