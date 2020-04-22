/**
 * volatile �ؼ��֣�ʹһ�������ڶ���̼߳�ɼ�
 * A B�̶߳��õ�һ��������javaĬ����A�߳��б���һ��copy���������B�߳��޸��˸ñ�������A�߳�δ��֪��
 * ʹ��volatile�ؼ��֣����������̶߳�������������޸�ֵ
 * 
 * ������Ĵ����У�running�Ǵ����ڶ��ڴ��t������
 * ���߳�t1��ʼ���е�ʱ�򣬻��runningֵ���ڴ��ж���t1�̵߳Ĺ������������й�����ֱ��ʹ�����copy��������ÿ�ζ�ȥ
 * ��ȡ���ڴ棬�����������߳��޸�running��ֵ֮��t1�̸߳�֪���������Բ���ֹͣ����
 * 
 * ʹ��volatile������ǿ�������̶߳�ȥ���ڴ��ж�ȡrunning��ֵ
 * 
 * �����Ķ���ƪ���½��и���������
 * http://www.cnblogs.com/nexiyi/p/java_memory_model_and_thread.html
 * 
 * volatile�����ܱ�֤����̹߳�ͬ�޸�running����ʱ�������Ĳ�һ�����⣬Ҳ����˵volatile�������synchronized
 * @author mashibing
 */
package com.mashibing.juc.c_012_Volatile;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class T01_HelloVolatile {
	 boolean running = true; //�Ա�һ������volatile������£������������н��������
	  synchronized void m() {
		System.out.println("m start");
		  try {
//			  for (int i=0;i<10000000;i++){
//				  UUID.randomUUID().toString();
//			  }
//			  System.out.println("�������");
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		  while(running) {
		}
		System.out.println("m end!");
	}

	synchronized void change(){
		System.out.println("�ı�M");
		running=false;
	}

	public static void main(String[] args) {
		T01_HelloVolatile t = new T01_HelloVolatile();
		
		new Thread(() -> {
			t.m();
		}).start();

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t.change();
	}
	
}


