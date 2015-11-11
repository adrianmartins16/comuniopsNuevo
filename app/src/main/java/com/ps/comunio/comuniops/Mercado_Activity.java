package com.ps.comunio.comuniops;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Mercado_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //coger de la base de datos
        int i=10000000;
        TextView tvSalarioT= (TextView) findViewById(R.id.tvSalarioTotal);
        tvSalarioT.setText(Integer.toString(i));
    }

    public void confirmacionCompra(View v){
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setMessage("¿Desea comprar este jugador?");
        b.setTitle("Confirmación de compra");
        b.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Mercado_Activity.this, "Jugador comprado", Toast.LENGTH_LONG).show();
                TextView tvSalarioT= (TextView) findViewById(R.id.tvSalarioTotal);
                String auxSalario=tvSalarioT.getText().toString();
                int valorSalT=Integer.parseInt(auxSalario);
                //coger de la BD
                valorSalT=valorSalT-100000;
                tvSalarioT.setText(Integer.toString(valorSalT));
            }
        });

        b.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Mercado_Activity.this, "Operación cancelada", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog d= b.create();
        d.show();
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent i = new Intent(Mercado_Activity.this, Home_Activity.class);
            startActivity(i);
        } else if (id == R.id.nav_ligas) {
            Intent i = new Intent(Mercado_Activity.this, Liga_Activity.class);
            startActivity(i);
        } else if (id == R.id.nav_miequipo) {
            Intent i = new Intent(Mercado_Activity.this, Equipo_Activity.class);
            startActivity(i);
        } else if (id == R.id.nav_mercado) {

        } else if (id == R.id.nav_jornada) {
            Intent i = new Intent(Mercado_Activity.this, Jornadas_Activity.class);
            startActivity(i);
        } else if (id == R.id.nav_jugadores) {
            Intent i = new Intent(Mercado_Activity.this, Jugadores_Activity.class);
            startActivity(i);
        } else if (id == R.id.nav_cerrarsesion) {
            Intent i = new Intent(Mercado_Activity.this, Login_Activity.class);
            i.putExtra("user", "");
            startActivity(i);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}



