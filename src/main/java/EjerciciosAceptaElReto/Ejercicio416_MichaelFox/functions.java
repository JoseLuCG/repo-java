package EjerciciosAceptaElReto.Ejercicio416_MichaelFox;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import static ejerciciosColecciones.Main.outPut;
public class functions {
    public static Fecha_Nacimiento dateGenerator () {
        Random rnd = new Random();
        int day = rnd.nextInt(1,32);
        int month = rnd.nextInt(1,13);
        int year = rnd.nextInt(1600, 2000);
        Fecha_Nacimiento fecha;

        if (month == 2 && day > 28) {
            day = rnd.nextInt(1,29);
        } else {
            if ( (month % 2 == 0 && month != 8) && day ==31 ){
                day = rnd.nextInt(1,31);
            }
        }

        fecha = new Fecha_Nacimiento(day,month,year);

        return fecha;
    }

    public static void fillArrayList (int persons, ArrayList<Fecha_Nacimiento> dates) {
        Fecha_Nacimiento date;

        for (int peopleDate = 0; peopleDate < persons; peopleDate++) {
            date = dateGenerator();
            dates.add(date);
        }
    }

    public static void checkerDatesEquals (ArrayList<Fecha_Nacimiento> dates) {
        int counter= 0;

        for (int i = 0; i < dates.size(); i++) {
            for (int j = i + 1; j < dates.size(); j++) {
                if ( ( dates.get(i).getDia() == dates.get(j).getDia()) &&
                        (dates.get(i).getMonth() == dates.get(j).getMonth() ) ) {
                    counter ++;
                }
            }
        }

        if (counter == 0) {
            outPut.println("NO");
        } else {
            outPut.println("Sí");
        }
        
        dates.clear();
    }
}
