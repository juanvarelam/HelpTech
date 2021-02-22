package com.castelaofpe.helptech.inicio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.castelaofpe.helptech.R;
import com.castelaofpe.helptech.models.Usuario;
import com.castelaofpe.helptech.principal.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.google.firestore.v1.WriteResult;

import java.util.HashMap;
import java.util.Map;

public class DescripcionActivity extends AppCompatActivity {

    EditText descritpion;
    //DatabaseReference mRootReference;
    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_descripcion);

        db = FirebaseFirestore.getInstance();
    }


    public void onClick(View view) {

        Intent vista = new Intent(DescripcionActivity.this, MainActivity.class);
        startActivity(vista);

        descritpion = findViewById(R.id.act_description_description);
        String texto = descritpion.getText().toString();
        guardaDatos(texto);


    }

    private void guardaDatos(final String description){

        final Map<String, Object> datosUsuario = new HashMap<>();
        datosUsuario.put("description", description);

        String filename = getString(R.string.sharedpreferences_file);
        SharedPreferences sharedPref = getSharedPreferences(filename, Context.MODE_PRIVATE);
        final String busca = sharedPref.getString("id", "No existe");

        db.collection("users").document(busca).set(datosUsuario, SetOptions.merge());


    }

}