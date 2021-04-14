package com.simplecalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplecalculator.model.SimpleCalculator;
import com.simplecalculator.service.SimpleCalculatorService;

/**
 * This is the Controller class responsible for serving request/response from/to
 * UI by calling the service class
 */
@RestController
@RequestMapping("/calculator")
public class SimpleCalculatorResource {
	@Autowired
	private SimpleCalculatorService simpleCalculatorService;

	@GetMapping("/history")
	public java.util.List<SimpleCalculator> getHistory() {
		java.util.List<SimpleCalculator> calculationHistory = simpleCalculatorService.getHistory();
		return calculationHistory;
	}

	@GetMapping("/add/{firstOperand}/{secondOperand}")
	public Double add(@PathVariable("firstOperand") Integer firstOperand,
			@PathVariable("secondOperand") Integer secondOperand) {
		Double additionResult = simpleCalculatorService.add(firstOperand, secondOperand);
		return additionResult;
	}

	@GetMapping("/sub/{firstOperand}/{secondOperand}")
	public Double substract(@PathVariable("firstOperand") Integer firstOperand,
			@PathVariable("secondOperand") Integer secondOperand) {
		Double substrationResult = simpleCalculatorService.substract(firstOperand, secondOperand);
		return substrationResult;
	}

	@GetMapping("/multiply/{firstOperand}/{secondOperand}")
	public Double multiply(@PathVariable("firstOperand") Integer firstOperand,
			@PathVariable("secondOperand") Integer secondOperand) {
		Double multiplicationResult = simpleCalculatorService.multiply(firstOperand, secondOperand);
		return multiplicationResult;
	}

	@GetMapping("/divide/{firstOperand}/{secondOperand}")
	public Double divide(@PathVariable("firstOperand") Integer firstOperand,
			@PathVariable("secondOperand") Integer secondOperand) throws IllegalArgumentException {
		Double divisionResult = simpleCalculatorService.divide(firstOperand, secondOperand);
		return divisionResult;
	}
}
