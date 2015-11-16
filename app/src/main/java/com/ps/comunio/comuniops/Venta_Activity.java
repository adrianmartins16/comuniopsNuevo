package com.ps.comunio.comuniops;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Venta_Activity extends AppCompatActivity {

    String[] nombres = {"Chuck Norris", "Bruce Banner", "Babab George", "Neymar","Marco Lolo","Benzema","Igor Casitas","Oliver Atom","Harry Rotter","Neil","Nicolas Rage"};
    int[] imagenes = {R.mipmap.jugador_norris,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_random1,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage,R.mipmap.jugador_nicage};
    String[] precios = {"44456","33212","564543","3453211","111201","1234544","99999999","145624","54465","100000","234534"};
    String[] posiciones = {"Todo","Centrocampista","Defensa","Delantero","Lateral izquierdo","Delantero","Portero","Lateral derecho","Defensa","Delantero","Portero"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta_);

        ImageView imagen = (ImageView) findViewById(R.id.ivventa);
        TextView nombre = (TextView) findViewById(R.id.tvnombrejugadorventa);
        TextView precio = (TextView) findViewById(R.id.tvpreciojugadorventa);
        TextView posicion = (TextView) findViewById(R.id.tvposicionjugadorventa);

        int pos = getIntent().getIntExtra("jugador",0);
        imagen.setImageResource(imagenes[pos]);
        nombre.setText(nombres[pos]);
        precio.setText(precios[pos]);
        posicion.setText(posiciones[pos]);

    }

    public void confirmacionCompra(View v){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setMessage("¿Desea comprar este jugador?");
        b.setTitle("Confirmación de compra");
        b.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TextView tvSalarioT = (TextView) findViewById(R.id.tvfondos);
                TextView tvPrecio = (TextView) findViewById(R.id.tvpreciojugadorventa);
                String auxSalario = tvSalarioT.getText().toString();
                String coste = tvPrecio.getText().toString();
                int valorSalT = Integer.parseInt(auxSalario);
                int precio = Integer.parseInt(coste);

                if (valorSalT < precio) {
                    Toast.makeText(Venta_Activity.this, "No tienes suficientes fondos", Toast.LENGTH_LONG).show();
                } else {
                    valorSalT = valorSalT - precio;
                    tvSalarioT.setText(Integer.toString(valorSalT));
                    Toast.makeText(Venta_Activity.this, "Jugador comprado", Toast.LENGTH_LONG).show();
                }

            }
        });

        b.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Venta_Activity.this, "Operación cancelada", Toast.LENGTH_LONG).show();

            }
        });
        AlertDialog d = b.create();
        d.show();
    }

}
