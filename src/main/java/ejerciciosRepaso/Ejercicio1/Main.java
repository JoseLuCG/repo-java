package ejerciciosRepaso.Ejercicio1;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int userNumber;

        do {
            System.out.println("Introduce un numero impar");
            userNumber = sc.nextInt();
        }while (userNumber % 2 == 0);

        for (int f = 0; f < userNumber; f++) {
            for (int c = 0; c < userNumber; c++) {
                if ((f == c) && (f + c == userNumber - 1)) System.out.print("*");
                if (f == c && !((f == c) && (f + c == userNumber - 1))) System.out.print("p");
                if (f + c == userNumber - 1 && !((f == c) && (f + c == userNumber - 1))) System.out.print("s");
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
