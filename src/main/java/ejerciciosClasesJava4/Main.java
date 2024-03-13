package ejerciciosClasesJava4;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class Main {
    public static PrintStream outPut = new PrintStream(System.out, true, StandardCharsets.UTF_8);

    public static void main(String[] args) {
        int year = LocalDate.now().getYear();
        System.out.println(year);
    }
}
