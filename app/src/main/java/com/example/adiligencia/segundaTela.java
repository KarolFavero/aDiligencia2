package com.example.adiligencia;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class segundaTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);
    }

    public void cadastrar(View view) {
        Intent intent = new Intent(this, telaCadastro.class);
        startActivity(intent);
    }


    public void login(View view) {
        EditText email = findViewById(R.id.email1);
        EditText senha = findViewById(R.id.senha1);
        String strEmail = email.getText().toString();
        String strsenha = senha.getText().toString();
        boolean erro = false;

        if (strEmail.length() > 0 && strsenha.length() > 0) {
            bancoController crud = new bancoController(getBaseContext());
            Cursor cursor = crud.fazerLogin(strEmail, strsenha);
            if (cursor == null || cursor.getCount() == 0) {
                erro = true;
            } else {
                String resEmail = cursor.getString(cursor.getColumnIndex("email"));
                String resSenha = cursor.getString(cursor.getColumnIndex("senha"));

                if (strEmail.equals(resEmail) && strsenha.equals(resSenha)) {
                    Toast.makeText(getApplicationContext(), "Seja bem-vindo.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, terceiraTela.class);
                    startActivity(intent);
                } else {
                    erro = true;
                }
            }
        } else {
            erro = true;
        }

        if (erro) {
            Toast.makeText(getApplicationContext(), "Credenciais incorretas.", Toast.LENGTH_LONG).show();
        }
    }
}