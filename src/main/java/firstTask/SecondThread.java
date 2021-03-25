package firstTask;

import static java.lang.Thread.sleep;

public class SecondThread implements Runnable {

    @Override
    public void run() {
        Thread fiveSecondsThread = Thread.currentThread();
        while (!fiveSecondsThread.isInterrupted()) {
            if (isFiveSecondsPassed()) {
                System.out.println("Five seconds passed");
            }
        }
    }

    private synchronized boolean isFiveSecondsPassed() {
        try {
            wait(5000);
        } catch (InterruptedException e) {
            return false;
        }
        notifyAll();
        return true;
    }
}
