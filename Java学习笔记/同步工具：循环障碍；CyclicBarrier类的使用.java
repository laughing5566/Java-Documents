//------------------------------同步工具：循环障碍；CyclicBarrier类的使用-------------------------
//可用于：集体出游设计
package ThreadTest;
import java.util.concurrent.*;
public class CyclicBarrierTest {
	public static void main(String[] args) {
		//创建一个可变长度的线程池
		ExecutorService executorService=Executors.newCachedThreadPool();
		final CyclicBarrier cb=new CyclicBarrier(3);
		for(int i=1;i<=3;i++){
			Runnable runnable=new Runnable(){
				public void run() {
					try {
						Thread.sleep((long)Math.random()*10000);
						System.out.println("线程"+Thread.currentThread().getName()+"到达集合点1，已有"+(cb.getNumberWaiting()+1)+"人到达,"+(cb.getNumberWaiting()==2?"都到齐了，继续走啊。":"人还没到齐，继续等待..."));
						cb.await();
						
						Thread.sleep((long)Math.random()*10000);
						System.out.println("线程"+Thread.currentThread().getName()+"到达集合点2，已有"+(cb.getNumberWaiting()+1)+"人到达,"+(cb.getNumberWaiting()==2?"都到齐了，继续走啊。":"人还没到齐，继续等待..."));
						cb.await();
						
						Thread.sleep((long)Math.random()*10000);
						System.out.println("线程"+Thread.currentThread().getName()+"到达集合点3，已有"+(cb.getNumberWaiting()+1)+"人到达,"+(cb.getNumberWaiting()==2?"都到齐了，继续走啊。":"人还没到齐，继续等待..."));
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
