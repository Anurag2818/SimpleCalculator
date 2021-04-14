package com.simplecalculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.simplecalculator.model.SimpleCalculator;
import com.simplecalculator.repo.SimpleCalculatorRepo;

/**
 * This is JUNIT class for testing Service class of our Application using
 * Mockito.
 *
 */
@RunWith(MockitoJUnitRunner.class)
class SimpleCalculatorServiceTests {

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Mock
	SimpleCalculatorRepo repo;

	@InjectMocks
	SimpleCalculatorService service;

	@Test
	void addTest() {
		Double expected = 10.0;
		SimpleCalculator model = setModel(expected);
		Mockito.when(repo.save(Mockito.any())).thenReturn(model);
		Double actual = service.add(8, 2);
		assertEquals(expected, actual);
	}

	@Test
	void substractTest() {
		Double expected = 3.0;
		SimpleCalculator model = setModel(expected);
		Mockito.when(repo.save(Mockito.any())).thenReturn(model);
		Double actual = service.substract(5, 2);
		assertEquals(expected, actual);
	}

	@Test
	void multiplyTest() {
		Double expected = 6.0;
		SimpleCalculator model = setModel(expected);
		Mockito.when(repo.save(Mockito.any())).thenReturn(model);
		Double actual = service.multiply(3, 2);
		assertEquals(expected, actual);
	}

	@Test
	void divideTest() {
		Double expected = 2.0;
		SimpleCalculator model = setModel(expected);
		Mockito.when(repo.save(Mockito.any())).thenReturn(model);
		Double actual = 0.0;
		try {
			actual = service.divide(10, 5);
			assertEquals(expected, actual);
		} catch (IllegalArgumentException e) {
			IllegalArgumentException expectedErrorMessage = new IllegalArgumentException(
					"Number cannot be divided by 0");
			assertEquals(expectedErrorMessage.getMessage(), e.getMessage());
		}
	}

	@Test
	void getHistoryTest() {
		List<SimpleCalculator> expectedList = new ArrayList<SimpleCalculator>();
		expectedList.add(setModel(2.0));
		expectedList.add(setModel(3.0));
		Mockito.when(repo.findAll()).thenReturn(expectedList);
		List<SimpleCalculator> actual = service.getHistory();
		assertEquals(expectedList.size(), actual.size());
	}

	private SimpleCalculator setModel(Double expected) {
		SimpleCalculator model = new SimpleCalculator();
		model.setFirstOperand(model.getFirstOperand());
		model.setSecondOperand(model.getFirstOperand());
		model.setOperationResult(expected);
		model.setOperation(model.getOperation());
		return model;
	}
}
