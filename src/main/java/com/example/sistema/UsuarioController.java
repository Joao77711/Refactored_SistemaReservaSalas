package com.example.sistema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin
public class UsuarioController {
    private final UsuarioRepository repo;
    public UsuarioController(UsuarioRepository repo){ this.repo = repo; }

    @GetMapping public List<Usuario> listar(){ return repo.findAll(); }

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Usuario criar(@RequestBody Usuario u){ return repo.save(u); }

    @PostMapping("/login")
    public Usuario login(@RequestBody Map<String,String> body){
        return repo.findByLoginAndSenha(body.get("login"), body.get("senha"))
                   .orElseThrow(() -> new RuntimeException("Credenciais inválidas"));
    }
}
