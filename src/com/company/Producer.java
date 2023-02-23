package com.company;

public class Producer extends Thread{
    private Buffer buf;
    private int val;

    public Producer(Buffer buf,int val) {
        this.buf = buf;
        this.val=val;
    }

    public void run() {
            boolean flag=true;
            for (int i = 1; i <= val; i++){
                if (i <= 1) flag=false;
                for (int j = 2; j < i; j++){
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    buf.produce(i);
                    buf.counter++;
                }
                flag=true;
            }
    }
}