package ejerciciosClasesJava5.Libro;

import java.util.Objects;

public class Libro {
    //Attributes:
    protected String title;
    protected String author;
    protected int numPages;
    protected String editorial;
    protected int code = 0;
    protected static int LASTCODE = 0;
    protected static final byte CODE_INCREMENT = 5;


    // Constructors
    public Libro(String title, String author, int numPages, String editorial) {
        this.title = title;
        this.author = author;
        this.numPages = numPages;
        this.editorial = editorial;

        code = LASTCODE;
        LASTCODE += CODE_INCREMENT;
    }
    public Libro (String title, String author) {
        this.title = title;
        this.author = author;

        LASTCODE = code;
        LASTCODE += CODE_INCREMENT;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getNumPages() { return numPages; }
    public String getEditorial() { return editorial; }
    public int getCode() { return code; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setNumPages(int numPages) { this.numPages = numPages; }
    public void setEditorial(String editorial) { this.editorial = editorial; }

    // ToString
    @Override
    public String toString() {
        return "\nTítulo: " + title +
                "\nAutor: " + author +
                "\nNúmero de páginas: " + numPages +
                "\nEditorial: " + editorial +
                "\nCódigo: " + code;
    }

    //Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return numPages == libro.numPages && code == libro.code && Objects.equals(title, libro.title) && Objects.equals(author, libro.author) && Objects.equals(editorial, libro.editorial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, numPages, editorial, code);
    }
}
