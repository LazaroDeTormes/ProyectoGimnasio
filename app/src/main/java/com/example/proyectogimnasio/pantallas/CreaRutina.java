package com.example.proyectogimnasio.pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;

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
                System.out.println(listaRutina.getAdapter().getCount());
                for (int i = 0; i < listaRutina.getAdapter().getCount(); i++){
                    LayoutInflater inflador = getLayoutInflater();
                    View view = inflador.inflate(R.layout.fila_ejercicios_rutina, null);
                    Switch interruptor = view.findViewById(R.layout.fila_ejercicios_rutina);
                    if (interruptor.isChecked()){
                        EjerEstir ejercicio = (EjerEstir) listaRutina.getAdapter().getItem(i);
                        String nombre = ejercicio.getNombre();
                        dbh.anhadirEjerRutina(nombre, rutdia);
                    }
                }
            }
        });


    }
}