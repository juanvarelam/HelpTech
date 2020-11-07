package com.castelaofpe.helptech;

public class PreferenciaItem {

    private String nombre;
    private int icono;

    public PreferenciaItem() {

    }

    public PreferenciaItem(String nombre, int icono) {
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
