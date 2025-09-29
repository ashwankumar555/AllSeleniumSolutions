package coreJava;

class WorkerThread extends Thread {

    public WorkerThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            // RUNNING → TIMED_WAITING
            System.out.println(getName() + " is going to sleep for 2 seconds.");
            Thread.sleep(2000);

            // RUNNING → WAITING (waiting for notify)
            synchronized (this) {
                System.out.println(getName() + " is waiting...");
                wait();  // moves to WAITING
            }

            // After being notified → RUNNING
            System.out.println(getName() + " is back to running.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " has finished."); // TERMINATED
    }
}

public class ThreadExample {
    public static void main(String[] args) throws Exception {
        WorkerThread t1 = new WorkerThread("Worker-1");

        // 🔹 NEW
        System.out.println("State after creation: " + t1.getState());

        // 🔹 RUNNABLE
        t1.start();
        System.out.println("State after start(): " + t1.getState());

        // Give it time to enter SLEEP (TIMED_WAITING)
        Thread.sleep(500);
        System.out.println("State while sleeping: " + t1.getState());

        // Wait more so that it enters WAITING state
        Thread.sleep(2500);
        System.out.println("State while waiting: " + t1.getState());

        // 🔹 BLOCKED example
        Thread t2 = new Thread(() -> {
            synchronized (t1) {
                System.out.println("t2 acquired lock on t1");
            }
        });
        t2.start();

        Thread.sleep(100); 
        System.out.println("State of t2 (possibly BLOCKED): " + t2.getState());

        // 🔹 Notify to bring Worker-1 back from WAITING
        synchronized (t1) {
            t1.notify();
        }

        // Wait until Worker-1 finishes
        t1.join();

        // TERMINATED
        System.out.println("State after termination: " + t1.getState());
    }
}

