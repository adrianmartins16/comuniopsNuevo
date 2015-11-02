package com.ps.comunio.comuniops;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Jugadores_Activity extends AppCompatActivity {
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugadores_);

        final String[] jugadores = {"Tono", "Victor", "Felix", "Alvaro", "Adrian","Uafi", "Carlos", "Superman", "Mandril", "Torres"};

        list = (ListView)findViewById(R.id.lvjugadores);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, jugadores);

        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {

                Toast.makeText(getApplicationContext(), "Cargando: " + jugadores[position], Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Jugadores_Activity.this, Jugador_Activity.class);
                i.putExtra("jugador", position);
                startActivity(i);
            }

        });
    }
}
