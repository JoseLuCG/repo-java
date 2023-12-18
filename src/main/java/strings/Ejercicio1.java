/* 1.
    El cálculo de la letra del Documento Nacional de Identidad (DNI) es un proceso
matemático sencillo que se basa en obtener el resto de la división entera del número
de DNI y el número 23. A partir del resto de la división, se obtiene la letra
seleccionándola dentro de un cadena de letras.

Por tanto, si el resto de la división es 0, la letra del DNI es la T y si el resto es
3 la letra es la A. Con estos datos,elaborar un pequeño script que:

- Almacene en una variable el número de DNI indicado por el usuario y en otra variable
la letra del DNI que se ha indicado.
- En primer lugar (y en una sola instrucción) se debe comprobar si el número es menor
que 0 o mayor que 99999999. Si ese es el caso, se muestra un mensaje al usuario indicando
que el número proporcionado no es válido y el programa no muestra más mensajes.
- Si el número es válido, se calcula la letra que le corresponde según el método explicado
anteriormente.
- Una vez calculada la letra, se debe comparar con la letra indicada por el usuario. Si no
coinciden, se muestra un mensaje al usuario diciéndole que la letra que ha indicado no es
correcta. En otro caso, se muestra un mensaje indicando que el número y la letra de DNI son
correctos. */
package strings;

import java.util.Scanner;

public class Ejercicio1 {
    public static boolean validator (String cadena) {
        String dni = cadena.toUpperCase();
        String letras ="TRWAGMYFPDXBNJZSQVHLCKET";
        int number;
        char letter;

        if (dni.length() != 9) return false;
        for (int character = 0; character < 8; character++) {
          if( (dni.charAt(character) < 47) || (dni.charAt(character) > 57) ) return false;
        }
        number = Integer.parseInt(dni.substring(0,8));
        letter = dni.charAt(8);
        if (letras.charAt(number%23) != letter) return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userDNI;
        boolean validation;

        System.out.println("introduce el dni:");
        userDNI = sc.nextLine().trim();
        validation = validator(userDNI);

        if (validation) { System.out.println("Dni correcto.");
        } else System.out.println("El dni introducido es incorrecto.");
    }
}
