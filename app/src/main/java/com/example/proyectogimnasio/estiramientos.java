package com.example.proyectogimnasio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class estiramientos extends AppCompatActivity {

    private ListView listaEst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estiramientos);

        listaEst = findViewById(R.id.listaEstiramientos);

        AdaptadorEjerEstir adaptador = new AdaptadorEjerEstir();
    }
}