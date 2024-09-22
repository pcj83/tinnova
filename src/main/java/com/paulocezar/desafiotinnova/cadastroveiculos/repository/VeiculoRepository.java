package com.paulocezar.desafiotinnova.cadastroveiculos.repository;

import com.paulocezar.desafiotinnova.cadastroveiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByVendidoFalse();
    List<Veiculo> findByCreatedAfter(LocalDateTime dateTime);
    @Query("SELECT v.marca, COUNT(v) FROM Veiculo v GROUP BY v.marca")
    List<Object[]> countVeiculosPorMarca();

    @Query("SELECT (v.ano / 10) * 10, COUNT(v) FROM Veiculo v GROUP BY (v.ano / 10) * 10")
    List<Object[]> countVeiculosPorDecada();
}
