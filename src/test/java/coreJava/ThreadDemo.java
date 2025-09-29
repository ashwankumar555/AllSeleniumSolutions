package coreJava;

class One extends Thread {
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

class Two extends Thread {
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

public class ThreadDemo {
	public static void main(String[] args) {
		One obj1 = new One();
		Two obj2 = new Two();

		// set loop counts
		obj1.setCount(100);
		obj2.setCount(100);

		// start threads (run() is called internally)
		obj1.start();
		obj2.start();
	}
}
