package strings;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Ejercicio6 {
    public static PrintStream outPut = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    public static String codificator (String text) {
        String codedVowels = "OIEAU";
        String codedNumbers = "=¡-¨$%&/()";
        String codedComforters = "BCDFGHJKLMNPQRST";
        String encodedText = "";
        int position;
        char c ;

        for (int character = 0; character < text.length(); character++) {
            char characterUser = text.toUpperCase().charAt(character);
            position = codedVowels.indexOf(characterUser);
            if (position != -1) {
                encodedText += position;
            } else if (characterUser >= '0' && characterUser <= '9') {
                c = codedNumbers.charAt(Integer.parseInt(characterUser+""));
                encodedText += c;
            } else {
                position = codedComforters.indexOf(characterUser);
                if (position != -1) {
                    if (position == codedComforters.length()-1) {
                        encodedText += codedComforters.charAt(0);
                    } else encodedText += (codedComforters.charAt(position+1));
                }
            }
        }

        return encodedText;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userText, encodedText;

        outPut.println("Escribe tu texto a codificar:");
        userText = sc.nextLine();
        encodedText = codificator(userText);
        outPut.println(encodedText);
    }
}
