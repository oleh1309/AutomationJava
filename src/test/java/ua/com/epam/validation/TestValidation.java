package ua.com.epam.validation;

import ua.com.epam.core.rest.RestClient;

public class TestValidation {

  private RestClient client;

  public TestValidation(RestClient client) {
    this.client = client;
  }

  public AuthorValidation getAuthorValidation() {
    return new AuthorValidation(client);
  }
}
