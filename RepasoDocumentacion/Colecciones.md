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
int jose = 1
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