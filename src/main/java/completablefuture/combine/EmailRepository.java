package completablefuture.combine;

public class EmailRepository {
  public String provideEmail1() {
    return "email1@example.com";
  }

  public String getAnotherEmailByEmail(String email) {
    return "another@email.com";
  }
}
