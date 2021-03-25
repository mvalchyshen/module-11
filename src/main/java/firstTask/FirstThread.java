package firstTask;

import static java.lang.Thread.sleep;

public class FirstThread implements Runnable {
    private int time = 0;

    @Override
    public void run() {
        Thread oneSecondThread = Thread.currentThread();
        while (!oneSecondThread.isInterrupted()) {
            if (isOneSecondPassed()) {
                time++;
                System.out.println("Time passed : " + time);
            }
        }
    }

    private synchronized boolean isOneSecondPassed() {
        try {
            wait(1000);
        } catch (InterruptedException e) {
            return false;
        }
        notifyAll();
        return true;
    }
}
