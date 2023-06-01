package com.example.proyectogimnasio.pantallas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.proyectogimnasio.R;
import com.example.proyectogimnasio.db.DBHelper;

public class MisRutinas extends AppCompatActivity  implements View.OnClickListener{

    private Button lun, mar, mie, jue, vie, sab, dom;
    private String nombre;
    private DBHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_rutinas);

        dbh = new DBHelper(this);

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


        registerForContextMenu(lun);
        registerForContextMenu(mar);
        registerForContextMenu(mie);
        registerForContextMenu(jue);
        registerForContextMenu(vie);
        registerForContextMenu(sab);
        registerForContextMenu(dom);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflador = getMenuInflater();
        inflador.inflate(R.menu.borrarmenu, menu);

        switch (v.getId()){
            case R.id.rutinaLunes:
                nombre=lun.getText().toString();
                break;
            case R.id.rutinaMartes:
                nombre=lun.getText().toString();
                break;
            case R.id.rutinaMiercoles:
                nombre=lun.getText().toString();
                break;
            case R.id.rutinaJueves:
                nombre=lun.getText().toString();
                break;
            case R.id.rutinaViernes:
                nombre=lun.getText().toString();
                break;
            case R.id.rutinaSabado:
                nombre=lun.getText().toString();
                break;
            case R.id.rutinaDomingo:
                nombre=lun.getText().toString();
                break;

        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()){
            case R.id.borradomenu:
                dbh.borrarRutina(nombre);
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        Bundle b;

        switch (v.getId()){
            case R.id.rutinaLunes:
                i = new Intent(this, PrevRutina.class);
                b = new Bundle();
                b.putString("dia", lun.getText().toString());
                System.out.println(lun.getText().toString());
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.rutinaMartes:
                i = new Intent(this, PrevRutina.class);
                b = new Bundle();
                b.putString("dia", mar.getText().toString());
                System.out.println(mar.getText().toString());
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.rutinaMiercoles:
                i = new Intent(this, PrevRutina.class);
                b = new Bundle();
                b.putString("dia", mie.getText().toString());
                System.out.println(mie.getText().toString());
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.rutinaJueves:
                i = new Intent(this, PrevRutina.class);
                b = new Bundle();
                b.putString("dia", jue.getText().toString());
                System.out.println(jue.getText().toString());
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.rutinaViernes:
                i = new Intent(this, PrevRutina.class);
                b = new Bundle();
                b.putString("dia", vie.getText().toString());
                System.out.println(vie.getText().toString());
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.rutinaSabado:
                i = new Intent(this, PrevRutina.class);
                b = new Bundle();
                b.putString("dia", sab.getText().toString());
                System.out.println(sab.getText().toString());
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.rutinaDomingo:
                i = new Intent(this, PrevRutina.class);
                b = new Bundle();
                b.putString("dia", dom.getText().toString());
                System.out.println(dom.getText().toString());
                i.putExtras(b);
                startActivity(i);
                break;




        }
    }


}