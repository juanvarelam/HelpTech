package com.castelaofpe.helptech.inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.castelaofpe.helptech.R;

public class PreinicialActivity extends AppCompatActivity {

    private final int DURACION_SPLASH = 900;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);

        setContentView(R.layout.act_preinicial);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(PreinicialActivity.this, InicialActivity.class);
                startActivity(intent);
                finish();
            }
        }, DURACION_SPLASH);
    }

}