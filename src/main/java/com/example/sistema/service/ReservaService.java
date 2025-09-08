package com.example.sistema.service;

import com.example.sistema.dao.ReservaDAO;
import com.example.sistema.dao.SalaDAO;
import com.example.sistema.model.Reserva;
import com.example.sistema.model.Sala;

import java.util.List;
import java.util.Optional;

// Single Responsibility: this service handles reservation rules only.
public class ReservaService {
    private final ReservaDAO reservaDAO;
    private final SalaDAO salaDAO;

    public ReservaService(ReservaDAO reservaDAO, SalaDAO salaDAO) {
        this.reservaDAO = reservaDAO;
        this.salaDAO = salaDAO;
    }

    public Reserva criarReserva(int salaId, String responsavel, String data, String horario) {
        // business rules: sala must exist
        Optional<Sala> sala = salaDAO.buscarPorId(salaId);
        if (!sala.isPresent()) {
            throw new IllegalArgumentException("Sala nao encontrada: " + salaId);
        }
        // More rules could be added (conflict check, horario format, etc.)
        Reserva r = new Reserva(0, salaId, responsavel, data, horario);
        return reservaDAO.salvar(r);
    }

    public List<Reserva> listarReservas() {
        return reservaDAO.listarTodas();
    }

    public List<Reserva> listarReservasPorSala(int salaId) {
        return reservaDAO.listarPorSala(salaId);
    }
}
