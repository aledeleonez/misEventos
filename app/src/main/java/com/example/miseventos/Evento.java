package com.example.miseventos;

import android.graphics.Bitmap;

import java.util.Date;

public class Evento {

    private String nombre;
    private String descripcion;
    private String direccion;
    private float precio;
    private Date fecha;
    private int aforo;
    private Bitmap imagen;

    public Evento(){}

    public Evento(String nombre, String descripcion, String direccion, float precio, Date fecha, int aforo, Bitmap imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.precio = precio;
        this.fecha = fecha;
        this.aforo = aforo;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }
}
