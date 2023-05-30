package com.example.proyectogimnasio.pantallas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectogimnasio.R;

public class Colores extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private TextView cuadrado;
    private SeekBar rojo;
    private SeekBar verde;
    private SeekBar azul;
    private int r, g, b;
    private Button guardar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colores);

        cuadrado = findViewById(R.id.cuadrado);
        rojo = findViewById(R.id.rojo);
        verde = findViewById(R.id.verde);
        azul = findViewById(R.id.azul);
        guardar = findViewById(R.id.guardar);


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = Color.rgb(r,g,b);
                Intent devolucion = new Intent();
                devolucion.putExtra("colornuevo", color);
                setResult(Activity.RESULT_OK, devolucion);
                finish();
            }
        });

        rojo.setOnSeekBarChangeListener(this);
        verde.setOnSeekBarChangeListener(this);
        azul.setOnSeekBarChangeListener(this);

        ajustesRGB();




    }

    public void ajustesRGB(){


        r = rojo.getProgress();
        g = verde.getProgress();
        b = azul.getProgress();

        int color = Color.rgb(r,g,b);

        cuadrado.setBackgroundColor(color);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        ajustesRGB();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);



        outState.putInt("r",r);
        outState.putInt("g",g);
        outState.putInt("b",b);


    }
}
