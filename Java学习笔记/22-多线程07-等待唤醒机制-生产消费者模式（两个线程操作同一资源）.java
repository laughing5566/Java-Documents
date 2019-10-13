/*
-----------------------------------------------����==������ģʽ--------------------------------------------
*/
class ThreadDemo 
{
	public static void main(String[] args) 
	{
		Resource r=new Resource();
		Thread t1=new Thread(new Producer(r));
		Thread t2=new Thread(new Consumer(r));
		t1.start();
		t2.start();
	}
}
class Resource
{
	private String name;
	private int count=1;
	private boolean flag=false;
	public synchronized void set(String name)
	{
		if (flag)
		{
			try{this.wait();}catch(Exception e){}
		}
		this.name=name+"..."+this.count++;
		System.out.println(Thread.currentThread().getName()+"������"+this.name);
		flag=true;
		this.notify();//���Ѵ��ڵȴ����߳�
	}
	public synchronized void out()
	{
		if (!flag)
		{
			try{this.wait();}catch(Exception e){}
		}
		System.out.println(Thread.currentThread().getName()+"......���ѣ�"+this.name);
		flag=false;
		this.notify();//���Ѵ��ڵȴ����߳�
	}
}
class Producer implements Runnable
{
	private Resource r;
	Producer(Resource r)
	{
		this.r=r;
	}
	public void run()
	{
		while (true)
		{
			r.set("��Ʒ+");
		}
	}
}
class Consumer implements Runnable
{
	private Resource r;
	Consumer(Resource r)
	{
		this.r=r;
	}
	public void run()
	{
		while (true)
		{
			r.out();
		}
	}
}