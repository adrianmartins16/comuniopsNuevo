package com.ps.comunio.comuniops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Jugador_Activity extends AppCompatActivity {

    String[] nombres = {"Tono", "Victor", "Van Der Bin", "Felix", "Alvaro", "Adrian","Uafi", "Carlos", "Suparman", "Manril", "Torres","Walter White","Donald McDonnal","Chuck Norris","Bruce Banner","Babilonia","Neymar","Marco Lolo","Benzema","Igor Casitas","Oliver Atom","Harry Rotter","Neil","Nicolas Rage"};
    int[] imagenes = {R.mipmap.jugador_tono,R.mipmap.jugador_senor,R.mipmap.jugador_random2,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_walter,R.mipmap.jugador_nicage,R.mipmap.jugador_norris,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_random1,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage};
    String[] precios = {"1234", "996775", "49012","34235", "345235", "9083","4332", "2134", "4234215", "99999", "234352","45456","5612312","5645361","44456","33212","564543","3453211","01","1234","99999999","124","54465","100000","234534"};
    String[] posiciones = {"Portero", "Delantero", "Defensa", "Delantero", "Centrocampista", "Centrocampista","Centrocampista", "Defensa", "Delantero", "Portero", "Centrocampista","Portero","Defensa","Todo","Centrocampista","Defensa","Delantero","Lateral izquierdo","Delantero","Portero","Lateral derecho","Defensa","Delantero","Portero"};

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
