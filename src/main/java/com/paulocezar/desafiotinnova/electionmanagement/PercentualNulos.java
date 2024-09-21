package com.paulocezar.desafiotinnova.electionmanagement;

public class PercentualNulos implements PercentualStrategy {
    @Override
    public double calcularPercentual(int totalEleitores, int votosNulos) {
        return (double) votosNulos / totalEleitores * 100;
    }
}
