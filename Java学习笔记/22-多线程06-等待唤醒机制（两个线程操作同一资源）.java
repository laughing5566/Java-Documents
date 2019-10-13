/**
---------------------------------------------------�̼߳�ͨ��ʾ��/�ȴ����ѻ���--------------------------------------------------
*/
class InputOutputDemo 
{
	public static void main(String[] args) 
	{
		Rec r=new Rec();
		Input in=new Input(r);
		Output out=new Output(r);

		Thread t1=new Thread(in);
		Thread t2=new Thread(out);
		t1.start();
		t2.start();
	}
}
class Rec
{
	String name;
	String sex;
	boolean flag=false;
}
class Input implements Runnable
{
	private Rec r;
	Input(Rec r)
	{
		this.r=r;
	}
	public void run()
	{
		int b=0;
		while (true)
		{
			synchronized(r)
			{
				if (r.flag)//���Ϊ��
				{
					try
					{
						r.wait();//�ô��̵߳ȴ�
					}
					catch (Exception e)
					{
					}
					
				}
				else
				{
					if (b==0)
					{
						r.name="Bike";
						r.sex="male";
					}
					else
					{
						r.name="С��";
						r.sex="Ů";
					}
					b=(b+1)%2;
					r.flag=true;
					r.notify();//������һ���߳�
				}
			}
		}
	}
}
class Output implements Runnable
{
	private Rec r;
	Output(Rec r)
	{
		this.r=r;
	}
	public void run()
	{
		while (true)
		{
			synchronized(r)
			{
				if (!r.flag)
				{
					try
					{
						r.wait();
					}
					catch (Exception e)
					{
					}
				}
				else
				{
					System.out.println(r.name+"......"+r.sex);
					r.flag=false;
				    r.notify();
				}
			}
		}
	}
}