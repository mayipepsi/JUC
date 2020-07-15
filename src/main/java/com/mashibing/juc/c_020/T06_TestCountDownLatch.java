package com.mashibing.juc.c_020;

import java.util.concurrent.CountDownLatch;

public class T06_TestCountDownLatch   {
    private static final int MAX_PRINT_NUM = 100;
    private static volatile int count = 0;

    public  void printAB() {
        // 声明CountDownLatch
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread thread2 = new Thread(() -> {
            while (count < MAX_PRINT_NUM) {
                if (count % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + count);
                    count++;
                }
            }
            // 偶数线程执行完则计数器减一
            countDownLatch.countDown();
        });

        Thread thread1 =  new Thread(() -> {
            while (count < MAX_PRINT_NUM) {
                if (count % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + count);
                    count++;
                }
            }
            // 奇数线程执行完则计数器减一
            countDownLatch.countDown();
        });
        thread1.setName("奇数线程");
        thread2.setName("偶数线程");
        thread1.start();
        thread2.start();
        System.out.println("主线程1");
        try {
            countDownLatch.await();
        } catch (Exception e) {
        }
        System.out.println("主线程");
    }

    public static void main(String[] args) {
        T06_TestCountDownLatch t06_TestCountDownLatch = new T06_TestCountDownLatch();
        t06_TestCountDownLatch.printAB();
    }
}