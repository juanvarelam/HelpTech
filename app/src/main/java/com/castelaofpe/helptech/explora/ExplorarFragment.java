package com.castelaofpe.helptech.explora;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.castelaofpe.helptech.R;

import java.util.ArrayList;


public class ExplorarFragment extends Fragment {

    RecyclerView recyclerExplorar;
    ArrayList<ItemExplora> listaItemsExplorar;

    public ExplorarFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ExplorarFragment newInstance(String param1, String param2) {
        ExplorarFragment fragment = new ExplorarFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frg_explorar, container, false);
        listaItemsExplorar = new ArrayList<>();
        recyclerExplorar = v.findViewById(R.id.frg_explorar_recyclerView);
        recyclerExplorar.setLayoutManager(new StaggeredGridLayoutManager( 2, StaggeredGridLayoutManager.VERTICAL));

        llenarLista();

        AdapterExplora adapter = new AdapterExplora(listaItemsExplorar);
        recyclerExplorar.setAdapter(adapter);

        return v;
    }

    private void llenarLista() {
        listaItemsExplorar.add(new ItemExplora("Visual Studio Code"));
        listaItemsExplorar.add(new ItemExplora("C"));
        listaItemsExplorar.add(new ItemExplora("JavaScript"));
        listaItemsExplorar.add(new ItemExplora("NodeJS"));
        listaItemsExplorar.add(new ItemExplora("Python"));
        listaItemsExplorar.add(new ItemExplora("Java"));
        listaItemsExplorar.add(new ItemExplora("AngularJS"));
        listaItemsExplorar.add(new ItemExplora("C++"));
        listaItemsExplorar.add(new ItemExplora("ReactJS"));
        listaItemsExplorar.add(new ItemExplora("VueJS"));

    }
}