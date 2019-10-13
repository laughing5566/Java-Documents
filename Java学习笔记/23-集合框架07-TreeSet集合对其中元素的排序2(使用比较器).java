//----------------------------------------TreeSet���϶�����Ԫ�ص�����----------------------------------------
//TreeSet�����е�Ԫ�ز��߱��Ƚ��ԣ��򲻾߱�����ıȽ��ԡ���Ҫ�õ�Comparator�Ƚ���.
//Comparator�Ƚ��������Զ���ȽϷ�ʽ
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
		ts.add(new Person("����",23));
		ts.add(new Person("����",26));
		ts.add(new Person("����",23));
		//ʹ�õ��������������е�Ԫ��
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
	//��дComparable�ӿ��е�compareTo()����
	public int compareTo(Object obj)//�˷����������Զ�����
	{
		if (!(obj instanceof Person))
		{
			throw new RuntimeException("����Person����");
		}
		else
		{
			//ָ��������������
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
//����һ���Ƚ���
class MyCom implements Comparator
{
	//��дComparator�ӿ��е�compare()����
	public int compare(Object o1,Object o2)
	{
		if (!((o1 instanceof Person) || (o2 instanceof Person)))
		{
			throw new RuntimeException("����Person����");
		}
		Person p1=(Person)o1;
		Person p2=(Person)o2;
		int num=p1.getName().compareTo(p2.getName());
		if (num==0)
		{
			//������һ��ʱ�ͱȽ�����
			return new Integer(p1.getAge()).compareTo(new Integer(p2.getAge()));
		}
		return num;
	}
}