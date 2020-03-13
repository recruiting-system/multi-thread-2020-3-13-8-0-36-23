package threadoperator;

public class SleepMessage implements Runnable {

  @Override
  public void run() {
    String importantInfo[] = {
        "Sleep",
        "Join",
        "Interrupt"
    };

    for (String s : importantInfo) {
      //Pause for 1 seconds
      Thread thread = Thread.currentThread();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println(thread.getState());
        e.printStackTrace();
      }
      System.out.println(s);
    }
  }
}
