/**
--------------------------------------去除ArryList集合中的重复的对象元素-------------------------------
只要姓名和年龄同时相同，就视为重复
*/
import java.util.*;
class ArrayListText 
{
	public static void main(String[] args) 
	{
		ArrayList arr=new ArrayList();
		arr.add(new Person("张三",23));
		arr.add(new Person("李四",56));
		arr.add(new Person("王五",89));
		arr.add(new Person("张三",23));
		arr.add(new Person("张三",23));
		arr.add(new Person("张三",23));
		//System.out.println(arr);//Person@1afae45, Person@da4b71, Person@18f1d7e,...输出的是对象的内存地址值
		signalElement(arr);
	}
	//去除重复元素
	public static void signalElement(ArrayList list)
	{
		ArrayList newList=new ArrayList();//定义一个新的容器
		Iterator it=list.iterator();
		while (it.hasNext())
		{
			Person p=(Person)it.next();
			//System.out.println(p.getName()+":::"+p.getAge());//去除重复之前输出结果
			if (!newList.contains(p))//contains()方法自动调用Person类的equals()方法
			{
				newList.add(p);
			}
		}
		Iterator newIt=newList.iterator();
		while (newIt.hasNext())
		{
			Person p1=(Person)newIt.next();
			System.out.println(p1.getName()+":::"+p1.getAge());//去除重复之后输出结果
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
}