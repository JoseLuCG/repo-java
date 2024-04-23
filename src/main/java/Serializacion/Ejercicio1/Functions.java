package Serializacion.Ejercicio1;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Functions {
    public static PrintStream outPut = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    public static Scanner sc = new Scanner(System.in);
    static  ArrayList<Mantenimiento> mantenimientos=new ArrayList<>();
    /**
     * Creates a new maintenance record and adds it to the collection.
     */
    public static void addMaintenance () {
        String carBrand, model, color;
        int day, month, year, maintenanceTypeOption, vehicleType, numberOfDoors = 0;
        double cargoCapacity = 0;
        TipoMantenimiento maintenanceType = TipoMantenimiento.PREVENTIVO;
        LocalDate manufacturingDate;
        LocalDate maintenanceDate;
        Mantenimiento newMaintenance;
        Camioneta newCamioneta;
        Automovil newAutomovil;

        outPut.println("Indica la marca de tu vehículo:");
        carBrand = sc.nextLine();
        outPut.println("Indica el modelo de tu vehículo:");
        model = sc.nextLine();
        outPut.println("Indica la fecha de fabricación de tu vehículo: yyyy mm dd");
        year = sc.nextInt();
        month = sc.nextInt();
        day = sc.nextInt();
        manufacturingDate = LocalDate.of(year, month, day);
        sc.nextLine();
        outPut.println("Indica el color de tu vehículo en formato #ffffff");
        color = sc.nextLine();

        do {
            outPut.println("Indica el tipo de vehículo que registras:");
            outPut.println("[1] - Automóvil.");
            outPut.println("[2] - Camioneta.");
            vehicleType = sc.nextInt();
            switch (vehicleType){
                case 1:
                    outPut.println("Indica el número de puertas de tu automóvil:");
                    numberOfDoors = sc.nextInt();
                    break;
                case 2:
                    outPut.println("Indica la capacidad de carga de tu camioneta:");
                    cargoCapacity = sc.nextDouble();
                    break;
                default: outPut.println("Se ha producucido un error.");
            }
        }while (vehicleType != 2 && vehicleType !=1);

        do {
            outPut.println("Indica el tipo de mantenimiento para tu vehículo:");
            outPut.println("[1] - Mantenimiento preventivo.");
            outPut.println("[2] - Mantenimiento correctivo.");
            maintenanceTypeOption = sc.nextInt();
            switch (maintenanceTypeOption) {
                case 1: maintenanceType = TipoMantenimiento.PREVENTIVO; break;
                case 2: maintenanceType = TipoMantenimiento.CORRECTIVO; break;
                default: outPut.println("Error. Selecciona un tipo de mantenimiento válido.");
            }
        }while (maintenanceTypeOption != 2 && maintenanceTypeOption !=1);

        outPut.println("Indica la fecha de tu mantenimiento: yyyy mm dd");
        year = sc.nextInt();
        month = sc.nextInt();
        day = sc.nextInt();
        maintenanceDate = LocalDate.of(year, month, day);

        switch (vehicleType) {
            case 1: // Automóvil.
                newAutomovil = new Automovil(carBrand,model,manufacturingDate,color,numberOfDoors);
                newMaintenance = new Mantenimiento(newAutomovil, maintenanceType, manufacturingDate);
                mantenimientos.add(newMaintenance);
                break;
            case 2: // Camioneta.
                newCamioneta = new Camioneta(carBrand, model, manufacturingDate, color, cargoCapacity);
                newMaintenance = new Mantenimiento(newCamioneta, maintenanceType, maintenanceDate);
                mantenimientos.add(newMaintenance);
                break;
            default: outPut.println("Error. Selecciona un tipo de mantenimiento válido.");
        }
        serialize(mantenimientos);
    }

    /**
     * Shows stored maintenance.
     */
    public static void listMaintenances() {
        System.out.println( mantenimientos.toString() );
        System.out.println(mantenimientos.size());
    }

    public static void deserialize () {
        try {
            FileInputStream file = new FileInputStream("mantenimientos.ser");
            ObjectInputStream coleccionSerializada = new ObjectInputStream(file);
            mantenimientos = (ArrayList<Mantenimiento>) coleccionSerializada.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void serialize (ArrayList<Mantenimiento> collection) {
        try {
            FileOutputStream file = new FileOutputStream("mantenimientos.ser");
            ObjectOutputStream mantenimientosList = new ObjectOutputStream(file);
            mantenimientosList.writeObject(collection);
            mantenimientosList.close();
            file.close();
            System.out.println("ArrayList serializado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
