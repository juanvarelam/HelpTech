package com.castelaofpe.helptech.models;

import android.media.Image;

import java.io.Serializable;

public class Usuario implements Serializable {

    private int id;
    private String email;
    private String pass;
    private int imagen;

    public Usuario(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public int getImagen() {
        return imagen;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}

