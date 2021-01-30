package com.castelaofpe.helptech.inicio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.castelaofpe.helptech.R;


public class RegisterFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.frg_register, container, false);

        ImageButton btnBack = v.findViewById(R.id.frg_register_btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InicialActivity actInicial = new InicialActivity();
                ((InicialActivity)getActivity()).iniciaActivity(actInicial);
            }
        });

        Button btnSignIn = v.findViewById(R.id.frg_registro_btn_sigin);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenciasActivity actPref = new PreferenciasActivity();
                ((InicialActivity)getActivity()).iniciaActivity(actPref);
            }
        });

        return v;
    }
}