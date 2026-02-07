class MyThread extends Thread {

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Child thread: " + i);
        }
    }

    public static void main(String[] args) {
        MyThread t = new MyThread(); // create thread object
        t.start();                  // start new thread

        for (int i = 1; i <= 3; i++) {
            System.out.println("Main thread: " + i);
        }
    }
}
