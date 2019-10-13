//-------------------------同步工具：信号灯；Semaphore类的使用-----------------------------------
//可以控制同时访问资源的个数，实现多线程对同一资源的并发访问的控制；
//一个线程拿到灯可以由其他线程来释放，从而可以用于死锁恢复
package ThreadTest;

import java.util.concurrent.*;

public class SemaphoreTest {
	public static void main(String[] args) {
		//创建一个线程池
		ExecutorService executorService=Executors.newCachedThreadPool();
		//创建信号灯(3个信号灯),信号灯个数表示同时能进入执行的线程个数
		final Semaphore sp=new Semaphore(3);
		//循环10次，模拟创建10个线程
		for(int i=1;i<=10;i++){
			Runnable runnable=new Runnable(){
				public void run() {
					try {
						sp.acquire();//拿到信号灯
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					System.out.println(Thread.currentThread().getName()+"进入；现在有："+(3-sp.availablePermits())+"个并发正在执行。");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					sp.release();//释放信号灯
					System.out.println(Thread.currentThread().getName()+"已经离开；现在有："+(3-sp.availablePermits())+"个并发正在执行。");
				}
			};
			executorService.execute(runnable);//执行线程
		}
	}

}
