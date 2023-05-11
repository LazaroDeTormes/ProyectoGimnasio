package com.example.proyectogimnasio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView imgTitulo;
    private LinearLayout pantallaPrincipal, pantBot;
    private Button btnRH, btnEj, btnEs, btnCR, btnRu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgTitulo = findViewById(R.id.imgTitulo);
        pantallaPrincipal = findViewById(R.id.pantallaTitulo);
        pantBot = findViewById(R.id.pantallaBotones);
        btnCR = findViewById(R.id.crearRutinaBtn);
        btnEj = findViewById(R.id.ejerciciosBtn);
        btnEs = findViewById(R.id.estiramientosBtn);
        btnRH = findViewById(R.id.rutinaHoyBtn);
        btnRu = findViewById(R.id.rutinasBtn);

        imgTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantallaPrincipal.setVisibility(View.GONE);
                pantBot.setVisibility(View.VISIBLE);
            }
        });

        btnRu.setOnClickListener(this);
        btnEj.setOnClickListener(this);
        btnEs.setOnClickListener(this);
        btnCR.setOnClickListener(this);
        btnRH.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rutinaHoyBtn:
                break;
            case R.id.ejerciciosBtn:
                Intent i = new Intent(this, Ejercicios.class);
                startActivity(i);
                break;
        }
    }
}