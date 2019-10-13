/**
--------------------------------------------------生产者==消费者模式示例(使用synchronized)----------------------------------------------------
*/
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
	public synchronized void set(String name)
	{
		while(flag)
		{
			try
			{
				this.wait();
			}
			catch (Exception e)
			{
			}
		}
			this.name=name+"..."+num++;
			System.out.println(Thread.currentThread().getName()+"...生产者"+this.name);
			flag=true;
			this.notifyAll();//唤醒所有处于等待的线程(使用notifyAll()方法主要是为了唤醒对方的线程，但notifyAll()方法却唤醒了所有的线程，同时却连本方的线程也唤醒了，有一定的局限性。有待优化！)
	}
	public synchronized void out()
	{
		while (true)
		{
			while(!flag)
			{
				try
				{
					this.wait();
				}
				catch (Exception e)
				{
				}
			}
				System.out.println(Thread.currentThread().getName()+"...消费者........"+name);
				flag=false;
				this.notifyAll();//唤醒所有处于等待的线程
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
			r.set("++商品++");
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
		r.out();
	}
}
