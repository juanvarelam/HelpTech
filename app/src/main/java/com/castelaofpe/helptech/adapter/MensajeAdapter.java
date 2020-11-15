package com.castelaofpe.helptech.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.castelaofpe.helptech.R;
import com.castelaofpe.helptech.models.Mensaje;

import java.util.List;

public class MensajeAdapter  extends RecyclerView.Adapter<MensajeAdapter.MensajeHolder> {

    private static final int layout = R.layout.mensajes_lista_adapter_item;
    private final Activity act;
    private List<Mensaje> items;

    public MensajeAdapter(Activity act, List<Mensaje> items) {
        this.act = act;
        this.items = items;
    }

    @NonNull
    @Override
    public MensajeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);

        return new MensajeHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MensajeHolder holder, int position) {
        final Mensaje item = items.get(position);

        holder.user.setText(item.getUser());
        holder.icon.setImageResource(item.getImage());
        holder.hora.setText(item.getHora());
        holder.txtMensaje.setText(item.getTxt());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MensajeHolder extends RecyclerView.ViewHolder {
        public TextView user;
        public TextView txtMensaje;
        public TextView hora;
        public ImageView icon;
        public ConstraintLayout linRoot;

        public MensajeHolder(View v) {
            super(v);
            user = v.findViewById(R.id.mensajes_lista_adapter_user);
            icon = v.findViewById(R.id.mensajes_lista_adapter_user_image);
            linRoot = v.findViewById(R.id.mensajes_lista_adapter_root);
            txtMensaje = v.findViewById(R.id.mensajes_lista_adapter_mensaje_txt);
            hora = v.findViewById(R.id.mensajes_lista_adapter_hora);
        }
    }
}

