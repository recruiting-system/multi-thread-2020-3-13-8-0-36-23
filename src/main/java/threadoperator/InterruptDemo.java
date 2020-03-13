package threadoperator;

public class InterruptDemo {

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(new InterruptMessage());
    thread.start();
    Thread.sleep(500);
    thread.interrupt();

    System.out.println(thread.getState());
  }

}
