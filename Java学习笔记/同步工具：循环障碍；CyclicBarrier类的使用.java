//------------------------------ͬ�����ߣ�ѭ���ϰ���CyclicBarrier���ʹ��-------------------------
//�����ڣ�����������
package ThreadTest;
import java.util.concurrent.*;
public class CyclicBarrierTest {
	public static void main(String[] args) {
		//����һ���ɱ䳤�ȵ��̳߳�
		ExecutorService executorService=Executors.newCachedThreadPool();
		final CyclicBarrier cb=new CyclicBarrier(3);
		for(int i=1;i<=3;i++){
			Runnable runnable=new Runnable(){
				public void run() {
					try {
						Thread.sleep((long)Math.random()*10000);
						System.out.println("�߳�"+Thread.currentThread().getName()+"���Ｏ�ϵ�1������"+(cb.getNumberWaiting()+1)+"�˵���,"+(cb.getNumberWaiting()==2?"�������ˣ������߰���":"�˻�û���룬�����ȴ�..."));
						cb.await();
						
						Thread.sleep((long)Math.random()*10000);
						System.out.println("�߳�"+Thread.currentThread().getName()+"���Ｏ�ϵ�2������"+(cb.getNumberWaiting()+1)+"�˵���,"+(cb.getNumberWaiting()==2?"�������ˣ������߰���":"�˻�û���룬�����ȴ�..."));
						cb.await();
						
						Thread.sleep((long)Math.random()*10000);
						System.out.println("�߳�"+Thread.currentThread().getName()+"���Ｏ�ϵ�3������"+(cb.getNumberWaiting()+1)+"�˵���,"+(cb.getNumberWaiting()==2?"�������ˣ������߰���":"�˻�û���룬�����ȴ�..."));
						cb.await();
					} catch (Exception e) {
						e.printStackTrace();
					} 
				};
			};
			executorService.execute(runnable);
		}
	}

}
