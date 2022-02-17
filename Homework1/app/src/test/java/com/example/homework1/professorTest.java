package com.example.homework1;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

import org.junit.Test;


public class professorTest extends TestCase {

    professor defProfessor;
    professor MacEvoy;

    public void setUp() throws Exception {
        defProfessor = new professor();
        List<String> MacClasses = new ArrayList<String>();
        MacClasses.add("Java");
        MacClasses.add("Programming Languages");
        MacEvoy = new professor("Warren MacEvoy","Computer Science", 16 , MacClasses, 45.37, "Mustard Yellow");
    }

    public void tearDown() throws Exception {
    }

    public void testAddClass() {
    }

    public void testNumberOfClasses() {
    }

    public void testGetDescription() {
    }
}