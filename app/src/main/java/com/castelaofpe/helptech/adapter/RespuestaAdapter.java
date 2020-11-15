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
import com.castelaofpe.helptech.models.Respuesta;

import java.util.List;

public class RespuestaAdapter  extends RecyclerView.Adapter<RespuestaAdapter.RespuestaHolder> {

    private static final int layout = R.layout.respuestas_adapter_item;
    private final Activity act;
    private List<Respuesta> items;

    public RespuestaAdapter(Activity act, List<Respuesta> items) {
        this.act = act;
        this.items = items;
    }

    @NonNull
    @Override
    public RespuestaAdapter.RespuestaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);

        return new RespuestaAdapter.RespuestaHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RespuestaAdapter.RespuestaHolder holder, int position) {
        final Respuesta item = items.get(position);

        holder.user.setText(item.getUser());
        holder.icon.setImageResource(R.drawable.programador);
        holder.fecha.setText(item.getHora());
        holder.txtRespuesta.setText(item.getTexto());
        holder.votos.setText(String.valueOf(item.getVotos()) + " votos");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class RespuestaHolder extends RecyclerView.ViewHolder {
        public TextView user;
        public TextView txtRespuesta;
        public TextView fecha;
        public ImageView icon;
        public TextView votos;
        public ConstraintLayout linRoot;

        public RespuestaHolder(View v) {
            super(v);
            user = v.findViewById(R.id.respuestas_adapter_user_txt);
            icon = v.findViewById(R.id.respuestas_adapter_user_image);
            linRoot = v.findViewById(R.id.respuestas_adapter_root);
            votos = v.findViewById(R.id.respuestas_adapter_votos_txt);
            txtRespuesta = v.findViewById(R.id.respuestas_adapter_respuesta_txt);
            fecha = v.findViewById(R.id.respuestas_adapter_hora_txt);
        }
    }
}


