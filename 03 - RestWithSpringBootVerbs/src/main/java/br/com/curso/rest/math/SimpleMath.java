package br.com.curso.rest.math;

import br.com.curso.rest.conversion.NumberConversion;
import br.com.curso.rest.exception.UnSuportedMathOperationException;

public class SimpleMath {

	// Sum
	public Double sum(String numberOne, String numberTwo) {
		return NumberConversion.convertToDouble(numberOne) + NumberConversion.convertToDouble(numberTwo);
	}

	// Subtraction
	public Double subtraction(String numberOne, String numberTwo) {
		return NumberConversion.convertToDouble(numberOne) - NumberConversion.convertToDouble(numberTwo);
	}

	// MUltiplication
	public Double multiplication(String numberOne, String numberTwo) {
		return NumberConversion.convertToDouble(numberOne) * NumberConversion.convertToDouble(numberTwo);
	}

	// Division
	public Double division(String numberOne, String numberTwo) {
		if (NumberConversion.convertToDouble(numberTwo) == 0) {
			throw new UnSuportedMathOperationException("division invalidates by zero !");
		}

		return NumberConversion.convertToDouble(numberOne) / NumberConversion.convertToDouble(numberTwo);
	}

	// Mean
	public Double mean(String numberOne, String numberTwo) {
		Double total = NumberConversion.convertToDouble(numberOne) + NumberConversion.convertToDouble(numberTwo);
		if (total == 0) {
			throw new UnSuportedMathOperationException("Sum of values equals to zero/ division invalidates by zero!");
		}
		return (NumberConversion.convertToDouble(numberOne) + NumberConversion.convertToDouble(numberTwo)) / 2;
	}

	// SquareRoot
	public Double squareRoot(String number) {
		return Math.sqrt(NumberConversion.convertToDouble(number));
	}

}
