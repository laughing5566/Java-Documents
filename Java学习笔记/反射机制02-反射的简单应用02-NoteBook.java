
public class NoteBook {
	public void run()
	{
		System.out.println("notebook run");
	}
	public void close()
	{
		System.out.println("notebook close");
	}
	public void useUSB(Usb usb)
	{
		if(usb!=null)
		{
			usb.open();
			usb.close();
		}
	}
}
