package com.ps.comunio.comuniops;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

public class Equipo_Activity extends AppCompatActivity {
    private ListView plantilla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo_);

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
        final String[] miplantilla = {"Tono", "Victor", "Van Der Bin", "Felix", "Alvaro", "Adrian","Uafi", "Carlos", "Superman"};

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_equipo_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
