package br.com.thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementationQueueThread extends Thread{
	
	private static ConcurrentLinkedQueue<ObjectQueueThread> queue_daughter = new ConcurrentLinkedQueue<ObjectQueueThread>();
	
	public static void add(ObjectQueueThread objectQueueThread){
		
		queue_daughter.add(objectQueueThread);
	}
	
	@Override
	public void run() {
		Iterator iterator = queue_daughter.iterator();
		
		//Block access to the list by other processes
		synchronized (iterator) {
			
			//while it have data in the list it will process
			while(iterator.hasNext()){
				ObjectQueueThread process = (ObjectQueueThread) iterator.next();
				
				//Create high processing routine
				
				System.out.println("-------------------------------------------");
				System.out.println(process.getNome());
				System.out.println(process.getEmail());
				
				
				iterator.remove();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
