/**---------------------------------------------��д�ļ�����-----------------------------------------
���̵�¼���Լ�����̨����������ֽ�����ʽ:
--1��������������Ҫ���浽Ӳ���ļ��У��ֽ���---ת��Ϊ--->�ַ�������Ҫת����-InputStreamReader
--2���ڿ���̨��չ��Ӳ�����ļ������ݣ��ַ���---ת��Ϊ--->�ֽ�������Ҫת����-OutputStreamWriter
*/
import java.io.*;
class  ReadWriteContent
{
	public static void main(String[] args) throws IOException
	{
		
		writeContent();
		readContent();
	}
	/*�Ѽ������������д���ļ���
	--Դ�����̣�
	--Ŀ�ĵأ�Ӳ���е��ļ���
	*/
	public static void writeContent() throws IOException
	{
		BufferedReader bur=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter buw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("aaa.txt")));
		//BufferedWriter buw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("aaa.txt"),"UTF-8"));//��ָ���ı����д������
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
	/*���ļ��е����ݴ�ӡ������̨
	--Դ��Ӳ���е��ļ���
	--Ŀ�ĵأ�����̨��
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
