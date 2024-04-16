package Excepciones;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numA, numB;

        System.out.println("introduce un numero:");
        numA = sc.nextInt();
        System.out.println("introduce un numero:");
        numB = sc.nextInt();

        Test test1 = new Test();
        test1.check(numA, numB);
    }
}

class Excepcion extends  Exception {
    private String message;

    public Excepcion() {}

    public Excepcion(String message) {
        this.message = message;
    }

    public String getMessage () { return message = "El doble del numero A es menor que el numero B.";}
}

class Test {
    public void check (int numA, int numB){
        Scanner sc = new Scanner(System.in);
        Excepcion error = new Excepcion();

        try {
            if ((numA * 2) < numB) {
                throw error;
            }
        } catch (Excepcion e){
            System.out.println(error.getMessage());
        }
    }

}

