//管道流：PipedInputStream类/PipedOutputStream类
//输入输出可直接进行连接，要使用多线程。使用单线程会造成死锁。
package iotest;
import java.io.*;
class Test {
	public static void main(String[] args) throws Exception{
		PipedInputStream in=new PipedInputStream();
		PipedOutputStream out=new PipedOutputStream(in);
		new Thread(new Write(out)).start();
		new Thread(new Read(in)).start();
	}
}
class Write implements Runnable{
	private PipedOutputStream out;
	Write(PipedOutputStream out){
		this.out=out;
	}
	public void run() {
		try {
			out.write("管道流写入".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
class Read implements Runnable{
	private PipedInputStream in;
	Read(PipedInputStream in){
		this.in=in;
	}
	public void run() {
		try {
			byte[] buf=new byte[1024];
			int len=in.read(buf);
			String s=new String(buf,0,len);
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}