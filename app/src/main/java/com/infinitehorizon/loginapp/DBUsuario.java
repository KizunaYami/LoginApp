package com.infinitehorizon.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBUsuario extends SQLiteOpenHelper {
    private static final String DATA_BASE = "usuarios";
    private static final int VERSION = 1;

    public DBUsuario(@Nullable Context context) {
        super(context, DATA_BASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE usuarios(\n" +
                "        id INTEGER PRIMARY KEY,\n" +
                "        user text not null,\n" +
                "        password int not null\n" +
                "    )";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void add(Usuario usuario){
        ContentValues contentValues = new ContentValues();
        contentValues.put("user", usuario.getUser());
        contentValues.put("password", usuario.getPassword());
        getWritableDatabase().insert("usuarios",null,contentValues);
    }

    public ArrayList<Usuario> getList(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from usuarios",null);
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            Usuario usuario = new Usuario(cursor.getString(1), cursor.getString(2));
            usuarios.add(usuario);
            cursor.moveToNext();
        }
        cursor.close();
        return usuarios;
    }
}