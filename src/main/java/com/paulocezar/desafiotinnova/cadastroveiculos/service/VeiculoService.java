package com.paulocezar.desafiotinnova.cadastroveiculos.service;

import com.paulocezar.desafiotinnova.cadastroveiculos.model.Veiculo;
import com.paulocezar.desafiotinnova.cadastroveiculos.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public Veiculo criarVeiculo(Veiculo veiculo) {
        veiculo.setCreated(LocalDateTime.now());
        veiculo.setUpdated(LocalDateTime.now());
        return veiculoRepository.save(veiculo);
    }

    public Optional<Veiculo> atualizarVeiculo(Long id, Veiculo veiculoAtualizado) {
        return veiculoRepository.findById(id).map(veiculo -> {
            veiculo.setMarca(veiculoAtualizado.getMarca());
            veiculo.setDescricao(veiculoAtualizado.getDescricao());
            veiculo.setAno(veiculoAtualizado.getAno());
            veiculo.setVendido(veiculoAtualizado.getVendido());
            veiculo.setUpdated(LocalDateTime.now());
            return veiculoRepository.save(veiculo);
        });
    }

    public List<Veiculo> listarNaoVendidos() {
        return veiculoRepository.findByVendidoFalse();
    }

    public List<Map<String, Object>> distribuicaoPorDecada() {
        return veiculoRepository.countVeiculosPorDecada()
                .stream()
                .map(arr -> Map.of("decada", arr[0], "quantidade", arr[1]))
                .collect(Collectors.toList());
    }

    public List<Map<String, Object>> distribuicaoPorMarca() {
        return veiculoRepository.countVeiculosPorMarca()
                .stream()
                .map(arr -> Map.of("marca", arr[0], "quantidade", arr[1]))
                .collect(Collectors.toList());
    }

    public List<Veiculo> veiculosUltimaSemana() {
        LocalDateTime umaSemanaAtras = LocalDateTime.now().minusWeeks(1);
        return veiculoRepository.findByCreatedAfter(umaSemanaAtras);
    }
}
