package com.example.adiligencia;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class telaCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        Button botao = findViewById(R.id.botaoCadastrar);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bancoController crud = new bancoController(getBaseContext());
                EditText nome = findViewById(R.id.nome);
                EditText email = findViewById(R.id.email);
                EditText senha = findViewById(R.id.senha);
                EditText repitaSenha = findViewById(R.id.repitaSenha);

                String nomeString = nome.getText().toString();
                String emailString = email.getText().toString();
                String senhaString = senha.getText().toString();
                String repitaSenhaString = repitaSenha.getText().toString();

                if (nomeString.isEmpty() || emailString.isEmpty() || senhaString.isEmpty() || repitaSenhaString.isEmpty()) {
                    String resultado = crud.insereDado(nomeString, emailString, senhaString);

                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                } else {
                    if (senhaString.equals(repitaSenhaString)) {
                        String resultado = crud.insereDado(nomeString, emailString, senhaString);
                        Toast toast = Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 50);
                        toast.show();
                    } else {
                        String resultado = "As senhas não conferem";
                        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                    }


                }
            }
        });
    }

}