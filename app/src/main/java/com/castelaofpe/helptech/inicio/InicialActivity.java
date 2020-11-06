package com.castelaofpe.helptech.inicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.castelaofpe.helptech.R;

public class InicialActivity extends AppCompatActivity {

    InicialFragment frgInicial    = new InicialFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_inicial);

        changeFragment(frgInicial);

    }

    public void changeFragment(Fragment frg){
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