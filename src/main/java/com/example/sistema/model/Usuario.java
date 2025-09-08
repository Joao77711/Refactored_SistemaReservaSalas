package com.example.sistema.model;

public class Usuario {
    private int id;
    private String login;
    private String senha;
    private String tipo; // ex: admin, operador, usuario

    public Usuario(int id, String login, String senha, String tipo) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }

    public int getId() { return id; }
    public String getLogin() { return login; }
    public String getSenha() { return senha; }
    public String getTipo() { return tipo; }

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", login='" + login + "', tipo='" + tipo + "'}";
    }
}
