/*----------------------------------------�����޶�----------------------------------------
*/
import java.util.*;
class TreeSetDemo 
{
	public static void main(String[] args) 
	{
		ArrayList<Person> as=new ArrayList<Person>();
		as.add(new Person("lisi"));
		as.add(new Person("lisi"));
		as.add(new Person("zhangsan"));
		as.add(new Person("lisi"));
		//show(as);
		ArrayList<Student> as1=new ArrayList<Student>();
		as1.add(new Student("lisi"));
		as1.add(new Student("lisi"));
		as1.add(new Student("zhangsan"));
		as1.add(new Student("zhangsan"));
		show(as1);
	}
	public static void show(ArrayList<? extends Person> arr)//��������Ϳ�����Person���������
	{
		for (Iterator<? extends Person> it=arr.iterator();it.hasNext() ; )//ʹ�õ��������������е�Ԫ��
		{
			System.out.println(it.next().getName());
		}
	}
}
class Person
{
	private String name;
	Person(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
}
class Student extends Person
{
	Student(String name)
	{
		super(name);
	}
}