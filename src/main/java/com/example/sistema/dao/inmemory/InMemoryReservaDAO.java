package com.example.sistema.dao.inmemory;

import com.example.sistema.dao.ReservaDAO;
import com.example.sistema.model.Reserva;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryReservaDAO implements ReservaDAO {
    private final Map<Integer, Reserva> store = new HashMap<>();
    private final AtomicInteger seq = new AtomicInteger(1);

    @Override
    public Reserva salvar(Reserva r) {
        int id = r.getId();
        if (id <= 0) {
            id = seq.getAndIncrement();
            Reserva nr = new Reserva(id, r.getSalaId(), r.getResponsavel(), r.getData(), r.getHorario());
            store.put(id, nr);
            return nr;
        } else {
            store.put(id, r);
            return r;
        }
    }

    @Override
    public Optional<Reserva> buscarPorId(int id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Reserva> listarTodas() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Reserva> listarPorSala(int salaId) {
        return store.values().stream().filter(r -> r.getSalaId() == salaId).collect(Collectors.toList());
    }

    @Override
    public boolean remover(int id) {
        return store.remove(id) != null;
    }
}
