package secondTask;



public class FizzBuzzGame {
    private volatile int number;
    private static final int END_GAME = 18;
    private StringBuffer sb = new StringBuffer();

    public FizzBuzzGame() {

        this.number = 1;
        playGame();
    }

    private void playGame() {
        new Thread(() -> fizz()).start();
        new Thread(() -> buzz()).start();
        new Thread(() -> fizzBuzz()).start();
        new Thread(() -> numberFlow()).start();
        System.out.println("GAME BEGINS \n\n" + sb);

    }

    private synchronized void numberFlow() {
        while (number <= END_GAME) {
            resultAdd(String.valueOf(number));
            if (number % 3 == 0 || number % 5 == 0) {
                stop();
            }
        }
    }

    private synchronized void fizz() {
        while (number <= END_GAME) {
            if (number % 3 == 0 && number % 5 != 0) {
                resultAdd("fizz");
            } else stop();
        }
    }

    private synchronized void buzz() {
        while (number <= END_GAME) {
            if (number % 3 != 0 && number % 5 == 0) {
                resultAdd("buzz");
            }
            stop();
        }
    }

    private synchronized void fizzBuzz() {
        while (number <= END_GAME) {
            if (number % 3 == 0 && number % 5 == 0) {
                resultAdd("fizzbuzz");
            }
            stop();
        }
    }

    private void resultAdd(String word) {
        sb.append(word).append(' ');
        number++;
        notifyAll();
    }

    private synchronized void stop() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
