package strings;

import static strings.Ejercicio7.sc;
import static strings.Ejercicio6.outPut;

public class Ejercicio8 {
    public static String getControlDigit (long number) {
        String controlDigit = "";
        int divisionRest;

        divisionRest = (int) (number % 97);
        if (divisionRest < 10) {
            if (divisionRest == 0) controlDigit = "00";
            if (divisionRest > 0) controlDigit = "0"+divisionRest;
        } else controlDigit = divisionRest+"";
        return controlDigit;
    }
    public static void main(String[] args) {
        long ssNumber;
        String controlDigit;

        outPut.println("Escribe un número de diez dígitos.");
        ssNumber = sc.nextLong();

        controlDigit = getControlDigit(ssNumber);
        outPut.println("Su código de control es: "+controlDigit);
    }
}
