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

public class AdapterFavoritos extends RecyclerView.Adapter<AdapterFavoritos.FavoritoViewHolder> {

    ArrayList<Favorito> listaFavoritos;

    public AdapterFavoritos(ArrayList<Favorito> listaFavoritos) {

            this.listaFavoritos = listaFavoritos;
        }

        @NonNull
        @Override
        public AdapterFavoritos.FavoritoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favoritos, null, false);
            return new AdapterFavoritos.FavoritoViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull FavoritoViewHolder holder, int position) {
            String nombreUsuario = listaFavoritos.get(position).getNombre_suario();
            String texto = listaFavoritos.get(position).getTexto();
            String votos = listaFavoritos.get(position).getVotos();

            holder.txtNombreUsuario.setText(nombreUsuario);
            holder.txtTexto.setText(texto);
            holder.txtVotos.setText(votos);
        }

        @Override
        public int getItemCount() {
            return listaFavoritos.size();
        }

        public class FavoritoViewHolder extends RecyclerView.ViewHolder {
            TextView txtNombreUsuario, txtTexto, txtVotos;

            public FavoritoViewHolder(@NonNull View itemView) {
                super(itemView);
                txtNombreUsuario = itemView.findViewById(R.id.frg_favoritos_usuario_pregunta);
                txtTexto = itemView.findViewById(R.id.frg_favoritos_texto_pregunta);
                txtVotos = itemView.findViewById(R.id.frg_favoritos_numero_votos);
            }
        }
    }