/**
--�����򵥵���������ļ���������ʹ�ô��������ں���ʾע����Ϣ��
*/
import java.io.*;
import java.util.*;
class RegistDemo 
{
	public static void main(String[] args) throws IOException
	{
		regist();
	}
	public static void regist() throws IOException
	{
		Properties pro=new Properties();
		File file=new File("Regist.ini");
		int count=0;//����һ��������
		//����ļ������ھʹ���һ�����ļ�
		if (!file.exists())
		{
			file.createNewFile();
		}
		FileInputStream fin=new FileInputStream(file);
		//�����ļ���
		pro.load(fin);
		String value=pro.getProperty("time");
		if (value!=null)
		{
			count=Integer.parseInt(value);
			if (count>=3)
			{
				System.out.println("�������ѹ�����ע�ᡣ");
				return;
			}
		}
		count++;
		pro.setProperty("time",count+"");
		FileOutputStream fos=new FileOutputStream(file);
		pro.store(fos,"");
		fin.close();
		fos.close();
	}
}
