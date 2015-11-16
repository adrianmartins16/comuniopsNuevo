package com.ps.comunio.comuniops;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Mercado_Activity extends AppCompatActivity {
    private ListView ventas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercado);

        final String[] jugadores = {"Chuck Norris", "Bruce Banner", "Babab George", "Neymar","Marco Lolo","Benzema","Igor Casitas","Oliver Atom","Harry Rotter","Neil","Nicolas Rage"};

        ventas = (ListView) findViewById(R.id.listViewMercado);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, jugadores);

    ventas.setAdapter(adaptador);
    ventas.setOnItemClickListener(new AdapterView.OnItemClickListener()

    {

        @Override
        public void onItemClick (AdapterView < ? > arg0, View arg1,int position, long id){

        Toast.makeText(getApplicationContext(), "Cargando: " + jugadores[position], Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Mercado_Activity.this, Venta_Activity.class);
                i.putExtra("jugador", position);
                startActivity(i);
            }

        });
    }

}



