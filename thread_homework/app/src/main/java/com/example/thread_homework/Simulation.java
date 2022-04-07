package com.example.thread_homework;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Simulation implements AutoCloseable{

    private static String getRandomLine(String path){
        List<String> lines;
        try{
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
        Random random = new Random();
        return lines.get(random.nextInt(lines.size()));
    }

    Dough makeDough(){ return new Dough((int)(Math.random()*10000));}


    Baker makeBaker(Inventory inventory){
        String name = getRandomLine("src/main/java/com/example/thread_homework/names.txt");
        return new Baker(name, inventory);
    }

    Inventory makeInventory(){
        Inventory inventory = new Inventory();
        for(int i = 0; i < 10; i++){
            inventory.addDough(makeDough());
        }
        return inventory;
    }

    List<Baker> bakers = new ArrayList<>();
    void setup(){
        Inventory inventory = makeInventory();
        for(int i = 0; i <= 5; ++i){
            bakers.add(makeBaker(inventory));
        }
    }

    @Override
    public void close() {
        for (Baker baker : bakers) {
            baker.close();
        }
    }

    public void join() {
        close();
        for (Baker baker : bakers) {
            baker.join();
        }
    }
}
