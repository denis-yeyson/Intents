package com.denisyeyson.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TercerActivity extends AppCompatActivity {

    TextView campo1,campo2,campo3;
    Button atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);

        campo1 = findViewById(R.id.lblNombre);
        campo2 = findViewById(R.id.lblApellido);
        campo3 = findViewById(R.id.lblEmail);
        atras = findViewById(R.id.btnAtrasTercer);

        Bundle receptor = recibirDatos();
        String nombre = receptor.getString("NOMBRES");
        String apellido = receptor.getString("APELLIDOS");
        String email = receptor.getString("EMAIL");

        campo1.setText("Nombre: "+nombre);
        campo2.setText("Nombre: "+apellido);
        campo3.setText("Nombre: "+email);

        atras.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private Bundle recibirDatos() {
        return getIntent().getExtras();
    }
}