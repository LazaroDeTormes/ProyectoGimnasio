package com.example.proyectogimnasio.pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.example.proyectogimnasio.R;
import com.example.proyectogimnasio.adaptadores.AdaptadorEjerEstir;
import com.example.proyectogimnasio.db.DBHelper;
import com.example.proyectogimnasio.pojos.EjerEstir;

import java.util.ArrayList;

public class Ejercicios extends AppCompatActivity {

    private ListView listaEjer;
    private ArrayList<EjerEstir> ejercicios;
    private ArrayList<String> nombres;
    private DBHelper dbh;
    private AutoCompleteTextView buscar;
    private AdaptadorEjerEstir adapter;
    private ArrayAdapter<?> adapterAutocomplete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);

        listaEjer = findViewById(R.id.listaEjercicios);
        buscar = findViewById(R.id.buscadorEjercicios);

        dbh = new DBHelper(this);

        ejercicios = dbh.getAllEjercicios();
        nombres = new ArrayList<>();

        for (int i = 0; i < ejercicios.size(); i++){
            nombres.add(ejercicios.get(i).getNombre());
        }


        recargarLista(ejercicios);

        adapterAutocomplete = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, nombres);




        buscar.setThreshold(2);
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
                    recargarLista(ejercicios);
                }
                return false;
            }
        });

        buscar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opcion = String.valueOf(buscar.getText());
                ejercicios = dbh.getBusquedaEjer(opcion);
                recargarLista(ejercicios);
            }
        });




    }

    public void recargarLista(ArrayList<EjerEstir> lista){

        adapter = new AdaptadorEjerEstir(this, R.layout.fila_ejercicios_estiramientos, ejercicios);

        listaEjer.setAdapter(adapter);

    }
}