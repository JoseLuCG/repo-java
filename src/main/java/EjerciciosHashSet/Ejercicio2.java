package EjerciciosHashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

import static EjerciciosHashSet.Ejercicio1.outPut;
/*
* Escribe la función “SorteoBonoloto” que nos da los 7 números diferentes entre 1 y 49.
* el séptimo número es el complementario y los 6 restantes una  combinación de la lotería.
* También se obtendrá el reintegro que será valor de 0 a 9. Mostrar la combinación con los
* números ordenados de forma creciente, el complementario y el reintegro. */
public class Ejercicio2 {
    public static Random rnd = new Random();

    public static int[] createNumbers () {
        int[] numbers = new int[49];

        for (int num = 0; num < numbers.length; num++) {
            numbers[num] = num + 1;
        }
        return numbers;
    }

    public static void bonolotoLottery (int[] numbers) {
        HashSet<Integer> loteryNumbers = new HashSet<>();
        int complementary = 0;
        int refund;

        while (loteryNumbers.size() < 7) {
            complementary = rnd.nextInt(1,50);
            loteryNumbers.add(complementary);
        }
        loteryNumbers.remove(complementary);
        refund = rnd.nextInt(0,10);

        outPut.print(loteryNumbers);
        outPut.print(" ["+complementary+"]");
        outPut.print(" ["+refund+"]");
    }

    public static void main(String[] args) {
        int[] numbers;

        numbers = createNumbers();
        bonolotoLottery(numbers);

    }
}
