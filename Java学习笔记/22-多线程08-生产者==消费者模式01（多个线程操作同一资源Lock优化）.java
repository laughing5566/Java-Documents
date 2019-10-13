/**
--------------------------------------------生产者==消费者模式示例(使用Lock对象优化)----------------------------------------------------
*/
import java.util.concurrent.locks.*;

class Demo
{
	public static void main(String[] args) 
	{
		Res r=new Res();
		Producer pro=new Producer(r);
		Consumer con=new Consumer(r);
		Thread p1=new Thread(pro);
		Thread p2=new Thread(pro);
		Thread c1=new Thread(con);
		Thread c2=new Thread(con);
		p1.start();
		p2.start();
		c1.start();
		c2.start();
	}
}
class Res
{
	private String name;
	private int num=1;
	private boolean flag=false;
	private Lock lock=new ReentrantLock();//创建一个锁对象
	private Condition condition_pro=lock.newCondition();//创建一个Producer的Condition对象
	private Condition condition_con=lock.newCondition();//创建一个Consumer的Condition对象

	public void set(String name) throws InterruptedException//因为await()方法抛出了异常
	{
		lock.lock();//上锁
		try
		{
			while(flag)
			{
				condition_pro.await();//使线程进入等待状态
			}
			this.name=name+"..."+num++;
			System.out.println(Thread.currentThread().getName()+"...生产者"+this.name);
			flag=true;
			//condition.signalAll();//唤醒的是所有处于等待的线程
			condition_con.signal();//本方只唤醒对方处于等待的线程
		}
		finally
		{
			lock.unlock();//解锁
		}
		
	}
	public void out() throws InterruptedException//因为await()方法抛出了异常
	{
		lock.lock();//上锁
		try
		{
				while(!flag)
				{
					condition_con.await();//使线程进入等待状态
				}
				System.out.println(Thread.currentThread().getName()+"...消费者........"+name);
				flag=false;
				//condition.signalAll();//唤醒的是所有处于等待的线程
				condition_pro.signal();//本方只唤醒对方处于等待的线程
		}
		finally
		{
			lock.unlock();//解锁
		}
	}
}
//生产者
class Producer implements Runnable
{
	private Res r;
	Producer(Res r)
	{
		this.r=r;
	}
	public void run()
	{
		while (true)
		{
			try
			{
				r.set("++商品++");
			}
			catch (InterruptedException e)
			{
			}
		}
	}
}
//消费者
class Consumer implements Runnable
{
	private Res r;
	Consumer(Res r)
	{
		this.r=r;
	}
	public void run()
	{
		while (true)
		{
			try
			{
				r.out();
			}
			catch (InterruptedException e)
			{
			}
		}
	}
}
