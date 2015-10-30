package com.ps.comunio.comuniops;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {
    String username = "admin";
    String password = "1234";
    Button btLogin;
    EditText etUser;
    EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser = (EditText) findViewById(R.id.editTextUserLogin);
        etPass = (EditText) findViewById(R.id.editTextPassLogin);
        btLogin = (Button) findViewById(R.id.buttonLoginLogin);
        btLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Login", "Boton Login pulsado");
                //Log.d("Login", String.valueOf(tvUser.getText()));
                if (String.valueOf(etUser.getText()).equals(username)) {
                    Log.d("Login", "Usuario Valido");
                    if (String.valueOf(etPass.getText()).equals(password)) {
                        Log.d("Login", "Pass Valido");
                        Intent i = new Intent(Login_Activity.this, Home_Activity.class);
                        i.putExtra("user", etUser.getText() + "");

                        startActivity(i);
                    }else{
                        Toast.makeText(Login_Activity.this, "Usuario o Contraseña erróneos.",
                                Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(Login_Activity.this, "Usuario o Contraseña erróneos.",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
    //Boton Login


}
