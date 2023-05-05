package com.infinitehorizon.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<Usuario> userList = (ArrayList<Usuario>) getIntent().getSerializableExtra("key");
        ListView listView = findViewById(R.id.idList);

        Toast.makeText(this, userList.get(0).getUser(), Toast.LENGTH_SHORT).show();

        //UserAdapter adaptador = new UserAdapter(this, userList);
       // listView.setAdapter(adaptador);
    }
}