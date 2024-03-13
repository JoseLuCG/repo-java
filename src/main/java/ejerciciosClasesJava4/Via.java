package ejerciciosClasesJava4;

import java.time.LocalDate;

enum TypeOwnership {
    STATE_OWNED, AUTONOMIC, PROVINCIAL, LOCAL
}

public abstract class Via {
    // Attributes
    protected String code = "";
    protected TypeOwnership typeOwnership = TypeOwnership.LOCAL;
    protected double numKm = 0;
    protected double numKmDeficients = 0;
    protected int widthInMeters = 0;
    protected LocalDate openingDate = LocalDate.now();

    // Constructors.
    public Via () {}

    public Via (String code, TypeOwnership typeOwnership, double numKm,
                double numKmDeficients, int widthInMeters, LocalDate openingDate) {
        this.code = code;
        this.typeOwnership = typeOwnership;
        this.numKm = numKm;
        this.numKmDeficients = numKmDeficients;
        this.widthInMeters = widthInMeters;
        this.openingDate = openingDate;
    }

    // Setters.

    public void setCode(String code) { this.code = code; }

    public void setTypeOwnership(TypeOwnership typeOwnership) { this.typeOwnership = typeOwnership; }

    public void setNumKm(double numKm) { this.numKm = numKm; }

    public void setNumKmDeficients(double numKmDeficients) { this.numKmDeficients = numKmDeficients; }

    public void setWidthInMeters(int widthInMeters) { this.widthInMeters = widthInMeters; }

    public void setOpeningDate(LocalDate openingDate) { this.openingDate = openingDate;}

    // Getters.

    public String getCode() { return code; }

    public TypeOwnership getTypeOwnership() { return typeOwnership; }

    public double getNumKm() { return numKm; }

    public double getNumKmDeficients() { return numKmDeficients; }

    public int getWidthInMeters() { return widthInMeters; }

    public LocalDate getOpeningDate() { return openingDate; }

    @Override
    public String toString() {
        return "Via: " +
                "\n Código: " + code +
                "\n Tipo de Titularidad: " + typeOwnership +
                "\n Número de Kilómetros: " + numKm + " Km " +
                "\n Número de Kilómetros Deficientes: " + numKmDeficients +
                "\n Ancho en metros: " + widthInMeters + " m " +
                "\n Fecha de apertura: " + openingDate;
    }

    // Methods.
    abstract double costMaintenance();

    public void arrange (double kilometres) {
        if ( (kilometres > 0) && ( (this.numKmDeficients - kilometres) >= 0 ) ) {
            this.numKmDeficients = this.numKmDeficients - kilometres;
        } else {
            System.out.println("Error, los datos son incorrectos.");
        }
    }

    public void communicateDeficiency (double kilometres) {
        if ( (kilometres > 0) && ( this.numKmDeficients <= this.numKm ) ) {
            this.numKmDeficients = this.numKmDeficients + kilometres;
        } else {
            System.out.println("Error, los datos son incorrectos.");
        }
    }

    public int yearsOfOperation () {
        int yearNow = LocalDate.now().getYear();
        int yearOfOpening = this.openingDate.getYear();
        int yearsOfService = yearNow - yearOfOpening;
        return yearsOfService;
    }
}
