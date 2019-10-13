/*
客户端登录
--客户端只允许最多登录3次
*/
import java.io.*;
import java.net.*;
class LoginClient
{
	public static void main(String[] args) throws Exception
	{
		Socket s=new Socket("172.33.3.106",5001);
		//读取键盘录入
		BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
		//向服务端发送信息
		PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
		//读取服务端的返回信息
		BufferedReader bufin=new BufferedReader(new InputStreamReader(s.getInputStream()));
		for (int x=0;x<3;x++)
		{
			String line=bufr.readLine();
			if (line==null)
			{
				break;
			}
			pw.println(line);
			//服务端返回信息
			String backInfo=bufin.readLine();
			System.out.println(backInfo);
			if (backInfo.contains("欢迎"))
			{
				break;
			}
		}
		bufr.close();
		s.close();
	}
}
