package com.paulocezar.desafiotinnova.fatorial;

public class Fatorial {

    private static final String NAO_PODE_SER_NEGATIVO = "Número não pode ser negativo.";

    public static long calcularFatorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException(NAO_PODE_SER_NEGATIVO);
        }

        long resultado = 1;
        for (int i = 2; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }
}

