package com.paulocezar.desafiotinnova.fatorial;

import java.util.Scanner;

public class Main {

    // Método para calcular o fatorial de forma iterativa
    public static long calcularFatorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("Número não pode ser negativo.");
        }

        long resultado = 1;
        for (int i = 2; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitando que o usuário insira um número
        System.out.print("Digite um número para calcular o fatorial: ");
        int numero = scanner.nextInt();

        // Calculando o fatorial e exibindo o resultado
        try {
            long resultado = calcularFatorial(numero);
            System.out.println("Fatorial de " + numero + " é: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}

