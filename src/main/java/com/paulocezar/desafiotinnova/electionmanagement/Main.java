package com.paulocezar.desafiotinnova.electionmanagement;

public class Main {
    public static void main(String[] args) {
        int totalEleitores = 1000;
        int votosValidos = 800;
        int votosBrancos = 150;
        int votosNulos = 50;

        // Calculando o percentual de votos válidos
        CalculadoraDePercentuais calculadora = new CalculadoraDePercentuais(new PercentualValidos());
        double percentualValidos = calculadora.calcular(totalEleitores, votosValidos);
        System.out.println("Percentual de votos válidos: " + percentualValidos + "%");

        // Calculando o percentual de votos brancos
        calculadora.setStrategy(new PercentualBrancos());
        double percentualBrancos = calculadora.calcular(totalEleitores, votosBrancos);
        System.out.println("Percentual de votos brancos: " + percentualBrancos + "%");

        // Calculando o percentual de votos nulos
        calculadora.setStrategy(new PercentualNulos());
        double percentualNulos = calculadora.calcular(totalEleitores, votosNulos);
        System.out.println("Percentual de votos nulos: " + percentualNulos + "%");
    }
}

