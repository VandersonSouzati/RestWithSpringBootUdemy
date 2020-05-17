package br.com.curso.rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.rest.conversion.NumberConversion;
import br.com.curso.rest.exception.UnSuportedMathOperationException;
import br.com.curso.rest.services.SimpleService;

@RestController
public class MathController {

	@Autowired
	SimpleService services;
	
	// Operação de soma
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!NumberConversion.isNumeric(numberOne) || !NumberConversion.isNumeric(numberTwo)) {
			throw new UnSuportedMathOperationException("Please set a numeric value!");
		}
		return services.sum(numberOne, numberTwo);
	}

	// Operação de subtração
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!NumberConversion.isNumeric(numberOne) || !NumberConversion.isNumeric(numberTwo)) {
			throw new UnSuportedMathOperationException("Please set a numeric value !");
		}
		return services.subtraction(numberOne, numberTwo);
	}

	// Operação de multiplicação
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if (!NumberConversion.isNumeric(numberOne) || !NumberConversion.isNumeric(numberTwo)) {
			throw new UnSuportedMathOperationException("Please set a numeric value !");
		}
		return services.multiplication(numberOne, numberTwo);
	}

	// Operação de divisão
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if (!NumberConversion.isNumeric(numberOne) || !NumberConversion.isNumeric(numberTwo)) {
			throw new UnSuportedMathOperationException("Please set a numeric value !");
		}
	    return services.division(numberOne, numberTwo);	
	}

	// Operação de média
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!NumberConversion.isNumeric(numberOne) || !NumberConversion.isNumeric(numberTwo)) {
			throw new UnSuportedMathOperationException("Please set a numeric value !");
		}
		return services.mean(numberOne, numberTwo);
	}
	

	// Operação raiz quadrada
	@RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number) {
		if (!NumberConversion.isNumeric(number)) {
			throw new UnSuportedMathOperationException("Please set a numeric value !");
		}
		return services.squareRoot(number);
	}

	
}
