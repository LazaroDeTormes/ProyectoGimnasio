package com.example.proyectogimnasio.pantallas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proyectogimnasio.R;
import com.example.proyectogimnasio.adaptadores.AdaptadorEjerEstir;
import com.example.proyectogimnasio.db.DBHelper;
import com.example.proyectogimnasio.pojos.EjerEstir;

import java.util.ArrayList;

public class PrevRutina extends AppCompatActivity {

    private ListView listaRutina;
    private DBHelper dbh;
    private ArrayList<EjerEstir> rutina;
    private String dia;
    private AdaptadorEjerEstir adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();

        dia = i.getStringExtra("dia");

        listaRutina = findViewById(R.id.listaRutina);

        dbh = new DBHelper(this);

        rutina = dbh.getRutinaPorDia(dia);


        if (rutina.size()!=0){
            adapter = new AdaptadorEjerEstir(this, R.layout.fila_ejercicios_estiramientos, rutina);


            listaRutina.setAdapter(adapter);
        } else {
            Toast.makeText(this, getString(R.string.rutina_vacia), Toast.LENGTH_SHORT).show();
        }





    }
}