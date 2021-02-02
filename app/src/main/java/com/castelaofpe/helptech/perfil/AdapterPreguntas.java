package com.castelaofpe.helptech.perfil;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.castelaofpe.helptech.R;

import java.util.ArrayList;

public class AdapterPreguntas extends RecyclerView.Adapter<AdapterPreguntas.PreguntaViewHolder> {

    ArrayList<Pregunta> listaPreguntas;

    public AdapterPreguntas(ArrayList<Pregunta> listaPreguntas) {

        this.listaPreguntas = listaPreguntas;
    }

    @NonNull
    @Override
    public PreguntaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_preguntas, null, false);
        return new PreguntaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PreguntaViewHolder holder, int position) {
        String fecha = listaPreguntas.get(position).getFecha();
        String texto = listaPreguntas.get(position).getTexto();
        String comentarios = listaPreguntas.get(position).getComentarios();
        String votos = listaPreguntas.get(position).getVotos();
        String hagstags = listaPreguntas.get(position).getHagstags();

        holder.txtFecha.setText(fecha);
        holder.txtTexto.setText(texto);
        holder.txtComentarios.setText(comentarios);
        holder.txtVotos.setText(votos);
        holder.txtHagstags.setText(hagstags);
    }

    @Override
    public int getItemCount() {
        return listaPreguntas.size();
    }

    public class PreguntaViewHolder extends RecyclerView.ViewHolder {
        TextView txtFecha, txtTexto, txtComentarios, txtVotos, txtHagstags;

        public PreguntaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFecha = itemView.findViewById(R.id.frg_preguntas_fecha);
            txtTexto = itemView.findViewById(R.id.frg_preguntas_texto_preguntas);
            txtComentarios = itemView.findViewById(R.id.frg_preguntas_numero_comentarios);
            txtVotos = itemView.findViewById(R.id.frg_preguntas_numero_votos);
            txtHagstags = itemView.findViewById(R.id.frg_preguntas_hagstags);
        }
    }
}
