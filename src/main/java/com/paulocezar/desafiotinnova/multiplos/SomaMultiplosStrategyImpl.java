package com.paulocezar.desafiotinnova.multiplos;

public class SomaMultiplosStrategyImpl implements SomaMultiplosStrategy {
    @Override
    public int calcularSoma(int limite) {
        int soma = 0;
        for (int i = 1; i < limite; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                soma += i;
            }
        }
        return soma;
    }
}
