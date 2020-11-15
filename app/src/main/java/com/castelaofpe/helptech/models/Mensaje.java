package com.castelaofpe.helptech.models;

public class Mensaje  {

    private int id;
    private String user;
    private int image;
    private String txt;
    private String hora;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Mensaje(String user, int image, String hora, String txt) {
        this.user = user;
        this.image = image;
        this.hora = hora;
        this.txt = txt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}

