package com.simplecalculator.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplecalculator.model.SimpleCalculator;

/**
 * This Interface is responsible for storing the data in JPA repository
 *
 */
@Repository
public interface SimpleCalculatorRepo extends JpaRepository<SimpleCalculator, String> {

}
