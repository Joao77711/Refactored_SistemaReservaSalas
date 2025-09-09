package com.example.sistema;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Sala {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Min(1)
    private int capacidade;

    public Sala() {}
    public Sala(String nome, int capacidade){ this.nome = nome; this.capacidade = capacidade; }

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public String getNome(){ return nome; }
    public void setNome(String nome){ this.nome = nome; }
    public int getCapacidade(){ return capacidade; }
    public void setCapacidade(int capacidade){ this.capacidade = capacidade; }
}
