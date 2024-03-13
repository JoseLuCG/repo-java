package ejerciciosClasesJava3;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static PrintStream outPut = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    static Usuario[] usuarios = new Usuario[6];

    public static void createEmployee () {
        String line;
        String[] data;
        for (int user = 0; user < usuarios.length; user++) {
            outPut.println("Introducce por orden: el nick, el correo, la fecha de registro," +
                    " el DNI, el nombre completo, la dirección y la fecha de nacimiento.");

            line = sc.nextLine();
            data = line.split("\t");

            usuarios[user] = new Empleado(
                    data[0],
                    data[1],
                    LocalDate.parse(data[2]),
                    data[3],
                    data[4],
                    data[5],
                    LocalDate.parse(data[6]));
        }
    }

    public static void modifyUser() {
        outPut.println("introduce un DNI o nombre y apellidos");
        String searchData = sc.nextLine();
        for (Usuario user:usuarios) {
            Empleado empleado = (Empleado) (user);
            if ( empleado.getDni().equals(searchData) || empleado.getFullName().equals(searchData) ) {
                outPut.println("Introduce la dirección y el correo.");
                String newAddress = sc.nextLine();
                String newEmail = sc.nextLine();
                if (newAddress != "") { empleado.setAddress(newAddress); }
                if (newEmail != "") { empleado.setEmail(newEmail); }
            }
        }
    }

    public static void userLonger() {
        long time = Long.MIN_VALUE;
        long years;
        int position = 0;

        for (int i = 0; i < usuarios.length; i++) {
            years = ChronoUnit.YEARS.between( usuarios[i].getRegistrationDate(), LocalDate.now() );
            if (years > time) {
                time = years;
                position= i;
            }
            outPut.println(usuarios[position] + " años de atiguedad " + time);
        }
    }

    public static void main(String[] args) {
        String option;

        createEmployee();

        do {
            outPut.println(" [1]. Modificar usuario." +
                    "\n [2]. Usuario más longevo." +
                    "\n [3]. Salir.");
            option = sc.nextLine();
            switch (option){
                case "1": modifyUser(); break;
                case "2": userLonger(); break;
            }
        }while (option != "3");


    }
}
