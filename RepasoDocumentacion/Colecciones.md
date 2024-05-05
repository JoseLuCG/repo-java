# **Colecciones**

En Java, los array son de tamaño fijo, una vez declarados y asignado un tamaño, éste no puede cambiarse. Para trabajar con estructuras de datos dinámicas, esto es, cuyo tamaño pueda variar, se usan Colecciones. 

Para trabajar con colecciones, no se puede hacer con tipos primitivos (int, char, double…), solo con objetos. Por lo tanto, para trabajar con tipos parecidos a primitivos, podemos usar las clases envoltorios (por ejemplo, no se
puede usar int ni double, pero sí Integer o Double).

Las clases de colección están en el paquete java.util, y son herencias todas de una interfaz madre. 

Los tipos más importantes de colecciones son:
    
* **Listas**: *clases*: `ArrayList`, `Vector`, `LinkedList` ( subclases de interfaz **List** ).
* **Mapas**: *clases*: `HashMap`, `TreeMap` ( subclases de interfaz **Map** y **Table** ).
* **Conjuntos**: *clases*: `HashSet`, `TreeSet` ( subclases de interfaz **Set** ).

## **Listas**

Una lista es una colección que almacena los elementos con un identificador numérico asociado a cada uno. Sus caracteristicas son:

* ***List*** es la interfaz de la que cuelgan estas colecciones.
* El *indicador*(**Indice**) es un **entero** creciente, muy parecido a un array.
* Es de tamaño variable, a diferencia de los arrays.
* Pueden contener elementos duplicados.

### ***Construcción de una lista***

Para construir una lista podemos especificar que tipo de lista crearemos: 

```java
ArrayList<String> laLista1 = new ArrayList<>();
Vector<String> laLista2 = new Vector<>();
LinkedList<String> laLista3 = new LinkedList<>();
```

O bien podemos emplear el polimorfismo:

```Java
List<String> laLista1 = new ArrayList<>();
List<String> laLista2 = new Vector<>();
List<String> laLista3 = new LinkedList<>();
```

### ***Métodos de una Lista***

*  ***`boolean add(Objeto paramName)`***: Mete un elemento al final de la lista.
```Java
objLista.add("Ejemplo"); // Suponiendo que la lista contenga Strings
```

*  ***`void add(int posicion, Objeto paramName)`***: Mete un elemento en la posición indicada, moviendo el resto hacia adelante.
```Java
objLista.add( 3, "Ejemplo"); // Suponiendo que la lista contenga Strings
```

*  ***`objeto get(int posicion)`***: Devuelve el elemento de la posición *`posicion`*. Cuidado: devuelve `objeto` si ArrayList si no tiene tipo.
```Java
String res = objLista.get(0);
```

* ***`objeto remove(int posicion)`***: Elimina el elemento de la posición indicada. Devuelve dicho elemento. 
```Java
objLista.remove(0);
```

* ***`int indexOf(Objeto paramName)`***: Devuelve el indice de la primera ocurrencia del objeto *`paramName`* en la lista, o -1 si no lo encuentra.
```Java
int pos = objLista.indexOf("Ejemplo"); // Suponiendo que la lista contenga Strings
```

* ***`objeto set(int posicion, elemento)`***: Sustituye el elemento de la posición *`posicion`*. Devuelve error si la posicion no existe 
```Java
objLista.set( 1, "Otro Ejemplo"); // Suponiendo que la lista contenga Strings
```

* ***`void clear()`***: Elimina los elementos de la lista.
```Java
objLista.clear();
```

* ***`boolean contains(Objeto parametro)`***: Informa de si un determinado contenido está en la colección. Cuidado: *`contains()`* usa `equals()` para comparar. Si se usan clases propias, es necesario sobreescribir `equals()`.
```Java
boolean existe = objLista.contains("Ejemplo"); // Suponiendo una lista de Strings
```

* ***`int size()`***: Devuelve el numero de elementos que tiene la lista.
```Java
int tamano = objLista.size(); // Suponiendo una lista de Strings
```

* ***`boolean addAll(Collection col)`***: Mete todos los elementos de la coleccion cole al final de la lista. Añade los nuevos elementos, aunque ya estuvieran en la coleccion
inicial, con lo que pueden aparecer repetidos.

* ***`boolean remove(Objeto obj)`***: Elimina (la primera ocurrencia) del objeto `obj`. Devuelve true si pudo eliminarlo. **CUIDADO** que es otra versión de `remove()`, donde el parámetro ha de ser un OBJETO, no confundir con la otra version de `remove()`.

*  ***`int lastIndexOf(Objeto obj)`***: Devuelve el indice de la última ocurrencia del objeto `obj` dentro del objeto invocante. Devuelve -1 si no encuentra el objeto en la colección.

* ***`List subList(int start, int end)`***: Devuelve una lista sacando los elementos desde el indice start al índice end (“shallow” copy).

* ***`int toArray()`***: Convierte un ArrayList en un array de Object, que necesitan casting posterior:
```Java
ArrayList<String> lista2 = new ArrayList<>();
lista2.add("Juan");
lista2.add("Pedro");
String[] nombres2 = (String []) objLista.toArray(); 
```

### ***Clases que implementan List***

* **`ArrayList`**: es el tipo de lista más usado por ser el más sencillo.
    > Métodos exclusivos de ArrayList:

    >*`Object clone ()`*: Devuelve una “shallow copy” (superficial) de la coleccion actual.

    > *`void removeRange(int inicio, inf fin)`*: Borra los elementos de la lista que se encuentren entre inicio (inclusive) y fin (exclusive).

* **`Vector`**: Es beneficioso su uso en proyectos multitarea, pues sus métodos están sincronizados. Esto perjudica el rendimiento, por lo que solo es interesante si se necesita utilizar multitarea.
    > Métodos exclusivos de Vector:

    >*`boolean copyInto(Object[] unarray)`*: Copia los elementos del vector en el array.

    > *`void ensureCapacity(int capacidad)`*: Incrementa la capacidad del vector si es necesario, hasta asegurar que puede almacenar el numero minimo de elementos especificados por el atributo Capacidad Minima (se puede definr en el constructor)

* **`LinkedList`**: también tiene los métodos casi iguales que ArrayList, pero está preparada para trabajar en modo pila o cola, para lo que añade métodos para acceder y retirar elementos desde la cabeza o la cola de la colección.
    > Métodos exclusivos de Vector:
    
    > *`void addFirst(Object ob)`*: Inserta el objeto ob al principio de la lista, desplazano los demas.

    > *`void addLast(Object ob)`*: Inserta el objeto ob al final de la lista.

    > *`void descendingIterator()`*: Devuelve un Iterator de los elementos en orden inverso.

    > *`Object getFirst ()`*: Devuelve, sin eliminarlo, el primer elemento de la lista.

    > *`Object getLast()`*: Devuelve, sin eliminarlo, el ultimo elemento de la lista.

    > *`Object peek ()`*: Devuelve, sin eliminarlo, el primer elemento de la lista.

    > *`Object poll()`*: Devuelve, y además elimina, el primer elemento de la lista.

    > *`Object removeFirst()`*: Devuelve, y además elimina, el primer elemento de la lista.

    > *`Object removeLast()`*: Devuelve, y además elimina, el ultimo elemento de la lista.

## **Conjuntos**

Los Set (conjuntos) son las colecciones más simples, pues agrupan objetos sin clave ni índice. Sus principales características son:

* Set es la interfaz de la que cuelgan el resto de colecciones de la lista: `HashSet`, `TreeSet`, `LinkedHashSet`.
* No existen métodos para recuperar un valor, pues no hay modo de identificarlos al no tener índice ni clave.
* Lo que sí que se puede hacer es recorrer directamente con un *`for-each`*.
* No puede tener elementos duplicados.
* Esta clase se utiliza solo para agrupar, y recorrer, pero no para recuperar algo en específico.
* Para construir un conjunto se puede usar la clase "hija" de ***Set***.


### ***Construcción de un conjunto***

Para construir un conjunto podemos especificar que tipo de lista crearemos: 

```java
// CLASECONJUNTO<tipo> variable = new CLASECONJUNTO<tipo>();
// CLASECONJUNTO<tipo> variable = new CLASECONJUNTO<>(); 
Set<String> elMapa1 = new TreeSet<>();
HashSet<String> elMapa2 = new HashSet<>();
LinkedHashSet<String> elMapa3 = new LinkedHashSet<>();
```

O bien podemos emplear el polimorfismo:

```Java
// SET<tipo> variable = new SET<>();
Set<String> laLista1 = new TreeSet<>();
Set<String> laLista2 = new HashSet<String>();
Set<String> laLista3 = new LinkedHashSet<String>();
```

### ***Métodos de un Set***

*  ***`boolean add(Objeto paramName)`***: Añade un objeto a la colección. Si añadimos un elemento igual a uno existente, devuelve *`false`* y no hace nada. Si no existe, lo añade y devuelve *`true`*. 
```Java
objSet.add("Eva"); // Suponiendo que el Set contenga Strings
```

*  ***`int size()`***: Devuelve el tamaño de la colección.
```Java
objSet.size();
```

*  ***`Object remove(Object obj)`***: Elimina el elemento que contiene el valor indicado. Devuelve *`null`* si no existe el elemento.
```Java
objSet.remove("Juan"); // Suponiendo que el Set contenga Strings
```

*  ***`boolean contains(Object obj)`***: Informa de si un determinado contenido está en la colección.
```Java
boolean existe = objSet.contains("Ana"); // Suponiendo un Set de Strings
```

*  ***`void clear()`***: Elimina todos los elementos de la colección.
```Java
objMapa.clear();
```

*  ***`boolean isEmpty()`***: Indica si la colección está vacía.
```Java
boolean estaVacio = objSet.isEmpty("Ana"); // Suponiendo un Set de Strings
```

*  ***`Object[] toArray()`***: Convierte un Set en un array de Object, que necesitan casting posterior. (Ver ejemplo en el caso de List).
```Java
HashSet<String> elMapa2 = new HashSet<>();
elMapa2.add("Juan");
elMapa2.add("Pedro");
String[] nombres2 = (String []) elMapa2.toArray(); 
```

*  ***`int addAll(Collection cole)`***: Mete todos los elementos de la coleccion cole al final del conjunto. Si hay elementos que ya existen en la coleccion origen, los sustituye. Los elementos nuevos, los incorpora al conjunto.

### ***Clases que implementan Set***

* **`TreeSet`**: ordena los elementos por su contenido. La clave se ordena ascendentemente (si el contenido permite un orden natural de ordenación) o si se trata de una clase, según la implementación de *`Comparator`*/*`Comparable`* que tenga. Ofrece peor rendimiento que otras clases. Un objeto `TreeSet` se crea igual que cualquier otro conjunto.

    > Métodos exclusivos de `TreeSet`:

    >*`Set clone()`*: Devuelve una copia de la colección.

    > *`Object ceiling(Object obj)`*: Devuelve el valor superior o igual en orden al dado por parámetro, o `null` si no existe.

    >*`Object floor(Object obj)`*: Devuelve el valor inferior o igual en orden al dado por parámetro, o `null` si no existe.

    > *`Object first()`*: Devuelve, tomando los elementos ordenados, el valor mas bajo (primer valor).

    >*`Object last()`*: Devuelve, tomando los elementos ordenados, el valor mas alto (ultimo valor).

    > *`Set headSet(Object obj)`*: Devuelve en un conjunto (set) los valores de la colección menores o iguales al parámetro.
    
    >*`Set tailSet(Object obj)`*: Devuelve en un conjunto (set) los valores de la colección mayores o iguales al parámetro.

    > *`Set subSet(int fromIndex, int toIndex)`*: Devuelve el conjunto de elementos que se encuentran entre los índices indicados en los parámetros, desde el primer parámetro inclusive al segundo parámetro exclusive.

    Un TreeSet tiene siempre sus elementos ordenados… por ello, los elementos de un TreeMap... ¡han de poder ordenarse! Si el elemento tiene orden natural, como Integer o String, funciona sin más, pero como añadamos objetos de clases propias a un TreeSet, hemos de decirle con un Comparator o Comparable cómo debe ordenar los objetos!!

* **`HashSet`**: ofrece el mejor rendimiento de todas las clases conjunto. No da ninguna garantía de como se ordenan los elementos ni en que orden se extraen. Permite elementos nulos.
    > Métodos exclusivos de `TreeSet`:

    >*`Set clone()`*: Devuelve una copia de la colección.

* **`LinkedHashSet`**: ofrece un rendimiento casi igual a `HashSet`. Los elementos se ordenan por el orden en el que fueron añadidos a la colección.

