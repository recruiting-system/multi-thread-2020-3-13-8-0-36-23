package completablefuture.demo;

public class App {

  public static void main(String[] args) {
    PersonService service=  new PersonService(new AddressRepository(), new EmailRepository());
    service.getPersonByFuture();
//    service.getPerson();
  }

}
