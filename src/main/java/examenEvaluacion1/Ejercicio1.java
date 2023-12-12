package examenEvaluacion1;

import java.util.Scanner;

public class Ejercicio1 {
    public static boolean EsPrimo (int num) {
        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroInicio;
        int numeroFinal;
        System.out.println("Selecciona el numero donde empezara el intervalo:");
        numeroInicio = sc.nextInt();
        System.out.println("Selecciona el numero donde termina el intervalo:");
        numeroFinal = sc.nextInt();

        System.out.println("Los numeros primos son:");
        for (int numero = numeroInicio; numero < numeroFinal; numero++) {
            if (EsPrimo(numero)) System.out.print(numero+",");
        }
    }
}
