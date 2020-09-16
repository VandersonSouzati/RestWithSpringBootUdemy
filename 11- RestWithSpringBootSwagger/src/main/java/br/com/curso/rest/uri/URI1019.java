package br.com.curso.rest.uri;

import java.io.IOException;
import java.util.Scanner;

public class URI1019 {
	public static void main(String[] args) {
        final int ANOS    = 365;
        final int MESES  = 30;
        int entrada, totalDias = 0, totalMeses = 0, totalAnos = 0, resto = 0;
        Scanner teclado = new Scanner(System.in);
        entrada = teclado.nextInt();
        
        totalAnos = (entrada/ANOS);
        resto = (entrada%ANOS);
        totalMeses = resto / MESES;
        resto = resto % MESES;
        totalDias = resto;
        
        System.out.printf("%d ano(s)%n%d mes(es)%n%d dia(s)%n", totalAnos, totalMeses, totalDias);
        
	}
}
