package com.castelaofpe.helptech.principal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.castelaofpe.helptech.R;

public class MainActivity extends AppCompatActivity {

    HomeFragment frgHome = new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        changeFragmentMain(frgHome);

    }



    public void changeFragmentMain(Fragment frg){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();

        trans.replace(R.id.act_main_container, frg, "fragment_01");

        trans.commit();
    }


}