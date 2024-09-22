package com.paulocezar.desafiotinnova.cadastroveiculos.controller;

import com.paulocezar.desafiotinnova.cadastroveiculos.model.Veiculo;
import com.paulocezar.desafiotinnova.cadastroveiculos.service.VeiculoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    @PostMapping
    public Veiculo criarVeiculo(@RequestBody @Valid Veiculo veiculo) {
        return veiculoService.criarVeiculo(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        return veiculoService.atualizarVeiculo(id, veiculoAtualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nao-vendidos")
    public List<Veiculo> listarNaoVendidos() {
        return veiculoService.listarNaoVendidos();
    }

    @GetMapping("/distribuicao-decada")
    public List<Map<String, Object>> distribuicaoPorDecada() {
        return veiculoService.distribuicaoPorDecada();
    }

    @GetMapping("/distribuicao-marca")
    public List<Map<String, Object>> distribuicaoPorMarca() {
        return veiculoService.distribuicaoPorMarca();
    }

    @GetMapping("/ultima-semana")
    public List<Veiculo> veiculosUltimaSemana() {
        return veiculoService.veiculosUltimaSemana();
    }
}
