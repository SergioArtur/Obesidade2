package com.example.obesidade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView textView;
    private TextView textViewMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        textView = findViewById(R.id.textViewResultado);
        textViewMensagem = findViewById(R.id.textViewMensagem);

        Double imc = calculaImc();
        String sIMC = getStringIMC(imc);

        if (imc >= 30){
            getWindow().getDecorView().setBackgroundColor(Color.RED);
        } else{
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        }

        textView.setText(sIMC);
        textViewMensagem.setText(avaliaIMC(imc));

        /*Log.d("teste", altura.toString());
        Log.d("teste", peso.toString());
        Log.d("teste", imc.toString());*/

    }

    private Double calculaImc() {
        Intent intent = getIntent();
        Double altura = intent.getExtras().getDouble("Altura");
        Double peso = intent.getExtras().getDouble("Peso");

        Double imc = peso / (altura * altura);

        return imc;
    }

    private String getStringIMC(Double imc) {

        String sIMC = imc.toString();

        int i = sIMC.indexOf('.');
        sIMC = sIMC.substring(0,i+2);

        return sIMC;
    }

    private String avaliaIMC(Double imc){

        String resultado = "";

        if (imc < 18.5)
        {
            resultado = "Abaixo do Peso";
        }
        else if (imc > 18.5 && imc < 24.9)
        {
            resultado = "Você está dentro do Peso";
        }
        else if (imc > 25 && imc < 29.9)
        {
            resultado = "Sobrepeso";
        }
        else if (imc > 30 && imc < 34.9)
        {
            resultado = "Obesidade Grau 1";
        }
        else if (imc > 35 && imc < 39.9)
        {
            resultado = "Obesidade Grau 2";
        }
        else
        {
            resultado = "Obesidade Grau 3";
        }

        return resultado;
    }
}
