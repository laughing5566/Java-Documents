import java.io.*;
import java.util.*;

public class ReflectTest {
	public static void main(String[] args) throws Exception {
		NoteBook book=new NoteBook();
		book.run();
		File file=new File("USB.properties");
		FileInputStream fin=new FileInputStream(file);
		Properties property=new Properties();
		//º”‘ÿ≈‰÷√Œƒº˛
		property.load(fin);
		for(int x=1;x<=property.size();x++)
		{
			String className=property.getProperty("usb"+x);
			Class c=Class.forName(className);
			Usb usb=(Usb)c.newInstance();
			book.useUSB(usb);
			book.close();
		}
		fin.close();
	}

}
