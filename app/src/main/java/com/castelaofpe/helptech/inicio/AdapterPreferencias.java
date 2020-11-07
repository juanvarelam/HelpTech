package com.castelaofpe.helptech.inicio;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterPreferencias extends RecyclerView.Adapter<AdapterPreferencias.ViewHolderPreferencias> {

    @NonNull
    @Override
    public ViewHolderPreferencias onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPreferencias holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderPreferencias extends RecyclerView.ViewHolder {


        public ViewHolderPreferencias(@NonNull View itemView) {
            super(itemView);
        }
    }
}
