package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class guiiiiii extends JFrame implements ActionListener{
    JPanel n =new JPanel();
    JButton b1 = new JButton("Start Producer");
    JTextField b2 = new JTextField();
    JTextField b3 = new JTextField();
    JTextField b4 = new JTextField();
    JEditorPane b5 =new JEditorPane();
    JEditorPane b6 =new JEditorPane();
    JEditorPane b7 =new JEditorPane();
    JEditorPane b8 =new JEditorPane();
    JEditorPane b9 =new JEditorPane();
    JLabel b10 = new JLabel("N");
    JLabel b11 = new JLabel("BUFFER SIZE");
    JLabel b12 = new JLabel("OUTPUT FILE");
    JLabel b13 = new JLabel("THE LARGEST PRIME NUMBER");
    JLabel b14 = new JLabel("# OF ELEMENTS(PRIME NUMBER)GENERATED");
    JLabel b15 = new JLabel("TIME ELAPSED SINCE THE START OF PROCCESSING");
    JSeparator b16 =new JSeparator();
    JSeparator b17 =new JSeparator();
    JSeparator b18 =new JSeparator();
    JLabel b19 = new JLabel("#");
    JLabel b20 = new JLabel("#");
    JLabel b21 = new JLabel("#");

    public guiiiiii(){
        fop();
    }
    public void fop(){

        setSize(460,420);
        setTitle("Threads Assignment");
        setVisible(true);
        setLocation(600, 200);
        setResizable(false);
        setLayout(new GridLayout(1,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(n);
        n.setBackground(Color.getHSBColor(345, 51, 100));
        n.setLayout(null);
        b1.setBounds(50, 185, 120, 30);
        b2.setBounds(30, 30,180, 30);
        b3.setBounds(30, 85,180, 30);
        b4.setBounds(30, 140,180, 30);
        b5.setBounds(0, 230,450, 20);
        b6.setBounds(0, 0,450, 20);
        b7.setBounds(0, 368,450, 20);
        b8.setBounds(0, 0,7, 390);
        b9.setBounds(440, 0,10, 390);
        b10.setBounds(220, 30,80, 20);
        b11.setBounds(220, 85,80, 20);
        b12.setBounds(220, 144,80, 20);
        b13.setBounds(10, 260,300, 20);
        b14.setBounds(10, 290,300, 20);
        b15.setBounds(10, 320,340, 20);
        b16.setBounds(10, 279,300, 20);
        b17.setBounds(10, 310,300, 20);
        b18.setBounds(10, 340,300, 20);
        b19.setBounds(340, 260,300, 20);
        b20.setBounds(340, 290,300, 20);
        b21.setBounds(340, 320,300, 20);
        n.add(b1);
        n.add(b2);
        n.add(b3);
        n.add(b4);
        n.add(b5);
        n.add(b6);
        n.add(b7);
        n.add(b8);
        n.add(b9);
        n.add(b10);
        n.add(b11);
        n.add(b12);
        n.add(b13);
        n.add(b14);
        n.add(b15);
        n.add(b16);
        n.add(b17);
        n.add(b18);
        n.add(b19);
        n.add(b20);
        n.add(b21);
        b1.setBackground(Color.gray);
        b1.setForeground(Color.black);
        b5.setBackground(Color.black);
        b6.setBackground(Color.black);
        b7.setBackground(Color.black);
        b8.setBackground(Color.black);
        b9.setBackground(Color.black);
        b10.setForeground(Color.black);
        b13.setForeground(Color.black);
        b14.setForeground(Color.black);
        b15.setForeground(Color.black);
        b16.setForeground(Color.black);
        b17.setForeground(Color.black);
        b18.setForeground(Color.black);
        b19.setForeground(Color.black);
        b20.setForeground(Color.black);
        b21.setForeground(Color.black);
        b1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            String s1 = b2.getText().toString(); // N
            String s2 = b3.getText().toString(); // buffer
            String s3 = b4.getText().toString(); // output file
            int x1=Integer.parseInt(s1);
            int x2=Integer.parseInt(s2);
            long startTime = System.currentTimeMillis();
            Buffer b=new Buffer(x2);
            Producer p =new Producer(b,x1);
            Consumer c = new Consumer(b, s3);
            try {
                p.start();
                c.start();  c.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            b19.setText(Integer.toString(c.maxPrime));
            b20.setText(Integer.toString(c.primeNo));
            b21.setText(Long.toString(c.endTime-startTime)+" ms");
        }
    }
}
