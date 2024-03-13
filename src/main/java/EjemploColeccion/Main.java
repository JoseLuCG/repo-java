package EjemploColeccion;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    static Persona[] personas = {
            new Persona("Ana", "Diz", "12345678Z", LocalDate.of(1999,11,1)),
            new Persona("Juan", "Diz", "33345678A", LocalDate.of(2000,10,11)),
            new Persona("Pepe", "Albar", "12345699B", LocalDate.of(2003,8,17))
    };

    public static void main(String[] args) {
        Arrays.sort(personas);

        for (Persona p: personas) {
            System.out.println(p);
        }

        System.out.println();

        Arrays.sort(personas, new comaradorFecha());
        for (Persona p: personas) {
            System.out.println(p);
        }

        System.out.println();

        Arrays.sort(personas, new comaradorEdad());
        for (Persona p: personas) {
            System.out.println(p);
        }
    }
}
