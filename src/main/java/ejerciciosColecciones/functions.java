package ejerciciosColecciones;

import java.util.ArrayList;
import java.util.Random;

import static ejerciciosColecciones.Main.outPut;

public class functions {

    public static void showArray(ArrayList<Integer> list) {
        outPut.println(list.toString());
    }
    public static Random rnd = new Random();

    public static void removeNegativeNumbers (ArrayList<Integer> list) {
        for (int num = 0; num < list.size(); num++) {
            if (list.get(num) < 0) {
                list.remove(num);
                num--;
            }
        }
    }

    public static void classifyNumbers (ArrayList<Integer> list, ArrayList<Integer> positives, ArrayList<Integer> negatives) {
        int temp;
        for (int num = 0; num < list.size(); num++) {
            if (list.get(num) < 0) {
                temp = list.get(num);
                negatives.add(temp);
            } else {
                temp = list.get(num);
                positives.add(temp);
            }
        }
    }

    public static void removeRepeatNumbers (ArrayList<Integer> list) {
        ArrayList<Integer> notRepeat = new ArrayList<>();
        for (int r = 0; r < list.size(); r++) {
            for (int c = r + 1; c < list.size(); c++) {
                if (list.get(r) == list.get(c)) {
                    list.remove(c);
                    c--;
                }
            }
        }
    }

    public static void bonolotolottery () {
        ArrayList<Integer> drum = new ArrayList<>();
        ArrayList<Integer> BonoLoto = new ArrayList<>();
        int selected;

        for (int number = 0; number < 50; number++) {
            drum.add(number);
        }
        for (int num = 0; num < 6; num++) {
            selected = rnd.nextInt(0,drum.size());
            BonoLoto.add(drum.get(selected));
            drum.remove(selected);
        }
        System.out.println(BonoLoto);
    }

    public static void listDisorderer (ArrayList<Integer> list) {
        Integer temp, randomPosition;
        for (int num = 0; num < list.size(); num++) {
                randomPosition = rnd.nextInt(0,list.size());
                temp = list.get(num);
                list.set(num, list.get(randomPosition));
                list.set(randomPosition,temp);
        }
    }
    public static void fashionList () {
        System.out.println("Se buscara el elemento mas repetido");
    }
}
