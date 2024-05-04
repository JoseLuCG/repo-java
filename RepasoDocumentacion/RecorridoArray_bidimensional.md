# **Recorridos de un array bidimensional:**

## **Recorrer el array fila a fila de izquierda a darecha**
Tenemos dos formas para recorrer el array fila a fila:
* *Recorrido con dos bucles:*
```java
public static void recorrerFilaAFila() {
    int[][] numeros = new int[5][4];

    for (int f=0; f< numeros.length; f++){
        for (int c=0; c< numeros[0].length; c++){
            numeros[f][c] = rnd.nextInt(1, 101);
        }
    }
}
```
* *Recorrido con un bucle:*
```java
public static void recFilFil1() {
    int[][] numeros = new int[5][4];
    int c = numeros[0].length;

    for (int p=0; p< numeros.length*numeros[0].length; p++){
        numeros[p/c][p%c] = rnd.nextInt(1, 101);
    }
}
```
## **Recorrer el array columna a columna de izquierda a darecha**
* *Recorrido con dos bucles:*
```java
public static  void recColxCol(){
    int[][] numeros = new int[5][4];

    for (int c=0; c< numeros[0].length; c++){
        for (int f=0; f< numeros.length; f++){
            numeros[f][c] = rnd.nextInt(1, 101);
        }
    }
}
```
* *Recorrido con un bucle:*
```java
public static  void recColxCol1(){
    int[][] numeros = new int[5][4];
    int f = numeros.length;

    for (int p=0; p< numeros.length*numeros[0].length; p++){
        numeros[p%f][p/f] = rnd.nextInt(1, 101);
    }
}
```
## **Recorrer las diagonales del array**
* *Recorrido de la diagonal principal:*
```java
public static void diagonalPrincipal(){
    int[][] numeros = new int[4][4];

    for (int p = 0; p < numeros.length ; p++) {
        numeros[p][p] = rnd.nextInt(1, 101);
    }
}
```
* *Recorrido de la diagonal secundaria:*
```java
public static void diagonalSecundaria() {
    int[][] numeros = new int[4][4];
    int c = numeros[0].length-1;
    for (int p = 0; p < numeros.length ; p++) {
        numeros[p][c] = rnd.nextInt(1, 101);
        c--;
    }
}
```
## **Recorrido de subareas y colindantes**
* *Recorer una sub area del array*
```java
public static void subAreaArray() {
    int[][] numeros = new int[10][8];
    int fila=4, col= 5, arco=3, fi, ff, ci, cf;
    int nc= numeros[0].length;

    fi = fila-arco; ff = fila+arco;
    ci = col - arco; cf = col + arco;
    if (fi<0) fi = 0;
    if (ci<0) ci = 0;
    if (ff>= numeros.length) ff = numeros.length-1;
    if (cf>=nc) cf = nc - 1;

    //Rellenamos el array:
    for (int f=fi; f<=ff;f++){
        for (int c=ci; c<= cf; c++){
            numeros[f][c] = rnd.nextInt(1,10);
        }
    }
}
```
* *Recorrido de colindantes*
```java
 public static void recorridoColindante (){
    int[][] numeros = new int[10][8];
    int f = 0, c = 1;

    if (f>0 && c>0) numeros[f-1][c-1] = rnd.nextInt(1, 10);
    if (f>0) numeros[f-1][c] = rnd.nextInt(1, 10);
    if (f>0 && c<numeros[0].length-1) numeros[f-1][c+1] = rnd.nextInt(1, 10);

    if (c>0) numeros[f][c-1] = rnd.nextInt(1, 10);
    if (c< numeros.length-1) numeros[f][c+1] = rnd.nextInt(1, 10);

    if (f< numeros.length-1 && c>0) numeros[f+1][c-1] = rnd.nextInt(1, 10);
    if (f< numeros.length-1) numeros[f+1][c] = rnd.nextInt(1, 10);
    if (f< numeros.length && c<numeros[0].length-1) numeros[f+1][c+1] = rnd.nextInt(1, 10);
}
```