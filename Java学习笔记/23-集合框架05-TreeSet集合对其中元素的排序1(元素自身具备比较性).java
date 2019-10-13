//----------------------------------------TreeSet���϶�����Ԫ�ص�����----------------------------------------
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
		ts.add(new Person("����",23));
		ts.add(new Person("����",26));
		ts.add(new Person("����",23));
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
	}
}