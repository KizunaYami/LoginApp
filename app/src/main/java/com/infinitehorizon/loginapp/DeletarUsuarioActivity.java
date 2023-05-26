package com.infinitehorizon.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeletarUsuarioActivity extends AppCompatActivity {
    DBUsuario dbUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar_usuario);

        dbUsuario = new DBUsuario(this);
    }

    public void onClickDeletar(View view) {
        EditText editText = findViewById(R.id.idEditTextUsuario);
        if (editText.getText().toString().equals("")) {
            Toast.makeText(this, "por favor digite um usuario", Toast.LENGTH_LONG).show();
            return;
        }
        dbUsuario.remove(editText.getText().toString());
        Toast.makeText(this, "Usuario deletado com sucesso", Toast.LENGTH_SHORT).show();
        editText.setText("");
    }
}