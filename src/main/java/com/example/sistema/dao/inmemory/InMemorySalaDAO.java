package com.example.sistema.dao.inmemory;
import com.example.sistema.model.Sala;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemorySalaDAO {
    private final Map<Integer, Sala> store = new HashMap<>();
    private final AtomicInteger seq = new AtomicInteger(1);
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
    public Optional<Sala> buscarPorId(int id){ return Optional.ofNullable(store.get(id)); }
    public List<Sala> listarTodas(){ return new ArrayList<>(store.values()); }
    public boolean remover(int id){ return store.remove(id) != null; }
}
