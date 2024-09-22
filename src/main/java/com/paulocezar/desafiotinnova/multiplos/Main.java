package com.paulocezar.desafiotinnova.multiplos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o limite: ");
        int limite = scanner.nextInt();

        SomaMultiplosStrategy strategy = new SomaMultiplosStrategyImpl();
        SomaMultiplosService service = new SomaMultiplosService(strategy);
        int soma = service.calcularSoma(limite);
        System.out.println("Soma dos múltiplos de 3 ou 5 abaixo de " + limite + ": " + soma);
    }
}