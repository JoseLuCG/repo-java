package Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio4 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        double n;
        int posicion;
        String cadena ;
        double[] valores = {9.83, 4.5, -3.06, 0.06, 2.52, -11.3, 7.60, 3.00, -30.4, 105.2};

        try{
            System.out.println("Contenido del array antes de modificar:");
            for (int i = 0; i < valores.length; i++) {
                System.out.print(valores[i] + "|");
            }
            System.out.print("\n\nIntroduce la posición del array a modificar: ");
            cadena = sc.nextLine();
            posicion = Integer.parseInt(cadena);
            System.out.print("\nIntroduce el nuevo valor de la posición " + posicion + ": ");
            n = sc.nextDouble();
            valores[posicion] = n;

            System.out.println("\nPosición a modificar " + posicion);
            System.out.println("Nuevo valor: " + n);
            System.out.println("Contenido del array modificado:");
            for (int i = 0; i < valores.length; i++) {
                System.out.print(valores[i] + "|");
            }
        } catch (IndexOutOfBoundsException err) {
            System.out.println("El indice sobre sale del array.");
        } catch (InputMismatchException err) {
            System.out.println("Se ha producido un error de paseo.");
        } catch (NumberFormatException err) {
            System.out.println("Error en el cambio de tipos.");
        } catch (Exception err) {
            System.out.println("No sabemos que ha ocurrido.");
        }
    }
}