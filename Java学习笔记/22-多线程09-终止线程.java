/**
-----------------------------线程停止-------------------------------------
停止线程理论上只有一种方法：使run()方法结束
*/
class Demo
{
	public static void main(String[] args) 
	{
		StopThread st=new StopThread();
		Thread t1=new Thread(st);
		Thread t2=new Thread(st);
		t1.start();
		t2.start();
		int num=0;
		while (true)
		{
			if (num++ == 30)
			{
				t1.interrupt();//强制使线程从冻结状态回到运行状态
				t2.interrupt();//强制使线程从冻结状态回到运行状态
				break;
			}
			System.out.println(Thread.currentThread().getName()+"......main..."+num);
		}
		System.out.println("Main over");
	}
}
class StopThread implements Runnable
{
	private boolean flag=true;
	public synchronized void run()
	{
		while (flag)
		{
			try
			{
				wait();
			}
			catch (Exception e)
			{
				System.out.println(Thread.currentThread().getName()+"......Exception");
				flag=false;
			}
			System.out.println(Thread.currentThread().getName()+"......run");
		}
	}
}