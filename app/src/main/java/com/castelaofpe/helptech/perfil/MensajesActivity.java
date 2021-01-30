package com.castelaofpe.helptech.perfil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.castelaofpe.helptech.adapter.MensajeAdapter;
import com.castelaofpe.helptech.models.Usuario;
import com.castelaofpe.helptech.R;
import com.castelaofpe.helptech.adapter.ContactoAdapter;
import com.castelaofpe.helptech.models.Mensaje;

import java.util.ArrayList;
import java.util.List;

public class MensajesActivity extends AppCompatActivity {

    private List<Usuario> contactos;
    private List<Mensaje> mensajes;
    RecyclerView recyclerMensajesRecientes;
    RecyclerView recyclerMensajesLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_mensajes);
        String txt = ("Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book.");

        contactos = new ArrayList<Usuario>();
        mensajes = new ArrayList<Mensaje>();

        for(int i = 0; i < 10; i++){
            contactos.add(new Usuario("User", R.drawable.programador));
            mensajes.add(new Mensaje("User", R.drawable.programador, "10:30",txt));
        }

        recyclerMensajesRecientes = findViewById(R.id.act_mensajes_recientes_container);
        recyclerMensajesLista = findViewById(R.id.act_mensajes_lista_container);
        recyclerMensajesRecientes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerMensajesLista.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ContactoAdapter contactoAdapter = new ContactoAdapter(this, contactos);
        MensajeAdapter  mensajeAdapter = new MensajeAdapter(this, mensajes);
        recyclerMensajesRecientes.setAdapter(contactoAdapter);
        recyclerMensajesLista.setAdapter(mensajeAdapter);
    }

}