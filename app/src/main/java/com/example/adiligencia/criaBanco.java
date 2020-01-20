package com.example.adiligencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class criaBanco extends SQLiteOpenHelper {


    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "usuario";
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";
    public static final String SENHA = "senha";
    private static final int VERSAO = 4;


    public criaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE usuario ("
                + ID + " integer primary key autoincrement,"
                + NOME + " text,"
                + EMAIL + " text,"
                + SENHA + " text"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }
}