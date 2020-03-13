package wait;

public class GuardedBoy {
  boolean isJoy;
  public void achieveJoy() {
    // Simple loop guard. Wastes
    // processor time. Don't do this!
    while(!isJoy) {

    }
    System.out.println("Joy has been achieved!");
  }

  public synchronized void achieveJoyAndEfficiency() {
    // This guard only loops once for each special event,
    // which may not be the event we're waiting for.
    while(!isJoy) {
      try {
        wait();
      } catch (InterruptedException e) {}
    }
    System.out.println("Joy and efficiency have been achieved!");
  }

  public synchronized void notifyJoy() {

    //do something
    isJoy = true;
    notifyAll();
  }

}
