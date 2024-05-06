# `.equals()` y `.hashCode()`

`.equals()` y `.hashCode()` son dos métodos directamente heredados de Object. 

* `.hashCode()`: Es un método que devuelve un *integer*,  que es un identificador único del objeto. 
>La implementación por defecto de hashCode() simplemente convierte la dirección de memoria del objeto en un numero `int`
* `.equals()`: Compara objetos para ver si son o no iguales.

Además, ambos se usan en la mayoría de las colecciones para ver si un elemento existe en dicha colección, y para borrarlo, especialmente en las colecciones que son de tipo Hash (HashTable, HashMap or HashSet.).

 >Cuando se busca un elemento en una colección, se intenta primero analizar si son iguales mirando si devuelve lo mismo el método hashCode().
 Como esto puede ocurrir con varios elementos (ver parte avanzada para mas detalle), además de eso, posteriormente se mira si da true el método *`.equals()`*. 

 Por eso, por que se ejecutan en “comanda”, tienen un “contrato particular” que obliga a que, si se decide sobrescribir equals() o hashCode() , deberían entonces sobrescribirse AMBOS.

## Sobrescribir `.equals()`

La implementación por defecto de `.equals()` simplemente compara las direcciones de memoria de los objetos, sus referencias. Esto quiere decir que deberemos sobrescribir `.equals()` para hacerlo a nuestro gusto siempre que:
- Sepamos que vamos a realizar comparaciones con objetos de nuestra clase, y por lo tanto, lo mas lógico será usar el propio método `.equals()` para ello.
- Sepamos que se van a crear colecciones con objetos de mi clase, y estas colecciones pueden ser de tipo Hash.

El mecanismo normal para hacer un `.equals()` en nuestra clase es comparar algunos de sus atributos, buscando alguna regla que dé true o false según las necesidades. En este ejemplo, dos coches no serán iguales sólo comparando sus matriculas, sino que se considerará que son iguales si tienen la misma marca y modelo.

El método ``.equals()` siempre recibe un Object como parámetro, así que lo primero que debemos hacer es hacerle un casting para convertirlo en un objeto de nuestra propia clase, y que podemos comparar correctamente.

```Java
public boolean equals (Object obj) { // El metodo es 'public' y recibe un Object.
    if (! ( obj instanceof MiClaseCoche)) return false;
        // Crea un objeto de tipo MiClaseCoche con un casting al
        // parámetro recibido, para poder usarlo ahora despues
        MiClaseCoche otro = (MiClaseCoche) obj;
        // Comparamos los atributos que queremos
        if ((marca.equals (otro.marca)) && (modelo.equals (otro.modelo))) {
            return true;
            /* Comparamos los atributos que queramos de los dos objetos para dar true o false a la comparación. Este ejemplo compara la marca y la matricula de un coche, esto es, considera que dos coches son iguales si tienen la misma marca y matricula. */
        }
    else {
        return false;
    }
 }
```

## Sobrescribir `.hashCode()`

Un "hashcode" es un valor que se necesita en ciertas operaciones y clases de Java, como en las colecciones de tipo Hash.  No es algo tremendamente necesario en proyectos simples como los de los estudiantes, pues si no se indica el método, Java usa el por defecto (heredado de Object) que es completamente suficiente.
>La implementación por defecto de `.hashCode()` (la que se hereda de Object) simplemente convierte la dirección de memoria del objeto en un numero `int`.

Si deseamos sobrescribir `.hashCode()`, para que tenga mas funcionalidad, debemos intentar que el método devuelva enteros diferentes para cada objetos diferente que creemos de nuestra app. Pero a la vez, es necesario que un mismo objeto siempre obtenga un mismo valor de su méodo `.hashCode()`, por lo que no es correcto usar funciones random para calcular un `.hashCode()`, pues pueden no devolver el mismo resultado a iguales llamadas en una misma ejecución del programa.

Normalmente se sobrescribe `.hashCode()` usando el hashCode() de alguno o varios atributos. 

Ejemplos:
```Java
@Override
public int hashCode () {
    final int prime = 31;
    int result = 1;
    result = prime * result + edad;
    return result;
}
```
```Java
@Override
public int hashCode () {
    return this.nombre.hashCode();
}
```
```Java
@Override
public int hashCode () {
    return this.nombre.hashCode() + this.edad;
}
```