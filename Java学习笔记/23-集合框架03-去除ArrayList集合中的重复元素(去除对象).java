/**
--------------------------------------ȥ��ArryList�����е��ظ��Ķ���Ԫ��-------------------------------
ֻҪ����������ͬʱ��ͬ������Ϊ�ظ�
*/
import java.util.*;
class ArrayListText 
{
	public static void main(String[] args) 
	{
		ArrayList arr=new ArrayList();
		arr.add(new Person("����",23));
		arr.add(new Person("����",56));
		arr.add(new Person("����",89));
		arr.add(new Person("����",23));
		arr.add(new Person("����",23));
		arr.add(new Person("����",23));
		//System.out.println(arr);//Person@1afae45, Person@da4b71, Person@18f1d7e,...������Ƕ�����ڴ��ֵַ
		signalElement(arr);
	}
	//ȥ���ظ�Ԫ��
	public static void signalElement(ArrayList list)
	{
		ArrayList newList=new ArrayList();//����һ���µ�����
		Iterator it=list.iterator();
		while (it.hasNext())
		{
			Person p=(Person)it.next();
			//System.out.println(p.getName()+":::"+p.getAge());//ȥ���ظ�֮ǰ������
			if (!newList.contains(p))//contains()�����Զ�����Person���equals()����
			{
				newList.add(p);
			}
		}
		Iterator newIt=newList.iterator();
		while (newIt.hasNext())
		{
			Person p1=(Person)newIt.next();
			System.out.println(p1.getName()+":::"+p1.getAge());//ȥ���ظ�֮��������
		}
	}
}
class Person
{
	private String name;
	private int age;
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	Person(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	//��дObject���equals()����
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Person))
		{
			return false;
		}
		else
		{
			Person p=(Person)obj;
			return this.name==p.name && this.age==p.age;
		}
	}
}