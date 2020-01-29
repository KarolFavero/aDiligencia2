package com.example.adiligencia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutionException;

public class WebService1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service1);

        final EditText etCep = findViewById(R.id.cep);
        final TextView tvResposta = findViewById(R.id.resposta);

        Button buscarCep = findViewById(R.id.buscarCep);

        buscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    CEP retorno = new HTTPService(etCep.getText().toString()).execute().get();
                    tvResposta.setText(retorno.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();

                }
            }
        });
    }
}
