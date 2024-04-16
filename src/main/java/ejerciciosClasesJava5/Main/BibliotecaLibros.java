package ejerciciosClasesJava5.Main;

import ejerciciosClasesJava5.Libro.Libro;

import java.util.ArrayList;

import static ejerciciosClasesJava5.Main.Functions.*;
public class BibliotecaLibros {
    static ArrayList<Libro> books = new ArrayList<>();
    public static void main(String[] args) {
        int option;

        do {
            System.out.println("\n");
            outPut.println("BIBLIOTECA DA CARBALLEIRA");
            outPut.println("=========================");
            outPut.println("1. Listado.");
            outPut.println("2. Nuevo Libro.");
            outPut.println("3. Modificar.");
            outPut.println("4. Borrar.");
            outPut.println("5. Salir.");
            outPut.println("=========================");

            option = sc.nextInt();
            System.out.print("\n");

            switch (option) {
                case 1: listBooks(books); break;
                case 2: insertNewBook(books); break;
                case 3: modifyBook(books); break;
                case 4: System.out.println(option); break;
            }

        }while (option != 5);
    }
}
