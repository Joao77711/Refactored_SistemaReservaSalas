package com.example.sistema.dao.inmemory;

import com.example.sistema.dao.UsuarioDAO;
import com.example.sistema.model.Usuario;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryUsuarioDAO implements UsuarioDAO {
    private final Map<Integer, Usuario> store = new HashMap<>();
    private final AtomicInteger seq = new AtomicInteger(1);

    @Override
    public Usuario salvar(Usuario u) {
        int id = u.getId();
        if (id <= 0) {
            id = seq.getAndIncrement();
            Usuario nu = new Usuario(id, u.getLogin(), u.getSenha(), u.getTipo());
            store.put(id, nu);
            return nu;
        } else {
            store.put(id, u);
            return u;
        }
    }

    @Override
    public Optional<Usuario> buscarPorLogin(String login) {
        return store.values().stream().filter(u -> u.getLogin().equals(login)).findFirst();
    }

    @Override
    public List<Usuario> listarTodas() {
        return new ArrayList<>(store.values());
    }
}
