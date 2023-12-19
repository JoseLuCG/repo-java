/* 4.
Escriba un programa que lea una frase y a continuación visualice cada palabra
de la frase en columnas, seguida del número de letras que tiene cada palabra. */
package strings;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Ejercicio4 {
    public static PrintStream printOut = new PrintStream(System.out,true, StandardCharsets.UTF_8);
    public static void counterWords (String textUSer) {
        String[] textWords = textUSer.split("[,.;: ]+");

        for (int word = 0; word < textWords.length; word++) {
            printOut.println(textWords[word]+" ==> Tiene: "+textWords[word].length()+" letras");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text;

        System.out.println("Escribe algo:");
        text = sc.nextLine();
        counterWords(text);
    }
}
