package completablefuture.combine;

public class Application {

  public static void main(String[] args) {
    PersonAcceptService service = new PersonAcceptService(new AddressRepository(), new EmailRepository());
    service.getPersonByFuture();
  }
}
