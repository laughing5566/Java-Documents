/*---------------------------------使用字节流复制图片----------------------------------*/
import java.io.*;
class FileStream 
{
	public static void main(String[] args) 
	{
		copyPicture();
		System.out.println("复制成功");
	}
	public static void copyPicture()
	{
		FileInputStream fis=null;//字节流读取
		FileOutputStream fos=null;//字节流写入
		try
		{
			fis=new FileInputStream("li.jpg");//读取源文件
			fos=new FileOutputStream("c:\\li.jpg");//写入指定的位置
			byte[] buty=new byte[1024];//创建一个字节数组
			int len=0;
			//循环写入
			while ((len=fis.read(buty))!=-1)
			{
				fos.write(buty,0,len);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("文件复制错误！");
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
					throw new RuntimeException("读取关闭错误！");
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
					throw new RuntimeException("写入关闭错误！");
				}
			}
		}
	}
}
