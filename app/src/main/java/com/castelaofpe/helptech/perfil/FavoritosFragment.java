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

public class FavoritosFragment extends Fragment {

    RecyclerView recyclerFavoritos;
    ArrayList<Favorito> listaFavoritos;

    public FavoritosFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frg_favoritos, container, false);

        listaFavoritos = new ArrayList<>();
        recyclerFavoritos = v.findViewById(R.id.frg_favoritos_recyclerView);
        recyclerFavoritos.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        AdapterFavoritos adapter = new AdapterFavoritos(listaFavoritos);
        recyclerFavoritos.setAdapter(adapter);

        return v;
    }

    private void llenarLista() {
        listaFavoritos.add(new Favorito("abrahantth5", "¿Cómo aprender a programar en una noche?", "2678"));
        listaFavoritos.add(new Favorito("davidbbcc", "Detener un servidor religiosamente", "344"));
        listaFavoritos.add(new Favorito("jorgeelcurioso", "¿Cuál es la abreviatura de «Expresión regular»?", "34"));
        listaFavoritos.add(new Favorito("albertocheco", "Detener un servidor religiosamente", "121"));
        listaFavoritos.add(new Favorito("luciaminster", "Detener un servidor religiosamente", "34"));
        listaFavoritos.add(new Favorito("claudiaferreiraa", "¿Cuál es la abreviatura de «Expresión regular»?", "234"));
        listaFavoritos.add(new Favorito("jmanuel34", "Mejores poemas informáticos", "34"));
        listaFavoritos.add(new Favorito("carmensitalp", "Ser programador de la noche a la mañana.", "34"));
    }
}