package completablefuture.demo;

public class AddressRepository {
  public String provideAddress() {
    System.out.println(Thread.currentThread());

    return "example-address";
  }
}
