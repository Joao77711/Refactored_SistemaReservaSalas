package com.example.sistema;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLoginAndSenha(String login, String senha);
}
