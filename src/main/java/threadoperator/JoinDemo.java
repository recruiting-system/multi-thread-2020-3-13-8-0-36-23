package threadoperator;

public class JoinDemo {

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(new JoinMessage());
    thread.start();
    thread.join();
    System.out.println("Main thread");
  }
}
