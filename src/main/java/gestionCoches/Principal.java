package gestionCoches;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Coche micoche = new Coche();
        Coche segundoCoche = new Coche("1234ABC", "Clase A","Mercedes");
        Coche[] coches = new Coche[10];

        System.out.println(segundoCoche.getMatricula());
        System.out.println();
        System.out.println();
        System.out.println(segundoCoche.toString());
        System.out.println();
        System.out.println();
        segundoCoche.setMatricula("3333ABC");
        System.out.println(segundoCoche.toString());
        micoche.setMatricula(sc.nextLine());
    }
}
