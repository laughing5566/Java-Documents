/**
 * ------------------------------线程读写锁的使用--------------------------------
 * ------------------------------缓存系统(多线程读取缓存数据)----------------------------------------
 *有多个线程从缓存中读取对象数据，先判断要读取的数据是否在缓存中，如果有直接返回，如果没有再从数据库中读取
 */
package ThreadTest;

import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public class CacheDemo {
	//定义一个Map集合用作缓存
	private Map<String,Object> mapCache=new HashMap<String,Object>();
	//定义一一个读写锁
	private ReadWriteLock rwLock=new ReentrantReadWriteLock();
	public static void main(String[] args) {

	}
	//用于获取缓存中的对象
	public Object getObject(String key){
		rwLock.readLock().lock();//加读锁
		Object value=null;
		try{
			value=mapCache.get(key);
			if(value==null){
				//如果有一个线程发现缓存中没有数据,他就会先把读锁换成写锁，等缓存中有了数据之后，
				//再把写锁换回读锁
				rwLock.readLock().unlock();//卸载读锁
				rwLock.writeLock().lock();//换成写锁
				try{
					if(value==null){
						value="xxx";//实际上是从数据库中读取数据
					}
				}
				finally{
					rwLock.writeLock().unlock();//卸载写锁
				}
				rwLock.readLock().lock();//重新换回读锁
			}
		}
		finally{
			rwLock.readLock().unlock();//卸载读锁
		}
		
		return value;
	}
}
