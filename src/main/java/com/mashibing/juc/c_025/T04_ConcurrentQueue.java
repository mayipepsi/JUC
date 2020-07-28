package com.mashibing.juc.c_025;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/***
 * 面试题QUEUE和LIST的区别
 * queue添加了一些对线程友好的API poll offer peek
 * 子类BlockingQueue  又添加了put take实现了阻塞操作 可以自然而然的实现生产者和消费者模型
 * 生产者和消费者MQ的基础
 */
public class T04_ConcurrentQueue {
	public static void main(String[] args) {
		Queue<String> strs = new ConcurrentLinkedQueue<>();
		
		for(int i=0; i<10; i++) {
			strs.offer("a" + i);  //add 加进去 加不进去会给你一个返回值
		}
		
		System.out.println(strs);
		
		System.out.println(strs.size());
		
		System.out.println(strs.poll());// 取 并且remove掉
		System.out.println(strs.size());
		
		System.out.println(strs.peek());//取 但不会remove掉
		System.out.println(strs.size());
		
		//双端队列Deque
	}
}
