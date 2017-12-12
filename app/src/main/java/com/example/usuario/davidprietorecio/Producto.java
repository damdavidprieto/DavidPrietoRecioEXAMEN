package com.example.usuario.davidprietorecio;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Usuario on 12/12/2017.
 */

public class Producto implements Serializable{

    private int idProductto,imagen;
    private String nombreProducto,descripcion;
    private double precio;
    private int [] galeriaImagenes;

    public Producto(int idProductto, int imagen, String nombreProducto, String descripcion, double precio, int[] galeriaImagenes) {
        this.idProductto = idProductto;
        this.imagen = imagen;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.galeriaImagenes = galeriaImagenes;
    }

    public int getIdProductto() {
        return idProductto;
    }

    public void setIdProductto(int idProductto) {
        this.idProductto = idProductto;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int[] getGaleriaImagenes() {
        return galeriaImagenes;
    }

    public void setGaleriaImagenes(int[] galeriaImagenes) {
        this.galeriaImagenes = galeriaImagenes;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProductto=" + idProductto +
                ", imagen=" + imagen +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", galeriaImagenes=" + Arrays.toString(galeriaImagenes) +
                '}';
    }
}
