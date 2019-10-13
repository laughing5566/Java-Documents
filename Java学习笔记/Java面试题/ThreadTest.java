/**
面试题：
子线程循环10次，接着主线程循环100此，接着又回到子线程循环10次，接着再回到主线程再循环100次，如此循环50此。
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
//定义一个业务类
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
				System.out.println("sub--"+j+"；sub of loop:"+i);
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
				System.out.println("main--"+j+"；main of loop:"+i);
			}
			flag=true;
			Business.class.notify();
		}
	}
}
