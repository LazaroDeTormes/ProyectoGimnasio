package com.example.proyectogimnasio;

import android.app.Activity;
import android.content.Context;
import android.widget.ListView;

import com.example.proyectogimnasio.adaptadores.AdaptadorEjerEstir;
import com.example.proyectogimnasio.pojos.EjerEstir;

import java.util.ArrayList;

public class Constantes {
    public static final String NOMBRE_BBDD = "gimnasio.db";
    public static final int VERSION = 1;



    public static void recargarLista(Activity contexto, AdaptadorEjerEstir adapter, ArrayList<EjerEstir> lista, ListView listaXML){

        adapter = new AdaptadorEjerEstir(contexto, R.layout.fila_ejercicios_estiramientos, lista);

        listaXML.setAdapter(adapter);

    }
}
