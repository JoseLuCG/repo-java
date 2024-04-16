package Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = { 4, 2, 9, 40, 34};

        try{
        System.out.println("introduce una posicion.");
        int i = sc.nextInt();
        System.out.println(numeros[i]);

        } catch (IndexOutOfBoundsException err) {
            System.out.println("Indice fuera de los limites");
        } catch (InputMismatchException err){
            System.out.println("El indice del array debe ser entero.");
        } catch (Exception err) {
            System.out.println("Error inesperado.");
        } finally {
            System.out.println("El programa termino.");
        }
    }
}
