package com.paulocezar.desafiotinnova.multiplos;

public class SomaMultiplosService {
    private SomaMultiplosStrategy strategy;

    public SomaMultiplosService(SomaMultiplosStrategy strategy) {
        this.strategy = strategy;
    }

    public int calcularSoma(int limite) {
        return strategy.calcularSoma(limite);
    }
}