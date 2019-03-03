package org.barracasentertainment.javatesting.exceptions;

import org.barracasentertainment.javatesting.errors.ErrorMessage;

public class CalculatorNotYetUpgradedException extends CalculatorException {

    public CalculatorNotYetUpgradedException() {
        super(ErrorMessage.CALCULATOR_NOT_YET_UPGRADED);
    }
}
