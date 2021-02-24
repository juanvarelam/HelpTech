package com.castelaofpe.helptech.principal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.castelaofpe.helptech.R;
import com.castelaofpe.helptech.inicio.InicialActivity;
import com.castelaofpe.helptech.models.Usuario;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class CreaFragment extends Fragment {

    EditText txtPregunta;
    FirebaseFirestore db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = FirebaseFirestore.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frg_crea, container, false);

        txtPregunta = v.findViewById(R.id.frg_crea_texto);

        Button btnPublica = v.findViewById(R.id.frg_crea_btn_post);
        btnPublica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                publicaPregunta();

                CreaFragment frgCrea = new CreaFragment();
                ((MainActivity)getActivity()).changeFragmentMain(frgCrea);

            }
        });

        return v;
    }


    private void publicaPregunta() {

        String error = getString(R.string.datos_incorrectos);
        Toast toast = Toast.makeText(getContext(), error,Toast.LENGTH_SHORT);

        final String txtPreg = txtPregunta.getText().toString();
        if (txtPreg.trim().isEmpty()){
            toast.show();
            return;
        }

        Usuario user = ((MainActivity)getActivity()).getUser();

        guardaDatos(txtPreg, user);

    }

    private void guardaDatos(String txtPreg, Usuario user){

        Map<String, Object> datosPregunta = new HashMap<>();
        datosPregunta.put("pregunta", txtPreg);
        datosPregunta.put("username", user.getUsername());
        datosPregunta.put("votos", 0);

        db.collection("preguntas").document()
                .set(datosPregunta);


    }



}