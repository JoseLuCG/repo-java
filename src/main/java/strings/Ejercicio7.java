package strings;

import java.util.Scanner;
import static strings.Ejercicio6.outPut;

public class Ejercicio7 {
    public static Scanner sc = new Scanner(System.in);
    public static boolean validateCard (String numberOfCard) {
        boolean valid = true;
        int sumOfEvenNumbers = 0;
        int totalSum = 0;

        // In the position number had the odd numbers.
        // in the position (number-1) had the even numbers.
        for (int number = numberOfCard.length()-1; number >= 0 ; number -= 2) {
            if (number != 0) {
                sumOfEvenNumbers = Integer.parseInt(numberOfCard.charAt(number-1)+"") * 2;
                if (sumOfEvenNumbers > 9) {
                    sumOfEvenNumbers = (sumOfEvenNumbers/10) + (sumOfEvenNumbers%10);
                }
                totalSum = totalSum + sumOfEvenNumbers;
            }
            totalSum = totalSum + Integer.parseInt(numberOfCard.charAt(number)+"");
        }
        if (!(totalSum%10 == 0)) valid = false;

        return valid;
    }
    public static void main(String[] args) {
        String cardNumber;
        boolean valid;
        outPut.println("Escribe un número de tarjeta:");
        cardNumber = sc.nextLine();
        valid = validateCard(cardNumber);
        System.out.println();
        outPut.println(valid ? "El número de tarjeta es correcto." : "El número de la tarjeta es incorrecto");
    }
}
