package com.example.thread_homework;

public class Baker implements Runnable, AutoCloseable {
    String name;
    private Dough myDough;
    Inventory myInventory;
    boolean running = true;

    private final Thread t;

    public Baker(String name, Inventory inventory){
        this.name = name;
        myInventory = inventory;
        t = new Thread(this);
        t.start();
    }


    public void grabDough(Inventory inventory){ myDough = inventory.getDough(); }

    public void workDough(){
        if(myDough != null) {
            if (myDough.getFolds() >= 3) {
                myDough.bake();
                System.out.println(name + " baked dough " + myDough.getID());
                myInventory.addBakedDough(myDough);
                System.out.println("The inventory has " + myInventory.bakedDoughInventory() + " baked dough");
                //Move this to grab dough
                if(myInventory.bakedDoughInventory() == 10)
                    this.close();
                myDough = null;
            }
            else {
                for (int i = 1; i <= (int) (Math.random() * 4); i++) {
                    myDough.fold();
                    System.out.println(this.name + " worked dough " + myDough.getID());
                }
                myInventory.addDough(myDough);
                myDough = null;
            }
        }
        else
            grabDough(myInventory);
    }

     public void join(){
        for(;;){
            try{
                close();
                t.join(1000);
                return;
            } catch(InterruptedException e){
                //Don't do anything
            }
        }
    }

    @Override public void run(){
        while(running){
            try{
                grabDough(myInventory);
                workDough();
                try {
                    Thread.sleep(400);
                } finally {

                }
            } catch (InterruptedException ex){
                //Don't do anything
                //System.out.println("Exception thrown");
            }
        }
        System.out.println("" + this + " stopped.");
    }

    @Override public void close(){
        running = false;
        t.interrupt();
    }
}
