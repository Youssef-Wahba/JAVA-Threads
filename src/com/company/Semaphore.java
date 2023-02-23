package com.company;

public class Semaphore {
    protected int value;

    protected Semaphore(){
        this.value=0;
    }

    protected Semaphore(int value){
        this.value=value;
    }
// wait
    protected synchronized void  P(){
        this.value--;
        if(value<0){
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("Semaphore wait error");
                e.printStackTrace();
            }
        }
    }
//  notify
    protected synchronized void V(){
        this.value++;
        if(value<=0){
            notify();
        }
    }
}
