/* 2.
    Leer una cadena de texto y generar un array de palabras con la función split(). Posteriormente,
mostrar la siguiente información: Número de palabras, primera palabra, última palabra, las palabras
colocadas en orden inverso, las palabras ordenadas de la a la z y las palabras ordenadas de la z a
la a. Sacar toda esta información en una ventana nueva. */
package strings;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {
    public static void counterTextLine (String text_) {
        String text = text_.toLowerCase();
        String[] words = text.split("[,.;: ]+");

        //Show the number of words:
        System.out.print("Numero de palabras del texto:");
        System.out.print("  "+words.length);
        System.out.println();
        System.out.println("Primera palabra: "+words[0]);
        System.out.println("Ultima palabra: "+words[words.length-1]);

        Arrays.sort(words);
        for (int word = 0; word < words.length; word++) {
            System.out.printf("%4s"," "+words[word]);
        }
        System.out.println();

        for (int word = words.length-1; word >= 0; word--) {
            System.out.printf("%4s"," "+words[word]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String textUser;

        System.out.println("Escribe algo:");
        textUser = sc.nextLine();

        counterTextLine(textUser);
    }
}
