package com.infinitehorizon.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DBUsuario dbUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbUsuario = new DBUsuario(this);
    }

    public void onClickLogin(View view) {//conferindo usuario e senha
        EditText user = findViewById(R.id.userInput);
        EditText password = findViewById(R.id.passwordInput);

        String usuario = user.getText().toString();
        String senha = password.getText().toString();

        if(dbUsuario.getList().size() != 0){//conferindo se o banco esta vazio
            for (int i = 1; i <= dbUsuario.getList().size(); i++){//Percorrendo o arraylist procurando por usuario e senha validos
                if(usuario.equals(dbUsuario.getList().get(i-1).getUser()) && senha.equals(dbUsuario.getList().get(i-1).getPassword())){
                    //usuario e senha confere com o banco
                    Toast.makeText(this,"Sucesso no login",Toast.LENGTH_SHORT).show();

                    Bundle bundle = new Bundle();
                    bundle.putString("user", usuario);

                    Intent intent = new Intent(this,bemVindoActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                    user.setText("");
                    password.setText("");
                    break;
                }else if(i == dbUsuario.getList().size()){
                    //nenhum usuario e senha confere com o banco
                    Toast.makeText(this,"Usuario ou senha invalido",Toast.LENGTH_LONG).show();
                    user.setText("");
                    password.setText("");
                }
            }
        }else{//Caso o banco esteja vazio
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
            dbUsuario.add(new Usuario(usuario,senha));
            Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_LONG).show();
        }
        user.setText("");
        password.setText("");
    }

    public void onClickListarUsuarios(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("userKey", dbUsuario.getList());

        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void onClickDeletarUsuario(View view) {
        Intent intent = new Intent(this, DeletarUsuarioActivity.class);
        startActivity(intent);
    }
}