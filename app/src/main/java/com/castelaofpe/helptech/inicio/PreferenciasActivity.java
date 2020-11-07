package com.castelaofpe.helptech.inicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.castelaofpe.helptech.PreferenciaItem;
import com.castelaofpe.helptech.R;

import java.util.ArrayList;

public class PreferenciasActivity extends AppCompatActivity {

    ArrayList<PreferenciaItem> listaPreferencias;
    RecyclerView recyclerPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_preferencias);

        listaPreferencias = new ArrayList<>();
        recyclerPreferencias = (RecyclerView) findViewById(R.id.recycler_preferencias);
        recyclerPreferencias.setLayoutManager(new LinearLayoutManager(this));

        llenarPreferencias();

        AdapterPreferencias adapter = new AdapterPreferencias(listaPreferencias);
        recyclerPreferencias.setAdapter(adapter);

    }

    private void llenarPreferencias() {
        listaPreferencias.add(new PreferenciaItem("Eclipse",R.drawable.eclipse));
        listaPreferencias.add(new PreferenciaItem("Android Studio",R.drawable.android_studio));
        listaPreferencias.add(new PreferenciaItem("C++",R.drawable.c_masmas));
        listaPreferencias.add(new PreferenciaItem("NetBeans",R.drawable.netbeans));
        listaPreferencias.add(new PreferenciaItem("Python",R.drawable.python));
        listaPreferencias.add(new PreferenciaItem("Sourcetree",R.drawable.sourcetree));
        listaPreferencias.add(new PreferenciaItem("Sublime Text",R.drawable.sublime_text));
        listaPreferencias.add(new PreferenciaItem("Swift",R.drawable.swift));
        listaPreferencias.add(new PreferenciaItem("Virtual Box",R.drawable.virtual_box));
    }
}