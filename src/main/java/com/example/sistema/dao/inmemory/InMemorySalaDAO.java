package com.example.sistema.dao.inmemory;

import com.example.sistema.dao.SalaDAO;
import com.example.sistema.model.Sala;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemorySalaDAO implements SalaDAO {
    private final Map<Integer, Sala> store = new HashMap<>();
    private final AtomicInteger seq = new AtomicInteger(1);

    @Override
    public Sala salvar(Sala s) {
        int id = s.getId();
        if (id <= 0) {
            id = seq.getAndIncrement();
            Sala ns = new Sala(id, s.getNome(), s.getCapacidade());
            store.put(id, ns);
            return ns;
        } else {
            store.put(id, s);
            return s;
        }
    }

    @Override
    public Optional<Sala> buscarPorId(int id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Sala> listarTodas() {
        return new ArrayList<>(store.values());
    }

    @Override
    public boolean remover(int id) {
        return store.remove(id) != null;
    }
}
