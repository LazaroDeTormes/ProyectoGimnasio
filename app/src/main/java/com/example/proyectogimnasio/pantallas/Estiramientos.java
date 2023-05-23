package com.example.proyectogimnasio.pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.proyectogimnasio.Constantes;
import com.example.proyectogimnasio.R;
import com.example.proyectogimnasio.adaptadores.AdaptadorEjerEstir;
import com.example.proyectogimnasio.db.DBHelper;
import com.example.proyectogimnasio.pojos.EjerEstir;

import java.util.ArrayList;

public class Estiramientos extends AppCompatActivity {

    private ListView listaEst;
    private ArrayList<EjerEstir> estiramientos;
    private ArrayList<String> grupos;
    private DBHelper dbh;
    private AdaptadorEjerEstir adapter;
    private ArrayAdapter<?> adaptadorSpn;
    private Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estiramientos);

        listaEst = findViewById(R.id.listaEstiramientos);
        spn = findViewById(R.id.spnGruposEstiramientos);

        dbh = new DBHelper(this);

        estiramientos = dbh.getAllEstiramientos();
        grupos = new ArrayList<>();
        grupos.add(getString(R.string.grupo_estir));

        for (int i = 0; i < estiramientos.size(); i++){
            grupos.add(estiramientos.get(i).getGrupo());
        }

        Constantes.recargarLista(this, adapter, estiramientos, listaEst);

        adaptadorSpn = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, grupos);

        spn.setAdapter(adaptadorSpn);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String eleccion = spn.getSelectedItem().toString();

                if (!eleccion.equals(getString(R.string.grupo_estir))){
                    estiramientos = dbh.getBusquedaEstir(eleccion);
                } else {
                    estiramientos = dbh.getAllEstiramientos();
                }
                Constantes.recargarLista(Estiramientos.this, adapter, estiramientos, listaEst);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


}