//---------------------------------同步工具：计数器；CountDownLatch类----------------------------
//可模拟 裁判-运动员 赛跑场景，
//可以实现一个人等待多个人的通知或者一个人通知多个人的情况
package ThreadTest;
import java.util.concurrent.*;
public class CountDownLatchTest {
	public static void main(String[] args) {
		//创建一个可变长度的线程池
		ExecutorService executorService=Executors.newCachedThreadPool();
		final CountDownLatch cdOrder=new CountDownLatch(1);//模拟裁判
		final CountDownLatch cdAnswer=new CountDownLatch(3);//模拟3个运动员
		//模拟运动员
		for(int i=1;i<=3;i++){
			Runnable runnable=new Runnable(){
				public void run() {
					try {
						System.out.println("线程"+Thread.currentThread().getName()+"正在等待命令...");
						cdOrder.await();
						System.out.println("线程"+Thread.currentThread().getName()+"已接受命令");
						System.out.println("线程"+Thread.currentThread().getName()+"回应结果");
						cdAnswer.countDown();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			executorService.execute(runnable);
		}
		executorService.shutdown();
		
		//主线程模拟裁判
		try {
			Thread.sleep(1000);
			System.out.println("线程"+Thread.currentThread().getName()+"发布命令");
			cdOrder.countDown();
			System.out.println("线程"+Thread.currentThread().getName()+"已经发布命令，正在等待结果...");
			cdAnswer.await();
			System.out.println("线程"+Thread.currentThread().getName()+"已经收到响应结果。");
		} catch (Exception e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}

}
