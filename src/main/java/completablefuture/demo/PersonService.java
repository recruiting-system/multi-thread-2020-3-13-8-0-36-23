package completablefuture.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.CompletableFuture.supplyAsync;

public class PersonService {

  private AddressRepository addressRepository;

  private EmailRepository emailRepository;

  public PersonService(AddressRepository addressRepository, EmailRepository emailRepository) {
    this.addressRepository = addressRepository;
    this.emailRepository = emailRepository;
  }

  public Person getPersonByFuture() {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    CompletableFuture<String> email = supplyAsync(() -> emailRepository.provideEmail(), executorService);

    //note : runAsync return Void

    CompletableFuture<String> address = supplyAsync(() -> addressRepository.provideAddress(), executorService);
    return new Person(email.join(), address.join());
  }

  public Person getPerson() {
    String email = emailRepository.provideEmail();

    String address = addressRepository.provideAddress();

    return new Person(email, address);
  }
}
