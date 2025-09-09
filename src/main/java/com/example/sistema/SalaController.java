package com.example.sistema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/salas")
@CrossOrigin
public class SalaController {
    private final SalaRepository repo;
    public SalaController(SalaRepository repo){ this.repo = repo; }

    @GetMapping public List<Sala> listar(){ return repo.findAll(); }

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Sala criar(@RequestBody Sala sala){ return repo.save(sala); }
}
