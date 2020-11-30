package com.cicd.calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    protected int i, j, sum, res, mult;
    protected double div;

    @BeforeEach
    void setUp() {
        i = -8;
        j = 4;
        sum = i+j;
        res = i-j;
        div = i/j;
        mult = i*j;
    }
    /*
     * Testing strategy
     *
     * Partitions setFirstValue(i) as follows:
     *  (1)  i is positive, negative, or 0
     *  (2) i = 1 or != 1
     *  (3) i is not NULL
     *  (4) i is not a String
     */

    //covers (1,2)
    @Test
    void setFirstValue_Negative() {
        Calculator c = new Calculator();
        int i = -1;
        c.setFirstValue(i);
        int j = c.getFirstValue();
        assertEquals(i,j);
    }

    //covers (1)
    @Test
    void setFirstValue_0() {
        Calculator c = new Calculator();
        c.setFirstValue(0);
        int i = c.getFirstValue();
        assertEquals(0,i);
    }

    //covers (3)
    @Test
    void setFirstValue_NotNull() {
        Calculator c = new Calculator();
        c.setFirstValue(i);
        int j = c.getFirstValue();
        assertNotNull(j);
    }

    //covers (4)
    @Test
    void setFirstValueIsNotString() {
        Calculator c = new Calculator();
        c.setFirstValue(i);
        int j = c.getFirstValue();
        Object expected = (Integer)j;
        assertFalse( expected instanceof String, "Input First Value is String object. Should be Integer.");
    }

    @Test
    void getFirstValue() {
        Calculator c = new Calculator();
        c.setFirstValue(i);
        int j = c.getFirstValue();
        assertEquals(i,j);
    }

    @Test
    void setSecondValue() {
        Calculator c = new Calculator();
        c.setSecondValue(i);
        int j = c.getSecondValue();
        assertEquals(i, j);
    }

    @Test
    void getSecondValue() {
        Calculator c = new Calculator();
        c.setSecondValue(i);
        int j = c.getSecondValue();
        assertEquals(i, j);
    }

    /*
     * Testing strategy
     *
     * Partitions Add(i,j) as follows:
     *  (1) i is positive, negative, or 0
     *  (2) j is positive, negative, or 0
     *  (3) i = 1 or != 1
     *  (4) j = 1 or != 1
     *  (5) Add(i,j) fits in a int value or not
     */

    //covers (1) and (2)
    @Test
    void add() {
        Calculator c = new Calculator();
        int result = c.Add(i, j);
        assertEquals(sum, result);
    }

    //covers (5)
    @Test
    void addMaxValue() {
        Calculator c = new Calculator();
        assertThrows(ArithmeticException.class, () -> {
            int result = c.Add(Integer.MAX_VALUE, 42);
        },
                "One or both terms are exceeding allowed MAX value of " +
                +Integer.MAX_VALUE + ".");

    }

    @Test
    void subtract() {
        Calculator c = new Calculator();
        int result = c.Subtract(i, j);
        assertEquals(res, result);
    }

    @Test
    void multiply() {
        Calculator c = new Calculator();
        int result = c.Multiply(i, j);
        assertEquals(mult, result);
    }

    @Test
    void divide() {
        Calculator c = new Calculator();
        double result = c.Divide(i, j);
        assertEquals(div, result);
    }
}