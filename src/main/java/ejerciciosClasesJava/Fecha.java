package ejerciciosClasesJava;

public class Fecha {
    // attributes
    private int day;
    private int month;
    private int year;

    // Methods
    public Fecha (int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public Fecha () {
        this.day = 1;
        this.month = 1;
        this.year = 2013;
    }
    // setters
    public void asignate (int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public void setDay (int day){
        this.day = day;
    }
    public void setMonth (int month) {
        this.month = month;
    }
    public void setYear (int year) {
        this.year = year;
    }
    // getters:
    public int getDay () { return this.day; }
    public int getMonth () { return this.month; }

    public int getYear() { return year; }
    // Métodos propios.
    public void incrementate (int d) {
        int[] meses = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 0; i < d; i++) {
            this.day++;
            if (this.day > meses[this.month-1]) {
                this.month++;
                this.day = 1;
            }
            if (this.month > 12) {
                this.month = 1;
                this.year++;
            }
        }
    }
    public void imprimete() {
        String date = "";
        String month = mesLetra();

        date = this.day+"-"+month+"-"+this.year;
        System.out.println(date);
    }
    public void imprimete(int d) {
        String date = "";
        String month = mesLetra();

        date = this.day+"-"+this.month+"-"+this.year;
        System.out.println(date);
    }
    private String mesLetra () {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Jumio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String monthInLetters;

        monthInLetters = meses[this.month-1];

        return monthInLetters;
    }
    public void getFecha() {
        String date = "";
        String month = mesLetra();

        date = this.day+"-"+month+"-"+this.year;
        System.out.println(date);
    }
}
