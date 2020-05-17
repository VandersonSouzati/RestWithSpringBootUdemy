package br.com.curso.rest.conversion;

import org.springframework.stereotype.Service;

@Service
public class NumberConversion {

	public static boolean isNumeric(String number) {
		if (number == null) {
			return false;
		}
		number = number.replace(",", ".");
		return number.matches("[+-]?[0-9]*\\.?[0-9]+");
	}

	public static Double convertToDouble(String number) {
		if (number == null) {
			return 0D;
		}
		number = number.replace(",", ".");
		return Double.parseDouble(number);
	}
}
