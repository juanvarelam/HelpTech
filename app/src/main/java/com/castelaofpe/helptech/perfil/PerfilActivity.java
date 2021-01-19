package com.castelaofpe.helptech.perfil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.castelaofpe.helptech.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class PerfilActivity extends AppCompatActivity {

    TabLayout tabLAyout;
    ViewPager viewPager;
    TabItem tab1, tab2, tab3;
    AdapterPager adapterPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_perfil);
        tabLAyout = findViewById(R.id.act_perfil_tabLayout);
        viewPager = findViewById(R.id.act_perfil_viewPager);

        tab1 = findViewById(R.id.act_perfil_tabPreguntas);
        tab2 = findViewById(R.id.act_perfil_tabRespuestas);
        tab3 = findViewById(R.id.act_perfil_tabFavoritos);

        adapterPager = new AdapterPager(getSupportFragmentManager(), tabLAyout.getTabCount());
        viewPager.setAdapter(adapterPager);
        tabLAyout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 1) {
                    adapterPager.notifyDataSetChanged();
                }
                if (tab.getPosition() == 1) {
                    adapterPager.notifyDataSetChanged();
                }
                if (tab.getPosition() == 2) {
                    adapterPager.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLAyout));
    }
}