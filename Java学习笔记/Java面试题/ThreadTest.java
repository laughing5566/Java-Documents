/**
�����⣺
���߳�ѭ��10�Σ��������߳�ѭ��100�ˣ������ֻص����߳�ѭ��10�Σ������ٻص����߳���ѭ��100�Σ����ѭ��50�ˡ�
*/
class ThreadTest 
{
	public static void main(String[] args) 
	{
		final Business business=new Business();
		
			new Thread(new Runnable(){
			public void run()
			{
				for(int i=1;i<=50;i++){
					business.sub(i);
				}
			}
			}).start();
			new Thread(new Runnable(){
				public void run()
				{
					for(int i=1;i<=50;i++){
						business.main(i);
					}
				}
			}).start();
	}
}
//����һ��ҵ����
class Business
{
	private boolean flag=true;
	public void sub(int i)
	{
		synchronized(Business.class)
		{
			while(!flag){
				try {
					Business.class.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (int j=1;j<=10;j++)
			{
				System.out.println("sub--"+j+"��sub of loop:"+i);
			}
			flag=false;
			Business.class.notify();
		}
	}
	public void main(int i)
	{
		synchronized(Business.class)
		{
			while(flag){
				try{
					Business.class.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (int j=1;j<=100;j++)
			{
				System.out.println("main--"+j+"��main of loop:"+i);
			}
			flag=true;
			Business.class.notify();
		}
	}
}
