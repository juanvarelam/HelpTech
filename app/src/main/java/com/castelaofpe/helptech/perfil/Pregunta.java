package com.castelaofpe.helptech.perfil;

public class Pregunta {

    private String fecha;
    private String texto;
    private String comentarios;
    private String votos;
    private String hagstags;

    public Pregunta() {

    }

    public Pregunta(String fecha, String texto, String comentarios, String votos, String hagstags) {
        this.fecha = fecha;
        this.texto = texto;
        this.comentarios = comentarios;
        this.votos = votos;
        this.hagstags = hagstags;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getVotos() {
        return votos;
    }

    public void setVotos(String votos) {
        this.votos = votos;
    }

    public String getHagstags() {
        return hagstags;
    }

    public void setHagstags(String hagstags) {
        this.hagstags = hagstags;
    }
}
