package com.example.proyectogimnasio.adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.proyectogimnasio.R;
import com.example.proyectogimnasio.pojos.EjerEstir;

import java.util.ArrayList;

public class AdaptadorEjerRutina extends ArrayAdapter {

    private Activity contexto;
    private ArrayList<EjerEstir> ejerOestir;

    public AdaptadorEjerRutina(Activity contexto, int layout, ArrayList<EjerEstir> ejerOestir) {
        super(contexto, layout, ejerOestir);
        this.contexto = contexto;
        this.ejerOestir = ejerOestir;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View fila = convertView;

        AdaptadorEjerRutina.ViewHolder vh;

        vh = new AdaptadorEjerRutina.ViewHolder();

        if (fila == null){
            LayoutInflater inflador = contexto.getLayoutInflater();
            fila = inflador.inflate(R.layout.fila_ejercicios_rutina, null);

            vh.nombre = fila.findViewById(R.id.nombreEjerEstir);
            vh.grupo = fila.findViewById(R.id.grupoEjerEstir);
            vh.interruptor = fila.findViewById(R.id.anhadir);

            fila.setTag(vh);
        } else {
            vh = (AdaptadorEjerRutina.ViewHolder) fila.getTag();
        }

        TextView nombre = fila.findViewById(R.id.nombreEjerEstir);
        TextView grupo = fila.findViewById(R.id.grupoEjerEstir);
        Switch interruptor = fila.findViewById(R.id.anhadir);

        nombre.setText(ejerOestir.get(position).getNombre());
        grupo.setText(ejerOestir.get(position).getGrupo());



        return fila;

    }

    public class ViewHolder{
        TextView nombre, grupo;
        Switch interruptor;

    }

}
