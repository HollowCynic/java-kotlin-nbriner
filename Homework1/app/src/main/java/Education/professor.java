package Education;

import java.nio.file.attribute.FileAttributeView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.Objects;
import java.util.TreeSet;

public class professor implements Comparable<professor> {

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

//    public professor get(){
//        return(this);
//    }

    @Override
    public boolean equals(Object o) {
        return compareTo((professor) o) == 0;
    }

//    @Override
//    public Object clone(){
//        return new professor(this);
//    }

//    public professor(professor copy) {
//        this(copy.name,copy.subject,copy.age, copy.classes, copy.height, copy.favColor, copy.goodAtMath);
//    }
//
//    @Override public Object clone() {
//        return new professor(this);
//    }


//    return getAge() == professor.getAge() && Double.compare(professor.height, height) == 0 &&
//    goodAtMath == professor.goodAtMath && getName().equals(professor.getName()) &&
//    getSubject().equals(professor.getSubject()) && classes.equals(professor.classes) &&
//            favColor.equals(professor.favColor);

    @Override
    public int compareTo(professor prof){
        int ans = name.compareTo(prof.name);
        if (ans != 0) return ans;
        ans = subject.compareTo(prof.subject);
        if (ans != 0) return ans;
        ans = Integer.compare(prof.age, age);
        if (ans != 0) return ans;
        Collections.sort(classes);
        Collections.sort(prof.classes);
        ans = (classes.equals(prof.classes) ? 0 : 1);
        if (ans != 0) return ans;
        ans = Double.compare(prof.height, height);
        if (ans != 0) return ans;
        ans = favColor.compareTo(prof.favColor);
        if (ans != 0) return ans;
        ans = Boolean.compare(prof.goodAtMath, goodAtMath);
        return ans;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSubject(), getAge(), classes, height, favColor, goodAtMath);
    }
}

