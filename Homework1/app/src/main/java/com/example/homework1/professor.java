package com.example.homework1;

import java.nio.file.attribute.FileAttributeView;
import java.util.ArrayList;
import java.util.List;



public class professor {

    private String name;
    private String subject;
    private int age;
    private List<String> classes;
    private double height;
    private String favColor;

    public static final String DEFAULT_FAVCOLOR = "red";
    public static final List<String> DEFAULT_CLASSES = new ArrayList<String>();
    public static final String DEFAULT_SUBJECT = "Business";
    public static final int DEFAULT_AGE = 0;
    public static final double DEFAULT_HEIGHT = 66.5;
    public static final String DEFAULT_NAME = "Nameless";

    public professor() {  this(DEFAULT_NAME,DEFAULT_SUBJECT,DEFAULT_AGE, DEFAULT_CLASSES, DEFAULT_HEIGHT, DEFAULT_FAVCOLOR); }

    public professor(String name, String subject, int age, List<String> classes, double height, String favColor) {
        this.name = name;
        this.subject = subject;
        this.age = age;
        this.classes = classes;
        this.height = height;
        this.favColor = favColor;
    }

    public void addClass(String newClass){
        classes.add(newClass);
    }

    public int numberOfClasses(){
        return classes.size();
    }

    public String getDescription(){
        return (name + "is a " + subject + " professor who teaches " + this.numberOfClasses() +
                "classes, and whose favorite color is " + favColor);
    }
}
