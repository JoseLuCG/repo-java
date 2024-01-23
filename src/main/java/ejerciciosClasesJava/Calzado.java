package ejerciciosClasesJava;

public class Calzado {
    // Atributtes:
    private int number;
    private double price;
    private int stock;
    private String type;
    private String sex;

    // Methods:
    // ---------- Constructors ----------
    public Calzado () {}
    public Calzado (int number, double price, int stock, String type, String sex) {
        this.number = number;
        this.price = price;
        this.stock = stock;
        this.type = type;
        this.sex = sex;
    }
    // ---------- Getters ----------
    public void setNumber(int number) { this.number = number; }

    public void setPrice(double price) { this.price = price; }

    public void setStock(int stock) { this.stock = stock; }

    public void setType(String type) { this.type = type; }

    public void setSex(String sex) { this.sex = sex; }
    // ---------- Setters ----------
    public int getNumber(){ return this.number; }

    public double getPrice() { return this.price; }

    public int getStock() { return this.stock; }

    public String getType() { return this.type; }

    public String getSex() { return this.sex; }
    // ---------- Method tallas ----------
    public double getTallaUS () {
        double[] tallaEU = {36, 36.5, 37, 37.5, 38, 38.5, 39, 39.5, 40, 41, 42, 42.5, 43, 44, 44.5};
        double[] tallaUS = {5.5, 6, 6.5, 7, 7.5, 8, 8.5, 9, 9.5, 10, 10.5, 11, 11.5, 12, 12.5};

        for (int talla = 0; talla < tallaEU.length; talla++) {
            if (this.number == tallaEU[talla]) { return tallaUS[talla]; }
        }

        return -1;
    }
    public double getTallaUK () {
        double[] tallaEU = {36, 36.5, 37, 37.5, 38, 38.5, 39, 39.5, 40, 41, 42, 42.5, 43, 44, 44.5};
        double[] tallaUK = { 3, 3.5, 4, 4.5, 5, 5.5, 6, 6.5, 7, 7.5, 8, 8.5, 9, 9.5, 10};

        for (int size = 0; size < tallaUK.length; size++) {
            if (this.number == tallaEU[size]) { return tallaUK[size]; }
        }

        return -1;
    }
}
