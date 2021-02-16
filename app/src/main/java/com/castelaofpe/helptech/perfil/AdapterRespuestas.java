package com.castelaofpe.helptech.perfil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.castelaofpe.helptech.R;

import java.util.ArrayList;

public class AdapterRespuestas extends RecyclerView.Adapter<AdapterRespuestas.RespuestaViewHolder>{

    ArrayList<Respuesta> listaRespuestas;

    public AdapterRespuestas(ArrayList<Respuesta> listaRespuestas) {
        this.listaRespuestas = listaRespuestas;
    }

    @NonNull
    @Override
    public AdapterRespuestas.RespuestaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_respuestas, null, false);
        return new AdapterRespuestas.RespuestaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRespuestas.RespuestaViewHolder holder, int position) {
        String fecha = listaRespuestas.get(position).getFecha();
        String texto = listaRespuestas.get(position).getTexto();
        String votos = listaRespuestas.get(position).getVotos();

        holder.txtFecha.setText(fecha);
        holder.txtTexto.setText(texto);
        holder.txtVotos.setText(votos);
    }

    @Override
    public int getItemCount() {
        return listaRespuestas.size();
    }

    public class RespuestaViewHolder extends RecyclerView.ViewHolder {
        TextView txtFecha, txtTexto, txtVotos;

        public RespuestaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFecha = itemView.findViewById(R.id.frg_respuestas_fecha);
            txtTexto = itemView.findViewById(R.id.frg_respuestas_texto_preguntas);
            txtVotos = itemView.findViewById(R.id.frg_respuestas_numero_votos);
        }
    }
}
