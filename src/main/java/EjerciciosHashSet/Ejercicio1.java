package EjerciciosHashSet;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/* Desarrollar un programa que codifique en código morse las diferentes palabras de un texto
* facilitado por el usuario. Para realizar dicha conversión se utilizarán los siguientes
* caracteres y los signos morse que le corresponde. */
public class Ejercicio1 {
    public static Scanner sc = new Scanner(System.in);
    public static PrintStream outPut = new PrintStream(System.out, true, StandardCharsets.UTF_8);

    public static String codificator (String text) {
        String[] morseCode = {".----", "..---", "... --", "....-", ".....",
                "_....", "_ _...", "- - -..", "----.", "-----", ".-", "-...",
                "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
                ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
                "--..", ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--..", " ", ".-.-.-", "--..--", "..--..", "---...",
                "-....-", "!"," "};
        String characters = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ .,?:-!";
        String[] textString = text.split("[,.;: -]+");
        HashSet<String> stringText = new HashSet<>();
        String encodedtext = "";

        stringText.addAll(List.of(textString));
        for (String word: stringText) {
            for (int i = 0; i < word.length(); i++) {
                char letterOfWord = word.charAt(i);
                if (characters.indexOf(letterOfWord) != -1) {
                    int indexOfCharacter = characters.indexOf(letterOfWord);
                    encodedtext += morseCode[indexOfCharacter];
                }
            }
        }
        return encodedtext;
    }

    public static void main(String[] args) {
        String userText;
        String encoded;

        outPut.println("Escribe un texto:");
        userText = sc.nextLine();

        encoded = codificator(userText);
        outPut.println(encoded);


    }
}
