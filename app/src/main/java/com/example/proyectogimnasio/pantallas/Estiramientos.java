package com.example.proyectogimnasio.pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.proyectogimnasio.R;
import com.example.proyectogimnasio.adaptadores.AdaptadorEjerEstir;
import com.example.proyectogimnasio.db.DBHelper;
import com.example.proyectogimnasio.pojos.EjerEstir;

import java.util.ArrayList;

public class Estiramientos extends AppCompatActivity {

    private ListView listaEst;
    private ArrayList<EjerEstir> estiramientos;
    private DBHelper dbh;
    private AdaptadorEjerEstir adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estiramientos);

        listaEst = findViewById(R.id.listaEstiramientos);

        dbh = new DBHelper(this);

        estiramientos = dbh.getAllEstiramientos();

        adapter = new AdaptadorEjerEstir(this, R.layout.fila_ejercicios_estiramientos, estiramientos);

        listaEst.setAdapter(adapter);
    }
}