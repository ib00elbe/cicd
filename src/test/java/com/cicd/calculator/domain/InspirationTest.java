package com.cicd.calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InspirationTest {

    /*
     * Testing strategy
     *
     * Partitions s=quote() as follows:
     *  (1) s is a String
     *  (2) s is not NULL
     */

    //covers (1)
    @Test
    void quoteIsString() {
        Inspiration inspiration = new Inspiration();
        Object quote = inspiration.Quote();
        assertTrue( quote instanceof String, "Quote is not of type String.");
    }

    //covers (2)
    @Test
    public void quoteIsNull() {
        Inspiration inspiration = new Inspiration();
        Object quote = inspiration.Quote();
        assertNotNull(quote, "Null is returned.");
    }

    @Test
    void getCallCounter() {
    }
}