package com.infinitehorizon.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class bemVindoActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        String user = (String) getIntent().getSerializableExtra("user");

        TextView txtBemvindo = findViewById(R.id.userTextId);
        txtBemvindo.setText("Bem vindo "+user);
    }
}