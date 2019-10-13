//----------------------------------------TreeSet集合对其中元素的排序----------------------------------------
//TreeSet集合中的元素不具备比较性，或不具备所需的比较性。需要用到Comparator比较器.
//Comparator比较器可以自定义比较方式
import java.util.*;
class TreeSetDemo 
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		TreeSet ts=new TreeSet(new MyCom());
		ts.add(new Person("张三",23));
		ts.add(new Person("张三",26));
		ts.add(new Person("李四",23));
		//使用迭代器遍历集合中的元素
		for (Iterator it=ts.iterator();it.hasNext() ; )
		{
			Person p=(Person)it.next();
			sop(p.getName()+":::"+p.getAge());
		}
	}
}
class Person //implements Comparable
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
	/*
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
	}*/
}
//定义一个比较器
class MyCom implements Comparator
{
	//重写Comparator接口中的compare()方法
	public int compare(Object o1,Object o2)
	{
		if (!((o1 instanceof Person) || (o2 instanceof Person)))
		{
			throw new RuntimeException("不是Person对象");
		}
		Person p1=(Person)o1;
		Person p2=(Person)o2;
		int num=p1.getName().compareTo(p2.getName());
		if (num==0)
		{
			//当姓名一样时就比较年龄
			return new Integer(p1.getAge()).compareTo(new Integer(p2.getAge()));
		}
		return num;
	}
}