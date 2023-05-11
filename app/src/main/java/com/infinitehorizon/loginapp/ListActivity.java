package com.infinitehorizon.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = findViewById(R.id.idList);
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) getIntent().getSerializableExtra("userKey");

        UserAdapter userAdapter = new UserAdapter(this, usuarios);
        listView.setAdapter(userAdapter);
    }
}