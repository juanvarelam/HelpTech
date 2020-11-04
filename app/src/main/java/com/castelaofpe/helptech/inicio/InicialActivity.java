package com.castelaofpe.helptech.inicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.castelaofpe.helptech.R;

public class InicialActivity extends AppCompatActivity {

    LoginFragment frgLog    = new LoginFragment();
    RegisterFragment frgReg = new RegisterFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_inicial);

        //si pulsa SIGN IN
        Button btnLogin = findViewById(R.id.act_inicial_btn_inicio);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();

                trans.replace(R.id.act_auth_container_frame, frgLog, "fragment_01");

                trans.commit();
            }
        });


        Button btnRegister = findViewById(R.id.act_inicial_btn_registro);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();

                trans.replace(R.id.act_auth_container_frame, frgReg, "fragment_01");

                trans.commit();
            }
        });
        


    }




}