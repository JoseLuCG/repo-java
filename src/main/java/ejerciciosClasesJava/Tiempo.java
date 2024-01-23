package ejerciciosClasesJava;

public class Tiempo {
    // Attributes:
    private int minutes;
    private int seconds;

    // ---------- Methods: ----------

    // Constructors:

    public Tiempo () {
        this.minutes = 0;
        this.seconds = 0;
    }
    public Tiempo (int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    // Setters

    public void setTiempo (int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public void setMinutes(int minutes) { this.minutes = minutes; }

    public void setSeconds(int seconds) { this.seconds = seconds; }

    public void addTime (int seconds) {
        this.minutes = this.minutes + seconds / 60;
        this.seconds = this.seconds + seconds % 60;
    }

    // Getters

    public String toString () {
        return minutes+":"+seconds;
    }

    public int getMinutes() { return minutes; }

    public int getSeconds() { return seconds; }
}
