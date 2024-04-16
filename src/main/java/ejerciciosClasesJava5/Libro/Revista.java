package ejerciciosClasesJava5.Libro;

import java.time.LocalDate;

public class Revista extends Libro{
    // Attributes
    private int number;
    private LocalDate publicationDate;

    // Constructors
    public Revista(String title, String author, int numPages, String editorial, int number, LocalDate publicationDate) {
        super(title, author, numPages, editorial);
        this.number = number;
        this.publicationDate = publicationDate;
    }
    public Revista(String title, String author, int number, LocalDate publicationDate) {
        super(title, author);
        this.number = number;
        this.publicationDate = publicationDate;
    }

    // Setters
    public void setNumber(int number) { this.number = number; }

    public void setPublicationDate(LocalDate publicationDate) { this.publicationDate = publicationDate; }

    //Getters
    public int getNumber() { return number;}
    public LocalDate getPublicationDate() { return publicationDate; }

    // ToString
    @Override
    public String toString() {
        return  "\n--------------- Revista --------------" +
                super.toString() +
                "\nNúmero: " + number +
                "\nFecha de Publicación: " + publicationDate ;
    }


}
