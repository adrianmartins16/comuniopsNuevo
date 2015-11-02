package com.ps.comunio.comuniops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Jugador_Activity extends AppCompatActivity {

    String[] nombres = {"Tono", "Victor", "Felix", "Alvaro", "Adrian","Uafi", "Carlos", "Superman", "Mandril", "Torres"};
    int[] imagenes = {R.mipmap.jugador_nicage,R.mipmap.jugador_senor,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage};
    String[] precios = {"1234 €", "996775 €", "34235 €", "345235 €", "9083 €","4332 €", "2134 €", "4234215 €", "99999 €", "234352 €"};
    String[] posiciones = {"Portero", "Delantero", "Defensa", "Centrocampista", "Lateral derecho","Lateral izquierdo", "Defensa", "Delantero", "Portero", "Centrocampista"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugador_);

        ImageView imagen = (ImageView) findViewById(R.id.ivjugador);
        TextView nombre = (TextView) findViewById(R.id.tvnombrejugador);
        TextView precio = (TextView) findViewById(R.id.tvpreciojugador);
        TextView posicion = (TextView) findViewById(R.id.tvposicionjugador);

        int pos = getIntent().getIntExtra("jugador",0);
        imagen.setImageResource(imagenes[pos]);
        nombre.setText(nombres[pos]);
        precio.setText(precios[pos]);
        posicion.setText(posiciones[pos]);

    }
}
