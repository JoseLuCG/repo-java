package ejerciciosRepaso.Ejercicio3;

import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        TreeSet<String> diferentWords = new TreeSet<>();
        String palabras;
        String[] spliterWords;

        System.out.println("Escribe tu texto:");
        palabras = sc.nextLine();
        spliterWords = palabras.split(" ");
        diferentWords.addAll(List.of(spliterWords));

        System.out.println(diferentWords.size());
    }
}
