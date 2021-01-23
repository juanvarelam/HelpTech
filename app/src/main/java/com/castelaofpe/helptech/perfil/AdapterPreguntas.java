package com.castelaofpe.helptech.perfil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.castelaofpe.helptech.R;

import java.util.ArrayList;

public class AdapterPreguntas extends RecyclerView.Adapter<AdapterPreguntas.ViewHolderPreguntas>{
    ArrayList<Pregunta> listaItems;

    public AdapterPreguntas(ArrayList<Pregunta> listaItems) {
        this.listaItems = listaItems;
    }

    @NonNull
    @Override
    public ViewHolderPreguntas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_preguntas, null, false);
        return new ViewHolderPreguntas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPreguntas holder, int position) {
        holder.fecha.setText(listaItems.get(position).getFecha());
        holder.texto.setText(listaItems.get(position).getTexto());
        holder.comentarios.setText(listaItems.get(position).getComentarios());
        holder.votos.setText(listaItems.get(position).getVotos());
        holder.hagstags.setText(listaItems.get(position).getHagstags());
    }

    @Override
    public int getItemCount() {
        return listaItems.size();
    }

    public class ViewHolderPreguntas extends RecyclerView.ViewHolder {

        TextView fecha;
        TextView texto;
        TextView comentarios;
        TextView votos;
        TextView hagstags;

        public ViewHolderPreguntas(@NonNull View itemView) {
            super(itemView);
            fecha = itemView.findViewById(R.id.frg_preguntas_fecha);
            texto = itemView.findViewById(R.id.frg_preguntas_texto_preguntas);
            comentarios = itemView.findViewById(R.id.frg_preguntas_numero_comentarios);
            votos = itemView.findViewById(R.id.frg_preguntas_numero_votos);
            hagstags = itemView.findViewById(R.id.frg_preguntas_hagstags);

        }
    }
}
