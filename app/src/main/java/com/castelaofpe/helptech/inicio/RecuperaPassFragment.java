package com.castelaofpe.helptech.inicio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.castelaofpe.helptech.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class RecuperaPassFragment extends Fragment {

    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.frg_recupera_pass, container, false);

        final EditText email1 = v.findViewById(R.id.frg_recupera_pass_email);

        ImageButton btnLogBack = v.findViewById(R.id.frg_recupera_btn_back);
        btnLogBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFragment frgLogin = new LoginFragment();
                ((InicialActivity)getActivity()).changeFragmentInicio(frgLogin);
            }
        });


        final Button btnEnviar = v.findViewById(R.id.frg_recupera_pass_btn_enviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String correo = getString(R.string.correo_enviado);
                final Toast toast = Toast.makeText(getContext(), correo,Toast.LENGTH_SHORT);

                String email = email1.getText().toString();

                mAuth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d("OK", "correo enviado");
                                    toast.show();
                                } else{
                                    Log.e("ERROR", "NO se envio correo");

                                }
                            }
                        });

            }
        });


        return v;
    }


}