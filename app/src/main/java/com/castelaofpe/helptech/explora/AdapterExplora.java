package com.castelaofpe.helptech.explora;

import android.opengl.GLES30;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.castelaofpe.helptech.R;

import java.util.ArrayList;


public class AdapterExplora extends RecyclerView.Adapter<AdapterExplora.ViewHolderExplora>{


    ArrayList<ItemExplora> listaItemsExplora;

    public AdapterExplora(ArrayList<ItemExplora> listaItemsExplora) {
        this.listaItemsExplora = listaItemsExplora;
    }

    @NonNull
    @Override
    public AdapterExplora.ViewHolderExplora onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_explora, null, false);
        return new AdapterExplora.ViewHolderExplora(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterExplora.ViewHolderExplora holder, int position) {
        holder.nombre.setText(listaItemsExplora.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return listaItemsExplora.size();
    }

    public class ViewHolderExplora extends RecyclerView.ViewHolder {

        TextView nombre;

        public ViewHolderExplora(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombreItemExplora);
        }
    }

}