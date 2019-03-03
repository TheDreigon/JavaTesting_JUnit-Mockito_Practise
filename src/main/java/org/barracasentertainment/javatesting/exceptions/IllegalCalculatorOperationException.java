package org.barracasentertainment.javatesting.exceptions;

import org.barracasentertainment.javatesting.errors.ErrorMessage;

public class IllegalCalculatorOperationException extends CalculatorException {

    public IllegalCalculatorOperationException () {
        super(ErrorMessage.INVALID_OPERATION);
    }
}
