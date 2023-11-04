package com.example.android_calculadora_temperaturas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import com.example.android_calculadora_temperaturas.models.Celsius;
import com.example.android_calculadora_temperaturas.models.Farenheit;
import com.example.android_calculadora_temperaturas.models.Kelvin;

public class Convertidor extends AppCompatActivity implements View.OnClickListener {

    RadioButton opCelsius;
    RadioButton opKelvin;
    RadioButton opFarenheit;
    Button buttonCelsius;
    Button buttonFarenheit;
    Button buttonKelvin;
    EditText editGrados;
    TextView resGrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertidor);
        opCelsius = findViewById(R.id.radioCelsius);
        opFarenheit = findViewById(R.id.radioFarenheit);
        opKelvin = findViewById(R.id.radioKelvin);
        buttonCelsius = findViewById(R.id.btnCelsius);
        buttonFarenheit = findViewById(R.id.btnFarenheit);
        buttonKelvin = findViewById(R.id.btnKelvin);
        editGrados = findViewById(R.id.txtGrados);
        resGrados = findViewById(R.id.GradosRes);

        buttonCelsius.setOnClickListener(this);
        buttonFarenheit.setOnClickListener(this);
        buttonKelvin.setOnClickListener(this);

        opCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonCelsius.setVisibility(View.GONE);
                buttonFarenheit.setVisibility(View.VISIBLE);
                buttonKelvin.setVisibility(View.VISIBLE);
            }
        });
        opKelvin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonCelsius.setVisibility(View.VISIBLE);
                buttonFarenheit.setVisibility(View.VISIBLE);
                buttonKelvin.setVisibility(View.GONE);
            }
        });
        opFarenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonCelsius.setVisibility(View.VISIBLE);
                buttonFarenheit.setVisibility(View.GONE);
                buttonKelvin.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (!TextUtils.isEmpty(editGrados.getText().toString())) {
            try {
                Double gr = Double.parseDouble(String.valueOf(editGrados.getText()));
                if (view.getId() == R.id.btnCelsius) {
                    if (opFarenheit.isChecked()) {
                        Celsius grCel = new Celsius(0.0);
                        Farenheit grFar = new Farenheit(gr);
                        grCel = grCel.parse(grFar);
                        resGrados.setText(grCel.getValor() + grCel.getUnidad());
                    } else if (opKelvin.isChecked()) {
                        Kelvin grKv = new Kelvin(gr);
                        Celsius grCel = new Celsius(0.0);
                        grCel = grCel.parse(grKv);
                        resGrados.setText(grCel.getValor() + grCel.getUnidad());
                    }
                } else if (view.getId() == R.id.btnFarenheit) {
                    if (opCelsius.isChecked()) {
                        Celsius grCel = new Celsius(gr);
                        Farenheit grFar = new Farenheit(0.0);
                        grFar = grFar.parse(grCel);
                        resGrados.setText(grFar.getValor() + grFar.getUnidad());
                    } else if (opKelvin.isChecked()) {
                        Kelvin grKv = new Kelvin(gr);
                        Farenheit grFar = new Farenheit(0.0);
                        grFar = grFar.parse(grKv);
                        resGrados.setText(grFar.getValor() + grFar.getUnidad());
                    }
                } else {
                    if (opCelsius.isChecked()) {
                        Celsius grCel = new Celsius(gr);
                        Kelvin grKv = new Kelvin(0.0);
                        grKv = grKv.parse(grCel);
                        resGrados.setText(grKv.getValor() + grKv.getUnidad());
                    } else if (opFarenheit.isChecked()) {
                        Farenheit grFar = new Farenheit(gr);
                        Kelvin grKv = new Kelvin(0.0);
                        grKv = grKv.parse(grFar);
                        resGrados.setText(grKv.getValor() + grKv.getUnidad());
                    }
                }
            } catch (Exception e) {
                resGrados.setText("Ingrese datos validos");
            }
        } else
            resGrados.setText("Ingrese datos");

    }
}