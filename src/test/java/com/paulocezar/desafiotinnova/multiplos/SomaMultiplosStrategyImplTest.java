package com.paulocezar.desafiotinnova.multiplos;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomaMultiplosStrategyImplTest {
    @ParameterizedTest
    @CsvSource({
            "10, 23",
            "20, 78",
            "30, 195",
            "40, 368"
    })
    void testCalcularSoma(int limite, int expectedSoma) {
        SomaMultiplosStrategy strategy = new SomaMultiplosStrategyImpl();
        int soma = strategy.calcularSoma(limite);
        assertEquals(expectedSoma, soma);
    }
}