/**---------------------------------------------读写文件内容-----------------------------------------
键盘的录入以及控制台的输出都是字节流形式:
--1、键盘输入内容要保存到硬盘文件中：字节流---转换为--->字符流，需要转换流-InputStreamReader
--2、在控制台上展现硬盘中文件的内容：字符流---转换为--->字节流，需要转换流-OutputStreamWriter
*/
import java.io.*;
class  ReadWriteContent
{
	public static void main(String[] args) throws IOException
	{
		
		writeContent();
		readContent();
	}
	/*把键盘输入的内容写入文件中
	--源：键盘；
	--目的地：硬盘中的文件。
	*/
	public static void writeContent() throws IOException
	{
		BufferedReader bur=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter buw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("aaa.txt")));
		//BufferedWriter buw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("aaa.txt"),"UTF-8"));//用指定的编码表写入数据
		String line=null;
		while ((line=bur.readLine())!=null)
		{
			if (line.equals("over"))
			{
				break;
			}
			buw.write(line);
			buw.flush();
			buw.newLine();
		}
	}
	/*把文件中的内容打印到控制台
	--源：硬盘中的文件；
	--目的地：控制台。
	*/
	public static void readContent() throws IOException
	{
		BufferedReader buf=new BufferedReader(new InputStreamReader(new FileInputStream("ThreadDemo.java")));
		BufferedWriter buw=new BufferedWriter(new OutputStreamWriter(System.out));
		String line=null;
		while ((line=buf.readLine())!=null)
		{
			if (line.equals("over"))
			{
				break;
			}
			System.out.println(line);
		}
	}
}
