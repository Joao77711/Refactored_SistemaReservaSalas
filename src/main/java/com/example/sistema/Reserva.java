package com.example.sistema;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Reserva {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Sala sala;

    @ManyToOne(optional = false)
    private Usuario usuario;

    @NotNull
    private LocalDate data;

    @NotNull
    private LocalTime horaInicio;

    @NotNull
    private LocalTime horaFim;

    public Reserva(){}

    public Reserva(Sala sala, Usuario usuario, LocalDate data, LocalTime horaInicio, LocalTime horaFim){
        this.sala=sala; this.usuario=usuario; this.data=data; this.horaInicio=horaInicio; this.horaFim=horaFim;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Sala getSala(){return sala;}
    public void setSala(Sala sala){this.sala=sala;}
    public Usuario getUsuario(){return usuario;}
    public void setUsuario(Usuario usuario){this.usuario=usuario;}
    public LocalDate getData(){return data;}
    public void setData(LocalDate data){this.data=data;}
    public LocalTime getHoraInicio(){return horaInicio;}
    public void setHoraInicio(LocalTime horaInicio){this.horaInicio=horaInicio;}
    public LocalTime getHoraFim(){return horaFim;}
    public void setHoraFim(LocalTime horaFim){this.horaFim=horaFim;}
}
