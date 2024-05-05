# **Ordenación de colecciones**

## Ordenación natural

Se han visto varios tipos de colecciones de datos, además de los arrays.
¿Pueden ordenarse los datos de estas colecciones? ¿Puedo ordenar los datos a mi interés?
Para poder ordenar elementos, la JVM ha de poder comparar dos elementos entre si para determinar cuál es mayor de los dos, y cuál menor. Esta comparación la puede hacer Java de modo automático, pero depende del tipo de dato que se quiera ordenar:

**a)** Java SI ordena automáticamente tipos de datos con ordenación natural: los números o cadenas de texto (que se ordenan numéricamente o alfabéticamente, como los String o los int). También se incluyen aquí Date y otras clases donde Java aplica orden por defecto. 

**b)** Java NO ordena automáticamente tipos de datos sin ordenación natural: son los tipos que Java no sabe ordenar, normalmente, tipos de dato creados por nosotros, como una Persona, una Tarjeta, un Coche. Si se le pide a Java que ordene Coches, ¿cómo lo ha de hacer? ¿por matricula? ¿por cilindrada? ¿por precio? Estos tipos de datos necesitan que se defina programáticamente como se van a ordenar.

## Mecanismos para ordenar colecciones

A la hora de ordenar colecciones, podemos actuar con alguna de estas soluciones:

**a)** Usar algoritmos propios de ordenación, esto es, construir nosotros un programa que ordene los elementos de array o colección, según los criterios deseados. Uno de los ejemplos más famosos es el algoritmo de la burbuja.

**b)** Usando el método `.sort()` de ordenación (en las clases `Arrays` y `Collections`). Este método funciona si:

1. Si el tipo de dato a ordenar tiene orden natural, sólo hace falta usar el método `.sort()` en la colección (tipos de datos primitivos, String, Date, etc).
2. Si el tipo de dato a ordenar es un objeto sin orden natural, se debe usar `Comparator` y `Comparable`.

**c)** Usando el mecanismo de ordenación que por defecto traen alguna de las colecciones (como TreeSet). En estos casos también es necesario al igual que antes analizar que:

1. Si tipo de dato a ordenar tiene orden natural, no hace falta hacer nada para ordenar la colección, está ordenada automáticamente.
2. Si el tipo de dato a ordenar es un objeto sin orden natural, se debe usar `Comparator` y `Comparable`.

## `Comparable` y `Comparator`

`Comparable` y `Comparator` se usan para ordenar colecciones de objetos que no tienen orden natural. La diferencia es que: con `Comparable` sólo se puede usar *un único criterio de ordenación* en la colección. Mientras que con `Comparator` se puede ordenar la colección, si es necesario, de diversas formas.

### `Comparable`

Se necesita usar Comparable para poder hacer comparaciones con una clase propia (y las comparaciones son necesarias para pode ordenar colecciones que contengan dicha clase propia). La interfaz `Comparable` para que se use correctamente obliga a tres pasos:

* Implementar `Comparable` en la clase propia que deseamos que haga comparaciones.
* Implementar el método *`.compareTo(Obj1)`* en la clase propia que deseamos que haga   comparaciones.
* Finalmente, ordenarse directamente con los mismos mecanismos que si fuera un tipo de dato con ordenación natural.

