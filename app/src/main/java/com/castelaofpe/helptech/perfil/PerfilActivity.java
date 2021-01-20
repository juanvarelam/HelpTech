package com.castelaofpe.helptech.perfil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.castelaofpe.helptech.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class PerfilActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AdapterPager adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_perfil);

        tabLayout = (TabLayout) findViewById(R.id.act_perfil_tabLayout);
        viewPager = (ViewPager) findViewById(R.id.act_perfil_viewPager);
        adapter = new AdapterPager(getSupportFragmentManager());

        //Add Fragment Here

        adapter.AddFragment(new AdapterPreguntas(),"Preguntas");
        adapter.AddFragment(new AdapterRespuestas(),"Respuestas");
        adapter.AddFragment(new AdapterFavoritos(),"");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(2).setIcon(R.drawable.ic_action_favorite);




    }

}