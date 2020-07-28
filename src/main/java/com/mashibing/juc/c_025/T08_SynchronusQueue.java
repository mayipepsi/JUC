package com.mashibing.juc.c_025;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 可以理解为一个线程递到了另一个线程的手里
 * 中间的队列是不存在的
 */
public class T08_SynchronusQueue { //容量为0
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> strs = new SynchronousQueue<>();
		
		new Thread(()->{
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		strs.put("aaa"); //阻塞等待消费者消费   前面等着拿东西的时候才可以往里装
		//strs.put("bbb");
		//strs.add("aaa");
		System.out.println(strs.size());
	}
}
