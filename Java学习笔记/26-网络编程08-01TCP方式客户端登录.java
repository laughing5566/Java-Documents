/*
�ͻ��˵�¼
--�ͻ���ֻ��������¼3��
*/
import java.io.*;
import java.net.*;
class LoginClient
{
	public static void main(String[] args) throws Exception
	{
		Socket s=new Socket("172.33.3.106",5001);
		//��ȡ����¼��
		BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
		//�����˷�����Ϣ
		PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
		//��ȡ����˵ķ�����Ϣ
		BufferedReader bufin=new BufferedReader(new InputStreamReader(s.getInputStream()));
		for (int x=0;x<3;x++)
		{
			String line=bufr.readLine();
			if (line==null)
			{
				break;
			}
			pw.println(line);
			//����˷�����Ϣ
			String backInfo=bufin.readLine();
			System.out.println(backInfo);
			if (backInfo.contains("��ӭ"))
			{
				break;
			}
		}
		bufr.close();
		s.close();
	}
}
