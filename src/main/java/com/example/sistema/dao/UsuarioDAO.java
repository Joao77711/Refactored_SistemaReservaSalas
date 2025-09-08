package com.example.sistema.dao;

import com.example.sistema.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioDAO {
    Usuario salvar(Usuario u);
    Optional<Usuario> buscarPorLogin(String login);
    List<Usuario> listarTodas();
}
