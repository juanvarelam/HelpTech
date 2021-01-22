package com.castelaofpe.helptech.perfil;

public class Pregunta {

    private String fecha;
    private String texto;
    private int comentarios;
    private int votos;
    private String hagstags;

    //Constructores
    public Pregunta() {
    }

    public Pregunta(String fecha, String texto, int comentarios, int votos, String hagstags) {
        this.fecha = fecha;
        this.texto = texto;
        this.comentarios = comentarios;
        this.votos = votos;
        this.hagstags = hagstags;
    }



    //Getters
    public String getFecha() {

        return fecha;
    }

    public String getTexto()
    {
        return texto;
    }

    public int getComentarios() {
        return comentarios;
    }

    public int getVotos() {
        return votos;
    }

    public String getHagstags() {
        return hagstags;
    }



    //Setters
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setComentarios(int comentarios) {
        this.comentarios = comentarios;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public void setHagstags(String hagstags) {
        this.hagstags = hagstags;
    }


}
