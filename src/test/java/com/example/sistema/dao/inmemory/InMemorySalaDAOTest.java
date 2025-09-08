package com.example.sistema.dao.inmemory;

import com.example.sistema.model.Sala;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InMemorySalaDAOTest {

    @Test
    public void testSalvarAtribuiId() {
        InMemorySalaDAO dao = new InMemorySalaDAO();
        Sala s = new Sala(0, "Sala X", 10);
        Sala saved = dao.salvar(s);
        assertTrue(saved.getId() > 0, "ID deve ser maior que zero após salvar");
        assertEquals("Sala X", saved.getNome());
        assertEquals(10, saved.getCapacidade());
    }
}
