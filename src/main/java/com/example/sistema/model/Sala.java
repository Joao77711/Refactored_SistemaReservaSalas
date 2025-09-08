package com.example.sistema.model;
public class Sala {
    private int id;
    private String nome;
    private int capacidade;
    public Sala(int id, String nome, int capacidade) { this.id=id; this.nome=nome; this.capacidade=capacidade; }
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public String getNome(){return nome;} public void setNome(String n){this.nome=n;}
    public int getCapacidade(){return capacidade;} public void setCapacidade(int c){this.capacidade=c;}
}
