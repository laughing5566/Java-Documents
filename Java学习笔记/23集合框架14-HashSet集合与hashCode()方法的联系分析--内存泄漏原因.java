/**----------------------------------------------HashSet集合与hashCode()方法的联系分析--内存泄漏原因-------------------------------------
--HashSet集合存储对象的原理是，算出每个对象的哈希值，然后根据哈希值为这个对象所存储的内存空间区域进行标识；
--内存泄漏的原因：程序为一个对象开辟了一片内存空间，但是该对象在使用完毕时并没有被释放，而是一直存在于内存中，直到程序运行结束，从而造成内存泄漏。
*/
import java.lang.reflect.*;
import java.util.*;
class Test 
{
	public static void main(String[] args) 
	{
		Set s=new HashSet();
		Person p1=new Person("sk",20);
		Person p2=new Person("ww",30);
		Person p3=new Person("ss",20);
		s.add(p1);
		s.add(p2);
		s.add(p3);
		//p1.age=40修改了对象一开始存入集合中时哈希值，等于是p1这个对象的储存地址变了，
		//而当s.remove(p1)删除p1时，根据的还是对象一开始存入集合中时哈希值对对象进行删除，
		//所以集合删除此对象时，无法找到该对象，进而无法删除。从而会造成内存泄漏。
		p1.age=40;
		s.remove(p1);

		System.out.println(s.size());
		System.out.println(s);
	}
}
class Person
{
	public String name;
	public int age;
	Person(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Person))
		{
			throw new RuntimeException("类型出错");
		}
		Person p=(Person)obj;
		return this.name.equals(p.name) && this.age==p.age;
	}
	public int hashCode()
	{
		return name.hashCode()+age;
	}
}
