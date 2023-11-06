package com.example.android_calculadora_temperaturas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Cargando;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cargando=findViewById(R.id.txtCargando);

        new CountDownTimer(5000,1000)
        {
            @Override
            public void onTick(long l)
            {
                Cargando.setText("Iniciando en: "+l/1000+"");
            }
            @Override
            public void onFinish()
            {
                Intent i=new Intent(MainActivity.this,Convertidor.class);
                startActivity(i);
            }
        }.start();
    }
}