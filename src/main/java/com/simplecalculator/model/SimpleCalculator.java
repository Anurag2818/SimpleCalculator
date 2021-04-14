package com.simplecalculator.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * This is the Model class responsible for containing the data for Calculation
 */
@Component
@Entity
@Table(name = "SIMPLECALCULATOR")
public class SimpleCalculator implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false, name = "ID")
	private Integer id;
	@Column(name = "OPERATION")
	private String operation;
	@Column(name = "FIRST_OPEARAND")
	private Integer firstOperand;
	@Column(name = "SECOND_OPERAND")
	private Integer secondOperand;
	@Column(name = "OPERATION_RESULT")
	private Double operationResult;

	public SimpleCalculator() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Integer getFirstOperand() {
		return firstOperand;
	}

	public void setFirstOperand(Integer firstOperand) {
		this.firstOperand = firstOperand;
	}

	public Integer getSecondOperand() {
		return secondOperand;
	}

	public void setSecondOperand(Integer secondOperand) {
		this.secondOperand = secondOperand;
	}

	public double getOperationResult() {
		return operationResult;
	}

	public void setOperationResult(double actionResult) {
		this.operationResult = actionResult;
	}

	@Override
	public String toString() {
		return "SimpleCalculator [id=" + id + ", operation=" + operation + ", firstOperand=" + firstOperand
				+ ", secondOperand=" + secondOperand + ", actionResult=" + operationResult + "]";
	}
}
