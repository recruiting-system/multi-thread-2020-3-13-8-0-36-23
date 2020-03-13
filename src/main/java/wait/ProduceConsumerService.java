package wait;


public class ProduceConsumerService {

  //Producer-Consumer application
  //the producer, that creates the data
  //the consumers, that do some action with data
  //the consumer thread must not attempt to retrieve the data before the producer thread has delivered it
  //the producer thread must not attempt to deliver new data if the consu5mer hasn't retrieved the old data
  MessageMachine drop = new MessageMachine();
  Thread produceThread = new Thread(new Producer(drop));
  Thread consumerThread = new Thread(new Consumer(drop));



  public void run() {
    produceThread.start();

    consumerThread.start();
    try {
      produceThread.join();
      consumerThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  class MessageMachine {

    private String message;
    private boolean isEmpty = true;

    public synchronized String get() {
      while (isEmpty) {
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      isEmpty = true;
      notifyAll();
      return message;
    }

    synchronized void set(String message) {

      while (!isEmpty) {
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
//      try {
//        Thread.sleep(1000);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
      isEmpty = false;
      this.message = message;
      notifyAll();
    }
  }

  class Producer implements Runnable {

    private MessageMachine messageMachine;

    public Producer(MessageMachine messageMachine) {
      this.messageMachine = messageMachine;
    }

    @Override
    public void run() {
      String[] infos = {
          "Solider",
          "Parents",
          "Happiness",
          "Work"
      };

      for (String info : infos) {
        messageMachine.set(info);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      messageMachine.set("DONE");
    }

  }

  class Consumer implements Runnable {
    private MessageMachine messageMachine;

    public Consumer(MessageMachine messageMachine) {
      this.messageMachine = messageMachine;
    }

    @Override
    public void run() {
      for (String message = messageMachine.get(); ! message.equals("DONE"); message = messageMachine.get()) {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.format("MESSAGE RECEIVED: %s%n", message);
      }
    }
  }

}
