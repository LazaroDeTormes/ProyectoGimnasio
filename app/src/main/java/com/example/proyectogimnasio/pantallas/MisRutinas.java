package com.example.proyectogimnasio.pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proyectogimnasio.R;

public class MisRutinas extends AppCompatActivity  implements View.OnClickListener {

    private Button lun, mar, mie, jue, vie, sab, dom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_rutinas);

        lun = findViewById(R.id.rutinaLunes);
        mar = findViewById(R.id.rutinaMartes);
        mie = findViewById(R.id.rutinaMiercoles);
        jue = findViewById(R.id.rutinaJueves);
        vie = findViewById(R.id.rutinaViernes);
        sab = findViewById(R.id.rutinaSabado);
        dom = findViewById(R.id.rutinaDomingo);

        lun.setOnClickListener(this);
        mar.setOnClickListener(this);
        mie.setOnClickListener(this);
        jue.setOnClickListener(this);
        vie.setOnClickListener(this);
        sab.setOnClickListener(this);
        dom.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        Bundle b;
        switch (v.getId()){
            case R.id.rutinaLunes:
                i = new Intent(this, PrevRutina.class);
                b = new Bundle();
                b.putString("dia", "lunes");
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.rutinaMartes:
                i = new Intent(this, PrevRutina.class);
                b = new Bundle();
                b.putString("dia", "martes");
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.rutinaMiercoles:
                i = new Intent(this, PrevRutina.class);
                b = new Bundle();
                b.putString("dia", "miercoles");
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.rutinaJueves:
                i = new Intent(this, PrevRutina.class);
                b = new Bundle();
                b.putString("dia", "jueves");
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.rutinaViernes:
                i = new Intent(this, PrevRutina.class);
                b = new Bundle();
                b.putString("dia", "viernes");
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.rutinaSabado:
                i = new Intent(this, PrevRutina.class);
                b = new Bundle();
                b.putString("dia", "sabado");
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.rutinaDomingo:
                i = new Intent(this, PrevRutina.class);
                b = new Bundle();
                b.putString("dia", "domingo");
                i.putExtras(b);
                startActivity(i);
                break;




        }
    }
}