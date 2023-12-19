package strings;

import java.util.Scanner;

public class Ejercicio5 {
    public static boolean passwordIsStrong (String password) {
        boolean paswordIsStrong = false;
        int countMajuscule = 0, countMinuscule = 0, countNumbers = 0;

        if (password.length() < 8) paswordIsStrong = false;
        for (int character = 0; character < password.length(); character++) {
            if (password.charAt(character) >= 'A' && password.charAt(character) <= 'Z') {
                countMajuscule++;
            }
            if (password.charAt(character) >= 'a' && password.charAt(character) <= 'z') {
                countMinuscule++;
            }
            if (password.charAt(character) >= '0' && password.charAt(character) <= '9') {
                countNumbers++;
            }
        }
        if ( (countMinuscule >= 1) && (countMajuscule >= 2) && (countNumbers >= 5) ) paswordIsStrong = true;

        return paswordIsStrong;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userPassword;
        boolean strongPassword;

        System.out.println("Introduce tu contraseña:");
        userPassword = sc.nextLine();
        strongPassword = passwordIsStrong(userPassword);

        System.out.println(strongPassword ? "La contraseña es Fuerte" : "La contraseña es debil");
    }
}
