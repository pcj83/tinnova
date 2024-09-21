package com.paulocezar.desafiotinnova.electionmanagement;

public class PercentualBrancos implements PercentualStrategy {
    @Override
    public double calcularPercentual(int totalEleitores, int votosBrancos) {
        return (double) votosBrancos / totalEleitores * 100;
    }
}
