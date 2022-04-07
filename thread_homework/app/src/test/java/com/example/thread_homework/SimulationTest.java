package com.example.thread_homework;

import junit.framework.TestCase;
import static org.junit.Assert.*;


import org.junit.Test;

public class SimulationTest {

    @Test
    public void testLeast(){
        Inventory I = new Inventory();
        Dough d1 = new Dough(123456);
        d1.fold();
        I.addDough(d1);
        Dough d2 = new Dough(756327);
        d2.fold(); d2.fold();
        I.addDough(d2);
        Dough minDough = new Dough(17565);
        I.addDough(minDough);
        assertEquals(minDough, I.getLeast());
    }

    @Test
    public void sim() throws Exception {
        System.out.println("Baking Start...");

        try (Simulation sim = new Simulation()) {
            sim.setup();
            Thread.sleep(30_000);
            System.out.println();
            sim.join();
        }
        System.out.println("Stopped...");
    }
}