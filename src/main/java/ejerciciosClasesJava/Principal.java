package ejerciciosClasesJava;

import java.util.Random;
import java.util.Scanner;
import static strings.Ejercicio6.outPut;

public class Principal {
    public static final String GREEN = "\u001B[32m";
    public static final String WHITE = "\u001B[37m";
    public static final String RESET = "\u001B[0m";
    public static Scanner sc = new Scanner(System.in);
    static TarjetaPrepago[] datos = new TarjetaPrepago[20];
    static TarjetaPrepago[][] datosEmpresa = new TarjetaPrepago[4][20];
    static Random rnd = new Random();

    public static void rellenarArray () {
        for (int i = 0; i < datos.length; i++){
            datos[i] = new TarjetaPrepago("Telefono"+(1+i),"", rnd.nextInt(1,50));
            outPut.println(datos[i].consultNumber());
        }
    }

    public static void rellenarEmpresas () {
        for (int f = 0; f < datosEmpresa.length; f++) {
            outPut.print("Compañia "+f+"\t");
            for (int c = 0; c < datosEmpresa[0].length; c++) {
                datosEmpresa[f][c] = new TarjetaPrepago("tarjeta"+(1+c),"",rnd.nextInt(10,50));
                outPut.print(datosEmpresa[f][c]+"   ");
            }
            System.out.println();
        }
    }
    public static void actualizarTarjeta (String telefono) {
        int s, numMensajes;

        for (TarjetaPrepago tarjeta: datos) {
            if (telefono.equals(tarjeta.consultPhoneNumber())){
                System.out.println(tarjeta.consultNumber());
                System.out.println("Introduzca segundos hablados y mensajes enviados");
                s = sc.nextInt();
                numMensajes = sc.nextInt();
                tarjeta.sendMessage(numMensajes);
                tarjeta.callMade(s);
                System.out.println(tarjeta.consultNumber());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ---------- Calzado ejercicio. ----------
        Calzado botas = new Calzado(38, 15.99, 5, "boots", "female");
        double us = botas.getTallaUS();
        double uk = botas.getTallaUK();

        System.out.println("----------------------------------------");

        if (us != -1) System.out.println("Equivalencia US: "+botas.getTallaUS());
        else System.out.println("Talla erronea.");
        if (uk != -1) System.out.println("Equivalencia UK: "+botas.getTallaUK());

        System.out.println();
        System.out.println();

        // ---------- Fecha ejercicio. ----------
        Fecha diaHoy = new Fecha();

        System.out.println("----------------------------------------");

        System.out.println(diaHoy.getDay()+" "+diaHoy.getMonth()+" "+diaHoy.getYear());
        diaHoy.asignate(1,1,2024);
        System.out.println(diaHoy.getDay()+" "+diaHoy.getMonth()+" "+diaHoy.getYear());
        diaHoy.incrementate(865);
        System.out.println(diaHoy.getDay()+" "+diaHoy.getMonth()+" "+diaHoy.getYear());
        diaHoy.imprimete();
        diaHoy.imprimete(2);
        diaHoy.getFecha();

        System.out.println();
        System.out.println();

        // ---------- Hora ejercicio. ----------
        Hora time = new Hora();
        Hora time2 = new Hora(13,20,50);
        Hora time3 = new Hora(1,6,50);

        System.out.println("----------------------------------------");

        System.out.println(time.getHour()+" : "+ time.getMinutes()+" : "+ time.getSeconds());
        System.out.println(time2.getHour()+":"+ time2.getMinutes()+":"+ time2.getSeconds());
        System.out.println(time3.toString());

        System.out.println();
        System.out.println();

        // ---------- LLamada ejercicio ----------
        Hora horaComienzo = new Hora(10, 30, 45);
        Hora horaFin = new Hora(11, 15, 25);
        Hora horaComienzo2 = new Hora(12, 30, 45);
        Hora horaFi2 = new Hora(11, 15, 25);
        int hour, minutes, seconds;
        Llamada miLlamada = new Llamada("123456789", time2, time3);
        Llamada miLlamada2 = new Llamada("123456789", time2, time3);

        System.out.println("----------------------------------------");

        System.out.println(miLlamada.toString());
        miLlamada.setComienzoLLamada(horaComienzo);
        miLlamada.setFinLLamada(horaFin);
        System.out.println(miLlamada.toString());
        System.out.println("La llamada 1 ha durado: "+miLlamada.duracionLlamada()+" segundos");
        System.out.println();


        System.out.println(miLlamada2.toString());
        miLlamada2.setComienzoLLamada(horaComienzo2);
        miLlamada2.setFinLLamada(horaFi2);
        System.out.println(miLlamada2.toString());
        System.out.println("La llamada 2 ha durado: "+miLlamada2.duracionLlamada()+" segundos");

        //System.out.println("Introduce horas, minutos y segundos:");
        //hour = sc.nextInt();
        //minutes = sc.nextInt();
        //seconds = sc.nextInt();
        //Hora hora1 = new Hora(hour, minutes, seconds);
        //Llamada llamada3 = new Llamada("123456712", hora1, new Hora(14,45,15));
        //System.out.println(llamada3.toString());

        System.out.println();
        System.out.println();

        // ---------- CuentaCorriente. ----------
        CuentaCorriente cuenta1 = new CuentaCorriente("Pepe",
                                                "Garcia",
                                                "Calle Ramon Puga 12 3o",
                                                "678456247",
                                                "985677876R",
                                                785.60);

        System.out.println("----------------------------------------");

        System.out.println(cuenta1.toString());
        cuenta1.depositMoney(15);
        System.out.println(GREEN+cuenta1.checkBalance());
        cuenta1.takeMoneyOut(100);
        System.out.println(GREEN+cuenta1.checkBalance());
        System.out.println(GREEN+cuenta1.negativeBalance());

        System.out.println(RESET);
        System.out.println();

        // ---------- TarjetaPrepago ejercicio. ----------
        TarjetaPrepago numero1 = new TarjetaPrepago("650902602", "12345678P", 50.20);

        System.out.println("----------------------------------------");

        System.out.println(numero1.consultNumber());
        numero1.sendMessage(5);
        System.out.println(numero1.consultNumber());
        numero1.callMade(100);
        System.out.println(numero1.consultNumber());
        numero1.callMade(200);
        System.out.println(numero1.consultNumber());
        System.out.println();
        System.out.println();
        rellenarArray();
        actualizarTarjeta("Telefono20");
        rellenarEmpresas();
    }
}
