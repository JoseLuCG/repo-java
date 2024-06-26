package ejerciciosClasesJava4;

import java.time.LocalDate;

public class Ciclovia extends Via{
    //Attributes.

    private String color;

    //Constructors
    public Ciclovia () {
        super();
        this.color = "#000000";
    }

    public Ciclovia (String code, TypeOwnership owner, double numKm, double numKmDeficients, int width, LocalDate openingDate, String color) {
        super(code,owner,numKm,numKmDeficients, width, openingDate);
        if (colorValidator(color)) {
            this.color = color;
        }

    }
    public double costMaintenance() {
        double costOfMaintenance;

        costOfMaintenance = this.numKm * 308.15;

        return costOfMaintenance;
    }

    private boolean colorValidator (String color) {
        color = color.toUpperCase();

        if (color.length() != 7) {
            return false;
        } else if (color.charAt(0) != '#') {
            return false;
        } else {
            for (int character = 1; character < color.length(); character++) {
                if (! (color.charAt(character) >= '0' && color.charAt(character) <= '9'
                        || color.charAt(character) >= 'A' && color.charAt(character) <= 'Z' ) ) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ciclovia: " +
                "\nColor: " + color +
                "\nCódigo: " + code +
                "\nPropietario: " + typeOwnership +
                "\nKilómetros: " + numKm +
                "\nKilómetros Deficientes: " + numKmDeficients +
                "\nAnchura en m: " + widthInMeters +
                "\nFecha de apertura: " + openingDate ;
    }
}
