package org.barracasentertainment.javatesting.services;

import org.barracasentertainment.javatesting.exceptions.IllegalCalculatorOperationException;

public interface SimpleCalculatorService {

    int sum(int a, int b);

    int sumPositive(int a, int b) throws IllegalCalculatorOperationException;

    int sumNegative(int a, int b) throws IllegalCalculatorOperationException;

    int subtract(int a, int b);

    int multiply(int a, int b);

    int divide(int a, int b);
}
