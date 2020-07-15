package com.mashibing.juc.c_020;

import java.util.concurrent.CountDownLatch;

public class T06_TestCountDownLatch   {
    private static final int MAX_PRINT_NUM = 100;
    private static volatile int count = 0;

    public  void printAB() {
        // ����CountDownLatch
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread thread2 = new Thread(() -> {
            while (count < MAX_PRINT_NUM) {
                if (count % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + count);
                    count++;
                }
            }
            // ż���߳�ִ�������������һ
            countDownLatch.countDown();
        });

        Thread thread1 =  new Thread(() -> {
            while (count < MAX_PRINT_NUM) {
                if (count % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + count);
                    count++;
                }
            }
            // �����߳�ִ�������������һ
            countDownLatch.countDown();
        });
        thread1.setName("�����߳�");
        thread2.setName("ż���߳�");
        thread1.start();
        thread2.start();
        System.out.println("���߳�1");
        try {
            countDownLatch.await();
        } catch (Exception e) {
        }
        System.out.println("���߳�");
    }

    public static void main(String[] args) {
        T06_TestCountDownLatch t06_TestCountDownLatch = new T06_TestCountDownLatch();
        t06_TestCountDownLatch.printAB();
    }
}