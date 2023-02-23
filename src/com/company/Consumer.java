package com.company;

import java.io.*;

public class Consumer extends Thread {
    private String fileName;
    private Buffer buf;
    public int primeNo=0;
    public long endTime;
    public int maxPrime;
    public Consumer(Buffer buf,String fileName) {
        this.buf = buf;
        this.fileName=fileName;
    }

    public void run(){
        try{
            for(int  i=0;i<buf.counter;i++){
                BufferedWriter p =new BufferedWriter(new FileWriter(fileName,true));
                int x=buf.consume();
                maxPrime=x;
                primeNo+=1;
                if(i%20==0)
                    p.append("\n");
                p.append("'");
                p.append(Integer.toString(x));
                p.append("'");
                p.append(" ");
                p.close();
            }
            buf.counter=0;
            endTime=System.currentTimeMillis();
        }catch (IOException f){
            System.out.println("error in file");
            f.printStackTrace();
        }
    }
}
