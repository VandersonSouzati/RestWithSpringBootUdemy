package br.com.curso.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.rest.conversion.NumberConversion;
import br.com.curso.rest.exception.UnSuportedMathOperationException;

@Service
public class SimpleService {

	@Autowired
	NumberConversion util;

	// Sum
	public Double sum(String numberOne, String numberTwo) {
		return util.convertToDouble(numberOne) + NumberConversion.convertToDouble(numberTwo);
	}

	// Subtraction
	public Double subtraction(String numberOne, String numberTwo) {
		return util.convertToDouble(numberOne) - NumberConversion.convertToDouble(numberTwo);
	}

	// MUltiplication
	public Double multiplication(String numberOne, String numberTwo) {
		return util.convertToDouble(numberOne) * NumberConversion.convertToDouble(numberTwo);
	}

	// Division
	public Double division(String numberOne, String numberTwo) {
		if (util.convertToDouble(numberTwo) == 0) {
			throw new UnSuportedMathOperationException("division invalidates by zero !");
		}

		return util.convertToDouble(numberOne) / util.convertToDouble(numberTwo);
	}

	// Mean
	public Double mean(String numberOne, String numberTwo) {
		Double total = util.convertToDouble(numberOne) + util.convertToDouble(numberTwo);
		if (total == 0) {
			throw new UnSuportedMathOperationException("Sum of values equals to zero/ division invalidates by zero!");
		}
		return (util.convertToDouble(numberOne) + util.convertToDouble(numberTwo)) / 2;
	}

	// SquareRoot
	public Double squareRoot(String number) {
		return Math.sqrt(util.convertToDouble(number));
	}

}
