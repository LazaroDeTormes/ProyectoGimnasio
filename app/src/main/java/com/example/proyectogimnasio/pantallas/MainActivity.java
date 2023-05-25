package com.example.proyectogimnasio.pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.proyectogimnasio.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView imgTitulo;
    private LinearLayout pantallaPrincipal, pantBot;
    private Button btnRH, btnEj, btnEs, btnCR, btnRu;
    private static final int RESPUESTA = 1;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuopciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.rutinaHoyBtn:
                i = new Intent(this, RutinaHoy.class);
                startActivity(i);
                break;
            case R.id.ejerciciosBtn:
                i = new Intent(this, Ejercicios.class);
                startActivity(i);
                break;
            case R.id.estiramientosBtn:
                i = new Intent(this, Estiramientos.class);
                startActivity(i);
                break;
            case R.id.crearRutinaBtn:
                i = new Intent(this, CreaRutina.class);
                startActivityForResult(i, RESPUESTA);
                break;
            case R.id.rutinasBtn:
                i = new Intent(this, MisRutinas.class);
                startActivity(i);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESPUESTA) {
            if(resultCode == Activity.RESULT_OK){
                Toast.makeText(this, data.getStringExtra("resultado"), Toast.LENGTH_SHORT).show();
            }
        }
    }
}