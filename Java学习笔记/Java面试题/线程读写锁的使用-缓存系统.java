/**
 * ------------------------------�̶߳�д����ʹ��--------------------------------
 * ------------------------------����ϵͳ(���̶߳�ȡ��������)----------------------------------------
 *�ж���̴߳ӻ����ж�ȡ�������ݣ����ж�Ҫ��ȡ�������Ƿ��ڻ����У������ֱ�ӷ��أ����û���ٴ����ݿ��ж�ȡ
 */
package ThreadTest;

import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public class CacheDemo {
	//����һ��Map������������
	private Map<String,Object> mapCache=new HashMap<String,Object>();
	//����һһ����д��
	private ReadWriteLock rwLock=new ReentrantReadWriteLock();
	public static void main(String[] args) {

	}
	//���ڻ�ȡ�����еĶ���
	public Object getObject(String key){
		rwLock.readLock().lock();//�Ӷ���
		Object value=null;
		try{
			value=mapCache.get(key);
			if(value==null){
				//�����һ���̷߳��ֻ�����û������,���ͻ��ȰѶ�������д�����Ȼ�������������֮��
				//�ٰ�д�����ض���
				rwLock.readLock().unlock();//ж�ض���
				rwLock.writeLock().lock();//����д��
				try{
					if(value==null){
						value="xxx";//ʵ�����Ǵ����ݿ��ж�ȡ����
					}
				}
				finally{
					rwLock.writeLock().unlock();//ж��д��
				}
				rwLock.readLock().lock();//���»��ض���
			}
		}
		finally{
			rwLock.readLock().unlock();//ж�ض���
		}
		
		return value;
	}
}
