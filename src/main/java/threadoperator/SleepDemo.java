package threadoperator;

public class SleepDemo {

  public static void main(String[] args) {
    Thread thread1 = new Thread(new SleepMessage());
    Thread thread2 = new Thread(new SleepMessage());
    thread1.start();
    thread2.start();
    System.out.println("Thread1 state is: " + thread1.getState());
    System.out.println("Thread2 state is: " + thread2.getState());
  }

}
