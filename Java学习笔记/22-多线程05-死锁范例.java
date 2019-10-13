/**
---------------------------------------------------死锁范例--------------------------------------------------
*/
class ThreadDemo 
{
	public static void main(String[] args) 
	{
		Thread t1=new Thread(new MyThread(false));
		Thread t2=new Thread(new MyThread(true));
		t1.start();
		t2.start();
	}
}
class MyThread implements Runnable
{
	boolean f=false;
	MyThread(boolean f)
	{
		this.f=f;
	}
	public void run()
	{
		if(f)
		{
			while(true)
			{
				synchronized(Locks.lock1)
				{
					System.out.println("if...lock1");
					synchronized(Locks.lock2)
					{
						System.out.println("if...lock2");
					}
				}
			}
		}
		else
		{
			while(true)
			{
				synchronized(Locks.lock2)
				{
					System.out.println("else...lock2");
					synchronized(Locks.lock1)
					{
						System.out.println("else...lock1");
					}
				}
		   }
	   }
	}
}
class Locks
{
	//定义两个锁
	static Object lock1=new Object();
	static Object lock2=new Object();
}