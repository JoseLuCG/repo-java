package CorreccionExamen18_04_24.Ejercicio2;

import java.util.Objects;

enum Estado {
    ACTIVO, DESCATALOGADO, BAJA
}

public class Producto {
    // Attributes
    protected String ean;
    protected String nombre;
    protected int precio;
    protected int existencias;
    protected Estado estado = Estado.ACTIVO;

    // Constructors.
    public Producto () {}

    public Producto(String ean, String nombre, int precio, int existencias) {
        setEan(ean);
        this.nombre = nombre;
        setPrecio(precio);
        setExistencias(existencias);
    }

    // Getters

    public String getEan() {
        return ean;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public Estado getEstado() {
        return estado;
    }

    // Setters


    public void setEan(String ean) {
        if (validarEan(ean)) {
            this.ean = ean;
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        if (precio >= 0) this.precio = precio;
    }

    public void setExistencias(int existencias) {
        if (existencias >= 0) this.existencias = existencias;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean validarEan(String ean) {
        String cadena = ean.substring(0,12);
        char control = ean.charAt(12);
        int sumador = 0, resto;

        if(ean.length() != 13) return false;
        for (int i = cadena.length()-1; i >= 0; i-=2) {
            if(i > 0){
                sumador += Integer.parseInt(cadena.charAt(i-1)+"");
            }
            sumador += Integer.parseInt(cadena.charAt(i) +"") * 3;
        }
        resto = sumador % 10;

        if ((10-resto)+"" == control+""){
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        return  "Ean: " + ean +
                "\nnombre: " + nombre +
                "\nprecio: " + precio +
                "\nexistencias: " + existencias +
                "\nestado: " + estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return ean.equals(producto.ean) && nombre.equals(producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ean, nombre);
    }
}
