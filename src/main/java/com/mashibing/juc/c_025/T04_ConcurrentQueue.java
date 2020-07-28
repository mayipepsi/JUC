package com.mashibing.juc.c_025;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/***
 * ������QUEUE��LIST������
 * queue�����һЩ���߳��Ѻõ�API poll offer peek
 * ����BlockingQueue  �������put takeʵ������������ ������Ȼ��Ȼ��ʵ�������ߺ�������ģ��
 * �����ߺ�������MQ�Ļ���
 */
public class T04_ConcurrentQueue {
	public static void main(String[] args) {
		Queue<String> strs = new ConcurrentLinkedQueue<>();
		
		for(int i=0; i<10; i++) {
			strs.offer("a" + i);  //add �ӽ�ȥ �Ӳ���ȥ�����һ������ֵ
		}
		
		System.out.println(strs);
		
		System.out.println(strs.size());
		
		System.out.println(strs.poll());// ȡ ����remove��
		System.out.println(strs.size());
		
		System.out.println(strs.peek());//ȡ ������remove��
		System.out.println(strs.size());
		
		//˫�˶���Deque
	}
}
