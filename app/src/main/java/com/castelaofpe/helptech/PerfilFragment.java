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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#//newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {
/*
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.

    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
*/

    FragmentManager transaction;
    Fragment fragmentPreguntas, fragmentRespuestas, fragmentFavoritos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     /*   if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
        fragmentPreguntas = new AdapterPreguntas();
        fragmentRespuestas = new AdapterRespuestas();
        fragmentFavoritos = new AdapterFavoritos();

        //getSupportFragmentManager().beginTransaction().add(R.id.act_perfil_contenedor, fragmentPreguntas).commit();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

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