/**
 * 有三个线程一次执行自己所对应的代码，并循环执行n次
 */
package ThreadTest;

import java.util.*;
import java.util.concurrent.locks.*;
class ConditionTest {
	public static void main(String[] args) {
		final BusinessResource br=new BusinessResource();
		//创建三个线程
		new Thread(new Runnable(){    //一号线程
			public void run() {
				for(int i=1;i<=5;i++){
					br.run1(i);
				}
			}
		}).start();
		
		new Thread(new Runnable(){    //二号线程
			public void run() {
				for(int i=1;i<=5;i++){
					br.run2(i);
				}
			}
		}).start();
		
		new Thread(new Runnable(){    //三号线程
			public void run() {
				for(int i=1;i<=5;i++){
					br.run3(i);
				}
			}
		}).start();
	}

}
//定义一个业务类
class BusinessResource{
	private Lock lock=new ReentrantLock();
	private Condition condition1=lock.newCondition();
	private Condition condition2=lock.newCondition();
	private Condition condition3=lock.newCondition();
	private int flag=1;//定义一个标记
	public void run1(int i)
	{
		lock.lock();
		try{
			if(flag!=1){
				try {
					condition1.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int j=1;j<=10;j++){
				System.out.println("一号："+j+"；loop of "+i);
			}
			flag=2;
			condition2.signal();
		}
		finally{
			lock.unlock();
		}
	}
	public void run2(int i)
	{
		lock.lock();
		try{
			if(flag!=2){
				try {
					condition2.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int j=1;j<=10;j++){
				System.out.println("二号："+j+"；loop of "+i);
			}
			flag=3;
			condition3.signal();
		}
		finally{
			lock.unlock();
		}
	}
	public void run3(int i)
	{
		lock.lock();
		try{
			if(flag!=3){
				try {
					condition3.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int j=1;j<=10;j++){
				System.out.println("三号："+j+"；loop of "+i);
			}
			flag=1;
			condition1.signal();
		}
		finally{
			lock.unlock();
		}
	}
}