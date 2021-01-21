package com.castelaofpe.helptech.perfil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.castelaofpe.helptech.R;

import java.util.List;

public class AdapterRecyclerTabsPerfil extends RecyclerView.Adapter<AdapterRecyclerTabsPerfil.MyViewHolder> {


    Context mContext;
    List<Pregunta> mData;

    public AdapterRecyclerTabsPerfil(Context mContext, List<Pregunta> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_preguntas, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.str_fecha.setText(mData.get(position).getFecha());
        holder.str_texto_pregunta.setText(mData.get(position).getTexto());
        holder.int_comentarios.setText(mData.get(position).getComentarios());
        holder.int_votos.setText(mData.get(position).getVotos());
        holder.str_hagstags.setText(mData.get(position).getHagstags());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView str_fecha;
        private TextView str_texto_pregunta;
        private TextView int_comentarios;
        private TextView int_votos;
        private TextView str_hagstags;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            str_fecha = (TextView) itemView.findViewById(R.id.frg_preguntas_fecha);
            str_texto_pregunta = (TextView) itemView.findViewById(R.id.frg_preguntas_texto_preguntas);
            int_comentarios = (TextView) itemView.findViewById(R.id.frg_preguntas_numero_comentarios);
            int_votos = (TextView) itemView.findViewById(R.id.frg_preguntas_numero_votos);
            str_hagstags = (TextView) itemView.findViewById(R.id.frg_preguntas_hagstags);

    }
    }

}
