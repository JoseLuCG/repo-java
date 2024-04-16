package Excepciones;

public class Ejercicio1 {
    public static void main(String[] args) {
        Exception exception1 = new Exception("Hola");

        try{
            throw exception1;
        }catch (Exception err) {
            System.out.println(err);
        } finally {
            System.out.println("Esto es el finally.");
        }
    }
}
