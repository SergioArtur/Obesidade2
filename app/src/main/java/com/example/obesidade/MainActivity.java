package com.example.obesidade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //                           Log.d("button", "Tocou em Calcular" );
                Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);

                Double altura = getAltura();
                Double peso = getPeso();

                if (altura <= 0 || peso <= 0){
                    showMessage("Insira o Peso/Altura e que sejam diferentes de Zero!");
                } else{
                    intent.putExtra("Peso", getPeso());
                    intent.putExtra("Altura", getAltura());

                    startActivity(intent);
                }


            }
        });
    }

    private Double getPeso(){

        try{
            EditText text = findViewById(R.id.editTextPeso);
            Double peso = Double.parseDouble(text.getText().toString());

            return peso;
        }catch (Exception e){
            return 0.0;
         }
    }

    private Double getAltura(){

        try{
            EditText text = findViewById(R.id.editTextAltura);
            Double altura = Double.parseDouble(text.getText().toString());

            return altura;
        }catch (Exception e){
             return 0.0;
            }

    }

    private void showMessage (String msg){

        Context context = getApplicationContext();
        String text = msg;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


}
