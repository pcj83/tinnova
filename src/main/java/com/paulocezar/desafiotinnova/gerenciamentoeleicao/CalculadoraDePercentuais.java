package com.paulocezar.desafiotinnova.gerenciamentoeleicao;

public class CalculadoraDePercentuais {

    private PercentualStrategy strategy;

    // Injetando a estratégia via construtor
    public CalculadoraDePercentuais(PercentualStrategy strategy) {
        this.strategy = strategy;
    }

    public double calcular(int totalEleitores, int votos) {
        return strategy.calcularPercentual(totalEleitores, votos);
    }

    // Permite trocar a estratégia de cálculo em runtime
    public void setStrategy(PercentualStrategy strategy) {
        this.strategy = strategy;
    }
}
