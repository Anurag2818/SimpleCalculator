package com.simplecalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		return simpleCalculatorService.getHistory();
	}

	@GetMapping("/add/{firstOperand}/{secondOperand}")
	public Double add(@PathVariable("firstOperand") Integer firstOperand,
			@PathVariable("secondOperand") Integer secondOperand) {
		return simpleCalculatorService.add(firstOperand, secondOperand);
	}

	@GetMapping("/sub/{firstOperand}/{secondOperand}")
	public Double substract(@PathVariable("firstOperand") Integer firstOperand,
			@PathVariable("secondOperand") Integer secondOperand) {
		return simpleCalculatorService.substract(firstOperand, secondOperand);
	}

	@GetMapping("/multiply/{firstOperand}/{secondOperand}")
	public Double multiply(@PathVariable("firstOperand") Integer firstOperand,
			@PathVariable("secondOperand") Integer secondOperand) {
		return simpleCalculatorService.multiply(firstOperand, secondOperand);
	}

	@GetMapping("/divide/{firstOperand}/{secondOperand}")
	public Double divide(@PathVariable("firstOperand") Integer firstOperand,
			@PathVariable("secondOperand") Integer secondOperand) throws IllegalArgumentException {
		return simpleCalculatorService.divide(firstOperand, secondOperand);
	}
}
