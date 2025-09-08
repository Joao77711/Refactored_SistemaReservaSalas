package com.example.sistema.model;

public class Reserva {
    private int id;
    private int salaId;
    private String responsavel;
    private String data; // ISO yyyy-MM-dd
    private String horario; // HH:mm-HH:mm

    public Reserva(int id, int salaId, String responsavel, String data, String horario) {
        this.id = id;
        this.salaId = salaId;
        this.responsavel = responsavel;
        this.data = data;
        this.horario = horario;
    }

    public int getId() { return id; }
    public int getSalaId() { return salaId; }
    public String getResponsavel() { return responsavel; }
    public String getData() { return data; }
    public String getHorario() { return horario; }

    @Override
    public String toString() {
        return "Reserva{id=" + id + ", salaId=" + salaId + ", responsavel='" + responsavel + "', data='" + data + "', horario='" + horario + "'}";
    }
}
