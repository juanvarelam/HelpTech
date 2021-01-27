package com.castelaofpe.helptech.models;

import com.castelaofpe.helptech.R;

public class Respuesta {

    private int id;
    private String user;
    private String hora;
    private String texto = String.valueOf(R.string.ejemplo_txt);
    private int votos;

    public Respuesta(String user, String hora, int votos) {
        this.user = user;
        this.hora = hora;
        this.votos = votos;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
}
