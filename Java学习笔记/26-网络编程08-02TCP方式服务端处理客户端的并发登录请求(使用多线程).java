/*
服务端处理客户端的并发登录
*/
import java.io.*;
import java.net.*;
class Server 
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss=new ServerSocket(5001);
		while (true)
		{
			Socket socket=ss.accept();
			new Thread(new UserThread(socket)).start();
		}
		//ss.close();
	}
}
class UserThread implements Runnable
{
	private Socket socket;
	UserThread(Socket socket)
	{
		this.socket=socket;
	}
	public void run()
	{
		String ip=socket.getInetAddress().getHostAddress();
		System.out.println(ip+"连接中...");
		try
		{
			for (int x=0;x<3;x++)
			{
				//读取客户端的登录信息
				BufferedReader bufr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedReader bufin=new BufferedReader(new FileReader("UserList.txt"));
				String name=bufr.readLine();//读取客户端的登录名
				String line=null;//读取本地文件中的用户列表
				boolean flag=false;
				if (name==null)
				{
					break;
				}
				while ((line=bufin.readLine())!=null)
				{
					if (line.equals(name))
					{
						flag=true;
						break;
					}
				}
				PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
				if (flag)
				{
					System.out.println(name+",登录成功！");
					pw.println(name+",欢迎回来！");
					break;
				}
				else
				{
					System.out.println(name+",正在尝试登录...");
					pw.println(name+",登录失败！");
				}
			}
			socket.close();
		}
		catch (Exception e)
		{
			throw new RuntimeException(ip+":校验失败！");
		}
		
	}
}