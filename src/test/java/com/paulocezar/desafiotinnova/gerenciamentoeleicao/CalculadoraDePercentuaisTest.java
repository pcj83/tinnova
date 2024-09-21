package com.paulocezar.desafiotinnova.gerenciamentoeleicao;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraDePercentuaisTest {

    @ParameterizedTest
    @CsvSource({
            "1000, 800, 80.0",  // Total de eleitores 1000, válidos 800, percentual esperado 80.0
            "500, 400, 80.0",   // Teste com outros números
            "1000, 1000, 100.0",// 100% dos votos são válidos
            "1000, 0, 0.0"      // Nenhum voto válido
    })
    public void testPercentualValidos(int totalEleitores, int votosValidos, double resultadoEsperado) {
        CalculadoraDePercentuais calculadora = new CalculadoraDePercentuais(new PercentualValidos());
        double resultado = calculadora.calcular(totalEleitores, votosValidos);
        assertEquals(resultadoEsperado, resultado, 0.01);
    }

    @ParameterizedTest
    @CsvSource({
            "1000, 150, 15.0",  // Total de eleitores 1000, brancos 150, percentual esperado 15.0
            "500, 100, 20.0",   // Teste com outros números
            "1000, 0, 0.0",     // Nenhum voto branco
            "1000, 1000, 100.0" // 100% dos votos são brancos
    })
    public void testPercentualBrancos(int totalEleitores, int votosBrancos, double resultadoEsperado) {
        CalculadoraDePercentuais calculadora = new CalculadoraDePercentuais(new PercentualBrancos());
        double resultado = calculadora.calcular(totalEleitores, votosBrancos);
        assertEquals(resultadoEsperado, resultado, 0.01);
    }

    @ParameterizedTest
    @CsvSource({
            "1000, 50, 5.0",    // Total de eleitores 1000, nulos 50, percentual esperado 5.0
            "500, 25, 5.0",     // Teste com outros números
            "1000, 0, 0.0",     // Nenhum voto nulo
            "1000, 1000, 100.0" // 100% dos votos são nulos
    })
    public void testPercentualNulos(int totalEleitores, int votosNulos, double resultadoEsperado) {
        CalculadoraDePercentuais calculadora = new CalculadoraDePercentuais(new PercentualNulos());
        double resultado = calculadora.calcular(totalEleitores, votosNulos);
        assertEquals(resultadoEsperado, resultado, 0.01);
    }
}
