package com.example.obesidade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
                startActivity(intent);

                intent.putExtra("Altura", 1.65);
                intent.putExtra("Peso", 86.2);
                startActivity(intent);
            }
        });
    }
}