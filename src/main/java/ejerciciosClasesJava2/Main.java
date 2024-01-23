package ejerciciosClasesJava2;

import static ejerciciosClasesJava2.Arbol.numTrees;
import static strings.Ejercicio6.outPut;

public class Main {
    public static void main(String[] args) {
        // ==================== Arbol ====================
        Arbol arbol1 = new Arbol(
                "Piñeiro",
                "Pinus Pinaster",
                23.00,
                "Ramirás",
                2000,
                1);
        Arbol arbol2 = new Arbol(
                "Castiñeiro",
                "Castanae Sativa",
                23.00,
                "Ramirás",
                1990,
                2);
        Arbol arbol3 = new Arbol(
                "Amieiro",
                "Alnus Glutinosa",
                23.00,
                "Celanova",
                2003,
                1);

        System.out.println("---------------------");
        outPut.println(arbol1.toString());
        System.out.println("---------------------");
        System.out.println("---------------------");
        outPut.println(arbol2.toString());
        System.out.println("---------------------");
        System.out.println("---------------------");
        outPut.println(arbol3.toString());
        System.out.println("---------------------");
        outPut.println("Número de árboles: "+numTrees);
        System.out.println("---------------------");

        System.out.println();
        System.out.println();
        System.out.println("==============================");
        System.out.println("==============================");
        System.out.println();
        System.out.println();
        // =========================================

        // ==================== PARCELA ====================
        Coordenada cor1 = new Coordenada(10,40);
        Coordenada cor2 = new Coordenada(20,80);
        Coordenada cor3 = new Coordenada(5,7);
        Coordenada cor4 = new Coordenada(46,87);
        Parcela parcela1 = new Parcela(cor1, cor2,5200);
        Parcela parcela2 = new Parcela(cor3, cor4,6780.50);
        Finca finca1 = new Finca(parcela1,"FINCA 1",TipoCultivo.VIÑEDO,false,4500.65);


        outPut.println(parcela1.toString());
        outPut.println(parcela2.toString());
        System.out.println();
        outPut.println(finca1.toString());
        finca1.incrementarSupALimpiar(500.65);
        System.out.println();
        outPut.println(finca1.toString());
        System.out.println();
        finca1.incrementarSupALimpiar(50000.65);
        System.out.println();
        outPut.println(finca1.toString());
        finca1.incrementarSupALimpiar(3900.00);
        finca1.incrementarSupALimpiar(101.00);
        outPut.println(finca1.toString());
        System.out.println("==========================================");
        finca1.decrementarSupALimpiar(1000.00);
        outPut.println(finca1.toString());
        System.out.println("==========================================");
        finca1.decrementarSupALimpiar(1000.00);
        outPut.println(finca1.toString());
        System.out.println("==========================================");
        finca1.decrementarSupALimpiar(1000.00);
        outPut.println(finca1.toString());
        System.out.println("==========================================");
        finca1.decrementarSupALimpiar(1000.00);
        outPut.println(finca1.toString());
        System.out.println("==========================================");
        finca1.decrementarSupALimpiar(1000.00);
        outPut.println(finca1.toString());
    }
}
