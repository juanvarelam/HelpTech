package com.castelaofpe.helptech.perfil;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.castelaofpe.helptech.R;

import java.util.ArrayList;
import java.util.List;


public class AdapterPreguntas extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<Pregunta> lstPregunta;

    public AdapterPreguntas() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frg_preguntas, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.frg_preguntas_recyclerPreguntas);
        AdapterRecyclerTabsPerfil recyclerViewAdapter = new AdapterRecyclerTabsPerfil(getContext(),lstPregunta);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstPregunta = new ArrayList<>();
        lstPregunta.add(new Pregunta("10:24", "¿Cómo usar el mejor framework em Java?", 8, 12, "#java, #framework"));
        lstPregunta.add(new Pregunta("8:20", "¿Cómo aprender a programar en el menor tiempo posible?", 4, 1, "#programar"));
        lstPregunta.add(new Pregunta("Ayer", "¿Cómo conectar MySQL con Java?", 1, 23, "#java, #mysql"));
        lstPregunta.add(new Pregunta("Martes", "¿Cómo alinear texto en Android Studio?", 7, 42, "#androidstudio, #alinear"));
        lstPregunta.add(new Pregunta("Martes", "¿Cómo subir los cambios a Git?", 9, 41, "#git, #sourcetree"));
        lstPregunta.add(new Pregunta("Martes", "¿Cómo importar dependencias en el pom?", 3, 71, "#eclipse, #pom"));
    }
}