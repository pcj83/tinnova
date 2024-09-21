package com.paulocezar.desafiotinnova.fatorial;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FatorialTest {

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120",
            "6, 720"
    })
    void testCalcularFatorial(int input, long expected) {
        assertEquals(expected, Fatorial.calcularFatorial(input));
    }


    @ParameterizedTest
    @CsvSource({
            "-1", "-5", "-10"
    })
    void testCalcularFatorialComNumeroNegativo(int input) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Fatorial.calcularFatorial(input);
        });
        assertEquals("Número não pode ser negativo.", exception.getMessage());
    }
}
