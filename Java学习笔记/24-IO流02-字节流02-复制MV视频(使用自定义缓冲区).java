/*---------------------------------ʹ���Զ�����ֽڶ�ȡ������MV��Ƶ----------------------------------*/
//----------------------------------------ģ���ȡ�ֽ���������---------------------------------------------
import java.io.*;
class FileStream 
{
	public static void main(String[] args) 
	{
		long startTime=System.currentTimeMillis();
		copyFile();
		long endTime=System.currentTimeMillis();
		System.out.println("���Ƴɹ�");
		System.out.println("��ʱ��"+(endTime-startTime)+"����");
	}
	public static void copyFile()
	{
		MyBufferedInputStream myBis=null;//ʹ���Զ����ֽ�����ȡ������
		BufferedOutputStream bos=null;//�ֽ���д�뻺����
		try
		{
			myBis=new MyBufferedInputStream(new FileInputStream("��Ӣ��.flv"));//Դ�ļ�
			bos=new BufferedOutputStream(new FileOutputStream("c:\\��Ӣ��.flv"));//���Ƶ�ָ��·����
			//���ڻ��������Ѿ���װ�����飬���ԾͲ��ٶ�������Ϊ������
			int byt=0;
			//ѭ��д��
			while ((byt=myBis.myRead())!=-1)
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
			if (myBis!=null)
			{
				try
				{
					myBis.myClose();
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
//ģ���ֽ�����ȡ�ļ��Ļ�����(�Զ����ȡ�ļ��Ľ���������)
class MyBufferedInputStream
{
	private FileInputStream fin;
	private int point=0;//����һ��ָ�룬���ڲ�������
	private int count=0;//����һ��������
	private byte[] byt=new byte[1024];//����һ������
	MyBufferedInputStream(FileInputStream fin)
	{
		this.fin=fin;
	}
	public int myRead() throws IOException
	{
		if (count==0)//count==0����byt����Ϊ��
		{
			count=fin.read(byt);//ʹ��fin�����Ӳ���϶�ȡ���ݣ�����byt������,�����ص���������Ԫ�صĸ���
			if (count<0)
			{
				return -1;
			}
			point=0;//ָ���0
			byte b=byt[point];//��ȡ�����е�һ��Ԫ��
			point++;//ָ������ƶ�һλ
			count--;//������Ԫ�ظ�����һ
			return b&255;//��ȡ����Ԫ�ط���
		}
		else if (count>0)//count>0����byt���鲻Ϊ��
		{
			byte b=byt[point];//��ȡ�����е�һ��Ԫ��
			point++;//ָ������ƶ�һλ
			count--;//������Ԫ�ظ�����һ
			return b&255;//��ȡ����Ԫ�ط���
		}
		return -1;
	}
	//�ر��ֽ���
	public void myClose() throws IOException
	{
		fin.close();
	}
}
