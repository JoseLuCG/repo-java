package EjerciciosAceptaElReto.Ejercicio416_MichaelFox;
public class Fecha_Nacimiento {
    // Attributes.
    private int day;
    private int month;
    private int year;

    // Methods.
    // Constructors:
    public Fecha_Nacimiento () {}

    public Fecha_Nacimiento(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Getters:

    public int getDia() { return day; }

    public int getMonth() { return month; }

    public int getYear() { return year; }

    // Setters:
    public void setDia(int dia) { this.day = dia; }

    public void setMonth(int month) { this.month = month; }

    public void setYear(int year) { this.year = year; }

    // To String:

    @Override
    public String toString() {
        return "(" + day + "/" + month + "/" + year + ")";
    }
}
