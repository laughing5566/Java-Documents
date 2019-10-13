//�ܵ�����PipedInputStream��/PipedOutputStream��
//���������ֱ�ӽ������ӣ�Ҫʹ�ö��̡߳�ʹ�õ��̻߳����������
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
			out.write("�ܵ���д��".getBytes());
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