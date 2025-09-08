package com.example.sistema.dao;

import com.example.sistema.model.Reserva;
import java.util.List;
import java.util.Optional;

public interface ReservaDAO {
    Reserva salvar(Reserva r);
    Optional<Reserva> buscarPorId(int id);
    List<Reserva> listarTodas();
    List<Reserva> listarPorSala(int salaId);
    boolean remover(int id);
}
