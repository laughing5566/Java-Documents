/*---------------------------------使用字节流复制MV视频----------------------------------*/
import java.io.*;
class FileStream 
{
	public static void main(String[] args) 
	{
		copyMV();
		System.out.println("复制成功");
	}
	public static void copyMV()
	{
		BufferedInputStream bis=null;//字节流读取缓冲区
		BufferedOutputStream bos=null;//字节流写入缓冲区
		try
		{
			bis=new BufferedInputStream(new FileInputStream("大英雄.flv"));//源文件
			bos=new BufferedOutputStream(new FileOutputStream("c:\\大英雄.flv"));//复制到指定路径下
			//由于缓冲区中已经封装了数组，所以就不再定义数组为缓冲区
			int byt=0;
			//循环写入
			while ((byt=bis.read())!=-1)
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
			if (bis!=null)
			{
				try
				{
					bis.close();
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
