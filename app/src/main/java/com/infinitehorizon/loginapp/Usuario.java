package com.infinitehorizon.loginapp;

public class Usuario {
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
