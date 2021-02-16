package com.castelaofpe.helptech.principal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.castelaofpe.helptech.explora.ExplorarFragment;
import com.castelaofpe.helptech.inicio.InicialActivity;
import com.castelaofpe.helptech.perfil.PerfilFragment;
import com.castelaofpe.helptech.R;

public class MainActivity extends AppCompatActivity {

    HomeFragment frgHome = new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        initButtons();

        changeFragmentMain(frgHome);

    }

    private void initButtons() {

        ImageButton btnHome = findViewById(R.id.frg_main_menu_home_btn);
        ImageButton btnExplora = findViewById(R.id.frg_main_menu_buscar_btn);
        ImageButton btnCrea = findViewById(R.id.frg_main_menu_crea);
        ImageButton btnNoti = findViewById(R.id.frg_main_menu_notif_btn);
        ImageButton btnPerfil = findViewById(R.id.frg_main_menu_perfil_btn);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragmentMain(frgHome);
            }
        });

        btnExplora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExplorarFragment frgExplora = new ExplorarFragment();
                changeFragmentMain(frgExplora);
            }
        });

        btnCrea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreaFragment frgCrea = new CreaFragment();
                changeFragmentMain(frgCrea);
            }
        });

        btnNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificacionesFragment frgNoti = new NotificacionesFragment();
                changeFragmentMain(frgNoti);
            }
        });

        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerfilFragment frgPerfil = new PerfilFragment();
                changeFragmentMain(frgPerfil);
            }
        });

    }

    public String cargaEmail(){
        String filename = "ficheroConfiguracion";
        SharedPreferences sharedPref = getSharedPreferences(filename, Context.MODE_PRIVATE);
        String busca = sharedPref.getString("id", "No existe");
        return sharedPref.getString("email"+busca, "No existe");
    }

    public String cargaUser(){
        String filename = "ficheroConfiguracion";
        SharedPreferences sharedPref = getSharedPreferences(filename, Context.MODE_PRIVATE);
        String busca = sharedPref.getString("id", "No existe");
        return sharedPref.getString("user"+busca, "No existe");
    }

    public void changeFragmentMain(Fragment frg){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();

        trans.replace(R.id.act_main_container, frg, "fragment_01");

        trans.commit();
    }

    public void changeFragmentPerfil(Fragment frg){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();

        trans.replace(R.id.frg_perfil_contenedor, frg, "fragment_01");

        trans.commit();
    }

    public void iniciaActivity (Activity act){
        Intent intent = new Intent(this, act.getClass());
        startActivity(intent);
    }



}