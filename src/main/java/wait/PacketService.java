package wait;

public class PacketService {
  Data data = new Data();
  Thread sender = new Thread(new Sender(data));
  Thread receiver = new Thread(new Receiver(data));

  public void run() {
    sender.start();
    receiver.start();
  }

  class Data {

    private String packet;
    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;

    public synchronized void send(String packet) {
      while (!transfer) {
        try {
          wait();
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
      System.out.println("SendThreadState:" + sender.getState());
      transfer = false;

      this.packet = packet;
      notifyAll();
    }

    public synchronized String receive() {
      while (transfer) {
        try {
          wait();
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
      transfer = true;

      notifyAll();
      return packet;
    }

  }

  class Sender implements Runnable {

    private Data data;

    public Sender(Data data) {
      this.data = data;
    }

    @Override
    public void run() {
      String packets[] = {
          "First packet",
          "Second packet",
          "Third packet",
          "Fourth packet",
          "End"
      };

      for (String packet : packets) {
        data.send(packet);

        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
    }
  }

  class Receiver implements Runnable {

    private Data load;

    public Receiver(Data load) {
      this.load = load;
    }

    // standard constructors

    @Override
    public void run() {
      for (String receivedMessage = load.receive();
          !"End".equals(receivedMessage);
          receivedMessage = load.receive()) {

        System.out.println(receivedMessage);

        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          System.out.println(Thread.currentThread().getState());

        }
      }
    }
  }
}
