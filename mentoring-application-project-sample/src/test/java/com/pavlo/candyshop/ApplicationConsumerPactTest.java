package com.pavlo.candyshop;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.pavlo.candyshop.entity.PeopleResponse;
import com.pavlo.candyshop.entity.Person;
import com.pavlo.candyshop.entrypoint.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //will run springboot
@ExtendWith(PactConsumerTestExt.class) //PactConsumer approach
@PactTestFor(providerName = "application-person") //Given provider.
public class ApplicationConsumerPactTest {
    // Person Project, we will have a controller and within that controller we will call Project Application.
    @Autowired
    private PersonService personService;

    @Pact(consumer = "application-project")
    public RequestResponsePact allPeople(PactDslWithProvider builder) {
        return builder
                  // given("") => state
                .given("Should Provide a List of People")
                    .uponReceiving("get all people")
                    .path("/person")
                .willRespondWith()
                    .status(200)
                    .body(
                            new PactDslJsonBody()
                                    .minArrayLike("people", 1, 1)
                                    .integerType("id", 1)
                                    .closeObject()
                                    .closeArray()
                    )
                .toPact();
    }

    @Pact(consumer = "application-project")
    public RequestResponsePact aPerson(PactDslWithProvider builder) {
        return builder
                .given("Should Provide a Person information of id 1", "id", 1)
                    .uponReceiving("get a person")
                    .path("/person/1")
                .willRespondWith()
                    .status(200)
                    .body(
                            new PactDslJsonBody()
                                    .integerType("id", 1)
                    )
                .toPact();
    }

    @Test
    @PactTestFor(pactMethod = "allPeople")
    void shouldReturnAllCandies(MockServer mockServer) {
        personService.setBaseUrl(mockServer.getUrl());
        PeopleResponse value = personService.getAllPeople();
        Assertions.assertEquals(1, value.getPeople().size());
        Assertions.assertEquals(1, value.getPeople().get(0).getId());
    }

    @Test
    @PactTestFor(pactMethod = "aPerson")
    void shouldReturnACandy(MockServer mockServer) {
        personService.setBaseUrl(mockServer.getUrl());
        Person value = personService.getAPerson(1);
        Assertions.assertEquals(1, value.getId());
    }
}
