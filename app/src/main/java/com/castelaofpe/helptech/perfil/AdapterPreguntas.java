package com.castelaofpe.helptech.perfil;

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
        holder.txtFecha.setText(listaPreguntas.get(position).getFecha());
        holder.txtTexto.setText(listaPreguntas.get(position).getTexto());
        holder.txtComentarios.setText(listaPreguntas.get(position).getComentarios());
        holder.txtVotos.setText(listaPreguntas.get(position).getVotos());
        holder.txtHagstags.setText(listaPreguntas.get(position).getHagstags());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PreguntaViewHolder extends RecyclerView.ViewHolder {
        TextView txtFecha, txtTexto, txtComentarios, txtVotos, txtHagstags;

        public PreguntaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFecha = (TextView) itemView.findViewById(R.id.frg_preguntas_fecha);
            txtTexto = (TextView) itemView.findViewById(R.id.frg_preguntas_texto_preguntas);
            txtComentarios = (TextView) itemView.findViewById(R.id.frg_preguntas_numero_comentarios);
            txtVotos = (TextView) itemView.findViewById(R.id.frg_preguntas_numero_votos);
            txtHagstags = (TextView) itemView.findViewById(R.id.frg_preguntas_hagstags);
        }
    }
}
