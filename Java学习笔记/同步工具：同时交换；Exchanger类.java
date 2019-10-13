//---------------------------同步工具：同时交换；Exchanger类----------------------
//实现两个线程在同一时间进行数据交换。再则之前两个线程将一直处于等待状态
package ThreadTest;
import java.util.concurrent.*;
public class ExchangerTest {
	public static void main(String[] args) {
		//创建一个可变长度的线程池
		ExecutorService executorService=Executors.newCachedThreadPool();
		final Exchanger ex=new Exchanger();
		//线程1
		Runnable runnable1=new Runnable(){
			public void run() {
				try {
					String data1="data1";
					System.out.println("线程"+Thread.currentThread().getName()+"正准备把"+data1+"换出去。");
					Thread.sleep((long)Math.random()*10000);
					String data2=(String)ex.exchange(data1);
					System.out.println("线程"+Thread.currentThread().getName()+"换回的数据为："+data2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		executorService.execute(runnable1);
		//线程2
		Runnable runnable2=new Runnable(){
			public void run() {
				try {
					String data1="data2";
					System.out.println("线程"+Thread.currentThread().getName()+"正准备把"+data1+"换出去。");
					Thread.sleep((long)Math.random()*10000);
					String data2=(String)ex.exchange(data1);
					System.out.println("线程"+Thread.currentThread().getName()+"换回的数据为："+data2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		executorService.execute(runnable2);
	}

}
