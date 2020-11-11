package com.castelaofpe.helptech.inicio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.castelaofpe.helptech.PreferenciaItem;
import com.castelaofpe.helptech.R;

import java.util.ArrayList;

public class AdapterPreferencias extends RecyclerView.Adapter<AdapterPreferencias.ViewHolderPreferencias> {

    ArrayList<PreferenciaItem> listaItems;

    public AdapterPreferencias(ArrayList<PreferenciaItem> listaItems) {
        this.listaItems = listaItems;
    }

    @NonNull
    @Override
    public ViewHolderPreferencias onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_preferencias, null, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_preferencias, null, false);
        return new ViewHolderPreferencias(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPreferencias holder, int position) {
        holder.etiNombre.setText(listaItems.get(position).getNombre());
        holder.foto.setImageResource(listaItems.get(position).getIcono());
    }

    @Override
    public int getItemCount() {
        return listaItems.size();
    }

    public class ViewHolderPreferencias extends RecyclerView.ViewHolder {

        TextView etiNombre;
        ImageView foto;

        public ViewHolderPreferencias(@NonNull View itemView) {
            super(itemView);
            etiNombre = itemView.findViewById(R.id.nombreItemPreferencia);
            foto = (ImageView) itemView.findViewById(R.id.iconoItemPreferencia);
        }
    }
}
