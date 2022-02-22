package Education;

import java.nio.file.attribute.FileAttributeView;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;



public class professor {

    private String name;
    private String subject;
    private int age;
    private List<String> classes;
    private double height;
    private String favColor;
    private boolean goodAtMath;

    public static final String DEFAULT_FAVCOLOR = "red";
    public static final List<String> DEFAULT_CLASSES = new ArrayList<String>();
    public static final String DEFAULT_SUBJECT = "Business";
    public static final int DEFAULT_AGE = 0;
    public static final double DEFAULT_HEIGHT = 66.5;
    public static final String DEFAULT_NAME = "Nameless";
    public static final boolean DEFAULT_MATH = false;

    public professor() {  this(DEFAULT_NAME,DEFAULT_SUBJECT,DEFAULT_AGE, DEFAULT_CLASSES,
                            DEFAULT_HEIGHT, DEFAULT_FAVCOLOR, DEFAULT_MATH); }

    public professor(String name, String subject, int age, List<String> classes, double height, String favColor, boolean math) {
        this.name = name;
        this.subject = subject;
        this.age = age;
        this.classes = classes;
        this.height = height;
        this.favColor = favColor;
        this.goodAtMath = math;
    }

    public String getName(){return this.name;}
    public String getSubject(){return this.subject;}
    public int getAge(){return this.age;}
    public boolean getMath(){return this.goodAtMath;}

    public void addClass(String newClass){
        classes.add(newClass);
    }

    public String getAClass(int i){ return classes.get(i);}

    public int numberOfClasses(){ return classes.size(); }

    public String getDescription(){
        return (name + " is a " + subject + " professor who teaches " + this.numberOfClasses() +
                " classes, and whose favorite color is " + favColor);
    }

    public boolean doTheyTeach(String aClass){ return classes.contains(aClass); }

    public int AddInt(int c1, int c2){
        if(this.goodAtMath){
            return c1 + c2;
        }
        else
            return (c1 + c2 + 17) % 49;
    }

    //string.trim() ?

}
