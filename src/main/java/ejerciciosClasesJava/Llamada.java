package ejerciciosClasesJava;

public class Llamada {
    // Attributes
    private String numeroTelefono;
    private Hora comienzoLLamada;
    private Hora finLLamada;

    // Methods

    // Constructors
    public Llamada () {}

    public Llamada (String num, Hora comienzo, Hora fin){
        this.numeroTelefono = num;
        this.comienzoLLamada = comienzo;
        this.finLLamada = fin;
    }

    // Setters.
    public void setComienzoLLamada(Hora comienzoLLamada) {
        this.comienzoLLamada = comienzoLLamada;
    }

    public void setFinLLamada(Hora finLLamada) {
        this.finLLamada = finLLamada;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    // Getters.
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public Hora getComienzoLLamada() {
        return comienzoLLamada;
    }

    public Hora getFinLLamada() {
        return finLLamada;
    }

    @Override
    public String toString() {
        return "Llamada del numero: "+numeroTelefono+" comienzo: "+comienzoLLamada+" fin: "+finLLamada;
    }
    // -----
    public int duracionLlamada () {
        int duracionLlamada = 0;
        int[] horaFinalizacion = new int[3];
        int[] horaComienzo = new int[3];
        int segundosFinllamada = 0;
        int segundosComienzoLlamada = 0;

        horaFinalizacion[0] = finLLamada.getHour() * 3600;
        horaFinalizacion[1] = finLLamada.getMinutes() * 60;
        horaFinalizacion[2] = finLLamada.getSeconds();

        for (int i = 0; i < horaFinalizacion.length; i++) {
            segundosFinllamada = segundosFinllamada + horaFinalizacion[i];
        }

        horaComienzo[0] = comienzoLLamada.getHour() * 3600;
        horaComienzo[1] = comienzoLLamada.getMinutes() * 60;
        horaComienzo[2] = comienzoLLamada.getSeconds();

        for (int i = 0; i < horaComienzo.length; i++) {
            segundosComienzoLlamada = segundosComienzoLlamada + horaComienzo[i];
        }

        if (segundosComienzoLlamada > segundosFinllamada) {
            duracionLlamada = -1;
        } else {
            duracionLlamada = segundosFinllamada - segundosComienzoLlamada;
        }

        return duracionLlamada;
    }
}
