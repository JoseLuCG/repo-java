package ejerciciosClasesJava2;

public class Coordenada {
    // Attributes
    private int x;
    private int y;

    // Constructors
    public Coordenada () {}
    public Coordenada (int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Setters.

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    // Getters.

    public int getX() { return x; }

    public int getY() { return y; }

    @Override
    public String toString() { return  x + "," + y ; }
}
