package com.castelaofpe.helptech.principal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.castelaofpe.helptech.PerfilFragment;
import com.castelaofpe.helptech.R;
import com.castelaofpe.helptech.perfil.PerfilActivity;

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
                ExploraFragment frgExplora = new ExploraFragment();
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


    public void changeFragmentMain(Fragment frg){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();

        trans.replace(R.id.act_main_container, frg, "fragment_01");

        trans.commit();
    }

    public void changeFragmentPerfil(Fragment frg){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();

        trans.replace(R.id.act_perfil_contenedor, frg, "fragment_01");

        trans.commit();
    }

    public void iniciaActivity (Activity act){
        Intent intent = new Intent(this, act.getClass());
        startActivity(intent);
    }



}