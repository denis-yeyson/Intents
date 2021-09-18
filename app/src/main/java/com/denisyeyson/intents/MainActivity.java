package com.denisyeyson.intents;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView url;
    Button send1,send2,send3;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send1 = findViewById(R.id.btnSend1);
        send2 = findViewById(R.id.btnSend2);
        send3 = findViewById(R.id.btnSend3);
        url = findViewById(R.id.txtUrl);

        send1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent_explicito = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent_explicito);
            }
        });

        send2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String dir = url.getText().toString();
                if(!dir.isEmpty()){
                    Intent intent_implicito = new Intent(Intent.ACTION_VIEW);
                    intent_implicito.setData(Uri.parse("https://"+dir));
                    startActivity(intent_implicito);
                }else{
                    Toast.makeText(getBaseContext(),"Campo vacio, ingresar una ruta valida.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        send3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent_implicito = new Intent(Intent.ACTION_CALL);
                intent_implicito.setData(Uri.parse("tel:123456789"));
                startActivity(intent_implicito);
            }
        });
    }
}