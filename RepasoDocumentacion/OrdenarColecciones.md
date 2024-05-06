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

#### Aplicar `Comparable`

1. **Implementar `Comparable`**: la clase que deseemos que pueda compararse debe comenzar por implementar `Comparable`, normalmente, indicando como tipo el de la propia clase:
```Java
class Persona implements Comparable<Persona> { // Comparable es una interfaz genérica, hay que poner la clase que se va a comparar.
}    
```

2. **Escribir el método `.compareTo()`**: El método recibe como parámetro un objeto con el que comparar , de forma que la comparación se realizará del objeto en si (this) con el objeto pasado como parámetro.
```Java
public int compareTo ( Miclase otroObjeto ) {
    // ...
}
```

El método debe devolver un valor entero que será según los casos:
* Un número negativo si el objeto base(this) es menor que el parámetro.
* Un cero si es igual que el parámetro.
* Un número positivo si el objeto base es mayor que el parámetro.

Por lo general, se usan uno o varios atributos de la clase para efectuar la comparación entre objetos (y por lo tanto la ordenación). Aquí podemos tener varios casos, según el tipo de dato a comparar:

**a)** Que el atributo sea un objeto, como String o Date. Para obtener el valor de retorno, usamos el propio método compareTo del objeto. En la clase Persona, si se compara por el nombre que es String, se usa `compareTo` de los nombres para que nos den directamente el valor a devolver:
```Java
class Persona implements Comparable<Persona> {
 String nombre;
 public Persona (String n) {
    this.nombre = n;
 }
 @Override // metodo compareTo con objetos
 public int compareTo (Persona p) {
return nombre.compareTo (p.nombre);
 }
}
```

**b)** Que el atributo sea un tipo primitivo numérico. Se puede hacer restando los valores a comparar (primero el propio y luego el del parámetro): También se puede hacer varios if que devuelven -1, 0 o 1 según lo que se desee.
```Java
class Persona implements Comparable<Persona> {
 int edad;
 public Persona (int s) {
    this.edad = e;
 }
 @Override // metodo compareTo con primit.
 public int compareTo (Persona p) {
    return this.edad - p.edad;
 }
}
```

3. **Ordenar la colección normalmente, como si tuviera orden natural**: ahora podemos usar la ordenación de una colección de nuestra clase como si fuera de String o de Integer. Listas y arrays mediante los métodos `Collections.sort()` y `Arrays.sort()`, también pueden ordenarse las claves en un mapa ordenado TreeMap, o como elementos de un set ordenado TreeSet (sin necesidad de métodos).

### `Comparator`

Comparable sólo puedo establecer un método de ordenación, pues solo puedo escribir un método `compareTo`, ya que este no es sobrecargable (p.e. la clase Persona del ejemplo anterior, si se ordena por nombre, luego no se puedo intentar ordenar por edad). `Comparator` sí permite varias ordenaciones, y su uso es muy parecido al de `Comparable`. Para usarlo seguiremos los siguientes pasos:

1. Se ha de crear una clase nueva, propia, que debe implementar `Comparator`, indicando el tipo de dato que se va a comparar.
2. En esta clase nueva creada, hay que implementar el método `compare(obj1, obj2)`.
3. Esta clase nueva creada, que implementa `Comparator`, podemos usarla para ordenar de usando los constructores de las colecciones habituales.

#### Aplicar `Comparator`

1. **Crear clase propia que hereda de `Comparator`**: A diferencia de `Comparable`, no se va a tener que cambiar nada en la clase que vamos luego a comparar(Ej: Persona). Lo que vamos a hacer es una nueva clase, que implemente la interfaz `Comparator`, y como `Comparator` es genérica y debe darse el tipo, ponemos como la clase que queremos comparar:
```Java
class MiClaseParaOrdenarPorNombre implements Comparator<Persona> {...}
```

2. **Escribir en nuestra nueva clase el método `.compare()`**: `Comparator` nos obliga a implementar el método `.compare()`, que hace las funciones del `.compareTo()` que vimos en `Comparable` (y es muy parecido al mismo).

El método recibe ésta vez como parámetros dos ojetos con los que queremos comparar (Persona).

```Java
public int compare ( Miclase p, Miclase q ) {…}
```

* Ambos parámetros han de tener como tipo la clase propia que queremos comparar (Persona).

* El método debe devolver un valor entero con la misma casuística que se usa en Comparable:
   * Un número negativo si el parámetro1 es menor que el parámetro2.
   * Un cero si son iguales ambos parámetros.
   * Un número positivo si el parámetro1 es mayor que el parámetro2.
* Por lo general, también como en `Comparable` se usan uno o varios atributos de la clase para efectuar la comparación, y nuevamente habrá dos casos, según el tipo de dato que usemos para ordenar.

**a)** Que el atributo sea un objeto, como `String` o `Date`. Para obtener el valor de retorno, usamos el propio método `compareTo` del objeto.
```Java
class ModeloComparador implements Comparator<Persona> {
   @Override
   public int compare (Persona p1, Persona p2) {
      return (p1.nombre.compareTo (p2.nombre));
   }
}
```

**b)** Que el atributo sea un tipo primitivo numérico. Se puede hacer restando los valores a comparar (de ambos parámetros):
```Java
class ModeloComparador2 implements Comparator<Persona> {
   @Override
   public int compare (Persona p1, Persona p2) {
      return (p1.edad - p2.edad);
   }
} 
```

3. **Implementar `Comparator`**: Esta clase nueva creada, que implementa Comparator, podemos usarla para ordenar de usando los constructores de las colecciones habituales:
   * Listas y arrays mediante los métodos `Collections.sort()` y `Arrays.sort()`, añadiendo un segundo parámetro, ademas de la colección a ordenar, un objeto de la clase `Comparator`.
   * También pueden ordenarse las claves en un mapa ordenado TreeMap.
   * Como elementos en un set ordenado TreeSet, para lo cual debemos crear un un objeto de la clase-comparator que se le pasa como parámetro al constructor de la colección, a la hora de crearla.

Comparator con ArrayList y Collections.sort() pero añadiendo la clase-comparator en el `sort()`.
```Java
public static void main (String[] args) {
   List<Persona> p = new ArrayList<Persona> ();
   p.add (new Persona ("Luis", 23));
   p.add (new Persona ("Pablo", 22));
   p.add (new Persona ("Alberto", 18));
   p.add (new Persona ("Cesar", 34));
   ModeloComparador modcom = new ModeloComparador ();
   Collections.sort (p, modcom);
   for (Persona serhumano : p) {
      System.out.println (serhumano.nombre);
   }
}
```
```shell
Alberto
Cesar
Luis
Pablo
```

Comparator con TreeMap y sin más metodos, pero añadiendo la clasecomparator en el constructor de la colección Advertir que lo que queda ordenado son las claves, pues no pueden quedar ordenados los valores, y que las claves NO se autoordenan por que son una Set en si mismas, pero NO de un tipo de orden natural.
```Java
public static void main (String[] args) {
   // Map<Persona, String> pp = new TreeMap<> (); // ESTO DA ERROR
   // pues intenta autoordenar la clave, que no es de orden natural
   ModeloComparador modcom2 = new ModeloComparador ();
   Map<Persona, String> pp = new TreeMap<> (modcom2);
   pp.put (new Persona ("Luis", 23), "Ruiz");
   pp.put (new Persona ("Pablo", 22), "Martinez");
   pp.put (new Persona ("Alberto", 18), "Lopez");
   pp.put (new Persona ("Cesar", 34), "Perez");
   for (Persona h : pp.keySet ()) {
      System.out.println (h.edad);
   }
}
```
```shell
18
22
23
34
```
