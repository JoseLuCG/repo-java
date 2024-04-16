package ejerciciosClasesJava5.Libro;

public class Novela extends Libro {
    // Attributes
    private String isbn;
    private String genre;

    // Constructors

    public Novela(String title, String author, int numPages, String editorial, String isbn, String genre) {
        super(title, author, numPages, editorial);
        this.isbn = isbn;
        this.genre = genre;
    }

    public Novela(String title, String author, String isbn, String genre) {
        super(title, author);
        this.isbn = isbn;
        this.genre = genre;
    }
    // Getters
    public String getIsbn() { return isbn; }

    public String getGenre() { return genre; }

    // Setters
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setGenre(String genre) { this.genre = genre; }

    // ToString

    @Override
    public String toString() {
        return "\n---------- Novela ---------" +
                super.toString() +
                "\nISBN: " + isbn +
                "\nGenero: " + genre ;
    }
}
