/**
--创建简单的软件配置文件，并限制使用次数，到期后提示注册信息。
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
		int count=0;//定义一个计数器
		//如果文件不存在就创建一个新文件
		if (!file.exists())
		{
			file.createNewFile();
		}
		FileInputStream fin=new FileInputStream(file);
		//加载文件流
		pro.load(fin);
		String value=pro.getProperty("time");
		if (value!=null)
		{
			count=Integer.parseInt(value);
			if (count>=3)
			{
				System.out.println("试用期已过，请注册。");
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
