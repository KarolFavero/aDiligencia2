package com.example.adiligencia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class WebService1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service1);

        final EditText etCep = findViewById(R.id.cep);

        Button botao = findViewById(R.id.buscarCep);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etCep.getText().toString().length() > 0 && etCep.getText().toString().equals("") && etCep.getText().toString().length() == 8) {

                }
            }
        });
    }
}
