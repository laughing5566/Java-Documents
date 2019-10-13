//-------------------------------------------对象的序列化----------------------------------------
import java.io.*;
class ObjectSerializable 
{
	public static void main(String[] args) throws Exception
	{
		writeObj();
		readObj();
	}
	public static void writeObj() throws Exception
	{
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("s.txt"));
		oos.writeObject(new Person("李四",30));
		oos.close();
	}
	public static void readObj() throws Exception
	{
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("s.txt"));
		Person p=(Person)ois.readObject();
		System.out.println(p);
		ois.close();
	}
}
class Person implements Serializable 
{
	public static final long serialVersionUID = 42L;//给类定义标记
	String name;
	int age;
	Person(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public String toString()
	{
		return name+"::"+age;
	}
}