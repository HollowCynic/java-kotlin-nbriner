package com.example.homework1;

import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import junit.framework.TestCase;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import javax.crypto.Mac;

import Education.professor;
import kotlin.random.Random;


public class professorTest extends TestCase {

    professor defProfessor;
    professor MacEvoy;
    professor OtherMacEvoy;

    String [] names = {"MacEvoy", "El Poobah Grande", "J.D. Salinger" , "Jim"};
    int i = 0;
    public void setUp() throws Exception {
        defProfessor = new professor();
        List<String> MacClasses = new ArrayList<String>(Arrays.asList("Interpretive Dance",
                                        "Intermediate Theory of German Influenced Puppetry"));

        MacEvoy = new professor("Warren MacEvoy","Computer Science", 16 ,
                MacClasses, 45.37, "Mustard Yellow", true);
        //defProfessor.addClass("Philosophy Of Nothingness");
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
        defProfessor.addClass("Philosophy Of Nothingness");
        MacEvoy.addClass("Java-Kotlin");
        MacEvoy.addClass("Swan Appreciation");
        assertEquals("Philosophy Of Nothingness", defProfessor.getAClass(0));
        assertEquals("Swan Appreciation", MacEvoy.getAClass(3));
    }

    @Test
    public void testNumberOfClasses() {
        defProfessor.addClass("Philosophy Of Nothingness");
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

    //@test equals ?



    @Test
    public void testHash(){

    }
//    @Test
//    public void swanMap(){
//        Map<Swan,Long> barCodes = new TreeMap<Swan,Long>();
//        barCodes.put(getSwan("grey"),123_234_234_234_242L);
//        barCodes.put(getSwan("white"),33L);
//        assertEquals(null, barCodes.get(getSwan("black")));
//        assertEquals(new Long(123_234_234_234_242L), barCodes.get(getSwan("grey")));
//    }

    @Test
    public void testProfessorMap(){
        Map<professor, String> namedProfessors = new TreeMap<>();
        namedProfessors.put(MacEvoy, "Warren");
        namedProfessors.put(defProfessor, "Spanko");
        assertFalse(defProfessor.equals(MacEvoy));
        assertTrue(defProfessor.equals(defProfessor));
        assertEquals("Spanko", namedProfessors.get(defProfessor));
        assertEquals("Warren",namedProfessors.get(MacEvoy));
        assertEquals(null, namedProfessors.get(new professor("jim", professor.DEFAULT_SUBJECT,
                professor.DEFAULT_AGE, professor.DEFAULT_CLASSES, professor.DEFAULT_HEIGHT,
                professor.DEFAULT_FAVCOLOR, false)));
        assertEquals(2, namedProfessors.size());
    }
    @Test
    public void testMapProfessor(){
        Map<String, professor> profMap = new TreeMap<>();
        profMap.put("Warren", MacEvoy);
        profMap.put("jobloopo", defProfessor);
        assertEquals(MacEvoy, profMap.get("Warren"));
        assertEquals(defProfessor, profMap.get("jobloopo"));
        assertEquals(null, profMap.get("AnkleSpanker"));
    }

    @Test
    public void testProfessorSet(){
        Set<professor> profSet = new HashSet<>();
        profSet.add(MacEvoy);
        profSet.add(defProfessor);
        assertEquals(2, profSet.size());
        assertEquals(true, profSet.contains(MacEvoy));
        assertFalse(profSet.contains(new professor("jim", professor.DEFAULT_SUBJECT,
                professor.DEFAULT_AGE, professor.DEFAULT_CLASSES, professor.DEFAULT_HEIGHT,
                professor.DEFAULT_FAVCOLOR, false)));
    }
}