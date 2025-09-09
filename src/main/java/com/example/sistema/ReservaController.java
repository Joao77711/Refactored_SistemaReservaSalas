package com.example.sistema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin
public class ReservaController {
    private final ReservaService service;
    public ReservaController(ReservaService service){ this.service = service; }

    @GetMapping public List<Reserva> listar(){ return service.listar(); }

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Reserva criar(@RequestBody Map<String, String> body){
        Long salaId = Long.parseLong(body.get("salaId"));
        Long usuarioId = Long.parseLong(body.get("usuarioId"));
        LocalDate data = LocalDate.parse(body.get("data"));
        LocalTime inicio = LocalTime.parse(body.get("horaInicio"));
        LocalTime fim = LocalTime.parse(body.get("horaFim"));
        return service.criarReserva(salaId, usuarioId, data, inicio, fim);
    }
}
