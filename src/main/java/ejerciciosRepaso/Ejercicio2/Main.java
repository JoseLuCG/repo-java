package ejerciciosRepaso.Ejercicio2;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void calculator (int gramsToLose, int restGrams, int sumGrams) {
        int gramsLostAtDay = restGrams - sumGrams;
        int result = gramsToLose / gramsLostAtDay;
        System.out.println(result);

    }
    public static void main(String[] args) {
        int gramsToLose;
        int gramsLostTraining;
        int gramsRecovered;

        gramsToLose = sc.nextInt();
        gramsLostTraining = sc.nextInt();
        gramsRecovered = sc.nextInt();
        if (gramsToLose < gramsLostTraining) {

        }
        calculator(gramsToLose, gramsLostTraining, gramsRecovered);

    }
}
