package ejerciciosClasesJava5.Main;

import ejerciciosClasesJava5.Libro.Libro;
import ejerciciosClasesJava5.Libro.Novela;
import ejerciciosClasesJava5.Libro.Periodico;
import ejerciciosClasesJava5.Libro.Revista;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Functions {
    public static PrintStream outPut = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    public static Scanner sc = new Scanner(System.in);

    /**
     * Shows the books in passed collection as parameter.
     * @param collection A ArrayList of `Libro`.
     */
    public static void listBooks (ArrayList<Libro> collection) {
        for (Libro book: collection) {
            outPut.println(book.toString());
        }
    }

    public static void insertNewBook (ArrayList<Libro> collection) {
        int bookType;

        do {
            outPut.println("Porfavor, introduzca los datos del libro:");
            outPut.println("[1] - Novela.");
            outPut.println("[2] - Revista.");
            outPut.println("[3] - Periodico.");
            bookType = sc.nextInt();

            switch (bookType) {
                case 1: collection.add( newNovela() ); break;
                case 2: collection.add( newRevista() ); break;
                case 3: collection.add( newPeriodico() ); break;
            }

        } while (bookType != 1 && bookType != 2 && bookType != 3);
    }
    private static Novela newNovela () {
        String title, author, editorial, genre, isbn;
        int numPages;

        System.out.println("\n");
        outPut.println("Introduce los datos de tu novela:");
        outPut.println("Introduce el título: ");
        sc.nextLine();
        title = sc.nextLine();
        outPut.println("Introduce el autor de tu novela: ");
        author = sc.nextLine();
        outPut.println("Introduce el número de páginas: ");
        numPages = sc.nextInt();
        outPut.println("Introduce la editorial de tu novela: ");
        editorial = sc.nextLine();
        outPut.println("Introduce el ISBN de tu novela: ");
        isbn = sc.nextLine();
        outPut.println("Introduce el género de tu novela: ");
        genre = sc.nextLine();

       Novela newNovela = new Novela(title, author, numPages, editorial, isbn, genre);

       return newNovela;
    }
    private static Revista newRevista () {
        String title, author, editorial;
        int numPages, number, year, month, day;
        LocalDate publication;

        System.out.println("\n");
        outPut.println("Introduce los datos de tu revista: ");
        outPut.println("Introduce el título: ");
        sc.nextLine();
        title = sc.nextLine();
        outPut.println("Introduce el autor de tu revista: ");
        author = sc.nextLine();
        outPut.println("Introduce el número de páginas: ");
        numPages = sc.nextInt();
        outPut.println("Introduce la editorial de tu revista: ");
        editorial = sc.nextLine();
        outPut.println("introduce el número de tu revista: ");
        number = sc.nextInt();
        outPut.println("Introduce la fecha de publicación: ");
        outPut.println("Año: ");
        year = sc.nextInt();
        outPut.println("Mes: ");
        month = sc.nextInt();
        outPut.println("Día: ");
        day = sc.nextInt();
        publication = LocalDate.of(year, month, day);

        Revista newRevista = new Revista(title,author,numPages,editorial,number, publication);

        return newRevista;
    }

    private static Periodico newPeriodico () {
        String title, author, editorial, type;
        int numPages, number, year, month, day;
        LocalDate publication;

        System.out.println("\n");
        outPut.println("Introduce los datos de tu periódico: ");
        outPut.println("Introduce el título: ");
        sc.nextLine();
        title = sc.nextLine();
        outPut.println("Introduce el autor: ");
        author = sc.nextLine();
        outPut.println("Introduce el número de páginas: ");
        numPages = sc.nextInt();
        outPut.println("Introduce la editorial: ");
        sc.nextLine();
        editorial = sc.nextLine();
        outPut.println("Introduce el tipo de tu periódico");
        type = sc.nextLine();
        outPut.println("introduce el número de tu periódico: ");
        number = sc.nextInt();
        outPut.println("Introduce la fecha de publicación: ");
        outPut.println("Año: ");
        year = sc.nextInt();
        outPut.println("Mes: ");
        month = sc.nextInt();
        outPut.println("Día: ");
        day = sc.nextInt();
        publication = LocalDate.of(year, month, day);

        Periodico newPeriodico = new Periodico(title,author,numPages, editorial,type, number, publication);

        return newPeriodico;
    }

    public static void modifyBook (ArrayList<Libro> collection) {
        int bookCode;

        outPut.println("Que libro deseas modificar: ");

    }
}
