package com.castelaofpe.helptech.perfil;

public class Favorito {

    private String nombre_suario;
    private String texto;
    private String votos;

    public Favorito(String nombre_suario, String texto, String votos) {
        this.nombre_suario = nombre_suario;
        this.texto = texto;
        this.votos = votos;
    }

    public String getNombre_suario() {
        return nombre_suario;
    }

    public void setNombre_suario(String nombre_suario) {
        this.nombre_suario = nombre_suario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getVotos() {
        return votos;
    }

    public void setVotos(String votos) {
        this.votos = votos;
    }
}
