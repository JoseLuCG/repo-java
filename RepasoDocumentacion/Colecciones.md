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

## **Mapas**

En estas clases los objetos *no tienen un indice numérico*, si no que *tienen un índice propio*, que se añade junto al propio dato a almacenar en la colección. Este índice se llama ***clave***, y hace las funciones de índice, pero no ordenado. La información que se almacena se denomina ***valor***. Las características de un Mapa son:

* `Map` es la interfaz de la que cuelgan el resto de colecciones de mapas: `HashMap`, `TreeMap`, `HashTable`.
* La clave puede ser de cualquier tipo de *objeto*, **no tipo primitivo** (al igual que pasa con el valor).
* Es de tamaño variable, no fijo como un array.
* Al crear el mapa, se debe indicar el tipo de clave y el tipo del valor almacenado en el mapa. Se puede acceder a los elementos (leer, añadir o borrar) por su posición a través del índice.
* No puede contener elementos con la clave duplicada.

### ***Construcción de una lista***

Para construir un mapa podemos especificar que tipo de mapa: 

```java
// CLASEMAPA<tipoClave, tipoValor> variable = new CLASEMAPA<>(); 
HashMap<Integer, String> elMapa1 = new HashMap<>(); 
TreeMap<Integer, String> mapa2 = new TreeMap<>();
```

O bien podemos emplear el polimorfismo:

```Java
// Map<tipoClave, tipoValor> variable = new Map<>(); 
Map<Integer, String> mapa1 = new HashMap<>();
Map<Integer,String> mapa1 = new TreeMap<>();
```

### ***Métodos de un Map***

*  ***`int size()`***: Devuelve el tamaño de la colección.
```Java
objMapa.size();
```

*  ***`object remove(ind)`***: Elimina el elemento con el indice *“ind”*. Devuelve `null` si no existe el indice.
```Java
objMapa.remove( 32 ); // Suponiendo que el Mapa tenga Integer en la clave
```

*  ***`void clear()`***: Elimina todos los elementos de la colección.
```Java
objMapa.clear(); 
```

*  ***`boolean containsKey(Object clave)`***: Indica si existe esa clave en la colección.
```Java
boolean existeLaClave = objMapa.containsKey(14);
```

*  ***`boolean Value(Object valor)`***: Indica si existe ese objeto-valor entre los valores de la colección.
```Java
boolean existeElValor = objMapa.containsValue("Pepe");
```

*  ***`object get(Object indice)`***: Devuelve el valor asociado con el indice indicado por parámetro, o `null` si no existe el indice
```Java
String elValor = objMapa.get(63); // Suponiendo que el mapa contenga Strings
```

*  ***`object put(Object clave, Object valor)`***: Coloca una clave y valor en la coleccion. Si la clave ya existían se sobrescribe el antiguo valor. Devuelve el antiguo valor, si ya existía la clave, o `null` si no existía la clave
```Java
objMapa.put( 19, "Juan"); // Suponiendo que el Mapa tenga Integer y String
```

*  ***`boolean replace(Object clave, Object valor)`***: Modifica el valor de un elemento siempre que coincida con la clave dada. Devuelve true si pudo.
```Java
objMapa.replace( 19, "Ana"); // Si existe la clave 19, le pone valor “Ana” 
```

*  ***`Collection values()`***: Devuelve una colección conteniendo únicamente los objeto-valor del mapa. 
```Java
ArrayList<String> v = objMapa.values(); 
```

*  ***`Set keySet()`***: Devuelve un conjunto (Set) conteniendo únicamente las objeto-clave del mapa. 
```Java
TreeSet<Integer> v = objMapa.keys(); 
```

*  ***`boolean isEmpty()`***: Indica si la colección está vacía.
```Java
boolean estaVacioElMapa = objMapa.isEmpty();
```

*  ***`Set entrySet()`***: Devuelve un conjunto de elementos llamados Map.Entry, que son precisamente del mismo “tipo” que el mapa (esto es, el par de elementos clave-valor) (ver mas adelante ejemplos y detalle).

### ***Clases que implementan Map***

* **`TreeMap`**: garantiza que los elementos del mismo estén ordenados ascendentemente por la clave. La clave se ordena ascendentemente (si el contenido permite un orden natural de ordenación) o si se trata de una clase, según la implementación de Comparator/Comparable que tenga (ver más adelante) Se puede ordenar por la clave, pero nunca por el valor.
    > Metodos exclusivos de `TreeMap`:

    > *`object ceilingEntry(clave)`*: Devuelve el valor asociado a la siguiente clave superior o igual en el orden a la pasada por parámetro, o `null` si no existe.

    > *`object ceilingKey(clave)`*: Devuelve la siguiente clave superior o igual en el orden a la pasada por parámetro, o `null` si no existe.

    > *`object floorEntry(clave)`*: Devuelve el valor asociado a la siguiente clave inferior o igual en el orden a la pasada por parámetro, o null si no existe.

    > *`object floorKey(clave)`*: Devuelve la siguiente clave inferior o igual en el orden a la pasada por parámetro, o `null` si no existe.

    > *`Set entrySet()`*: Devuelve como un conjunto (set) los valores de la colección.

    > *`object firstEntry()`*: Devuelve, tomando los elementos ordenados, el valor del elemento de clave mas baja.

    > *`object firstKey()`*: Devuelve, tomando los elementos ordenados, la clave mas baja (primera clave).

    > *`object lastEntry()`*: Devuelve, tomando los elementos ordenados, el valor del elemento de clave mas alta.

    > *`object lastKey()`* Devuelve, con los elementos ordenados, la clave mas alta (ultima clave).

* **`HashMap`**: en un HashMap, no se puede garantizar el orden de los elementos, de hecho, puede vaiar durante la propia ejecución. En un HashMap se permite que sea null tanto la clave como el valor (con clave, solo un elemento a null).

    > Metodos exlusivos de `HashMap`:
    
    > *`Set clone()`* Devuelve una copia del map.

* **`HashTable`**: es muy similar a HashMap, con dos diferencias importantes: sus metodos están sincronizados, y no se permiten claves ni valores nulos.

* **`LinkedHashMap`**: Un objeto LinkedHashMap es muy similar a HashMap, pero sus valores si tienen orden: el de inserción.

### ***Recorrer un Map***

Los mapas no pueden ser recorridos con un `for-each` porque guardan dos coleccriones (los índices y los valores). Al recorrer con un `for-each`, hay que decirle a éste cual de las colecciones ha de recorrer, si la de las claves o la de los valores. Por lo tanto, no se puede recorrer directamente el mapa, hay que usar la colección de claves o valores.

Esta colección intermedia ha de ser del tipo Collection, que es superclase de Listas y Conjuntos, con este uso:

* Con el método *`.values()`*: se consigue una colección con los valores del mapa. La colección es de la clase `Collection`. Ya vimos que este método devuelve un objeto de tipo Collection con la colección de valores del mapa, que sí tiene un indice para poder usarse en un `for-each`.

* Con el método *`.keySet()`*: se consigue una colección con los índices del mapa
Ya vimos que este método devuelve un objeto de tipo `Set` (hija de `Collection`) con la colección de valores del mapa, que sí tiene un indice para poder usarse en un `for-each`.

Ejemplo, partimos de este mapa ya creado:
```Java
Map<Integer,String> miMapa = new HashMap<>();
miMapa.put(29,"Ana");
miMapa.put(17,"Mercedes");
miMapa.put(31,"Maria");
```

* Recorriendo los valores usando *`.values()`*:
```Java
// Lo mas habitual: Usando en el for-each el método .values()
for (String cadaValor : miMapa.values()) {
 System.out.println(cadaValor);
} 
// --------------------------------------------------------
// Otra opción mas detallada: Creando un objeto Collection y usándolo en for-each
Collection<String> losvalores = miMapa.values();
for (String cadavalor : losvalores) {
 System.out.println(cadavalor);
}
```

Resultado:
```shell
 Ana
 Mercedes
 Maria
```

* Recorriendo las claves usando *`.keySet()`*:
```Java
// Lo mas habitual: Usando en el for-each el método keySet()
for (Integer cadaclave : miMapa.keySet()) {
 System.out.println(cadaclave);
}
// --------------------------------------------------------
// Otra opción mas detallada: Creando un objeto Collection y usándolo en for-each
Collection<Integer> lasclaves = miMapa.keySet();
for (Integer cadaclave : lasclaves) {
 System.out.println(cadaclave);
}
```

Resultado:
```shell
29
17
31
```

### ***Map.Entry***

Ya se ha visto que de un mapa o se recorre la colección de valores o la de claves
๏ Pero, ¿y si quiero recorrer ambas colecciones a la vez? (conocer en un mismo bucle los valores y sus claves) Una solución es recorrer en un bucle las claves, y dentro del bucle, ir sacando los valores:

```Java
Map<Integer,String> miMapa = new HashMap<>();
miMapa.put(29,"Ana");
miMapa.put(17,"Mercedes");
miMapa.put(31,"Maria");
```

```Java
for (Integer cadaclave : miMapa.keySet()) {
 String cadavalor = miMapa.get(cadaclave);
 System.out.print(cadavalor);
 System.out.println(cadaclave);
}
```

```shell
Ana29
Mercedes17
Maria31
```

Pero hay una solución que aporta java, más efectiva, usar el método `entrySet()` en el mapa. Así se usa:


* `entrySet()` en un mapa devuelve un conjunto de elementos llamados `Map.Entry`.

* Cada `Map.Entry` es realmente un par de elementos (clave y valor), correspondiente a cualquier elemento del Mapa.

* De cada elemento del `Map.Entry` se puede extraer el valor con el método `getValue()` y la clave con el método `getKey()`.

Ejempo: Analicemos como funciona Map.Entry, viendo los métodos necesarios al usarlo dentro de for-each:

* En la colección a recorrer, usar `entrySet()` en el mapa a recorrer.
* En el elemento que entrega del `for-each`, poner como tipo ***`Map.Entry<tipoClave,tipoValor>`***.
* En el interior del `for-each`, usar con cada elemento `.getValue()` (para valores) y `.getKey()` (para claves).

```Java
// En este caso es siempre mejor usar el método .entrySet() directamente dentro del for-each
for (Map.Entry<Integer, String> cadaEntry : miMapa.entrySet() ) {
 System.out.println ("clave = " + cadaEntry.getKey() + ", valor = " + cadaEntry.getValue());
```
```shell
Clave = 20, valor = Ana
Clave = 10, valor = Mercedes
Clave = 30, valor = Maria
```

