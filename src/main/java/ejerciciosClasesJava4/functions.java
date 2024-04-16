package ejerciciosClasesJava4;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

import static ejerciciosClasesJava4.Main.outPut;
import static ejerciciosClasesJava4.Main.sc;
public class functions {
    public static void fillArray (Via[] vias) {
        Random rnd = new Random();

        for (int i = 0; i < vias.length; i++) {
            int option = rnd.nextInt(1,4);
            String code = rnd.nextInt(0,100)+"";
            TypeOwnership Owner = TypeOwnership.values()[rnd.nextInt(0,4)];
            double numKm = rnd.nextDouble(1,500);
            double numKmDef = rnd.nextDouble(0,numKm);
            int ancho = rnd.nextInt(4,10);
            LocalDate fecha = LocalDate.now().minusMonths(rnd.nextInt(0,500));

            switch (option) {
                case 1:
                    int numLanes = rnd.nextInt(2,6);
                    vias[i] = new Estrada(code, Owner, numKm, numKmDef, ancho, fecha, numLanes);
                    break;
                case 2:
                    String[] color = {"#FF0000", "#008000", "#00FFFF", "#FFFFFF"};
                    vias[i] = new Ciclovia(
                            code,
                            Owner,
                            numKm,
                            numKmDef,
                            ancho,
                            fecha,
                            color[rnd.nextInt(0, color.length)]
                    );
                    break;
                case 3:
                    vias[i] = new Sendero(code, Owner, numKm, numKmDef, ancho, fecha, Boolean.parseBoolean("true"));
                    break;
            }
        }
    }
    public static void showArray(Via[] vias) {
        for (Via v: vias) {
            System.out.println("========================================");
            outPut.println(v);
            System.out.println("========================================");
        }
    }

    public static void oldestRoad(Via[] vias) {
        Via oldestRoad = vias[0];
        for (int i = 1; i < vias.length; i++) {
            if (vias[i].getOpeningDate().isBefore(oldestRoad.getOpeningDate())) {
                oldestRoad = vias[i];
            }
        }
        System.out.println();
        outPut.println("La via más antigua es: "+oldestRoad);
        System.out.println();
    }

    public static void roadWithMoreRoads (Via[] vias) {
        int numberOfLanesMax = 0;

        for (int i = 0; i < vias.length; i++) {
            if (vias[i] instanceof Estrada) {
                if ( ((Estrada) vias[i]).getNumLanes() > numberOfLanesMax ) {
                    numberOfLanesMax = ( ( (Estrada) vias[i]).getNumLanes() );
                }
            }
        }

        if (numberOfLanesMax > 0) {
            outPut.println("El número máximo de carriles es: "+numberOfLanesMax);
            outPut.println("Las estradas que tienen estos carriles son:");
            for (Via v: vias) {
                if ( v instanceof Estrada ) {
                    if ( ((Estrada) v).getNumLanes() == numberOfLanesMax ) {
                        outPut.println(v);
                        System.out.println("==============================");
                    }
                }
            }
        }
    }

    public static void roadsOrderbyKm (Via[] vias) {

    }
}
