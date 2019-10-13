//---------------------------------ͬ�����ߣ���������CountDownLatch��----------------------------
//��ģ�� ����-�˶�Ա ���ܳ�����
//����ʵ��һ���˵ȴ�����˵�֪ͨ����һ����֪ͨ����˵����
package ThreadTest;
import java.util.concurrent.*;
public class CountDownLatchTest {
	public static void main(String[] args) {
		//����һ���ɱ䳤�ȵ��̳߳�
		ExecutorService executorService=Executors.newCachedThreadPool();
		final CountDownLatch cdOrder=new CountDownLatch(1);//ģ�����
		final CountDownLatch cdAnswer=new CountDownLatch(3);//ģ��3���˶�Ա
		//ģ���˶�Ա
		for(int i=1;i<=3;i++){
			Runnable runnable=new Runnable(){
				public void run() {
					try {
						System.out.println("�߳�"+Thread.currentThread().getName()+"���ڵȴ�����...");
						cdOrder.await();
						System.out.println("�߳�"+Thread.currentThread().getName()+"�ѽ�������");
						System.out.println("�߳�"+Thread.currentThread().getName()+"��Ӧ���");
						cdAnswer.countDown();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			executorService.execute(runnable);
		}
		executorService.shutdown();
		
		//���߳�ģ�����
		try {
			Thread.sleep(1000);
			System.out.println("�߳�"+Thread.currentThread().getName()+"��������");
			cdOrder.countDown();
			System.out.println("�߳�"+Thread.currentThread().getName()+"�Ѿ�����������ڵȴ����...");
			cdAnswer.await();
			System.out.println("�߳�"+Thread.currentThread().getName()+"�Ѿ��յ���Ӧ�����");
		} catch (Exception e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}

}
