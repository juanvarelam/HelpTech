package com.castelaofpe.helptech;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.castelaofpe.helptech.inicio.InicialActivity;
import com.castelaofpe.helptech.perfil.AdapterFavoritos;
import com.castelaofpe.helptech.perfil.AdapterPreguntas;
import com.castelaofpe.helptech.perfil.AdapterRespuestas;
import com.castelaofpe.helptech.principal.MainActivity;

public class PerfilFragment extends Fragment {


    public PerfilFragment() {

    }


    FragmentManager transaction;
    Fragment fragmentPreguntas, fragmentRespuestas, fragmentFavoritos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentPreguntas = new AdapterPreguntas();
        fragmentRespuestas = new AdapterRespuestas();
        fragmentFavoritos = new AdapterFavoritos();

       // getSupportFragmentManager().beginTransaction().add(R.id.frg_perfil_contenedor, fragmentPreguntas).commit();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frg_perfil, container, false);

        Button btnPreguntas = v.findViewById(R.id.frg_perfil_btn_preguntas);
        btnPreguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).changeFragmentPerfil(fragmentPreguntas);
            }
        });

        Button btnRespuestas = v.findViewById(R.id.frg_perfil_btn_respuestas);
        btnRespuestas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).changeFragmentPerfil(fragmentRespuestas);
            }
        });

        ImageButton btnFavoritos = v.findViewById(R.id.frg_perfil_btn_favoritos);
        btnFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).changeFragmentPerfil(fragmentFavoritos);
            }
        });

       /* ImageButton btnConfig = v.findViewById(R.id.frg_perfil_btn_config);
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity)getActivity()).changeFragmentPerfil(fragmentFavoritos);
            }
        });*/

        return v;
    }





}