package threadoperator;

public class JoinMessage implements Runnable {

  @Override
  public void run() {
    String importantInfo[] = {
        "Sleep",
        "Interrupt",
        "Join"
    };

    for (String s : importantInfo) {

      Thread thread = Thread.currentThread();

      System.out.println(s);
    }
  }
}
