package com.ps.comunio.comuniops;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class Equipo_Activity extends AppCompatActivity {
    private ListView plantilla;
    int cont = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo_);


        ImageView i1 = (ImageView) findViewById(R.id.ivAlineacion);
        i1.setImageResource(R.mipmap.alineacion1);

        //Pestañas de equipo
        Resources res1 = getResources();
        TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();
        TabHost.TabSpec spec = tabs.newTabSpec("Pestaña 1");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Plantilla");
        tabs.addTab(spec);

        tabs.setup();
        TabHost.TabSpec spec1 = tabs.newTabSpec("Pestaña 2");
        spec1.setContent(R.id.tab4);
        spec1.setIndicator("Alineación");
        tabs.addTab(spec1);

        //Plantilla
        final String[] miplantilla = {"Tono", "Victor", "Van Der Bin", "Felix", "Alvaro", "Adrian","Uafi", "Carlos", "Suparman", "Manril", "Torres", "Walter White", "Donald McDonnal"};

        plantilla = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, miplantilla);

        plantilla.setAdapter(adaptador);
        plantilla.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {

                Toast.makeText(getApplicationContext(), "Cargando: " + miplantilla[position], Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Equipo_Activity.this, Jugador_Activity.class);
                i.putExtra("jugador", position);
                startActivity(i);
            }

        });

    }

    //Cambio de alineación
    public void confirmacionCambio(View v) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Cambio de alineación");
        b.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(cont == 1) {
                    ImageView imagen = (ImageView) findViewById(R.id.ivAlineacion);
                    imagen.setImageResource(R.mipmap.alineacion2);
                    cont = 2;
                    Toast.makeText(Equipo_Activity.this, "Alineación 3-4-3", Toast.LENGTH_LONG).show();
                }
                else{
                    ImageView imagen1 = (ImageView) findViewById(R.id.ivAlineacion);
                    imagen1.setImageResource(R.mipmap.alineacion1);
                    cont = 1;
                    Toast.makeText(Equipo_Activity.this, "Alineación 1-5-4", Toast.LENGTH_LONG).show();
                }
            }
        });
        b.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Equipo_Activity.this, "Operación cancelada", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog d = b.create();
        d.show();
    }
}
