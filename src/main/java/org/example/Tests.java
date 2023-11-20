package org.example;


import org.example.Variant4;
import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void testInputOutputTask() {
        Variant4 variant = new Variant4();
        assertEquals(0, variant.inputOutputTask(0));

    }

    @Test
    public void testIntegerNumbersTask() {
        Variant4 variant = new Variant4();
        assertEquals(2, variant.integerNumbersTask(6, 3));
        assertEquals(3, variant.integerNumbersTask(9, 3));
        assertEquals(0, variant.integerNumbersTask(0, 5));
    }

    @Test
    public void testBooleanTask() {
        Variant4 variant = new Variant4();
        assertTrue(variant.booleanTask(3, 6));
        assertFalse(variant.booleanTask(1, 5));
        assertFalse(variant.booleanTask(4, 7));
    }

    @Test
    public void testIfTask() {
        Variant4 variant = new Variant4();
        assertEquals(2, variant.ifTask(1, 2, -3));
        assertEquals(2, variant.ifTask(4, -5, 6));
        assertEquals(0, variant.ifTask(-7, -8, -9));
    }

    @Test
    public void testSwitchTask() {
        Variant4 variant = new Variant4();
        assertEquals(31, variant.switchTask(1));
        assertEquals(28, variant.switchTask(2));
        assertEquals(30, variant.switchTask(4));
        assertEquals(29, variant.switchTask(13));
    }

     @Test
    public void testSwitchTaskInvalidMonth() {
        Variant4 variant = new Variant4();
        // Testing invalid month
        assertThrows(IllegalArgumentException.class, () -> variant.switchTask(13));
    }
    
    @Test
    public void testForTask() {
        Variant4 variant = new Variant4();
        double[] expected = {5.0, 10.0, 15.0, 20.0, 25.0, 30.0, 35.0, 40.0, 45.0, 50.0};
        assertArrayEquals(expected, variant.forTask(5), 0.01);
    }

    @Test
    public void testWhileTask() {
        Variant4 variant = new Variant4();
        assertFalse(variant.whileTask(27));
        assertFalse(variant.whileTask(9));
        assertTrue(variant.whileTask(1));
    }

    @Test
    public void testArrayTask() {
        Variant4 variant = new Variant4();
        int[] expected = {2, 6, 18, 54, 162};
        assertArrayEquals(expected, variant.arrayTask(5, 2, 3));
    }

    @Test
    public void testTwoDimensionArrayTask() {
        Variant4 variant = new Variant4();
        int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertArrayEquals(expected, variant.twoDimensionArrayTask(3, 3));
    }
}
