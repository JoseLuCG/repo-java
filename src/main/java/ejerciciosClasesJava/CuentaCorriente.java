package ejerciciosClasesJava;

public class CuentaCorriente {
    // Attributes.
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String nif;
    private double accountBalance;

    // Methods:
    public CuentaCorriente () {}
    public CuentaCorriente (String name, String surname, String address,
                            String phone, String nif, double accountBalance) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.nif = nif;
        this.accountBalance = accountBalance;
    }

    // Public Methods:
    public boolean negativeBalance() {
        boolean money = false;

        if (this.accountBalance < 0) money = true;

        return money;
    }

    // Setters.
    public void takeMoneyOut (double money) {
        this.accountBalance = this.accountBalance - money;
    }
    public void depositMoney (double money) {
        this.accountBalance = this.accountBalance + money;
    }
    public void setName (String name) { this.name = name; }
    public void setSurname (String surname) { this.surname = surname; }
    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setNif(String nif) { this.nif = nif; }
    public void setAccountBalance(double accountBalance) { this.accountBalance = accountBalance; }

    // Getters.
    public double checkBalance() { return this.accountBalance; }
    public String checkName() { return this.name; }
    public String checkSurname() { return this.surname; }
    public String checkAddress() { return this.address; }
    public String checkPhone() { return this.phone; }
    public String checkNif() { return this.nif; }
    public String toString() {
        return "Nombre: "+this.name+" \tApellidos: "+this.surname+" \tDireccion: "+this.address+
                "\nTelefono: "+this.phone+" \tNIF: "+this.nif+" \tSaldo: "+this.accountBalance;
    }
}
