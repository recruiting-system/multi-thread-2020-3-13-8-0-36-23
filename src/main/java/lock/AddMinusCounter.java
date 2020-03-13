package lock;

public class AddMinusCounter {

  private int counter = 0;


  //0
  // add 1
  // minus -1
  public void add() {
//    try {
    synchronized(this) {
      counter++;
    }  // release

//    } finally {
//
//    }

  }

  public void minus() {

    synchronized(this) {
      counter--;
    }
  }

  public int getCounter() {

    return counter;
  }

}
