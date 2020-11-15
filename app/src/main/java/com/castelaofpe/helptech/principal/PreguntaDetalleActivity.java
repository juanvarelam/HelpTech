package com.castelaofpe.helptech.principal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.castelaofpe.helptech.adapter.RespuestaAdapter;
import com.castelaofpe.helptech.R;
import com.castelaofpe.helptech.models.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class PreguntaDetalleActivity extends AppCompatActivity {

    private List<Respuesta> respuestas;
    RecyclerView recyclerRespuestas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_pregunta_detalle);

        respuestas = new ArrayList<Respuesta>();

        for(int i = 0; i < 10; i++){
            respuestas.add(new Respuesta("User", "Ayer, 19:30", 128));

        }

        recyclerRespuestas = findViewById(R.id.act_pregunta_detalle_respuestas_container);
        recyclerRespuestas.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        RespuestaAdapter respuestaAdapter = new RespuestaAdapter(this, respuestas);
        recyclerRespuestas.setAdapter(respuestaAdapter);
    }

}
