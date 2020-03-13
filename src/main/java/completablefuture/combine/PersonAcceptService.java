package completablefuture.combine;

import completablefuture.demo.Person;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class PersonAcceptService {

  private AddressRepository addressRepository;

  private EmailRepository emailRepository;

  public PersonAcceptService(AddressRepository addressRepository, EmailRepository emailRepository) {
    this.addressRepository = addressRepository;
    this.emailRepository = emailRepository;
  }

  public Person getPersonByFuture() {
    CompletableFuture<String> emailFuture = supplyAsync(() -> emailRepository.provideEmail1());

    // two CompletableFuture
    CompletableFuture<String> anotherEmailFuture = emailFuture.thenCompose(email -> supplyAsync(() -> emailRepository.getAnotherEmailByEmail(email)));

    //do some action for CompletableFuture
    anotherEmailFuture.thenAccept(System.out::println);
    CompletableFuture<String> upperCaseFuture = anotherEmailFuture.thenApply(String::toUpperCase);

    CompletableFuture<String> address = supplyAsync(() -> addressRepository.provideAddress());
    String email = upperCaseFuture.join();
    System.out.println(email);
    return new Person(email, address.join());
  }

}
