package ejerciciosClasesJava;

public class TarjetaPrepago {
    // ---------- Attributes: ----------
    private String phoneNumber;
    private String nif;
    private double balance;
    private Tiempo consumption = new Tiempo();

    // ---------- Methods: ----------

    // Constructors:

    public TarjetaPrepago () {}
    public TarjetaPrepago (String phoneNumber, String nif, double balance){
        this.phoneNumber = phoneNumber;
        this.nif = nif;
        this.balance = balance;
    }

    // Setters:

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public void setNif(String nif) { this.nif = nif; }

    public void setBalance(double balance) { this.balance = balance; }

    public void setConsumption(Tiempo consumption) { this.consumption = consumption; }

    // Getters

    public String consultPhoneNumber() { return phoneNumber; }

    public String consultNif() { return nif; }

    public Tiempo consultConsumption() { return consumption; }

    public double consultBalance() { return balance; }

    public String consultNumber () {
        return "Numero de telefono: "+phoneNumber+" \tNif: "+nif+"\t Saldo: "+balance+"$ \tConsumo: "+consumption;
    }

    public String toString () {
        return phoneNumber+","+nif+",: "+balance+","+consumption;
    }
    // Own methods

    public void enterBalance (double credit) {
        this.balance = this.balance + credit;
    }

    public void sendMessage (int messages) {
        double messagesExpense = messages * 0.09;

        this.balance = this.balance - messagesExpense;
    }

    public void callMade (int callSecond) {
        double callExpense = callSecond * 0.01;

        this.consumption.addTime(callSecond);
        this.balance = this.balance - 0.15;
        this.balance = this.balance - callExpense;
    }
}