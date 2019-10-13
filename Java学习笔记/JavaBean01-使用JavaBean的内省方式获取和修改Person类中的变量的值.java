/**--------------------------------使用JavaBean的内省方式获取和修改Person类中的变量的值----------------------------------------
*/
import java.lang.reflect.*;
import java.beans.*;
class  JavaBeanTest
{
	public static void main(String[] args) throws Exception
	{
		Person p=new Person("张三",20);
		String propertyName="name";
		getAndSetProperty(p,propertyName);
		
	}
	public static void getAndSetProperty(Object obj,String propertyName) throws Exception
	{
		//创建属性描述器对象，参数（要获取的属性的名称，指定属性所属的类）
		PropertyDescriptor pd=new PropertyDescriptor(propertyName,obj.getClass());
		//获取属性的get方法
		Method methodGetName=pd.getReadMethod();
		//通过get方法获取属性的值(类型为 Object)
		Object returnValue=methodGetName.invoke(obj);
		System.out.println("修改前的name:"+returnValue);
		//获取属性的set方法
		Method methodSetName=pd.getWriteMethod();
		//通过set方法修改属性的值
		methodSetName.invoke(obj, "李四");
		Object returnSetValue=methodGetName.invoke(obj);
		System.out.println("修改后的name:"+returnSetValue);
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