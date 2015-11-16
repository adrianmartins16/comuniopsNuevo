package com.ps.comunio.comuniops;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Login_Activity extends AppCompatActivity {

    Usuarios_DB admin = new Usuarios_DB("admin","1234");
    Button btLogin;
    Button btRegistro;
    EditText etUser;
    EditText etPass;
    ArrayList<Usuarios_DB> listaUsuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        listaUsuarios.add(admin);
        if((getIntent().getStringExtra("user")!=null)&&(getIntent().getStringExtra("pass")!=null)){
            String username = getIntent().getStringExtra("user");
            String password = getIntent().getStringExtra("pass");
            Usuarios_DB nuevo = new Usuarios_DB(username,password);
            listaUsuarios.add(nuevo);
        }


        etUser = (EditText) findViewById(R.id.editTextUserLogin);
        etPass = (EditText) findViewById(R.id.editTextPassLogin);
        btLogin = (Button) findViewById(R.id.buttonLoginLogin);

        btLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Login", "Boton Login pulsado");
                //Log.d("Login", String.valueOf(tvUser.getText()));
                String sacarUsername = etUser.getText().toString();
                String sacarPassword = etPass.getText().toString();
                Usuarios_DB comprobador = new Usuarios_DB(sacarUsername,sacarPassword);

                if (tieneUsuario(comprobador)) {
                    Log.d("Login", "Usuario Valido");
                    Log.d("Login", "Pass Valido");
                    Intent i = new Intent(Login_Activity.this, Home_Activity.class);
                    i.putExtra("user", etUser.getText() + "");

                    startActivity(i);
                    finish();

                }else{
                    Toast.makeText(Login_Activity.this, "Usuario o Contraseña erróneos.",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });
        btRegistro = (Button) findViewById(R.id.buttonRegistrarLogin);
        btRegistro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                    Intent i = new Intent(Login_Activity.this, Registrar_Activity.class);
                    startActivity(i);


            }
        });


    }

    public Boolean tieneUsuario(Usuarios_DB userPasado){
        for (Usuarios_DB i:listaUsuarios) {
            if ((i.getUsername().equals(userPasado.getUsername()))&&(i.getPass().equals(userPasado.getPass()))){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
    //Boton Login


}
