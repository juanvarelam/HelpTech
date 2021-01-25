package com.castelaofpe.helptech.inicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;


import com.castelaofpe.helptech.R;

public class InicialActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_inicial);

       // changeFragmentInicio(frgInicial);

        initButtons();
        
    }

    private void initButtons() {
        Button btnLogin = findViewById(R.id.act_inicial_btn_inicio);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFragment    frgLogin    = new LoginFragment();
                changeFragmentInicio(frgLogin);
            }
        });

        Button btnReg = findViewById(R.id.act_inicial_btn_registro);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterFragment frgRegister = new RegisterFragment();
                changeFragmentInicio(frgRegister);
            }
        });
    }

    public void changeFragmentInicio(Fragment frg){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();

        trans.replace(R.id.act_auth_container_frame, frg, "fragment_01");

        trans.commit();
    }

    public void iniciaActivity (Activity act){
        Intent intent = new Intent(this, act.getClass());
        startActivity(intent);
    }

}