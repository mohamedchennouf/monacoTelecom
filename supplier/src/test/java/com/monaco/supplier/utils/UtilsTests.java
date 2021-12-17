package com.monaco.supplier.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilsTests {

    @Test
    public void testGetRandom(){
        int result = Utils.getRandom(10);
        int maxExpectedResult = 10;
         assertTrue(maxExpectedResult >= result);
    }

    @Test
    public void testGetRandomTwo(){
        int result = Utils.getRandom(20);
        int maxExpectedResult = 20;
        assertTrue(maxExpectedResult >= result);
    }
}
