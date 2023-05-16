package com.example.proyectogimnasio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Ejercicios extends AppCompatActivity {

    private ListView listaEjer;
    private ArrayList<EjerEstir> ejercicios;
    private DBHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);

        listaEjer = findViewById(R.id.listaEjercicios);

        dbh = new DBHelper(this);

        ejercicios = dbh.getAllEjercicios();

        AdaptadorEjerEstir adapter = new AdaptadorEjerEstir(this, R.layout.fila_ejercicios_estiramientos, ejercicios);

        listaEjer.setAdapter(adapter);


    }
}