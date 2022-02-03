package com.example.myapplication3;

public class Sample {
    double width;
    double length;
    double height;

    Sample(double width, double length, double height){
        this.width = width;
        this.length = length;
        this.height = height;
    }

    double getVolume(){
        return (width*length*height);
    }
}
