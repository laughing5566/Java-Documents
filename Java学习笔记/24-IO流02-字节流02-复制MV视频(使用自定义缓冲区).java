/*---------------------------------使用自定义的字节读取流复制MV视频----------------------------------*/
//----------------------------------------模拟读取字节流缓冲区---------------------------------------------
import java.io.*;
class FileStream 
{
	public static void main(String[] args) 
	{
		long startTime=System.currentTimeMillis();
		copyFile();
		long endTime=System.currentTimeMillis();
		System.out.println("复制成功");
		System.out.println("费时："+(endTime-startTime)+"毫秒");
	}
	public static void copyFile()
	{
		MyBufferedInputStream myBis=null;//使用自定义字节流读取缓冲区
		BufferedOutputStream bos=null;//字节流写入缓冲区
		try
		{
			myBis=new MyBufferedInputStream(new FileInputStream("大英雄.flv"));//源文件
			bos=new BufferedOutputStream(new FileOutputStream("c:\\大英雄.flv"));//复制到指定路径下
			//由于缓冲区中已经封装了数组，所以就不再定义数组为缓冲区
			int byt=0;
			//循环写入
			while ((byt=myBis.myRead())!=-1)
			{
				bos.write(byt);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("文件复制错误！");
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
					throw new RuntimeException("读取关闭错误！");
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
					throw new RuntimeException("写入关闭错误！");
				}
			}
		}
	}
}
//模拟字节流读取文件的缓冲区(自定义读取文件的节流缓冲区)
class MyBufferedInputStream
{
	private FileInputStream fin;
	private int point=0;//定义一个指针，用于操作数组
	private int count=0;//定义一个计数器
	private byte[] byt=new byte[1024];//定义一个数组
	MyBufferedInputStream(FileInputStream fin)
	{
		this.fin=fin;
	}
	public int myRead() throws IOException
	{
		if (count==0)//count==0代表byt数组为空
		{
			count=fin.read(byt);//使用fin对象从硬盘上读取数据，存入byt数组中,并返回的是数组中元素的个数
			if (count<0)
			{
				return -1;
			}
			point=0;//指针归0
			byte b=byt[point];//获取数组中的一个元素
			point++;//指针向后移动一位
			count--;//数组中元素个数减一
			return b&255;//把取到的元素返回
		}
		else if (count>0)//count>0代表byt数组不为空
		{
			byte b=byt[point];//获取数组中的一个元素
			point++;//指针向后移动一位
			count--;//数组中元素个数减一
			return b&255;//把取到的元素返回
		}
		return -1;
	}
	//关闭字节流
	public void myClose() throws IOException
	{
		fin.close();
	}
}
