package com.example.sistema;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ReservaServiceTest {

    @Autowired private ReservaService service;
    @Autowired private SalaRepository salaRepo;
    @Autowired private UsuarioRepository usuarioRepo;

    @Test
    void naoPermiteConflito(){
        Sala s = salaRepo.save(new Sala("Sala A", 10));
        Usuario u = usuarioRepo.save(new Usuario("Joao", "joao", "123"));
        service.criarReserva(s.getId(), u.getId(), LocalDate.now(), LocalTime.of(9,0), LocalTime.of(10,0));
        assertThrows(IllegalStateException.class, () ->
            service.criarReserva(s.getId(), u.getId(), LocalDate.now(), LocalTime.of(9,30), LocalTime.of(10,30))
        );
    }
}
