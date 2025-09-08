package com.example.sistema.app;

import com.example.sistema.dao.SalaDAO;
import com.example.sistema.dao.ReservaDAO;
import com.example.sistema.dao.UsuarioDAO;
import com.example.sistema.dao.inmemory.InMemorySalaDAO;
import com.example.sistema.dao.inmemory.InMemoryReservaDAO;
import com.example.sistema.dao.inmemory.InMemoryUsuarioDAO;
import com.example.sistema.model.Sala;
import com.example.sistema.model.Usuario;
import com.example.sistema.service.ReservaService;

public class MainTest {
    public static void main(String[] args) {
        // Setup in-memory DAOs (used for automated testing without DB)
        SalaDAO salaDAO = new InMemorySalaDAO();
        ReservaDAO reservaDAO = new InMemoryReservaDAO();
        UsuarioDAO usuarioDAO = new InMemoryUsuarioDAO();

        // Seed some data
        Sala s1 = salaDAO.salvar(new Sala(0, "Sala 101", 30));
        Sala s2 = salaDAO.salvar(new Sala(0, "Sala 102", 20));

        usuarioDAO.salvar(new Usuario(0, "admin", "senha", "admin"));
        usuarioDAO.salvar(new Usuario(0, "user1", "1234", "usuario"));

        ReservaService service = new ReservaService(reservaDAO, salaDAO);

        System.out.println("== Criando reservas de teste ==");
        var r1 = service.criarReserva(s1.getId(), "Joao", "2025-09-10", "09:00-10:00");
        var r2 = service.criarReserva(s2.getId(), "Maria", "2025-09-10", "10:00-11:00");

        System.out.println("Reservas atuais:" );
        service.listarReservas().forEach(System.out::println);

        System.out.println("Reservas por sala (Sala 101):");
        service.listarReservasPorSala(s1.getId()).forEach(System.out::println);

        System.out.println("Teste concluido com sucesso.");
    }
}
