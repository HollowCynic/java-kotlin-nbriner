package com.example.myapplication3;

import junit.framework.TestCase;

public class SampleTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testGetVolume() {
        Sample plywood = new Sample(4*12, 8*12, 3.0/8.0);

        double expect = 4*12 * 8*12 * 3.0/8.0;

        assertEquals(expect, plywood.getVolume(), 0.000_000_1);
    }
}