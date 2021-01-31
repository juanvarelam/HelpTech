package com.castelaofpe.helptech.inicio;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.castelaofpe.helptech.R;
import com.castelaofpe.helptech.models.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;


public class RegisterFragment extends Fragment {

    private FirebaseAuth mAuth;
    private EditText email, password, confirmPassword;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.frg_register, container, false);

        email = v.findViewById(R.id.frg_registro_email);
        password = v.findViewById(R.id.frg_registro_password);
        confirmPassword = v.findViewById(R.id.frg_registro_confirm_password);

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
                registroUser();

            }
        });

        return v;
    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);

    }

    private void updateUI(FirebaseUser currentUser) {
        Log.i("User:",""+currentUser);
    }


    private void registroUser(){

        String error = getString(R.string.datos_incorrectos);
        Toast toast = Toast.makeText(getContext(), error,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP,0,0);


        final String compruebaEmail = email.getText().toString();
        if(compruebaEmail.trim().isEmpty()){
            toast.show();
            return;
        }

        final String compruebaPassword = password.getText().toString();
        if(compruebaPassword.trim().isEmpty()){
            toast.show();
            return;
        }

        String compruebaConfirmPassword = confirmPassword.getText().toString();
        if(compruebaConfirmPassword.trim().isEmpty()){
            toast.show();
            return;
        }

        if(!compruebaConfirmPassword.equals(compruebaPassword)){
            toast.show();
            return;
        }

       // mAuth = FirebaseAuth.getInstance();
        creaUsuario(compruebaEmail, compruebaPassword);

        PreferenciasActivity actPrefe = new PreferenciasActivity();
        ((InicialActivity)getActivity()).iniciaActivity(actPrefe);

    }

    private void creaUsuario(final String email, final String pass){

        final String oki = "registrado";
        final String fallo= "caspitas";


            mAuth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener( new OnCompleteListener <AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Log.d("OK", "Usuario Creado");
                                FirebaseUser currentUser = mAuth.getCurrentUser();
                                updateUI(currentUser);
                                Toast toast = Toast.makeText(getContext(), oki,Toast.LENGTH_SHORT);

                            } else {
                                Log.e("ERROR", "No se Ha creado el usuario");
                                FirebaseUser currentUser = mAuth.getCurrentUser();
                                updateUI(null);
                                Toast toast = Toast.makeText(getContext(), fallo,Toast.LENGTH_SHORT);
                            }
                        }
                    });
        }


}