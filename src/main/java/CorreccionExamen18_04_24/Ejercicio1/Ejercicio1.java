package CorreccionExamen18_04_24.Ejercicio1;

import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String texto, palabraMasLarga = "";
        String[] palabras;

        System.out.println("Introduceme un texto:");
        texto = sc.nextLine();
        palabras = texto.split("[ ,.;:]+");
        TreeSet<String> palbrasOrdenadas = new TreeSet<>(List.of(palabras));

        for (String p: palbrasOrdenadas) {
            System.out.println(p);
            if (p.length() > palabraMasLarga.length()) {
                palabraMasLarga = p;
            }
        }
        System.out.println();
        System.out.print("La palabra mas larga es: ");
        System.out.print(palabraMasLarga);

        if (palabras.length == palbrasOrdenadas.size()) {
            System.out.println("No hay palabras repetidas.");
        } else {
            System.out.println("Hay palabras repetidas.");
        }

    }
}
