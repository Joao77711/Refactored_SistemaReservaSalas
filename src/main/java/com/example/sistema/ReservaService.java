package com.example.sistema;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final SalaRepository salaRepository;
    private final UsuarioRepository usuarioRepository;

    public ReservaService(ReservaRepository reservaRepository, SalaRepository salaRepository, UsuarioRepository usuarioRepository){
        this.reservaRepository = reservaRepository;
        this.salaRepository = salaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Reserva criarReserva(Long salaId, Long usuarioId, LocalDate data, LocalTime inicio, LocalTime fim){
        Sala sala = salaRepository.findById(salaId).orElseThrow(() -> new IllegalArgumentException("Sala inexistente"));
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new IllegalArgumentException("Usuario inexistente"));
        if(!reservaRepository.verificarConflitos(salaId, data, inicio, fim).isEmpty()){
            throw new IllegalStateException("Conflito de horário para a sala");
        }
        Reserva r = new Reserva(sala, usuario, data, inicio, fim);
        return reservaRepository.save(r);
    }

    public List<Reserva> listar(){ return reservaRepository.findAll(); }
}
