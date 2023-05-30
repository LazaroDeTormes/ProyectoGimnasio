package com.example.proyectogimnasio.pantallas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectogimnasio.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView imgTitulo;
    private SharedPreferences sp;
    private TextView saludo;
    private Notification.Builder builder;
    private LinearLayout pantallaPrincipal, pantBot;
    private Button btnRH, btnEj, btnEs, btnCR, btnRu;
    private AlertDialog.Builder ventana;
    private EditText nombre;
    private int color;
    private static final int RESPUESTA = 1;
    private static final int NOTIF_ALERTA_ID = 2;
    private static final int RESPUESTA_COLOR = 3;
    private static final String CHANNEL_ID = "4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = PreferenceManager.getDefaultSharedPreferences(this);
        imgTitulo = findViewById(R.id.imgTitulo);
        pantallaPrincipal = findViewById(R.id.pantallaTitulo);
        pantBot = findViewById(R.id.pantallaBotones);
        btnCR = findViewById(R.id.crearRutinaBtn);
        btnEj = findViewById(R.id.ejerciciosBtn);
        btnEs = findViewById(R.id.estiramientosBtn);
        btnRH = findViewById(R.id.rutinaHoyBtn);
        btnRu = findViewById(R.id.rutinasBtn);
        saludo = findViewById(R.id.saludo);
        color = getResources().getColor(R.color.color1);





        builder = new Notification.Builder(this);
        builder.setSmallIcon(R.drawable.icono);
        builder.setTicker(getString(R.string.notificacion));
        builder.setContentTitle(getString(R.string.notificacion));
        Bitmap largeIcon= BitmapFactory.decodeResource(getResources(),R.drawable.icono);
        builder.setLargeIcon(largeIcon);

        Intent i = new Intent(this, RutinaHoy.class);
        PendingIntent pi;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            pi = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_IMMUTABLE);

        }else {
            pi = PendingIntent.getActivity(this, 0, i, 0);
        }
        builder.setContentIntent(pi);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notificaciones básicas";
            String description = "Canal para notificaciones sencillas";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new
                    NotificationChannel(CHANNEL_ID, name, importance);
            if  (channel==null){
                channel.enableVibration(false);
            }
            channel.setDescription(description);

            NotificationManager nm = (NotificationManager)
                    getSystemService(Context.NOTIFICATION_SERVICE);
            nm.createNotificationChannel(channel);

        }

        NotificationManager nm = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notificacion=builder.build();
        nm.notify(NOTIF_ALERTA_ID, notificacion);








        imgTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantallaPrincipal.setVisibility(View.GONE);
                pantBot.setVisibility(View.VISIBLE);
            }
        });

        registerForContextMenu(saludo);



        btnRu.setOnClickListener(this);
        btnEj.setOnClickListener(this);
        btnEs.setOnClickListener(this);
        btnCR.setOnClickListener(this);
        btnRH.setOnClickListener(this);

        cargar();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflador = getMenuInflater();
        inflador.inflate(R.menu.menupreferences, menu);


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {


        switch(item.getItemId()){
            case R.id.texto:
                ventana = new AlertDialog.Builder(this);
                LayoutInflater inflador = this.getLayoutInflater();
                View view = inflador.inflate(R.layout.laydialogo, null);
                ventana.setTitle(getString(R.string.modif_saludo))
                        .setNegativeButton(getString(R.string.atras), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                saludo.setText(nombre.getText().toString());
                                SharedPreferences.Editor editor = sp.edit();
                                editor.putString("saludo", saludo.getText().toString());
                                editor.apply();
                            }
                        })
                        .setView(view)
                        .show();
                nombre = view.findViewById(R.id.etnom);
                break;
            case R.id.botones:
                Intent i = new Intent(this, Colores.class);
                startActivityForResult(i, RESPUESTA_COLOR);
                break;

        }

        return true;
    }

    public void cargar(){

        saludo.setText(sp.getString("saludo", getString(R.string.frase_inicial)));

        int nuevocolor = sp.getInt("colornuevo", color);





    }



    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.rutinaHoyBtn:
                i = new Intent(this, RutinaHoy.class);
                startActivity(i);
                break;
            case R.id.ejerciciosBtn:
                i = new Intent(this, Ejercicios.class);
                startActivity(i);
                break;
            case R.id.estiramientosBtn:
                i = new Intent(this, Estiramientos.class);
                startActivity(i);
                break;
            case R.id.crearRutinaBtn:
                i = new Intent(this, CreaRutina.class);
                startActivityForResult(i, RESPUESTA);
                break;
            case R.id.rutinasBtn:
                i = new Intent(this, MisRutinas.class);
                startActivity(i);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESPUESTA) {
            if(resultCode == Activity.RESULT_OK){
                Toast.makeText(this, data.getStringExtra("resultado"), Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == RESPUESTA_COLOR){
            if (resultCode == Activity.RESULT_OK){
                Intent i = getIntent();
                color = i.getIntExtra("nuevocolor", getResources().getColor(R.color.color1));
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("colornuevo", color);

            }
        }
    }
}