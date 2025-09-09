package com.example.sistema;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String login;

    @NotBlank
    private String senha;

    public Usuario(){}
    public Usuario(String nome, String login, String senha){
        this.nome=nome; this.login=login; this.senha=senha;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome=nome;}
    public String getLogin(){return login;}
    public void setLogin(String login){this.login=login;}
    public String getSenha(){return senha;}
    public void setSenha(String senha){this.senha=senha;}
}
