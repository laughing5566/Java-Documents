//----------------------------------HashSet去除重复对象--------------------------------
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
		hs.add(new Person("张三",23));
		hs.add(new Person("张三",23));
		hs.add(new Person("李四",56));
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
	//重写Object类的equals()方法
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
	//重写Object类的hashCode()方法（此方法被对象自动调用）
	public int hashCode()
	{
		return 60;
	}
}