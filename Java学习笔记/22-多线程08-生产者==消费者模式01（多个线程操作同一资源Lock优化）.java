/**
--------------------------------------------������==������ģʽʾ��(ʹ��Lock�����Ż�)----------------------------------------------------
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
	private Lock lock=new ReentrantLock();//����һ��������
	private Condition condition_pro=lock.newCondition();//����һ��Producer��Condition����
	private Condition condition_con=lock.newCondition();//����һ��Consumer��Condition����

	public void set(String name) throws InterruptedException//��Ϊawait()�����׳����쳣
	{
		lock.lock();//����
		try
		{
			while(flag)
			{
				condition_pro.await();//ʹ�߳̽���ȴ�״̬
			}
			this.name=name+"..."+num++;
			System.out.println(Thread.currentThread().getName()+"...������"+this.name);
			flag=true;
			//condition.signalAll();//���ѵ������д��ڵȴ����߳�
			condition_con.signal();//����ֻ���ѶԷ����ڵȴ����߳�
		}
		finally
		{
			lock.unlock();//����
		}
		
	}
	public void out() throws InterruptedException//��Ϊawait()�����׳����쳣
	{
		lock.lock();//����
		try
		{
				while(!flag)
				{
					condition_con.await();//ʹ�߳̽���ȴ�״̬
				}
				System.out.println(Thread.currentThread().getName()+"...������........"+name);
				flag=false;
				//condition.signalAll();//���ѵ������д��ڵȴ����߳�
				condition_pro.signal();//����ֻ���ѶԷ����ڵȴ����߳�
		}
		finally
		{
			lock.unlock();//����
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
			try
			{
				r.set("++��Ʒ++");
			}
			catch (InterruptedException e)
			{
			}
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
