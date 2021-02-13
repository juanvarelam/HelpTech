package com.castelaofpe.helptech.inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.castelaofpe.helptech.R;
import com.castelaofpe.helptech.principal.MainActivity;

public class FotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_foto);
    }


    public void onClick(View view) {
        Intent vista = new Intent(FotoActivity.this, DescripcionActivity.class);
        startActivity(vista);
    }
}