package synch;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SynchronizedCounterTest {

  int count = 0;

  @Test
  void should_return_1000() throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(4);

//    SynchronizedCounter counter = new SynchronizedCounter();

    IntStream.range(0, 1000).forEach(i -> executor.submit(this::increment));
    executor.shutdown();
    executor.awaitTermination(1000, TimeUnit.MILLISECONDS);

    assertEquals(1000, getValue()); // 1000
  }

  private synchronized void increment() {

    count++;
  }

  private  int getValue() {
    return count;
  }

}