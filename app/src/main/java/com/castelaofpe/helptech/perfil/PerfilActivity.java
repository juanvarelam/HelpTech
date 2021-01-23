package com.castelaofpe.helptech.perfil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.View;

import com.castelaofpe.helptech.R;


public class PerfilActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragmentPreguntas, fragmentRespuestas, fragmentFavoritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_perfil);

    }


}