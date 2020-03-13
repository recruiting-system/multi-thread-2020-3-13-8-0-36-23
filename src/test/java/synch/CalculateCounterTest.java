package synch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateCounterTest {

  @Test
  public void should_return_1000_when_increment_1000_times() throws InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(3);

    CalculateCounter summation = new CalculateCounter();

    IntStream.range(0, 10000)
        .forEach(count -> service.submit(summation::calculate));

    service.shutdown();
    service.awaitTermination(1000, TimeUnit.MILLISECONDS);
    assertEquals(10000, summation.getCount());
  }

}