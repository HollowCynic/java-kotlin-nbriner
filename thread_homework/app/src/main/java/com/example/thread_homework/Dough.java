package com.example.thread_homework;

import java.util.Objects;

public class Dough implements Comparable<Dough>{
    final int id;
    private int folds;
    private boolean baked;

    Dough(int id){this.id = id; this.folds = 0; this.baked = false;}


    public void fold(){
        folds++;
    }

    public int getFolds(){ return folds; }

    public int getID() { return id; }

    public void bake(){ baked = true;}

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Dough)) return false;
//        Dough dough = (Dough) o;
//        return id == dough.id && getFolds() == dough.getFolds() && baked == dough.baked;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getFolds(), baked);
    }

    @Override
    public boolean equals(Object o) {
        return compareTo((Dough) o) == 0;
    }

    @Override
    public int compareTo(Dough d) {
        int ans = Boolean.compare(baked, d.baked);
        if (ans != 0) return ans;
        ans = Integer.compare(folds, d.folds);
        if (ans != 0) return ans;
        ans = Double.compare(id,d.id);
        return ans;
    }

}

//public class Inventory
//indexOf
