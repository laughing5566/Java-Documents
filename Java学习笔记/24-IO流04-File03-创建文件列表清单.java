/**----------------------------------------创建文件列表清单----------------------------------
*/
import java.io.*;
import java.util.*;
class FileDemo
{
	public static void main(String[] args) throws IOException
	{
		File dir=new File("D:\\影视");
		ArrayList<File> arrs=new ArrayList<File>();
		getFile(dir,arrs);
		String fileName="D:\\List.txt";
		writeToFile(arrs,fileName);
		System.out.println("创建文件成功");
	}
	//将读取到到的文件列表名添加到一个集合中
	public static void getFile(File dir,ArrayList<File> arrList)
	{
		File[] files=dir.listFiles();
		for (int i=0;i<files.length;i++)
		{
			if (files[i].isDirectory())
			{
				//递归调用
				getFile(files[i],arrList);
			}
			else
			{
				arrList.add(files[i]);
			}
		}
	}
	//把集合中的信息写入硬盘文件中
	public static void writeToFile(ArrayList<File> arrList,String filePath)throws IOException
	{
		BufferedWriter bufw=null;
		try
		{
			bufw=new BufferedWriter(new FileWriter(filePath));
			for (File name : arrList)
			{
				bufw.write(name.getAbsolutePath());
				bufw.newLine();
				bufw.flush();
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("写入错误");
		}
		finally
		{
			try
			{
				if (bufw!=null)
				{
					bufw.close();
				}
			}
			catch (IOException e)
			{
				throw new RuntimeException("流关闭错误");
			}
		}
	}
}
