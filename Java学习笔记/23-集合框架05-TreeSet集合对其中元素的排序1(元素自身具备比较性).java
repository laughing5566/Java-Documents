//----------------------------------------TreeSet集合对其中元素的排序----------------------------------------
import java.util.*;
class TreeSetDemo 
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		TreeSet ts=new TreeSet();
		ts.add(new Person("张三",23));
		ts.add(new Person("张三",26));
		ts.add(new Person("李四",23));
		for (Iterator it=ts.iterator();it.hasNext() ; )
		{
			Person p=(Person)it.next();
			sop(p.getName()+":::"+p.getAge());
		}
	}
}
class Person implements Comparable
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
	//重写Comparable接口中的compareTo()方法
	public int compareTo(Object obj)//此方法被对象自动调用
	{
		if (!(obj instanceof Person))
		{
			throw new RuntimeException("不是Person对象");
		}
		else
		{
			//指定按照年龄排序
			Person p=(Person)obj;
			if (this.age-p.age>0)
			{
				return 1;
			}
			if (this.age-p.age==0)
			{
				return this.name.compareTo(p.name);
			}
			return -1;
		}
	}
}