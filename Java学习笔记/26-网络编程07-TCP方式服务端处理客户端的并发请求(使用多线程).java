/**-----------------------------------TCP��ʽ����˽���ͼƬ-----------------------------
--ʵ�ֿͻ��˵Ĳ����ϴ���ͬʱ�ϴ���
--ʹ�ö��߳�ʵ��
*/
import java.io.*;
import java.net.*;
class TCPServer 
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss=new ServerSocket(10000);
		while (true)
		{
			Socket s=ss.accept();
			//����һ�����߳�
			new Thread(new TranceThread(s)).start();
		}
		//ss.close();
	}
}
class TranceThread implements Runnable
{
	private Socket socket;
	TranceThread(Socket socket)
	{
		this.socket=socket;
	}
	public void run()
	{
		int count=1;
		String ip=socket.getInetAddress().getHostAddress();
		try
		{
			System.out.println(ip+"����...");
			InputStream in=socket.getInputStream();
			File file=new File(ip+"("+count+").jpg");
			while (file.exists())
			{
				file=new File(ip+"("+(count++)+").jpg");
			}
			FileOutputStream fos=new FileOutputStream(file);
			byte[] buf=new byte[1024];
			int len=0;
			while ((len=in.read(buf))!=-1)
			{
				fos.write(buf,0,len);
			}
			OutputStream out=socket.getOutputStream();
			out.write("�ϴ�ͼƬ�ɹ�".getBytes());
			fos.close();
			socket.close();
		}
		catch (Exception e)
		{
			throw new RuntimeException(ip+":�ϴ�ʧ��");
		}
		
	}
}
