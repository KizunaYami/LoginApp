package com.infinitehorizon.loginapp;

import java.io.Serializable;

public class Usuario implements Serializable {
    private final String user;
    private final String password;

    public Usuario(String u, String p){
        this.user = u;
        this.password = p;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
