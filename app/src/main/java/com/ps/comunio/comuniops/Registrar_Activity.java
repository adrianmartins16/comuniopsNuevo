package com.ps.comunio.comuniops;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar_Activity extends AppCompatActivity {
    EditText etUserNew;
    EditText etPassNew;
    EditText etPass2New;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_);

        Button registrar = (Button) findViewById(R.id.buttonregistarregistrar);
        etUserNew = (EditText) findViewById(R.id.editTextusername);
        etPassNew = (EditText) findViewById(R.id.editTextpass1);
        etPass2New = (EditText) findViewById(R.id.editTextpass2);

        registrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Login", "Boton Login pulsado");
                //Log.d("Login", String.valueOf(tvUser.getText()));
                String aux = String.valueOf(etPass2New.getText());
                if (String.valueOf(etPassNew.getText()).equals(aux)) {
                    Toast.makeText(Registrar_Activity.this, "Usuario Registrado!",
                            Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(Registrar_Activity.this, Login_Activity.class);
                        i.putExtra("user", etUserNew.getText().toString());
                        i.putExtra("pass", etPassNew.getText().toString());
                        startActivity(i);
                        finish();

                }else{
                    Toast.makeText(Registrar_Activity.this, "Las contraseñas no coinciden.",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
