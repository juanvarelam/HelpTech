package com.castelaofpe.helptech.explora;

import androidx.annotation.NonNull;

public class ItemExplora {

    private String nombre;

    public ItemExplora() {
    }

    public ItemExplora(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
