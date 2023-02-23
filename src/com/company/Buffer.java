package com.company;

public class Buffer {

    private int bufferSize;
    private int store[];
    //    pointers to trigger in and out buffer
    private int inPtr = 0;
    private int outPtr = 0;
    public int counter;

    Semaphore spaces;
    Semaphore elements = new Semaphore(0);

    Buffer(int bufferSize){
        this.bufferSize=bufferSize;
        store = new int[bufferSize];
        spaces = new Semaphore(bufferSize);
    }

    public void produce(int value) {
        spaces.P();
        store[inPtr] = value;
        inPtr = (inPtr + 1) % bufferSize;
        elements.V();
    }

    public int consume() {
        int value;
        elements.P();
        value = store[outPtr];
        outPtr = (outPtr + 1) % bufferSize;
        spaces.V();
        return value;
    }
}
