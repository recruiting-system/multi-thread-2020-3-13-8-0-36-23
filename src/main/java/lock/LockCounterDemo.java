package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class LockCounterDemo {

  public static void main(String[] args) throws InterruptedException {

    LockCounter lockCounter = new LockCounter();

    ExecutorService executor = Executors.newFixedThreadPool(5);
    IntStream.range(0, 1000).forEach(i -> executor.submit(lockCounter::add));

    //wait for executor complete all task or reach timeout
    executor.shutdown();
    executor.awaitTermination(1000, TimeUnit.SECONDS);

    System.out.println(lockCounter.getCounter());
  }

}
