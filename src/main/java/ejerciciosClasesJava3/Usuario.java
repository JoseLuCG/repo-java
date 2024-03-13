package ejerciciosClasesJava3;

import java.time.LocalDate;
import java.util.Random;

enum State {
    ACTIVO, BLOQUEADO, BAJA
}

public class Usuario {
    // ---------- Attributes. ----------
    static Random rnd = new Random();
    protected String nick;
    protected String email;
    protected String password;
    protected LocalDate registrationDate;
    protected State state = State.ACTIVO;

    // ---------- Methods: ----------
    // ---------- Constructors ----------
    public Usuario () {}

    public Usuario(String nick, String email, LocalDate registrationDate) {
        this.nick = nick;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    // ---------- Setters ----------

    public void setNick(String nick) { this.nick = nick; }

    public void setEmail(String email) { this.email = email; }

    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }

    public void setState(State state) { this.state = state; }

    // ---------- Getters ----------

    public String getNick() { return nick; }

    public String getEmail() { return email; }

    public String getPassword() { return password; }

    public LocalDate getRegistrationDate() { return registrationDate; }

    public State getState() { return state; }

    @Override
    public String toString() {
        return "Usuario" +
                "\nNick= " + nick  +
                "\nEmail= " + email +
                "\nPassword= " + password +
                "\nRegistrationDate= " + registrationDate +
                "\nState= " + state;
    }

    // ---------- Own Methods ----------
    public void generatePassword () {
        char[] signs = {',', '.', '-', ';', '*'};
        String password = "";
        char[] passwordChar = new char[8];
        char upperCaseChar, lowerCaseChar, randomSingChar, randomNumberChar;
        String randomNumber, upperCase, lowerCase, randomSing;
        char aux;
        int x;

        upperCaseChar = (char) rnd.nextInt(65,90);
        passwordChar[0] = upperCaseChar;
        for (int character = 1; character < 6; character++) {
            lowerCaseChar = (char) rnd.nextInt(97,123);
            passwordChar[character] = lowerCaseChar;
        }
        randomNumberChar = (char) rnd.nextInt(48,58);
        passwordChar[6] = randomNumberChar;
        randomSingChar = signs[rnd.nextInt(0,6)];
        passwordChar[7] =randomSingChar;

        // Mix the characters
        for (int character = 0; character < passwordChar.length; character++) {
            x = rnd.nextInt(0, passwordChar.length);
            aux = passwordChar[x];
            passwordChar[x] = passwordChar[character];
            passwordChar[character] = aux;
        }

        this.password = String.valueOf(passwordChar);
    }
}
