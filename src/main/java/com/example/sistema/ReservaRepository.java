package com.example.sistema;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query("select r from Reserva r where r.sala.id = :salaId and r.data = :data and not (r.horaFim <= :inicio or r.horaInicio >= :fim)")
    List<Reserva> verificarConflitos(@Param("salaId") Long salaId,
                                     @Param("data") LocalDate data,
                                     @Param("inicio") LocalTime inicio,
                                     @Param("fim") LocalTime fim);
}
