package br.com.thread;

import javax.swing.JOptionPane;

public class ExampleThread {

	public static void main(String[] args) throws InterruptedException {

		// Thread processing in parallel 1
		Thread thread1 = new Thread(threadexample1);
		thread1.start();
		
		// Thread processing in parallel 2
		Thread thread2 = new Thread(threadexample2);
		thread2.start();
		

		System.out.println("Thread end");
		JOptionPane.showMessageDialog(null, "system keeps running for the user");

	}
	
	private static Runnable threadexample1 = new Runnable() {
		
		@Override
		public void run() {
			// parallel code
			for (int pos = 0; pos < 10; pos++) {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("teste----teste");
			}
		}
	};
	
	private static Runnable threadexample2 = new Runnable() {
		
		@Override
		public void run() {
			// parallel code
			for (int pos = 0; pos < 10; pos++) {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("teste2----teste2");

			}
		}
	};
		

}
