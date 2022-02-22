package com.example.homework1;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import java.util.Arrays;

import org.junit.Test;

import Education.professor;


public class professorTest extends TestCase {

    professor defProfessor;
    professor MacEvoy;

    public void setUp() throws Exception {
        defProfessor = new professor();
        List<String> MacClasses = new ArrayList<String>(Arrays.asList("Interpretive Dance",
                                        "Intermediate Theory of German Influenced Puppetry"));

        MacEvoy = new professor("Warren MacEvoy","Computer Science", 16 ,
                MacClasses, 45.37, "Mustard Yellow", true);
        defProfessor.addClass("Philosophy Of Nothingness");
    }

    @Test
    public void testmake(){
        assertEquals(professor.DEFAULT_NAME,defProfessor.getName());
        assertEquals(professor.DEFAULT_SUBJECT,defProfessor.getSubject());
        assertEquals(professor.DEFAULT_AGE,defProfessor.getAge());
        assertEquals(professor.DEFAULT_MATH,defProfessor.getMath());

        assertEquals("Warren MacEvoy",MacEvoy.getName());
        assertEquals("Computer Science",MacEvoy.getSubject());
        assertEquals(16,MacEvoy.getAge());
        assertEquals(true,MacEvoy.getMath());
    }

    @Test
    public void testAddGetClasses(){
        MacEvoy.addClass("Java-Kotlin");
        MacEvoy.addClass("Swan Appreciation");
        assertEquals("Philosophy Of Nothingness", defProfessor.getAClass(0));
        assertEquals("Swan Appreciation", MacEvoy.getAClass(3));
    }

    @Test
    public void testNumberOfClasses() {

        assertEquals(1, defProfessor.numberOfClasses());
        assertEquals(2, MacEvoy.numberOfClasses());
        MacEvoy.addClass("Swan Appreciation");
        defProfessor.addClass("A Bad Class");
        assertEquals(2, defProfessor.numberOfClasses());
        assertEquals(3, MacEvoy.numberOfClasses());

        assertEquals(false, defProfessor.doTheyTeach("Swan Appreciation"));
        assertEquals(true, MacEvoy.doTheyTeach("Swan Appreciation"));
    }

    @Test
    public void testDoTheyTeach() {
        MacEvoy.addClass("Swan Appreciation");
        assertEquals(true,MacEvoy.doTheyTeach("Interpretive Dance"));
        assertEquals(true,MacEvoy.doTheyTeach("Swan Appreciation"));
        assertEquals(false,MacEvoy.doTheyTeach("Kung Fu"));
    }

    @Test
    public void testGetDescription() {
        assertEquals("Warren MacEvoy is a Computer Science professor who teaches 2 classes," +
                " and whose favorite color is Mustard Yellow", MacEvoy.getDescription());
    }

    @Test
    public void testMathSkills(){
        assertEquals((90+17)%49,defProfessor.AddInt(40,50));
        assertEquals(17 + 98, MacEvoy.AddInt(17,98));
    }
}