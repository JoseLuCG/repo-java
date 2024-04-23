package Serializacion.Ejercicio1;

import static Serializacion.Ejercicio1.Functions.*;
import java.time.LocalDate;
import java.util.*;

public class Main {

    static Random rnd=new Random();
    public static void Creararray() {
        for (int i = 0; i < 10; i++) {
            //Vehiculo datos
            String[] marcas = {"Toyota", "Honda", "Ford", "Chevrolet", "Volkswagen", "BMW", "Mercedes-Benz", "Audi", "Hyundai", "Nissan"};
            String marca = marcas[(int) (Math.random() * marcas.length)];

            String modelo = "Mod" + (int) ((Math.random() * 5) + 1);

            long anioactual = LocalDate.now().getYear();
            long diferenciaAnios = (anioactual - 2000 + 1);
            int anio = (int) ((Math.random() * diferenciaAnios) + 2000);
            int mes = (int) ((Math.random() * 12) + 1);
            LocalDate anioFabricacion = LocalDate.of(anio, mes, 1);


            String color = "#FFF" + rnd.nextInt(100, 1000);
            //Automovil datos
            int numeroPuertas = rnd.nextInt(2, 6);
            //Camioneta Var
            int capacidadCarga = (int) ((Math.random() * 2501) + 2500);

            //Mantenimiento datos
            long diasRestarFechaMantenimiento = rnd.nextInt(0, 1866);
            LocalDate fechaMantenimiento = LocalDate.now().minusDays(diasRestarFechaMantenimiento);

            int tipoVehiculo = rnd.nextInt(2);
            Vehiculo vehiculo;
            //Crear Mantenimiento en ARRAY
            if (tipoVehiculo == 0) {
                vehiculo = new Automovil(marca, modelo, anioFabricacion, color, numeroPuertas);
                mantenimientos.add(new Mantenimiento(vehiculo, TipoMantenimiento.PREVENTIVO, fechaMantenimiento));
            } else {
                vehiculo = new Camioneta(marca, modelo, anioFabricacion, color, capacidadCarga);
                mantenimientos.add(new Mantenimiento(vehiculo, TipoMantenimiento.PREVENTIVO, fechaMantenimiento));
            }
        }
        serialize(mantenimientos);
    }

    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);

        //Creararray();
        deserialize();

        //  MENU:
        int opcion;
        do {
            outPut.println("Seleccione la opción que desea realizar:");
            outPut.println("[ 1 ] = Añadir mantenimiento.");
            outPut.println("[ 2 ] = Listar mantenimientos.");
            outPut.println("[ 3 ] = Salir.");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    addMaintenance();
                    break;
                case 2:
                    listMaintenances();
                    break;
                case 3:
                    System.out.println("exit the program.");
                    break;
                default:
                    System.out.println("error. selecciona una opcion valida.");
            }

        } while (opcion != 3);
        }
}
