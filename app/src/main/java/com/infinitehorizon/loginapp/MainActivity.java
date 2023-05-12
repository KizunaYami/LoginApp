package com.infinitehorizon.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public void onClickLogin(View view) {//conferindo usuario e senha
        EditText user = findViewById(R.id.userInput);
        EditText password = findViewById(R.id.passwordInput);

        String usuario = user.getText().toString();
        String senha = password.getText().toString();

        if(usuarios.size() != 0){//conferindo se o arraylist esta vazio
            for (int i = 1; i <= usuarios.size(); i++){//Percorrendo o arraylist procurando por usuario e senha validos
                if(usuario.equals(usuarios.get(i-1).getUser()) && senha.equals(usuarios.get(i-1).getPassword())){
                    //usuario e senha confere com o arraylist
                    Toast.makeText(this,"Sucesso no login",Toast.LENGTH_SHORT).show();

                    Bundle bundle = new Bundle();
                    bundle.putString("user", usuario);

                    Intent intent = new Intent(this,bemVindoActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                    user.setText("");
                    password.setText("");
                    break;
                }else if(i == usuarios.size()){
                    //nenhum usuario e senha confere com o arraylist
                    Toast.makeText(this,"Usuario ou senha invalido",Toast.LENGTH_LONG).show();
                    user.setText("");
                    password.setText("");
                }
            }
        }else{//Caso o arraylist esteja vazio
            Toast.makeText(this,"Usuario ou senha invalido",Toast.LENGTH_LONG).show();
            user.setText("");
            password.setText("");
        }
    }

    public void onClickCadastrar(View view) {//Cadastrando usuario e senha
        EditText user = findViewById(R.id.userInput);
        EditText password = findViewById(R.id.passwordInput);

        String usuario = user.getText().toString();
        String senha = password.getText().toString();

        if(usuario.equals("") || senha.equals("")){
            Toast.makeText(this, "Digite usuario e senha validos", Toast.LENGTH_LONG).show();
        }else{
            usuarios.add(new Usuario(usuario,senha));
            Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_LONG).show();
        }
        user.setText("");
        password.setText("");
    }

    public void onClickListarUsuarios(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("userKey", usuarios);

        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}