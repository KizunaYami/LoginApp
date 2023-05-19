package com.infinitehorizon.loginapp;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String user;
    private String password;

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
