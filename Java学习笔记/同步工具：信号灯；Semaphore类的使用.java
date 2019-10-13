//-------------------------ͬ�����ߣ��źŵƣ�Semaphore���ʹ��-----------------------------------
//���Կ���ͬʱ������Դ�ĸ�����ʵ�ֶ��̶߳�ͬһ��Դ�Ĳ������ʵĿ��ƣ�
//һ���߳��õ��ƿ����������߳����ͷţ��Ӷ��������������ָ�
package ThreadTest;

import java.util.concurrent.*;

public class SemaphoreTest {
	public static void main(String[] args) {
		//����һ���̳߳�
		ExecutorService executorService=Executors.newCachedThreadPool();
		//�����źŵ�(3���źŵ�),�źŵƸ�����ʾͬʱ�ܽ���ִ�е��̸߳���
		final Semaphore sp=new Semaphore(3);
		//ѭ��10�Σ�ģ�ⴴ��10���߳�
		for(int i=1;i<=10;i++){
			Runnable runnable=new Runnable(){
				public void run() {
					try {
						sp.acquire();//�õ��źŵ�
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					System.out.println(Thread.currentThread().getName()+"���룻�����У�"+(3-sp.availablePermits())+"����������ִ�С�");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					sp.release();//�ͷ��źŵ�
					System.out.println(Thread.currentThread().getName()+"�Ѿ��뿪�������У�"+(3-sp.availablePermits())+"����������ִ�С�");
				}
			};
			executorService.execute(runnable);//ִ���߳�
		}
	}

}
