package ejerciciosClasesJava2;

public class Parcela {
    // Attributes.
    private Coordenada puntoRef1;
    private Coordenada puntoRef2;
    private double metrosCuadrados;

    // ---------- Methods. ----------

    // Constructors.

    public Parcela () {}
    public Parcela (Coordenada puntoRef1, Coordenada puntoRef2, double metrosCuadrados) {
        this.puntoRef1 = puntoRef1;
        this.puntoRef2 = puntoRef2;
        this.metrosCuadrados = metrosCuadrados;
    }

    // Setters.

    public void setPuntoRef1(Coordenada puntoRef1) { this.puntoRef1 = puntoRef1; }

    public void setPuntoRef2(Coordenada puntoRef2) { puntoRef2 = puntoRef2; }

    public void setMetrosCuadrados(double metrosCuadrados) { this.metrosCuadrados = metrosCuadrados; }

    // Getters.

    public Coordenada getPuntoRef1() { return puntoRef1; }

    public Coordenada getPuntoRef2() { return puntoRef2; }

    public double getMetrosCuadrados() { return metrosCuadrados; }

    @Override
    public String toString() {
        return "Punto de referencia 1: " + String.format("%5s",puntoRef1) +
               "\tPunto de referencia 2: " + String.format("%5s",puntoRef2) +
                "\tMetros cuadrados: " + String.format("%5.2f",metrosCuadrados);
    }
}
