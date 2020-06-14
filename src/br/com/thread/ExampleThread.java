package br.com.thread;

import javax.swing.JOptionPane;

public class ExampleThread {

	public static void main(String[] args) throws InterruptedException {

		// Thread processing in parallel 1
		new Thread() {

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
			};

		}.start();
		
		// Thread processing in parallel 2

		new Thread() {

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
			};

		}.start();

		System.out.println("Thread end");
		JOptionPane.showMessageDialog(null, "system keeps running for the user");

	}

}
