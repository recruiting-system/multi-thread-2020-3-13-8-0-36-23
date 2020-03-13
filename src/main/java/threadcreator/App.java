package threadcreator;

public class App {

  public static void main(String[] args) throws InterruptedException {
    SimpleThread simpleThread = new SimpleThread();

    simpleThread.run();

    System.out.println(simpleThread.getState());

//    new Thread(() -> System.out.println("SimpleRunnable")).start();
//    System.out.println("Main Thread");

  }

}
