package com.simplecalculator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplecalculator.model.SimpleCalculator;
import com.simplecalculator.repo.SimpleCalculatorRepo;

/**
 * This is the Service class responsible for taking the request from Controller
 * class and executing the calculation and storing it in database
 */
@Service
public class SimpleCalculatorService {
	private static final String ADD_OPERATION = "+";
	private static final String SUBSTRACTION_OPERATION = "-";
	private static final String MULTIPLICATION_OPERATION = "*";
	private static final String DIVISION_OPERATION = "/";
	@Autowired
	private SimpleCalculatorRepo simpleCalculatorRepo;

	/**
	 * This method will add 2 operands
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @return Addition result
	 */
	public Double add(int firstOperand, int secondOperand) {
		Double result = (double) (firstOperand + secondOperand);
		saveOperation(firstOperand, secondOperand, ADD_OPERATION, result);
		return result;
	}

	/**
	 * This method will substract 2 operands
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @return Substraction result
	 */
	public Double substract(int firstOperand, int secondOperand) {
		Double result = (double) (firstOperand - secondOperand);
		saveOperation(firstOperand, secondOperand, SUBSTRACTION_OPERATION, result);
		return result;
	}

	/**
	 * This method will multiply 2 operands
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @return Multiplication result
	 */
	public Double multiply(int firstOperand, int secondOperand) {
		Double result = (double) (firstOperand * secondOperand);
		saveOperation(firstOperand, secondOperand, MULTIPLICATION_OPERATION, result);
		return result;
	}

	/**
	 * This method will divide 2 operands
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @return Division result
	 */
	public Double divide(int firstOperand, int secondOperand) throws IllegalArgumentException {
		if (secondOperand == 0) {
			throw new IllegalArgumentException("Number cannot be divided by 0");
		}
		Double result = (Double.valueOf(firstOperand) / Double.valueOf(secondOperand));
		saveOperation(firstOperand, secondOperand, DIVISION_OPERATION, result);
		return result;
	}

	/**
	 * This method will get the full History of Calculation
	 * 
	 * @return Calculation History
	 */
	public List<SimpleCalculator> getHistory() {
		return simpleCalculatorRepo.findAll();
	}

	private void saveOperation(int firstOperand, int secondOperand, String operation, double result) {
		SimpleCalculator simpleCalculator = new SimpleCalculator();
		simpleCalculator.setFirstOperand(firstOperand);
		simpleCalculator.setSecondOperand(secondOperand);
		simpleCalculator.setOperation(operation);
		simpleCalculator.setOperationResult(result);
		simpleCalculatorRepo.save(simpleCalculator);
	}
}