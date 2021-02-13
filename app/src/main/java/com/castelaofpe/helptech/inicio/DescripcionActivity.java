package com.castelaofpe.helptech.inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.castelaofpe.helptech.R;
import com.castelaofpe.helptech.principal.MainActivity;

public class DescripcionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_descripcion);
    }


    public void onClick(View view) {
        Intent vista = new Intent(DescripcionActivity.this, MainActivity.class);
        startActivity(vista);
    }
}