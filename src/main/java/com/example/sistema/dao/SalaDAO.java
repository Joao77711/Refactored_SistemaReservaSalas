package com.example.sistema.dao;

import com.example.sistema.model.Sala;
import java.util.List;
import java.util.Optional;

public interface SalaDAO {
    Sala salvar(Sala s);
    Optional<Sala> buscarPorId(int id);
    List<Sala> listarTodas();
    boolean remover(int id);
}
