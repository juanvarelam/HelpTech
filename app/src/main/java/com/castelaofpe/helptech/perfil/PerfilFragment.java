package com.castelaofpe.helptech.perfil;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.castelaofpe.helptech.R;
import com.castelaofpe.helptech.perfil.AdapterFavoritos;
import com.castelaofpe.helptech.perfil.AdapterPreguntas;
import com.castelaofpe.helptech.perfil.AdapterRespuestas;
import com.castelaofpe.helptech.perfil.ConfigActivity;
import com.castelaofpe.helptech.principal.MainActivity;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;

public class PerfilFragment extends Fragment {


    public PerfilFragment() {

    }

    Fragment fragmentPreguntas, fragmentRespuestas, fragmentFavoritos;
    Activity configActivity = new ConfigActivity();
    TextView emailPerfil, usuarioPerfil, descripcionPerfil;
    FirebaseUser user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentPreguntas = new PreguntasFragment();
        fragmentRespuestas = new RespuestasFragment();
        fragmentFavoritos = new FavoritosFragment();

      //  user = ((MainActivity)getActivity()).cargaUsuarioLogueado();
      //  ((MainActivity)getActivity()).cargaDocumentoUsuarioLogueado(user.getUid());

        ((MainActivity)getActivity()).changeFragmentPerfil(fragmentPreguntas);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frg_perfil, container, false);

        emailPerfil = (TextView) v.findViewById(R.id.frg_perfil_email);
        String emaildb = ((MainActivity)getActivity()).cargaemail();
        emailPerfil.setText(emaildb);

        usuarioPerfil = (TextView) v.findViewById(R.id.frg_perfil_usuario);
        String usuarioPreference = ((MainActivity)getActivity()).cargaUsername();
        usuarioPerfil.setText(usuarioPreference);

        descripcionPerfil = (TextView) v.findViewById(R.id.act_perfil_descripcion);
        String descripcionPreference = ((MainActivity)getActivity()).cargaDescription();
        descripcionPerfil.setText(descripcionPreference);

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

        ImageButton btnConfig = v.findViewById(R.id.frg_perfil_btn_config);
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity)getActivity()).iniciaActivity(configActivity);
            }
        });

        return v;
    }






}