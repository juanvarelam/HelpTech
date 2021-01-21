package com.castelaofpe.helptech.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.castelaofpe.helptech.R;

import java.util.ArrayList;
import java.util.List;


public class AdapterPreguntas extends Fragment {

    View v;
    private RecyclerView myRecyclerView;
    private List<Pregunta> lstPregunta;

    public AdapterPreguntas() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frg_preguntas, container, false);
        myRecyclerView = (RecyclerView) v.findViewById(R.id.frg_preguntas_recyclerPreguntas);
        AdapterRecyclerTabsPerfil recyclerTabsPerfil = new AdapterRecyclerTabsPerfil(getContext(), lstPregunta);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerTabsPerfil);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstPregunta = new ArrayList<>();
        lstPregunta.add(new Pregunta("10:24", "¿cómo empezar a programar?", 4, 23, "#programar #junior"));
        lstPregunta.add(new Pregunta("10:24", "¿cómo empezar a programar?", 4, 23, "#programar #junior"));
        lstPregunta.add(new Pregunta("10:24", "¿cómo empezar a programar?", 4, 23, "#programar #junior"));
        lstPregunta.add(new Pregunta("10:24", "¿cómo empezar a programar?", 4, 23, "#programar #junior"));


    }
}