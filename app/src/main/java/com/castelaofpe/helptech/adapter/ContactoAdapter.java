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

        import com.castelaofpe.helptech.models.Usuario;
        import com.castelaofpe.helptech.R;

        import java.util.List;

public class ContactoAdapter  extends RecyclerView.Adapter<ContactoAdapter.ContactoHolder> {

    private static final int layout = R.layout.mensajes_recientes_adapter_item;
    private final Activity act;
    private List<Usuario> items;

    public ContactoAdapter(Activity act, List<Usuario> items) {
        this.act = act;
        this.items = items;
    }

    @NonNull
    @Override
    public ContactoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);

        return new ContactoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoHolder holder, int position) {
        final Usuario item = items.get(position);

        String texto = item.getEmail();
        holder.txt.setText(texto);
       // holder.icon.setImageResource(item.getImagen());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ContactoHolder extends RecyclerView.ViewHolder {
        public TextView txt;
        public ImageView icon;
        public ConstraintLayout linRoot;

        public ContactoHolder(View v) {
            super(v);
            txt = v.findViewById(R.id.mensajes_recientes_adapter_user_name);
            icon = v.findViewById(R.id.mensajes_recientes_adapter_user_image);
            linRoot = v.findViewById(R.id.mensajes_recientes_adapter_root);
        }
    }

    private void getImagen(){}

}

