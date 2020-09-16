package br.com.curso.rest;

import java.util.Scanner;
import java.util.Locale;

public class MyClass {
	private Integer codigo;
	private String descricao;

	public MyClass(Integer codigo) {
		this.codigo = codigo;
	}

	public static void main(String args[]) {
		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);
		float a, b, c, r1, r2;
		double delta;
		a = teclado.nextFloat();
		b = teclado.nextFloat();
		c = teclado.nextFloat();
		delta = (double) (b*b) - 4 * a * c;
        
		if (delta < 0) {
			System.out.println("Impossivel calcular");
		} else {
			r1 = (-b + (float) Math.sqrt(delta)) / (2 * a);
			r2 = (-b - (float) Math.sqrt(delta)) /  (2 * a);
			System.out.printf("R1 = %.5f%n", r1);
			System.out.printf("R2 = %.5f%n", r2);
		}
	}
}
