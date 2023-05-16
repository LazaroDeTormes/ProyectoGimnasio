package com.example.proyectogimnasio.pantallas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.proyectogimnasio.R;
import com.example.proyectogimnasio.adaptadores.AdaptadorEjerEstir;
import com.example.proyectogimnasio.adaptadores.AdapterAutocomplete;
import com.example.proyectogimnasio.db.DBHelper;
import com.example.proyectogimnasio.pojos.EjerEstir;

import java.util.ArrayList;

public class Ejercicios extends AppCompatActivity {

    private ListView listaEjer;
    private ArrayList<EjerEstir> ejercicios;
    private DBHelper dbh;
    private AutoCompleteTextView buscar;
    private AdaptadorEjerEstir adapter;
    private AdapterAutocomplete adapterAutocomplete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);

        listaEjer = findViewById(R.id.listaEjercicios);
        buscar = findViewById(R.id.buscadorEjercicios);

        dbh = new DBHelper(this);

        ejercicios = dbh.getAllEjercicios();

        adapter = new AdaptadorEjerEstir(this, R.layout.fila_ejercicios_estiramientos, ejercicios);
        adapterAutocomplete = new AdapterAutocomplete(this, android.R.layout.simple_dropdown_item_1line, ejercicios);



        listaEjer.setAdapter(adapter);
        buscar.setAdapter(adapterAutocomplete);

        buscar.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER){
                    String busqueda = buscar.getText().toString().toLowerCase();
                    if (!busqueda.isEmpty()){
                        ejercicios = dbh.getBusquedaEjer(busqueda);
                    } else {
                        ejercicios = dbh.getAllEjercicios();
                    }

                    adapter = new AdaptadorEjerEstir(Ejercicios.this, R.layout.fila_ejercicios_estiramientos, ejercicios);
                    listaEjer.setAdapter(adapter);
                }
                return false;
            }
        });




    }
}