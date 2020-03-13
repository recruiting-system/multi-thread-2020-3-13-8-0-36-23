package threadoperator;

public class InterruptMessage implements Runnable {

  @Override
  public void run() {
    String importantInfo[] = {
        "Sleep",
        "Interrupt",
        "Join"
    };

    for (String s : importantInfo) {
      Thread thread = Thread.currentThread();
      try {
        Thread.sleep(2000);
        System.out.println(s);
      } catch (InterruptedException e) {
        System.out.println(thread.getState());
        return;
      }

    }
  }
}
