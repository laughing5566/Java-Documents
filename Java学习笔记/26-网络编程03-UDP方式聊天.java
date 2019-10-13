//------------------------------------------使用UDP方式实现聊天功能------------------------------------------
import java.io.*;
import java.net.*;
class UDPChat 
{
	public static void main(String[] args) throws Exception
	{
		DatagramSocket sendSocket=new DatagramSocket();
		DatagramSocket receiveSocket=new DatagramSocket(10000);
		new Thread(new Send(sendSocket)).start();
		new Thread(new Receive(receiveSocket)).start();
	}
}
//数据发送端
class Send implements Runnable
{
	private DatagramSocket ds;
	Send(DatagramSocket ds)
	{
		this.ds=ds;
	}
	public void run()
	{
		try
		{
			BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
			String line=null;
			while ((line=buf.readLine())!=null)
			{
				if (line.equals("886"))
				{
					break;
				}
				byte[] dataByte=line.getBytes();
				//将要发送的数据封装成数据包
				DatagramPacket dp=new DatagramPacket(dataByte,dataByte.length,InetAddress.getByName("172.33.3.106"),10000);
				ds.send(dp);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("发送数据失败！");
		}
	}
}
//数据接收端
class Receive implements Runnable
{
	private DatagramSocket ds;
	Receive(DatagramSocket ds)
	{
		this.ds=ds;
	}
	public void run()
	{
		try
		{
			while (true)
			{
				byte[] by=new byte[1024];
				DatagramPacket dp=new DatagramPacket(by,by.length);
				//把接收到的数据封装到数据包中
				ds.receive(dp);
				String ip=dp.getAddress().getHostAddress();
				String data=new String(dp.getData());
				System.out.println(ip+"---"+data);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("数据接受失败！");
		}
	}
}
