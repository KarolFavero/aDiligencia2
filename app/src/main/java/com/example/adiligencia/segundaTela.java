package com.example.adiligencia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class segundaTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);
    }

    public void entrar(View view){
        Intent intent = new Intent(this, terceiraTela. class);
        startActivity(intent);
    }

    public void cadastrar(View view) {
        Intent intent = new Intent(this, telaCadastro.class);
        startActivity(intent);
    }

}
