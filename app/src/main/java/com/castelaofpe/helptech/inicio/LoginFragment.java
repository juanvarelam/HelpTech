package com.castelaofpe.helptech.inicio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
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
import com.castelaofpe.helptech.principal.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.DataOutputStream;


public class LoginFragment extends Fragment {

    private EditText email, password;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.frg_login, container, false);


        email = v.findViewById(R.id.frg_login_email);
        password = v.findViewById(R.id.frg_login_password);

        //si accede a la aplicacion
        Button btnSignIn = v.findViewById(R.id.frg_login_btn_sigin);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkDatos();

            }
        });

        Button btnRecuperaPass = v.findViewById(R.id.act_login_recovery_btn);
        btnRecuperaPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecuperaPassFragment frgRecuperaPass = new RecuperaPassFragment();
                ((InicialActivity)getActivity()).changeFragmentInicio(frgRecuperaPass);
            }
        });

        ImageButton btnBack = v.findViewById(R.id.frg_login_btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InicialActivity actInicial = new InicialActivity();
                ((InicialActivity)getActivity()).iniciaActivity(actInicial);
            }
        });

        return v;
    }

    private void checkDatos(){

        String error = getString(R.string.datos_incorrectos);
        Toast toast = Toast.makeText(getContext(), error,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP,0,0);

        String compruebaEmail = email.getText().toString();
        if(compruebaEmail.trim().isEmpty()){
            toast.show();
            return;
        }
        String compruebaPassword = password.getText().toString();
        if(compruebaPassword.trim().isEmpty()){
            toast.show();
            return;
        }

        inicioSesion(compruebaEmail, compruebaPassword);
        MainActivity actMain = new MainActivity();
        ((InicialActivity)getActivity()).iniciaActivity(actMain);

    }

    private void inicioSesion(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("OK", "Sesion iniciada");
                            FirebaseUser user = mAuth.getCurrentUser();


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.e("ERROR", "No se pudo iniciar sesion");
                            Toast toast = Toast.makeText(getContext(), "fallo",Toast.LENGTH_SHORT);
                            updateUI(null);
                            // ...
                        }

                        // ...
                    }
                });
    }

    private void updateUI(FirebaseUser currentUser) {
        Log.i("User:",""+currentUser);
    }

}