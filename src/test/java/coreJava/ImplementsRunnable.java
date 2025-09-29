package coreJava;

class OneDemo implements Runnable {
	private int i;

	// override correct run()
	@Override
	public void run() {
		for (int j = 0; j < i; j++) {
			System.out.println("Hi");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setCount(int i) {
		this.i = i;
	}
}

class TwoDemo implements Runnable {
	private int i;

	@Override
	public void run() {
		for (int j = 0; j < i; j++) {
			System.out.println("Akhira");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setCount(int i) {
		this.i = i;
	}
}

public class ImplementsRunnable {
	public static void main(String[] a) {
		OneDemo obj1 = new OneDemo();
		TwoDemo obj2 = new TwoDemo();

		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		// set loop counts
		obj1.setCount(100);
		obj2.setCount(100);

		// start threads (run() is called internally)
		t1.start();
		t2.start();
	}
}
