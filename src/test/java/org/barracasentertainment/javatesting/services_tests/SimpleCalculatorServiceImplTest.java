package org.barracasentertainment.javatesting.services_tests;

import org.barracasentertainment.javatesting.exceptions.CalculatorNotYetUpgradedException;
import org.barracasentertainment.javatesting.exceptions.IllegalCalculatorOperationException;
import org.barracasentertainment.javatesting.services.SimpleCalculatorServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SimpleCalculatorServiceImplTest {

    // the SimpleCalculatorServiceImpl is our SUT (System Under Test)
    private SimpleCalculatorServiceImpl simpleCalculatorServiceImpl;

    // this code will run before each test
    @Before
    public void setup() {
        simpleCalculatorServiceImpl = new SimpleCalculatorServiceImpl();
    }

    // this annotates this method as a test, and will be invoked by the Test Runner
    @Test
    public void sumTest() {

        int result = simpleCalculatorServiceImpl.sum(10, -5);
        int expected = 5;

        // assert if the two values are equal. if they are different, the test fails
        assertEquals(expected, result);
    }

    // these next 2 tests expect an IllegalArgumentException and will fail if it was not thrown
    @Test(expected = IllegalCalculatorOperationException.class)
    public void sumPositiveTest() throws IllegalCalculatorOperationException {
        simpleCalculatorServiceImpl.sumPositive(-10, 10);
    }

    @Test(expected = IllegalCalculatorOperationException.class)
    public void sumNegativeTest() throws IllegalCalculatorOperationException {
        simpleCalculatorServiceImpl.sumNegative(-5, 5);
    }

    @Test
    public void subtractTest() {

        int result = simpleCalculatorServiceImpl.subtract(10, -5);
        int expected = 15;

        assertEquals(expected, result);
    }

    @Test
    public void multiplyTest() {

        int result = simpleCalculatorServiceImpl.multiply(10, -5);
        int expected = -50;

        assertEquals(expected, result);
    }

    @Test
    public void divideTest() {

        int result = simpleCalculatorServiceImpl. divide(10, -5);
        int expected = -2;

        assertEquals(expected, result);
    }

    @Test
    public void upgradedSumTest() throws CalculatorNotYetUpgradedException {

        // Setup
        SimpleCalculatorServiceImpl.SimpleCalculatorUpgrade simpleCalculatorUpgrade = mock(SimpleCalculatorServiceImpl.SimpleCalculatorUpgrade.class);
        simpleCalculatorServiceImpl.setSimplecalculatorUpgrade(simpleCalculatorUpgrade);
        when(simpleCalculatorUpgrade.upgradedSum(1, 2, 3)).thenReturn(6);

        // Exercise
        int result = simpleCalculatorServiceImpl.upgradedSum(1, 2, 3);
        int expected = 6;

        // Verify. In this case, first that the method was called (Mockito), then that the result is what we what (JUnit)
        verify(simpleCalculatorUpgrade).upgradedSum(1,2, 3);
        assertEquals(expected, result);
    }

    @Test
    public void upgradedSubtractionTest() throws CalculatorNotYetUpgradedException {

        // Setup
        SimpleCalculatorServiceImpl.SimpleCalculatorUpgrade simpleCalculatorUpgrade = mock(SimpleCalculatorServiceImpl.SimpleCalculatorUpgrade.class);
        simpleCalculatorServiceImpl.setSimplecalculatorUpgrade(simpleCalculatorUpgrade);
        when(simpleCalculatorUpgrade.upgradedSubtraction(1, 2, 3)).thenReturn(-4);

        // Exercise
        int result = simpleCalculatorServiceImpl.upgradedSubtraction(1, 2, 3);
        int expected = -4;

        // Verify
        verify(simpleCalculatorUpgrade).upgradedSubtraction(1, 2, 3);
        assertEquals(expected, result);
    }
}
