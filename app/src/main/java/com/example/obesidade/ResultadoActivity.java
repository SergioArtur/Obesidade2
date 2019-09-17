package com.example.obesidade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        textView = findViewById(R.id.textViewResultado);

        Intent intent = getIntent();
        Double altura = intent.getExtras().getDouble("Altura");
        Double peso = intent.getExtras().getDouble("Peso");

        Double imc = peso / (altura * altura);
        textView.setText(imc.toString());

        Log.d("teste", altura.toString());
        Log.d("teste", peso.toString());
        Log.d("teste", imc.toString());

    }
}
