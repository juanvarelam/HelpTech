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


public class PreguntasFragment extends Fragment {

    RecyclerView recyclerPreguntas;
    ArrayList<Pregunta> listaPreguntas;

    public PreguntasFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frg_preguntas, container, false);

        listaPreguntas = new ArrayList<>();
        recyclerPreguntas = v.findViewById(R.id.frg_preguntas_recyclerView);
        recyclerPreguntas.setLayoutManager(new LinearLayoutManager(getContext()));
        
        llenarLista();

        AdapterPreguntas adapter = new AdapterPreguntas(listaPreguntas);
        recyclerPreguntas.setAdapter(adapter);

        return v;
    }

    private void llenarLista() {
        listaPreguntas.add(new Pregunta("18:12", "La menor manera de empezar a programar.", "12", "34", "#aprenderaprogramar"));
        listaPreguntas.add(new Pregunta("Ayer", "Como añadir paquetes a SublimeText?", "1", "12", "#sublimetext"));
        listaPreguntas.add(new Pregunta("Martes, 26 enero", "Como usar un recyclerView en Android?", "12", "52", "#android #recyclerView"));
        listaPreguntas.add(new Pregunta("Sábado, 23 enero", "Cómo implementar la última versión" + " de una librería en Android", "12", "34", "#libreriaandroid"));
        listaPreguntas.add(new Pregunta("Jueves, 31 diciembre 2020", "Como programar mejor despues de Nochevieja?", "344", "125", "#vivaJava"));
    }
}