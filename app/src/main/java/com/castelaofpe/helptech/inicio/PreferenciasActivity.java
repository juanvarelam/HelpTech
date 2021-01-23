package com.castelaofpe.helptech.inicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.castelaofpe.helptech.R;
import com.castelaofpe.helptech.principal.MainActivity;

import java.util.ArrayList;

public class PreferenciasActivity extends AppCompatActivity {

    ArrayList<Preferencia> listaPreferencias;
    RecyclerView recyclerPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_preferencias);

        listaPreferencias = new ArrayList<>();
        recyclerPreferencias = (RecyclerView) findViewById(R.id.recycler_preferencias);
        //recyclerPreferencias.setLayoutManager(new LinearLayoutManager(this));
        recyclerPreferencias.setLayoutManager(new GridLayoutManager(this, 2));

        llenarPreferencias();

        AdapterPreferencias adapter = new AdapterPreferencias(listaPreferencias);
        recyclerPreferencias.setAdapter(adapter);

    }

    private void llenarPreferencias() {
        listaPreferencias.add(new Preferencia("Java",R.drawable.java));
        listaPreferencias.add(new Preferencia("Eclipse",R.drawable.eclipse));
        listaPreferencias.add(new Preferencia("Android Studio",R.drawable.android_studio));
        listaPreferencias.add(new Preferencia("C++",R.drawable.c_masmas));
        listaPreferencias.add(new Preferencia("NetBeans",R.drawable.netbeans));
        listaPreferencias.add(new Preferencia("Python",R.drawable.python));
        listaPreferencias.add(new Preferencia("Sourcetree",R.drawable.sourcetree));
        listaPreferencias.add(new Preferencia("Sublime Text",R.drawable.sublime_text));
        listaPreferencias.add(new Preferencia("Swift",R.drawable.swift));
        listaPreferencias.add(new Preferencia("Virtual Box",R.drawable.virtual_box));
    }

    public void onClick(View view) {
        Intent vista = new Intent(PreferenciasActivity.this, MainActivity.class);
        startActivity(vista);
    }
}