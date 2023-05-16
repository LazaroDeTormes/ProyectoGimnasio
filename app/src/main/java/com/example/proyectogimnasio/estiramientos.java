package com.example.proyectogimnasio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class estiramientos extends AppCompatActivity {

    private ListView listaEst;
    private ArrayList<EjerEstir> estiramientos;
    private DBHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estiramientos);

        listaEst = findViewById(R.id.listaEstiramientos);

        dbh = new DBHelper(this);

        estiramientos = dbh.getAllEstiramientos();

        AdaptadorEjerEstir adapter = new AdaptadorEjerEstir(this, R.layout.fila_ejercicios_estiramientos, estiramientos);

        listaEst.setAdapter(adapter);
    }
}