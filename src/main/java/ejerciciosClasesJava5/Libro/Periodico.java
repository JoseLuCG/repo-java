package ejerciciosClasesJava5.Libro;

import java.time.LocalDate;

public class Periodico extends Libro{
    // Attributes
    private String type;
    private int number;
    private LocalDate date;

    // Constructors
    public Periodico(String title, String author, int numPages, String editorial, String type, int number, LocalDate date) {
        super(title, author, numPages, editorial);
        this.type = type;
        this.number = number;
        this.date = date;
    }

    public Periodico(String title, String author, String type, int number, LocalDate date) {
        super(title, author);
        this.type = type;
        this.number = number;
        this.date = date;
    }

    // Setter
    public void setType(String type) { this.type = type; }
    public void setNumber(int number) { this.number = number; }
    public void setDate(LocalDate date) { this.date = date; }

    // Getter
    public String getType() { return type; }
    public int getNumber() { return number; }
    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        return  "\n--------------- Periódico --------------" +
                super.toString() +
                "\nNúmero: " + number +
                "\nFecha de Publicación: " + date ;
    }
}
