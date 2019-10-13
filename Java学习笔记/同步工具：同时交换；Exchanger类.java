//---------------------------ͬ�����ߣ�ͬʱ������Exchanger��----------------------
//ʵ�������߳���ͬһʱ��������ݽ���������֮ǰ�����߳̽�һֱ���ڵȴ�״̬
package ThreadTest;
import java.util.concurrent.*;
public class ExchangerTest {
	public static void main(String[] args) {
		//����һ���ɱ䳤�ȵ��̳߳�
		ExecutorService executorService=Executors.newCachedThreadPool();
		final Exchanger ex=new Exchanger();
		//�߳�1
		Runnable runnable1=new Runnable(){
			public void run() {
				try {
					String data1="data1";
					System.out.println("�߳�"+Thread.currentThread().getName()+"��׼����"+data1+"����ȥ��");
					Thread.sleep((long)Math.random()*10000);
					String data2=(String)ex.exchange(data1);
					System.out.println("�߳�"+Thread.currentThread().getName()+"���ص�����Ϊ��"+data2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		executorService.execute(runnable1);
		//�߳�2
		Runnable runnable2=new Runnable(){
			public void run() {
				try {
					String data1="data2";
					System.out.println("�߳�"+Thread.currentThread().getName()+"��׼����"+data1+"����ȥ��");
					Thread.sleep((long)Math.random()*10000);
					String data2=(String)ex.exchange(data1);
					System.out.println("�߳�"+Thread.currentThread().getName()+"���ص�����Ϊ��"+data2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		executorService.execute(runnable2);
	}

}
