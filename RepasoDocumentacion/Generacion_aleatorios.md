# Generación de números aleatorios

Para generar números de forma aleatoria en java podemos hacer uso de dos clases implementadas con Java: la clase *`Random`* o el método *`Math.random()`*.

## Uso de la clase **`Random`**

Para implementar la clase `Random`, lo primero que tenemos que hacer es importarla desde la librería *util*:

```Java
import java.util.Random;
```

Despues de importarla crearemos un objeto que nos permita generar un número aleatorio dentro de los rangos que decidamos posteriormente. Lo mas habitual es generar este objeto en ambito de clase como un atribúto estático de la clase para poder implementarlo en todo el archivo.

```Java
static Random rnd = new Random();
```

Una vez creado el objeto simplemente creamos una variable para poder almacenar el número aleatorio y haciendo uso del método *`.nextInt([parametro11], [parametro2])`*. 

Este método recibe dos parámetros con los que podremos definir el rango de nuestro número aleatorio:
* ***`[Parametro1]`***  - El valor mínimo que puede tener nuestro número aleatorio, incluyendo el número pasado como parámetro.

* ***`[Parametro2]`***  - El valor máximo que puede tener nuestro número aleatorio, este número no se incluye dentro de los posibles valores de nuestro número aleatorio. por lo que hay que tener en cuenta que siempre será un número menos que el que pasemos aqui como parámetro.

Ejemplo:
```Java
import java.util.Random; // Importamos la librería.

public class Main {
    static Random rnd = new Random(); // Generamos el  objeto que nos permite crear números randoms

    public static void main(String[] args) {
        int random = rnd.nextInt(2,40); // En este caso generaremos un número aleatorio entre el 2 y el 39.

        System.out.println(random);
    }
}
```

## Uso del metodo **`Math.random()`**

Con el metodo `Math.random()` no tenemos que importar nada, pero tenemos que recordar la forma en la que se usa este método. Para ello introducimos el una variable donde irá nuestro número aleatorio y lo parseamos a entero. Después multiplicamos el `Math.random()` por la siguiente secuencia: (`maxValue` - `minValue` + 1) + `minValue`.

```Java
public class Main {
    public static void main(String[] args) {
        int randomNumber; // Variable donde almacenaremos el número random
        // Definimos el rango:
        int max = 10;
        int min = 1;
        int range = max - min + 1;

        // Generamos numeros aleatorios entre 1 y 10:
        randomNumber = (int) (Math.random() * range) + min;
    }
}
```