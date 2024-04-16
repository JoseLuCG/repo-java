package ejerciciosClasesJava4;

import java.time.LocalDate;

public class Estrada extends Via{
    // Attributes
    private int numLanes;

    // Constructor
    public Estrada() {}

    public Estrada(String code,
                   TypeOwnership typeOwnership,
                   double numKm,
                   double numKmDeficients,
                   int widthInMeters,
                   LocalDate openingDate,
                   int numLanes) {
        super(code, typeOwnership, numKm, numKmDeficients, widthInMeters, openingDate);
        this.numLanes = numLanes;
    }

    //Setters
    public void setNumLanes(int numLanes) {
        this.numLanes = numLanes;
    }

    // Getters
    public int getNumLanes() {
        return numLanes;
    }

    // Methods

    @Override
    double costMaintenance() {
        double costOfMaintenance;

        costOfMaintenance = this.numKm * 206.03 * numLanes;

        return costOfMaintenance;
    }

    @Override
    public String toString() {
        return "Estrada: " +
                "\nNúmero de carriles: " + numLanes +
                "\nCódigo: " + code +
                "\nPropiedad: " + typeOwnership +
                "\nKilómetros: " + numKm +
                "\nKilómetros Deficientes: " + numKmDeficients +
                "\nwAnchura en m: " + widthInMeters +
                "\nFecha Apertura: " + openingDate;
    }
}
