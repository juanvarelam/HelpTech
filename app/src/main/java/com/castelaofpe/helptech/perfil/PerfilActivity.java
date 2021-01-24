package com.castelaofpe.helptech.perfil;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.castelaofpe.helptech.R;

public class PerfilActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragmentPreguntas, fragmentRespuestas, fragmentFavoritos;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_perfil);

        fragmentPreguntas = new AdapterPreguntas();
        fragmentRespuestas = new AdapterRespuestas();
        fragmentFavoritos = new AdapterFavoritos();

        getSupportFragmentManager().beginTransaction().add(R.id.act_perfil_contenedor, fragmentPreguntas).commit();
    }

    public void onClick (View view) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch(view.getId()) {
            case R.id.act_perfil_btn_preguntas:
                transaction.replace(R.id.act_perfil_contenedor, fragmentPreguntas).commit();
                break;
            case R.id.act_perfil_btn_respuestas:
                transaction.replace(R.id.act_perfil_contenedor, fragmentRespuestas).commit();
                break;
            case R.id.act_perfil_btn_favoritos:
                transaction.replace(R.id.act_perfil_contenedor, fragmentFavoritos);
                break;
        }

    }


}
