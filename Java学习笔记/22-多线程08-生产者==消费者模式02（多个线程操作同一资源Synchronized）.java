/**
--------------------------------------------------������==������ģʽʾ��(ʹ��synchronized)----------------------------------------------------
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
			System.out.println(Thread.currentThread().getName()+"...������"+this.name);
			flag=true;
			this.notifyAll();//�������д��ڵȴ����߳�(ʹ��notifyAll()������Ҫ��Ϊ�˻��ѶԷ����̣߳���notifyAll()����ȴ���������е��̣߳�ͬʱȴ���������߳�Ҳ�����ˣ���һ���ľ����ԡ��д��Ż���)
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
				System.out.println(Thread.currentThread().getName()+"...������........"+name);
				flag=false;
				this.notifyAll();//�������д��ڵȴ����߳�
		}
	}
}
//������
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
			r.set("++��Ʒ++");
		}
	}
}
//������
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
