package com.denisyeyson.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView nombre,apellidos,email;
    Button atras,enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nombre = findViewById(R.id.txtNombres);
        apellidos = findViewById(R.id.txtApellidos);
        email = findViewById(R.id.txtEmail);
        atras = findViewById(R.id.btnAtras);
        enviar = findViewById(R.id.btnEnviar);

        enviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String nomb = nombre.getText().toString();
                String apel = apellidos.getText().toString();
                String correo = email.getText().toString();

                Intent intent_explicito = new Intent(SecondActivity.this, TercerActivity.class);
                intent_explicito.putExtra("NOMBRES",nomb);
                intent_explicito.putExtra("APELLIDOS",apel);
                intent_explicito.putExtra("EMAIL",correo);
                startActivity(intent_explicito);
            }
        });

        atras.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}