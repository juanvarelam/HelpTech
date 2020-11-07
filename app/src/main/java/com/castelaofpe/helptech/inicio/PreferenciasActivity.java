package com.castelaofpe.helptech.inicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.castelaofpe.helptech.R;

import java.util.ArrayList;

public class PreferenciasActivity extends AppCompatActivity {

    ArrayList<String> listPreferencias;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_preferencias);

        recycler = (RecyclerView) findViewById(R.id.recycler_preferencias);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false) );

        listPreferencias = new ArrayList<String>();

        for (int i=0; i<50; i++) {
            listPreferencias.add("Item # " +i+" ");
        }

        AdapterPreferencias adapter = new AdapterPreferencias(listPreferencias);
        recycler.setAdapter(adapter);
    }
}