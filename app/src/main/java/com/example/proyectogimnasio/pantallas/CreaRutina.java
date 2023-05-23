package com.example.proyectogimnasio.pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.proyectogimnasio.Constantes;
import com.example.proyectogimnasio.R;
import com.example.proyectogimnasio.adaptadores.AdaptadorEjerEstir;
import com.example.proyectogimnasio.adaptadores.AdaptadorEjerRutina;
import com.example.proyectogimnasio.db.DBHelper;
import com.example.proyectogimnasio.pojos.EjerEstir;

import java.util.ArrayList;

public class CreaRutina extends AppCompatActivity {

    private Spinner dia;
    private ListView listaRutina;
    private ArrayList<EjerEstir> elecciones;
    private DBHelper dbh;
    private AdaptadorEjerRutina adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_rutina);

        dbh = new DBHelper(this);
        dia = findViewById(R.id.spnDia);
        listaRutina = findViewById(R.id.listaRutina);

        elecciones = dbh.getAllEjercicios();

        adapter = new AdaptadorEjerRutina(this, R.layout.fila_ejercicios_rutina, elecciones);

        listaRutina.setAdapter(adapter);


    }
}