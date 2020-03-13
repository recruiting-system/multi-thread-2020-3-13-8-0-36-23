package synch;

public class CalculateCounter {
  private int count = 0;

  public void calculate() {

    int sum = getCount() + 1;
    setCount(sum);
  }

  public synchronized int getCount() {
    return count;
  }

  public synchronized void setCount(int count) {
    this.count = count;

  }
}
