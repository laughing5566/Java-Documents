/*---------------------------------ʹ���ֽ�������MV��Ƶ----------------------------------*/
import java.io.*;
class FileStream 
{
	public static void main(String[] args) 
	{
		copyMV();
		System.out.println("���Ƴɹ�");
	}
	public static void copyMV()
	{
		BufferedInputStream bis=null;//�ֽ�����ȡ������
		BufferedOutputStream bos=null;//�ֽ���д�뻺����
		try
		{
			bis=new BufferedInputStream(new FileInputStream("��Ӣ��.flv"));//Դ�ļ�
			bos=new BufferedOutputStream(new FileOutputStream("c:\\��Ӣ��.flv"));//���Ƶ�ָ��·����
			//���ڻ��������Ѿ���װ�����飬���ԾͲ��ٶ�������Ϊ������
			int byt=0;
			//ѭ��д��
			while ((byt=bis.read())!=-1)
			{
				bos.write(byt);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("�ļ����ƴ���");
		}
		finally
		{
			if (bis!=null)
			{
				try
				{
					bis.close();
				}
				catch (IOException e)
				{
					throw new RuntimeException("��ȡ�رմ���");
				}
			}
			if (bos!=null)
			{
				try
				{
					bos.close();
				}
				catch (IOException e)
				{
					throw new RuntimeException("д��رմ���");
				}
			}
		}
	}
}
