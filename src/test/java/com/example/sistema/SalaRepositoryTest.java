package com.example.sistema;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class SalaRepositoryTest {

    @Autowired
    private SalaRepository repo;

    @Test
    void criaEListaSala(){
        repo.save(new Sala("Sala 101", 10));
        List<Sala> salas = repo.findAll();
        assertEquals(1, salas.size());
        assertEquals("Sala 101", salas.get(0).getNome());
    }
}
