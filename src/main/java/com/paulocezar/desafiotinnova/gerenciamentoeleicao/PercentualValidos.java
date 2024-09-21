package com.paulocezar.desafiotinnova.gerenciamentoeleicao;

public class PercentualValidos implements PercentualStrategy {
    @Override
    public double calcularPercentual(int totalEleitores, int votosValidos) {
        return (double) votosValidos / totalEleitores * 100;
    }
}

