package ejerciciosClasesJava3;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Empleado extends Usuario{
    // ---------- Attributes. ----------
    private String dni;
    private String fullName;
    private String address;
    private LocalDate birthDate;

    // ---------- Constructors. ----------
    public Empleado (){}

    public Empleado(String nick, String email, LocalDate registrationDate, String dni, String fullName, String address, LocalDate birthDate) {
        super(nick, email, registrationDate);
        if (checkDni(dni)) {
            this.dni = dni;
        } else this.dni = "";
        this.fullName = fullName;
        this.address = address;
        this.birthDate = birthDate;
    }

    // ---------- Setters. ----------
    public void setDni(String dni) {
        if (checkDni(dni)) {
            this.dni = dni;
        }
    }

    public void setFullName(String fullName) { this.fullName = fullName; }

    public void setAddress(String address) { this.address = address; }

    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }


    // ---------- Getters. ----------
    public String getDni() { return dni; }

    public String getFullName() { return fullName; }

    public String getAddress() { return address; }

    public LocalDate getBirthDate() { return birthDate; }

    // ---------- Own Methods. ----------
    private boolean checkDni (String userDni) {
        String dni = userDni.toUpperCase();
        int number;
        char letter;
        String letters = "TRWAGMYFPDXBNJZSQVHLCKET";

        if (dni.length() != 9) return false;
        number = Integer.parseInt(dni.substring(0,8));
        letter = dni.charAt(8);
        if (letters.charAt(number%23) != letter ) {
            return false;
        }

        return true;
    }

    public long getAge () {
        return ChronoUnit.YEARS.between(this.birthDate, LocalDate.now());
    }

    @Override
    public String toString() {
        return "Nombre: " + fullName +
                "\nDNI: " + dni +
                "\nEdad: " + getAge() +
                "\nDirección: " + address;
    }
}
