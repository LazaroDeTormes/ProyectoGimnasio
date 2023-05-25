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
        setContentView(R.layout.activity_prev_rutina);

        listaRutina = findViewById(R.id.listaRutina);

        Intent i = getIntent();

        dia = i.getStringExtra("dia");

        switch (dia){
            case "monday":
            case "luns":
                dia= "lunes";
                break;
            case "tuesday":
            case "martes":
                dia= "martes";
                break;
            case "wednesday":
            case "mércores":
                dia= "miércoles";
                break;
            case "thursday":
            case "xoves":
                dia= "jueves";
                break;
            case "friday":
            case "venres":
                dia= "viernes";
                break;
            case "saturday":
            case "sábado":
                dia= "sábado";
                break;
            case "sunday":
            case "domingo":
                dia= "domingo";
                break;

        }

        System.out.println(dia);

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