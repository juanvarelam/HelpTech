package com.castelaofpe.helptech.perfil;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.castelaofpe.helptech.R;

import java.util.ArrayList;


public class RespuestasFragment extends Fragment {
    RecyclerView recyclerRespuestas;
    ArrayList<Respuesta> listaRespuestas;

    public RespuestasFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frg_respuestas, container, false);

        listaRespuestas = new ArrayList<>();
        recyclerRespuestas = v.findViewById(R.id.frg_respuestas_recyclerView);
        recyclerRespuestas.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        AdapterRespuestas adapter = new AdapterRespuestas(listaRespuestas);
        recyclerRespuestas.setAdapter(adapter);

        return v;
    }

    private void llenarLista() {
        listaRespuestas.add(new Respuesta("18:12", "La mejor forma sería declarar una variable estática en vez de acceder a ella en cada petición.", "0"));
        listaRespuestas.add(new Respuesta("Ayer", "Para mí, VS Code, OJO no confuncir con Visual Studio.", "21"));
        listaRespuestas.add(new Respuesta("Sádado, 13 febrero", "Se puede usar fgets o gets.", "2"));
        listaRespuestas.add(new Respuesta("Miércoles, 10 febrero", "SELECT nombre, apellidos FROM CLIENTE WHERE cifcl < ALL (SELECT cifcl FROM CLIENTE WHERE ciudad = 'Barcelona')", "6"));
        listaRespuestas.add(new Respuesta("Viernes, 1 enero", "Te diriges a Help -> Check for updates.", "34"));
    }
}