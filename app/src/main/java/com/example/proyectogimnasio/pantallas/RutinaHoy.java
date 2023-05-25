package com.example.proyectogimnasio.pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.proyectogimnasio.R;
import com.example.proyectogimnasio.adaptadores.AdaptadorEjerEstir;
import com.example.proyectogimnasio.adaptadores.AdaptadorEjerRutina;
import com.example.proyectogimnasio.db.DBHelper;
import com.example.proyectogimnasio.pojos.EjerEstir;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RutinaHoy extends AppCompatActivity {

    private ListView listaRutinaHoy;
    private ArrayList<EjerEstir> ejerciciosHoy;
    private DBHelper dbh;
    private AdaptadorEjerEstir adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutina_hoy);

        listaRutinaHoy = findViewById(R.id.listaRutinaHoy);

        dbh = new DBHelper(this);


        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);

        switch (dayOfTheWeek){
            case "Monday":
            case "Luns":
                dayOfTheWeek= "lunes";
                break;
            case "Tuesday":
            case "Martes":
                dayOfTheWeek= "martes";
                break;
            case "Wednesday":
            case "Mércores":
                dayOfTheWeek= "miércoles";
                break;
            case "Thursday":
            case "Xoves":
                dayOfTheWeek= "jueves";
                break;
            case "Friday":
            case "Venres":
                dayOfTheWeek= "viernes";
                break;
            case "Saturday":
            case "Sábado":
                dayOfTheWeek= "sábado";
                break;
            case "Sunday":
            case "Domingo":
                dayOfTheWeek= "domingo";
                break;

        }
        System.out.println(dayOfTheWeek);

        ejerciciosHoy = dbh.getRutinaPorDia(dayOfTheWeek.toLowerCase(Locale.ROOT));

        adapter = new AdaptadorEjerEstir(this, R.layout.fila_ejercicios_estiramientos, ejerciciosHoy);

        listaRutinaHoy.setAdapter(adapter);

    }
}