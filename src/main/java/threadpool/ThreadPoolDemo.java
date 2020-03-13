package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class ThreadPoolDemo {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    for (int i = 0; i < 9; i++) {
      executorService.submit(new Task("" + i));
    }
    // no new tasks will be accepted
    executorService.shutdown();

    //Blocks until all tasks have completed execution after a shutdown request
    executorService.awaitTermination(10000, TimeUnit.MILLISECONDS);

    System.out.println("Main thread");
  }

}
