package gestionCoches;

public class Coche {
    private String matricula;
    private String modelo;
    private String marca;
    private int potenciaMotor;
    private String numeroSerie;
    // Métodos Constructores.
    public Coche () {}
    public Coche (String matricula, String model, String marca) {
        this.matricula = matricula;
        this.modelo = model;
        this.marca = marca;
    }
    public String getMatricula () {
        return this.matricula;
    }
    public String getModelo() {
        return this.modelo;
    }
    public String getMarca() {
        return this.marca;
    }
    public int getPotencia() {
        return this.potenciaMotor;
    }
    public String getNumeroSerie() {
        return this.numeroSerie;
    }
    public String toString (){
        return "Matricula: "+matricula+"\tMarca: "+marca+"\tModelo: "+modelo+"\nPotenciaMotor: "+potenciaMotor+"\tNumero Serie "+numeroSerie;
    }
    //setters
    public void setMatricula (String matricula){
        this.matricula = matricula;

    }
}
