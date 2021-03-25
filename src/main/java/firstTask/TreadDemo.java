package firstTask;

public class TreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread oneSecondThread = new Thread(new FirstThread());
        Thread fiveSecondsThread = new Thread(new SecondThread());

        oneSecondThread.start();
        fiveSecondsThread.start();
        Thread.sleep(15000);
        oneSecondThread.interrupt();
        fiveSecondsThread.interrupt();
    }
}
