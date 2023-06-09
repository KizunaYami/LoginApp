package com.infinitehorizon.loginapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<Usuario> {
    private ArrayList<Usuario> users;

    public UserAdapter(@NonNull Context context, @NonNull ArrayList<Usuario> objects) {
        super(context, 0, objects);
        this.users = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            Context ctx = getContext();
            LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.templatelist, null);
        }
        Usuario usuario = users.get(position);
        TextView txtUser = view.findViewById(R.id.idTextViewUser);
        txtUser.setText(usuario.getUser());
        return view;
    }
}
