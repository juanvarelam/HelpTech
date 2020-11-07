package com.castelaofpe.helptech.inicio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.castelaofpe.helptech.R;

import java.util.ArrayList;

public class AdapterPreferencias extends RecyclerView.Adapter<AdapterPreferencias.ViewHolderPreferencias> {

    ArrayList<String> listPreferencias;

    public AdapterPreferencias(ArrayList<String> listPreferencias) {
        this.listPreferencias = listPreferencias;
    }

    @Override
    public ViewHolderPreferencias onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_list_preferencias, null, false);
        return new ViewHolderPreferencias (view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPreferencias holder, int position) {
        holder.asignarItems(listPreferencias.get(position));
    }

    @Override
    public int getItemCount() {
        return listPreferencias.size();
    }

    public class ViewHolderPreferencias extends RecyclerView.ViewHolder {

        TextView item;

        public ViewHolderPreferencias(View itemView) {
            super(itemView);
            item = (TextView) itemView.findViewById(R.id.itemJavatxt);
        }

        public void asignarItems(String items) {
            item.setText(items);
        }
    }
}
