//----------------------------------HashSetȥ���ظ�����--------------------------------
import java.util.*;
class HashSetDemo 
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		HashSet hs=new HashSet();
		hs.add(new Person("����",23));
		hs.add(new Person("����",23));
		hs.add(new Person("����",56));
		for (Iterator it=hs.iterator();it.hasNext() ; )
		{
			Person p=(Person)it.next();
			sop(p.getName()+":::"+p.getAge());
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
	//��дObject���hashCode()�������˷����������Զ����ã�
	public int hashCode()
	{
		return 60;
	}
}