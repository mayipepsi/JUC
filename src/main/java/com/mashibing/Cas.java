package com.mashibing;

public class Cas {

    enum ReadyToRun {T1,T2}
    static  volatile ReadyToRun r=ReadyToRun.T1;

    public static void main(String[] args) {
        char[] c1="1234".toCharArray();
        char[] c2="abcd".toCharArray();
        new Thread(()-> {
            for (char c: c1) {
                while (r!=ReadyToRun.T1){}/**自旋 不放弃CPU 在这里空转*/
                    System.out.println(c);
                    r=ReadyToRun.T2;
            }
        },"t1").start();
        new Thread(()-> {
            for (char c: c2) {
                while (r!=ReadyToRun.T2){ }
                    System.out.println(c);
                    r=ReadyToRun.T1;
            }
        },"t2").start();
    }

}
