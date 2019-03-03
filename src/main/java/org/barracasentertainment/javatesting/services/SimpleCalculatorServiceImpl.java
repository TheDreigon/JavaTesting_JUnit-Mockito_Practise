package org.barracasentertainment.javatesting.services;

import org.barracasentertainment.javatesting.exceptions.CalculatorNotYetUpgradedException;
import org.barracasentertainment.javatesting.exceptions.IllegalCalculatorOperationException;

public class SimpleCalculatorServiceImpl implements SimpleCalculatorService {

    private boolean hasUpgrade;
    private SimpleCalculatorUpgrade simplecalculatorUpgrade;

    public void setSimplecalculatorUpgrade(SimpleCalculatorUpgrade simplecalculatorUpgrade) {
        hasUpgrade = true;
        this.simplecalculatorUpgrade = simplecalculatorUpgrade;
    }

    public boolean isUpgraded() {
        return hasUpgrade;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int sumPositive(int a, int b) throws IllegalCalculatorOperationException {

        if (a < 0 || b < 0) throw new IllegalCalculatorOperationException();

        return a + b;
    }

    public int sumNegative(int a, int b) throws IllegalCalculatorOperationException {

        if (a > 0 || b > 0) throw new IllegalCalculatorOperationException();

        return a + b;
    }

    public int upgradedSum(int a, int b, int c) throws CalculatorNotYetUpgradedException {

        if (hasUpgrade = false) throw new CalculatorNotYetUpgradedException();
        return simplecalculatorUpgrade.upgradedSum(a, b, c);
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int upgradedSubtraction(int a, int b, int c) throws CalculatorNotYetUpgradedException {

        if (hasUpgrade = false) throw new CalculatorNotYetUpgradedException();
        return simplecalculatorUpgrade.upgradedSubtraction(a, b, c);
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public abstract class SimpleCalculatorUpgrade implements SimpleCalculatorUpgradeService {

        public int upgradedSum(int a, int b, int c) {
            return a + b + c;
        }

        public int upgradedSubtraction(int a, int b, int c) {
            return a - b - c;
        }
    }
}
