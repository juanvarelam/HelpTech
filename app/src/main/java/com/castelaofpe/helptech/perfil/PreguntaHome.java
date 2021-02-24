package com.castelaofpe.helptech.perfil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PreguntaHome {

    private String nombreUsuario;
    private String fecha;
    private String texto;
    private String comentarios;
    private int votos = 0;
    // private String hagstags;



    public PreguntaHome(String nombreUsuario, Date fecha, String texto, String comentarios, int votos ) {
        this.nombreUsuario = nombreUsuario;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:ss");
        this.fecha = sdf.format(fecha);
        this.texto = texto;
        this.comentarios = comentarios;
        this.votos = votos;

    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

   /* public String getHagstags() {
        return hagstags;
    }

    public void setHagstags(String hagstags) {
        this.hagstags = hagstags;
    }*/


}
