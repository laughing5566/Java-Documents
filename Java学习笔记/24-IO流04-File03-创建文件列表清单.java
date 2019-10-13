/**----------------------------------------�����ļ��б��嵥----------------------------------
*/
import java.io.*;
import java.util.*;
class FileDemo
{
	public static void main(String[] args) throws IOException
	{
		File dir=new File("D:\\Ӱ��");
		ArrayList<File> arrs=new ArrayList<File>();
		getFile(dir,arrs);
		String fileName="D:\\List.txt";
		writeToFile(arrs,fileName);
		System.out.println("�����ļ��ɹ�");
	}
	//����ȡ�������ļ��б�����ӵ�һ��������
	public static void getFile(File dir,ArrayList<File> arrList)
	{
		File[] files=dir.listFiles();
		for (int i=0;i<files.length;i++)
		{
			if (files[i].isDirectory())
			{
				//�ݹ����
				getFile(files[i],arrList);
			}
			else
			{
				arrList.add(files[i]);
			}
		}
	}
	//�Ѽ����е���Ϣд��Ӳ���ļ���
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
			throw new RuntimeException("д�����");
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
				throw new RuntimeException("���رմ���");
			}
		}
	}
}
