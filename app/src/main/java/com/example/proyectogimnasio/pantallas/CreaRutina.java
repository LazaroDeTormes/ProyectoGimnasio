package com.example.proyectogimnasio.pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

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
    private Button fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_rutina);

        dbh = new DBHelper(this);
        dia = findViewById(R.id.spnDia);
        listaRutina = findViewById(R.id.listaRutina);
        fin = findViewById(R.id.fin);


        elecciones = dbh.getAllEjercicios();

        adapter = new AdaptadorEjerRutina(this, R.layout.fila_ejercicios_rutina, elecciones);

        listaRutina.setAdapter(adapter);

        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String rutdia = dia.getSelectedItem().toString();
                switch (rutdia){
                    case "monday":
                    case "luns":
                        rutdia= "lunes";
                        break;
                    case "tuesday":
                    case "martes":
                        rutdia= "martes";
                        break;
                    case "wednesday":
                    case "mércores":
                        rutdia= "miércoles";
                        break;
                    case "thursday":
                    case "xoves":
                        rutdia= "jueves";
                        break;
                    case "friday":
                    case "venres":
                        rutdia= "viernes";
                        break;
                    case "saturday":
                    case "sábado":
                        rutdia= "sábado";
                        break;
                    case "sunday":
                    case "domingo":
                        rutdia= "domingo";
                        break;

                }
                System.out.println(listaRutina.getAdapter().getCount());
                for (int i = 0; i < listaRutina.getAdapter().getCount(); i++){
                    boolean switchState =  adapter.getSwitchState(i);
                    if (switchState){
                        EjerEstir ejercicio = (EjerEstir) listaRutina.getAdapter().getItem(i);
                        String nombre = ejercicio.getNombre();
                        System.out.println(nombre);

                        if (dbh.getRutinaPorDia(rutdia, nombre).isEmpty()){
                            dbh.anhadirEjerRutina(nombre, rutdia);
                        } else {
                            Toast.makeText(CreaRutina.this, getString(R.string.ejercicioEnRutina), Toast.LENGTH_SHORT).show();
                        }

                        
                    }
                }

                Intent devolucion = new Intent();
                devolucion.putExtra("resultado", getString(R.string.rutinaActualizada));
                setResult(Activity.RESULT_OK, devolucion);
                finish();

            }
        });


    }
}