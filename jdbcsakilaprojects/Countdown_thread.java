class MyThread extends Thread {

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Count: " + i);
                Thread.sleep(2000); // 2 seconds delay after print
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class Countdown_thread {
    public static void main(String[] args) {

        MyThread t = new MyThread(); // creating the thread
        t.start(); 
    }
}
