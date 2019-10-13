/*
����˴���ͻ��˵Ĳ�����¼
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
		System.out.println(ip+"������...");
		try
		{
			for (int x=0;x<3;x++)
			{
				//��ȡ�ͻ��˵ĵ�¼��Ϣ
				BufferedReader bufr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedReader bufin=new BufferedReader(new FileReader("UserList.txt"));
				String name=bufr.readLine();//��ȡ�ͻ��˵ĵ�¼��
				String line=null;//��ȡ�����ļ��е��û��б�
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
					System.out.println(name+",��¼�ɹ���");
					pw.println(name+",��ӭ������");
					break;
				}
				else
				{
					System.out.println(name+",���ڳ��Ե�¼...");
					pw.println(name+",��¼ʧ�ܣ�");
				}
			}
			socket.close();
		}
		catch (Exception e)
		{
			throw new RuntimeException(ip+":У��ʧ�ܣ�");
		}
		
	}
}