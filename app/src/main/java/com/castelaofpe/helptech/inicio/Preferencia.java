package com.castelaofpe.helptech.inicio;

public class Preferencia {

    private String nombre;
    private int icono;

    public Preferencia() {

    }

    public Preferencia(String nombre, int icono) {
        this.nombre = nombre;
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }
}
