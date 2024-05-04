# **Documentación clase String**
Los Strings en Java son ***objetos***, tipo **`String`**. Pueden ser inicializados de dos formas:

* Como una variable normal:
```java
String hola = "Hello Word!";
```

* Al ser objetos, también pueden ser inicializados como tales, a  través del constructor:
```java
String s = new String(); // String vacio.
String s = new String("Hola"); // String "Hola".
```

## Métodos de la clase String:
* ### ***`int length()`***
Retorna el largo (cantidad de caracteres) de un String.
```java
String texto1 = "Hola";
String texto2 = "(/.,;>.)";

int n = texto1.length(); // 4
int m = texto2.length(); // 8
```

* ### ***`char charAt(int index)`***
Retorna el caracter que se encuentra en la posición dada por _`index`_. Si _`index`_ es mayor que el largo del String se producirá un error. Por lo que hay que tener en cuenta la longitud del String.
```java
String texto = "¡Hola Juanito!";
char c1 = texto.charAt(0); // ’¡’
char c2 = texto.charAt(1); // ’H’
char c3 = texto.charAt(13); // ’!’
char c4 = texto.charAt(20); // error
char c5 = texto.charAt( texto.length() - 1 ); // ’!’
```

* ### ***`boolean startsWith(String text, [int index])`***
Devuelve _true_ si el String comienza con el String ___`text`___ entregado como parámetro. La coincidencia debe ser exacta (se distingue mayúsculas, minúsculas y caracteres con tilde).
```java
String texto = "¡Hola Juanito!";
boolean b1 = texto.startsWith("¡"); // true
boolean b2 = texto.startsWith("¡Hola ") // true
boolean b3 = texto.startsWith("¡hola Juanito!") // false
boolean b4 = texto.startsWith("¡Hola Juanito! ") // false
boolean b5 = texto.startsWith("¡Hola Juanito!") // true
```

Con el segundo parametro opcional: _`[int index]`_, comienza a revisar desde la posición _`index`_, sin importar que haya antes. Si _`index`_ == 0, entonces el método es equivalente a no emplear este parámetro.
```java
String texto = "¡Hola Juanito!";
boolean b1 = texto.startsWith("Hola", 1); // true
boolean b2 = texto.startsWith(" Juanito!", 5); // true
boolean b3 = texto.startsWith("a", 7); // false
boolean b4 = texto.startsWith("¡", 20); // false
```

* ### ***`int indexOf([char c]/[String s], [int fromIndex])`***
Devuelve un entero que indica la posición donde aparece por primera vez el caracter _`c`_ o el String _`s`_. Si el caracter no aparece en todo el String, devuelve -1.
```java
String textoUno = "¡Hola Juanito!";
int n = textoUno.indexOf(’o’); // 2
int m = textoUno.indexOf(’ ’); // 5
int p = textoUno.indexOf(’¡’); // 0
int q = textoUno.indexOf(’z’); // -1

String textoDos = "En la arboleda un arbolito";
int n = textoDos.indexOf("arbol"); // 6
int m = textoDos.indexOf("´arbol"); // -1
int p = textoDos.indexOf("boli"); // 20
int q = textoDos.indexOf("bol"); // 8
```
El parametro opcional: _`[int fromIndex]`_ indica la posición desde la que se empieza a buscar.

* ### ***`int lastIndexOf([char c]/[String s], [int fromIndex])`***
Como el ___`indexOf()`___ pero en lugar de buscar la primera aparición del caracter o String, busca la última. Retorna -1 si no lo encuentra. Se define de manera análoga a los anteriores.

* ### ***`boolean equals(String s)`***
Retorna _true_ cuando ambos String son exactamente iguales. Esto quiere decir que el largo de ambos es el mismo, y que en cada posición encontramos el mismo caracter.
```java
String texto1 = "casa";
String texto2 = "caza";
String texto3 = "casi";
String texto4 = "casa";
String texto5 = "CaSa";
boolean b1 = texto1.equals(texto3); // false
boolean b2 = texto4.equals(texto1); // true
boolean b3 = texto3.equals(texto1); // false
boolean b4 = texto1.equals(texto5); // false
```

* ### ***`boolean equalsIgnoreCase(String s)`***
Retorna _true_ cuando ambos String son iguales, sin importar mayúsculas y minúsculas.
```java
String texto1 = "casa";
String texto2 = "caza";
String texto3 = "casi";
String texto4 = "casa";
String texto5 = "CaSa";
boolean b1 = texto1.equalsIgnoreCase(texto3); // false
boolean b2 = texto4.equalsIgnoreCase(texto1); // true
boolean b3 = texto3.equalsIgnoreCase(texto1); // false
boolean b4 = texto1.equalsIgnoreCase(texto5); // true
```

* ### ***`int compareTo(String s)`***
Compara lexicográficamente dos Strings. Parte en el primer par de caracteres hasta encontrar un par de _char_ distintos. Si encuentra dos caracteres distintos, retorna la diferencia entre ellos (recuerde que char funciona como un número entero). Si uno de los String comienza con el otro, retorna el número de caracteres adicionales que tiene. Si ambos son iguales, retorna 0.
```java
String texto = "radiografía";
int n = texto.compareTo("radio"); // 6
int m = texto.compareTo("radiología"); // -5
int p = texto.compareTo("rabia"); // 2
int q = texto.compareTo("ralentizar"); // -8
int r = texto.compareTo("radiografia"); // 132
int s = texto.compareTo("radiografía"); // 0
```

* ### ***`String substring(int inicio, int fin)`***
Retorna una parte del String dede la posición _`inicio`_ hasta la posición _`fin`_.
```java
String texto = "desenfreno";
String subTexto = texto.substring(5, 10); // "freno"
```

* ### ***`String replaceAll(String aReemplazar, String reemplazo)`***
Reemplaza todas las ocurrencias de _`aReemplazar`_ por _`reemplazo`_.
```java
String t1 = "El auto volaba rápido";
String t2 = t1.replaceAll("auto", "avión"); // "El avión volaba rápido"
```