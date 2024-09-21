package com.paulocezar.desafiotinnova.electionmanagement;

public class PercentualValidos implements PercentualStrategy {
    @Override
    public double calcularPercentual(int totalEleitores, int votosValidos) {
        return (double) votosValidos / totalEleitores * 100;
    }
}

