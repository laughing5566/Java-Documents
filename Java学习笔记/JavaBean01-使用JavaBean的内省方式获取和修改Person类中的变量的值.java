/**--------------------------------ʹ��JavaBean����ʡ��ʽ��ȡ���޸�Person���еı�����ֵ----------------------------------------
*/
import java.lang.reflect.*;
import java.beans.*;
class  JavaBeanTest
{
	public static void main(String[] args) throws Exception
	{
		Person p=new Person("����",20);
		String propertyName="name";
		getAndSetProperty(p,propertyName);
		
	}
	public static void getAndSetProperty(Object obj,String propertyName) throws Exception
	{
		//�����������������󣬲�����Ҫ��ȡ�����Ե����ƣ�ָ�������������ࣩ
		PropertyDescriptor pd=new PropertyDescriptor(propertyName,obj.getClass());
		//��ȡ���Ե�get����
		Method methodGetName=pd.getReadMethod();
		//ͨ��get������ȡ���Ե�ֵ(����Ϊ Object)
		Object returnValue=methodGetName.invoke(obj);
		System.out.println("�޸�ǰ��name:"+returnValue);
		//��ȡ���Ե�set����
		Method methodSetName=pd.getWriteMethod();
		//ͨ��set�����޸����Ե�ֵ
		methodSetName.invoke(obj, "����");
		Object returnSetValue=methodGetName.invoke(obj);
		System.out.println("�޸ĺ��name:"+returnSetValue);
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
	public void setName(String name)
	{
		this.name=name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	Person(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
}