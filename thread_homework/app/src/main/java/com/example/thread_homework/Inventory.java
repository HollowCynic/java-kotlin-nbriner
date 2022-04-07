package com.example.thread_homework;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

import kotlin.jvm.Synchronized;

public class Inventory {
    private ArrayList<Dough> doughSupply = new ArrayList<>();
    private ArrayList<Dough> bakedDough = new ArrayList<>();

    synchronized public Dough getDough(){
        if(doughSupply.size() > 0) {
            int randindex = (int) Math.random() * doughSupply.size();
            Dough retDough = doughSupply.get(randindex);
            doughSupply.remove(randindex);
            return retDough;
        }
        else
            return null;
    }

    public void addDough(Dough d){ doughSupply.add(d); }

    public void addBakedDough(Dough d){ bakedDough.add(d);}

    public int bakedDoughInventory(){
        return bakedDough.size();
    }

//    public int getSupplySize(){
//        return
//    }
    @RequiresApi
    synchronized public Dough getLeast() {
        Dough minDough = doughSupply.parallelStream()
                .min(Dough::compareTo)
                .get();
        doughSupply.remove(minDough);
        return minDough;
    }

    //maybe make a stream thing that returns dough under certain conditions
}
