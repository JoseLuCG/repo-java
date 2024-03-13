package herencia;

import java.time.LocalDate;

public class Principal {
    static SeleccionFutbol[] seleccion = new SeleccionFutbol[4];

    public static void visualizarArray () {
        for (int i = 0; i < seleccion.length; i++) {
            System.out.println(seleccion[i] + "dentro años"+seleccion[i].getFechaNacimiento().plusYears(5));
        }
    }
    public static void visualizarArray1 () {
        for (SeleccionFutbol sel:seleccion) {
            if (sel instanceof Futbolista ) System.out.println(sel);
        }
    }

    public static void main(String[] args) {
        seleccion[0] = new Entrenador(1,"Vicente","Del BOsque",45,LocalDate.of(1940,05,3),"2842131");

        System.out.println(seleccion[0]);

        seleccion[1] = new Futbolista(2,"Andres", "Iniesta", 29, LocalDate.now(), 6,"Interior Derecha");
        seleccion[2] = new Futbolista(3,"Raul", "Martinez", 24,LocalDate.of(2000,1,1), 8,"Interior Izquierda");
        seleccion[3] = new Masajista(4,"Pedro", "Alvarez", 41, LocalDate.parse("2001-11-28"), "Fisioterapia",10);
        visualizarArray();
        System.out.println("==============================================================================================================");
        visualizarArray1();
    }
}
