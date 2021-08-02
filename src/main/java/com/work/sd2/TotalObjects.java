package com.work.sd2;

public class TotalObjects {
    private int object;
    public TotalObjects(){
        object = 0;
    }
    public void objectAdded(){
        object++;
    }
    public int getTotalObjects(){
        return object;
    }
}
