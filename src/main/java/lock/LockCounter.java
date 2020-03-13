package lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {

  ReentrantLock lock = new ReentrantLock();
  private int counter = 0;

  public void add() {
    //Acquires the lock
    lock.lock();
    try {
      counter++;
    } finally {
      //release this lock
      lock.unlock();

    }
  }
  public int getCounter() {
    return counter;
  }


}
