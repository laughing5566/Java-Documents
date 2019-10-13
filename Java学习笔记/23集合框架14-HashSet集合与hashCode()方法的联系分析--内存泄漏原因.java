/**----------------------------------------------HashSet������hashCode()��������ϵ����--�ڴ�й©ԭ��-------------------------------------
--HashSet���ϴ洢�����ԭ���ǣ����ÿ������Ĺ�ϣֵ��Ȼ����ݹ�ϣֵΪ����������洢���ڴ�ռ�������б�ʶ��
--�ڴ�й©��ԭ�򣺳���Ϊһ�����󿪱���һƬ�ڴ�ռ䣬���Ǹö�����ʹ�����ʱ��û�б��ͷţ�����һֱ�������ڴ��У�ֱ���������н������Ӷ�����ڴ�й©��
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
		//p1.age=40�޸��˶���һ��ʼ���뼯����ʱ��ϣֵ��������p1�������Ĵ����ַ���ˣ�
		//����s.remove(p1)ɾ��p1ʱ�����ݵĻ��Ƕ���һ��ʼ���뼯����ʱ��ϣֵ�Զ������ɾ����
		//���Լ���ɾ���˶���ʱ���޷��ҵ��ö��󣬽����޷�ɾ�����Ӷ�������ڴ�й©��
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
			throw new RuntimeException("���ͳ���");
		}
		Person p=(Person)obj;
		return this.name.equals(p.name) && this.age==p.age;
	}
	public int hashCode()
	{
		return name.hashCode()+age;
	}
}
