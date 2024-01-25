package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText editTextGasolina;
    private EditText editTextEtanol;
    private ImageView imageViewResultado;
    private Button buttonComparar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);
        imageViewResultado = findViewById(R.id.imageViewResultado);
        buttonComparar = findViewById(R.id.buttonComparar);

        buttonComparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comparadorDeValores();
            }
        });
    }

    private void comparadorDeValores() {
        try {
            double valorGasolina = Double.parseDouble(editGasolina.getText().toString());
            double valorEtanol = Double.parseDouble(editEtanol.getText().toString());

            double setentaPorcentoGasolina = 0.7 * valorGasolina;

            if (valorEtanol < setentaPorcentoGasolina) {
                imageViewResultado.setImageResource(R.drawable.ic_etanol);
            }else if(valorEtanol > setentaPorcentoGasolina){
                imageViewResultado.setImageResource(R.drawable.ic_gasolina);
            }else {
                imageViewResultado.setImageResource(R.drawable.ic_igual);
            }

            imageViewResultado.setVisibility(View.VISIBLE);
        }catch (NumberFormatException e) {
            imageViewResultado.setVisibility(View.INVISIBLE);
        }
    }
}
