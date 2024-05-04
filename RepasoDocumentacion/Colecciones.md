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
Para construir una lista podemos especificar que tipo de lista crearemos o bien podemos emplear el polimorfismo:

```java
int jose = 1
ArrayList<String> laLista1 = new ArrayList<>();
Vector<String> laLista2 = new Vector<>();
LinkedList<String> laLista3 = new LinkedList<>();
```