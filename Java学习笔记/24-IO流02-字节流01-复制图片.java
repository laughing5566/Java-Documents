/*---------------------------------ʹ���ֽ�������ͼƬ----------------------------------*/
import java.io.*;
class FileStream 
{
	public static void main(String[] args) 
	{
		copyPicture();
		System.out.println("���Ƴɹ�");
	}
	public static void copyPicture()
	{
		FileInputStream fis=null;//�ֽ�����ȡ
		FileOutputStream fos=null;//�ֽ���д��
		try
		{
			fis=new FileInputStream("li.jpg");//��ȡԴ�ļ�
			fos=new FileOutputStream("c:\\li.jpg");//д��ָ����λ��
			byte[] buty=new byte[1024];//����һ���ֽ�����
			int len=0;
			//ѭ��д��
			while ((len=fis.read(buty))!=-1)
			{
				fos.write(buty,0,len);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("�ļ����ƴ���");
		}
		finally
		{
			if (fis!=null)
			{
				try
				{
					fis.close();
				}
				catch (IOException e)
				{
					throw new RuntimeException("��ȡ�رմ���");
				}
			}
			if (fos!=null)
			{
				try
				{
					fos.close();
				}
				catch (IOException e)
				{
					throw new RuntimeException("д��رմ���");
				}
			}
		}
	}
}
