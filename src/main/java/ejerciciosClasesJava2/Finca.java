package ejerciciosClasesJava2;

import static strings.Ejercicio6.outPut;

enum TipoCultivo {
    MONTE_BAIXO, ARBUSTIVO, CULTIVO, VIÑEDO
}

public class Finca {
    // Attributes.
    private Parcela parcela;
    private String toponimo;
    private TipoCultivo tipoCultivo;
    private boolean regadio;
    private double metrosTotales;
    private double metrosLimpios = this.metrosTotales;

    // ---------- Methods. ----------

    // Constructors
    public Finca () {}
    public Finca (Parcela parcela,
                  String toponimo,
                  TipoCultivo tipoCultivo,
                  boolean regadio,
                  double metrosTotales) {
        this.parcela = parcela;
        this.toponimo = toponimo;
        this.tipoCultivo = tipoCultivo;
        this.regadio = regadio;
        this.metrosTotales = metrosTotales;
        this.metrosLimpios = this.metrosTotales;
    }

    // Getters.

    public Parcela getParcela() { return parcela; }

    public String getToponimo() { return toponimo; }

    public TipoCultivo getTipoCultivo() { return tipoCultivo; }

    public boolean isRegadio() { return regadio; }

    public double getMetrosLimpios() { return metrosLimpios; }

    public double getMetrosTotales() { return metrosTotales; }

    @Override
    public String toString() {
        return " *** Finca: *** " + String.format("%5s",toponimo) +
                "\nTipo de cultivo: " + String.format("%5s", tipoCultivo) +
                "\nRegadio: " + String.format("%5s", regadio) +
                "\nCoordenadas de referencia: " +parcela.getPuntoRef1()+" - "+parcela.getPuntoRef2() +
                "\nMetros limpios: " + String.format("%8.2f", metrosLimpios) +
                "\nMetros totales: " + String.format("%8.2f", metrosTotales);
    }

    // Setters.

    public void setParcela(Parcela parcela) { this.parcela = parcela; }

    public void setToponimo(String toponimo) { this.toponimo = toponimo; }

    public void setTipoCultivo(TipoCultivo tipoCultivo) { this.tipoCultivo = tipoCultivo; }

    public void setRegadio(boolean regadio) { this.regadio = regadio; }

    public void setMetrosLimpios(double metrosLimpios) { this.metrosLimpios = metrosLimpios; }

    public void setMetrosTotales(double metrosTotales) { this.metrosTotales = metrosTotales; }

    // ---------- Own Methods. ----------

    public void incrementarSupALimpiar (double m2) {
        if ((this.metrosLimpios - m2) >= 0){
            this.metrosLimpios = this.metrosLimpios - m2;
        } else {
            outPut.println("¡¡¡¡¡  No quedan metros que limpiar.  !!!!!");
        }
    }
    public void decrementarSupALimpiar (double m2) {
        if ((this.metrosLimpios + m2) > this.metrosTotales) {
            outPut.println("¡¡¡¡¡  No hay más metros a limpiar.  !!!!!");
        } else {
            this.metrosLimpios = this.metrosLimpios + m2;
        }
    }
}
