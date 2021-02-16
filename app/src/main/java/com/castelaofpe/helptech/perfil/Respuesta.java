package com.castelaofpe.helptech.perfil;

public class Respuesta {

    private String fecha;
    private String texto;
    private String votos;

    public Respuesta() {

    }

    public Respuesta(String fecha, String texto, String votos) {
        this.fecha = fecha;
        this.texto = texto;
        this.votos = votos;
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

    public String getVotos() {
        return votos;
    }

    public void setVotos(String votos) {
        this.votos = votos;
    }

}
