package MultiThreading;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadPoolImplementation {
	
  	public ThreadPoolImplementation()
	{
		ThreadPool ObjThreadPool=new ThreadPool(3);
		
		for(int i=0;i<1000;i++)
		{
			Task ObjTask=new Task(i);
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ObjThreadPool.AddTask(ObjTask);
		}
		
	}

}
class Task implements Runnable
{
	int TaskNumber;
	Task(int i)
	{
		TaskNumber=i;
	}
	@Override
	public void run() {
		System.out.println("Thread ID is:"+Thread.currentThread().getId()+ " ,Task is:"+TaskNumber);
		
	}
	
}

 class ThreadPool
{
	 PoolThread ObjPoolThread[];
	 LinkedList<Runnable> ObjQueue=new LinkedList<Runnable>();
	 
	 ThreadPool(int ThreadCount)
	 {
		 ObjPoolThread=new PoolThread[ThreadCount];
		 for(int i=0;i<ThreadCount;i++)
		 {
			 ObjPoolThread[i]=new PoolThread();
			 ObjPoolThread[i].start();
		 }
		 
	 }
	 
	 public void AddTask(Runnable ObjTask)
	 {
		 synchronized (ObjQueue) {
			 ObjQueue.add(ObjTask);
			 ObjQueue.notify();
		 }
		
	 }
	 
	 class PoolThread extends Thread
	 {
		 Runnable ObjTask;
		 
		 public void run()
		 {
			 while(true)
			 {
				 synchronized (ObjQueue) {
					 while(ObjQueue.isEmpty())
					 {
						 try
						 {
							 ObjQueue.wait();
						 }catch(Exception ex)
						 {
							 System.out.println("Exception is:"+ex.getMessage());
						 }
						 
					 }
					 ObjTask= ObjQueue.removeFirst();
					 try
					 {
						/*Thread obj=new Thread(ObjTask);
						obj.start();*/
						 ObjTask.run();
					 }
					 catch(Exception ex)
					 {
						 System.out.println("Exception is:"+ex.getMessage());
					 }
				 }
			 }
		 }
		 
	 }
	
}
 
 

