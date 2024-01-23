package ejerciciosClasesJava;

public class Hora {
    // Attributes
    private int hour;
    private int minutes;
    private int seconds;

    // Methods
    public Hora () {
        hour = 0;
        minutes = 0;
        seconds = 0;
    }
    public Hora (int hour, int minutes, int seconds) {
        if (hour < 0 || hour > 24 || minutes<0 || minutes > 60 || seconds< 0 || seconds > 60) {
            new Hora();
        } else {
            this.hour = hour;
            this.minutes = minutes;
            this.seconds = seconds;
        }
    }
    // Getters
    public int getHour() { return hour; }

    public int getMinutes() { return minutes; }

    public int getSeconds() { return seconds; }
    public String toString () {
         return hour+":"+minutes+":"+seconds;
    }

    // Setters
    public void setHour(int hour, int minutes, int seconds) {
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public void setHour(int hour) { this.hour = hour; }

    public void setMinutes(int minutes) { this.minutes = minutes; }

    public void setSeconds(int seconds) { this.seconds = seconds; }
}
