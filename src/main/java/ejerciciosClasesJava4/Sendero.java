package ejerciciosClasesJava4;

import java.time.LocalDate;

public class Sendero extends Via {
    // Attributes
    private boolean isPaved = false;

    // Constructors
    public Sendero() {}

    public Sendero(String code, TypeOwnership typeOwnership, double numKm, double numKmDeficients, int widthInMeters, LocalDate openingDate, boolean isPaved) {
        super(code, typeOwnership, numKm, numKmDeficients, widthInMeters, openingDate);
        this.isPaved = isPaved;
    }

    // Setters
    public void setPaved(boolean paved) { isPaved = paved; }

    // Getters
    public boolean isPaved() { return isPaved; }

    @Override
    double costMaintenance() {
        double costOfMaintenance;

        if (isPaved){
            costOfMaintenance = this.numKm * 110.15;
        } else {
            costOfMaintenance = this.numKm * 145.45;
        }

        return costOfMaintenance;
    }

    @Override
    public String toString() {
        return "Sendero:" +
                "\nPavimentado: " + isPaved +
                "\nCódigo: " + code +
                "\nPropiedad: " + typeOwnership +
                "\nKilómetros: " + numKm +
                "\nKilómetros Deficientes: " + numKmDeficients +
                "\nwAnchura en m: " + widthInMeters +
                "\nFecha Apertura: " + openingDate;
    }
}
